/* Copyright (c) 2020 vesoft inc. All rights reserved.
 *
 * This source code is licensed under Apache 2.0 License,
 * attached with Common Clause Condition 1.0, found in the LICENSES directory.
 */

package com.vesoft.nebula.jdbc;

import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.exception.AuthFailedException;
import com.vesoft.nebula.client.graph.exception.IOErrorException;
import com.vesoft.nebula.client.graph.net.AuthResult;
import com.vesoft.nebula.client.graph.net.LoadBalancer;
import com.vesoft.nebula.client.graph.net.RoundRobinLoadBalancer;
import com.vesoft.nebula.client.graph.net.SyncConnection;
import com.vesoft.nebula.graph.ExecutionResponse;

import java.io.Closeable;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Properties;

/**
 * @author captain
 */

public class InternalConnection implements Closeable {
    private final LoadBalancer loadBalancer;
    private static final int RETRY_TIMES = 3;
    private final SyncConnection connection;
    private final AuthResult authenticate;
    private boolean isClosed;
    /**
     * unit ms
     */
    private int timeout = 3000;

    /**
     * @param addresses
     * @param properties at least include 'user' 'password', 'timeout' is optional
     * @throws IOErrorException
     * @throws AuthFailedException
     */
    public InternalConnection(List<HostAddress> addresses, Properties properties) throws IOErrorException, AuthFailedException {
        String timeout = properties.getProperty("timeout");
        if (timeout != null) {
            this.timeout = Integer.parseInt(timeout);
        }
        this.loadBalancer = new RoundRobinLoadBalancer(addresses, this.timeout);
        if (!loadBalancer.isServersOK()) {
            throw new IOErrorException(IOErrorException.E_CONNECT_BROKEN, "All server is not ready!");
        }
        SyncConnection syncConnection = create();
        String userName = properties.getProperty("user", "");
        String password = properties.getProperty("password", "");
        assert syncConnection != null;
        authenticate = syncConnection.authenticate(userName, password);
        this.connection = syncConnection;
    }

    @Override
    public void close() {
        this.loadBalancer.close();
        this.isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public ResultSet execute(String stmt) throws IOErrorException {
        try {
            if (isClosed()) {
                throw new IOErrorException(IOErrorException.E_CONNECT_BROKEN,
                        "Connection is closed");
            }
            ExecutionResponse resp = connection.execute(authenticate.getSessionId(), stmt);
            return new ResultSet(resp, authenticate.getTimezoneOffset());
        } catch (IOErrorException ie) {
            if (ie.getType() == IOErrorException.E_CONNECT_BROKEN) {
                int retryTimes = RETRY_TIMES;
                while (retryTimes-- > 0) {
                    try {
                        ExecutionResponse resp = connection.execute(authenticate.getSessionId(), stmt);
                        return new ResultSet(resp, authenticate.getTimezoneOffset());
                    } catch (IOErrorException e) {
                        if (retryTimes == 0) {
                            close();
                            throw e;
                        }
                    }
                }
            }
            throw ie;
        }
    }

    public boolean ping() {
        return !isClosed() && connection.ping();
    }

    private SyncConnection create() throws IOErrorException {
        int retry = RETRY_TIMES;
        SyncConnection conn = new SyncConnection();
        while (retry-- > 0) {
            try {
                HostAddress address = loadBalancer.getAddress();
                if (address == null) {
                    throw new IOErrorException(IOErrorException.E_ALL_BROKEN,
                            "All servers are broken.");
                }
                conn.open(address, this.timeout);
                return conn;
            } catch (IOErrorException e) {
                if (retry == 0) {
                    throw e;
                }
                this.loadBalancer.updateServersStatus();
            }
        }
        return null;
    }
}
