package com.vesoft.nebula.jdbc;

import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.exception.IOErrorException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.logging.Logger;

import static com.vesoft.nebula.jdbc.Constants.GRAPH_ADDRESS;

/**
 * @author captain
 */

public class NebulaConnection extends BaseConnection {

    private static Logger LOG = Logger.getLogger(NebulaConnection.class.getName());

    private InternalConnection connection;
    private final String graphName;
    private final String url;
    private static final ExecutorService CHECK_THREAD = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), r -> {
        Thread thread = new Thread(r);
        thread.setName("Connection-Valid-Thread");
        thread.setDaemon(true);
        return thread;
    });

    public NebulaConnection(String url, Properties properties) throws SQLException {
        super(properties);
        this.graphName = properties.getProperty(Constants.GRAPH_NAME, "");
        this.url = url;
        List<HostAddress> addresses = parseAddress(properties);
        try {
            addresses = hostToIp(addresses);
            connection = new InternalConnection(addresses, properties);
//            metaManager = new GraphMetaManager(this);
            if (!graphName.isEmpty()) {
                ResultSet rs = connection.execute("USE " + graphName);
                if (!rs.isSucceeded()) {
                    throw new SQLException(String.format("Error code: %d, Msg: %s", rs.getErrorCode(), rs.getErrorMessage()));
                }
            }
        } catch (Exception e) {
            close();
            throw new SQLException(e);
        }
    }

    public String getUrl() {
        return url;
    }

    private List<HostAddress> hostToIp(List<HostAddress> addresses)
            throws UnknownHostException {
        List<HostAddress> newAddrs = new ArrayList<>();
        for (HostAddress addr : addresses) {
            String ip = InetAddress.getByName(addr.getHost()).getHostAddress();
            newAddrs.add(new HostAddress(ip, addr.getPort()));
        }
        return newAddrs;
    }

    private List<HostAddress> parseAddress(Properties properties) {
        List<HostAddress> addresses = new ArrayList<>();
        if (properties != null) {
            for (Object o : properties.keySet()) {
                String key = o.toString();
                if (key.startsWith(GRAPH_ADDRESS + ".")) {
                    String address = properties.getProperty(key);
                    int portIdx = address.lastIndexOf(':');
                    String host = address.substring(0, portIdx);
                    int port = Integer.parseInt(address.substring(portIdx + 1));
                    addresses.add(new HostAddress(host, port));
                }
            }
        }
        return addresses;
    }

    public ResultSet execute(String sql) throws SQLException {
        try {
            return this.connection.execute(sql);
        } catch (IOErrorException e) {
            throw new SQLException("error sql: " + sql, e);
        }
    }

    @Override
    public Statement createStatement() throws SQLException {
        return new NebulaStatement(this);
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return new NebulaPreparedStatement(this, sql);
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } finally {
                connection = null;
            }
        }
    }

    @Override
    public void rollback() throws SQLException {
    }

    @Override
    public boolean isClosed() throws SQLException {
        return connection == null || connection.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return new NebulaDatabaseMetaData(this);
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        if (timeout < 0) {
            throw new SQLException("Timeout can't be less than zero");
        }
        if (timeout == 0) {
            timeout = 60;
        }
        try {
            return !isClosed() && CHECK_THREAD.submit(() -> connection.ping()).get(timeout, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            LOG.warning(e.getMessage());
        }
        return false;
    }

    public String getGraphName() {
        return graphName;
    }
}
