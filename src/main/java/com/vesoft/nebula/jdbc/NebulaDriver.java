package com.vesoft.nebula.jdbc;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.vesoft.nebula.jdbc.Constants.GRAPH_ADDRESS;
import static com.vesoft.nebula.jdbc.Constants.GRAPH_NAME;

/**
 * @author captain
 */

public final class NebulaDriver implements Driver {

    private static final Logger LOGGER = Logger.getLogger(NebulaDriver.class.getName());
    private static final String DRIVER_URL_PREFIX = "jdbc:nebula:";

    public NebulaDriver() throws SQLException {
        DriverManager.registerDriver(this);
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        Properties properties = parseURL(url, info);
        return new NebulaConnection(url, properties);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith(DRIVER_URL_PREFIX);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        Properties copy = new Properties(info);
        Properties parse = parseURL(url, copy);
        if (parse != null) {
            copy = parse;
        }

        DriverPropertyInfo[] props = new DriverPropertyInfo[copy.size()];
        int i = 0;
        Set<Object> keys = copy.keySet();
        for (Object key : keys) {
            String k = key.toString();
            props[i++] = new DriverPropertyInfo(k, copy.getProperty(k));
        }
        return props;
    }

    @Override
    public int getMajorVersion() {
        return 1;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return LOGGER;
    }

    /**
     * refer to PostgresQL JDBC
     *
     * @param url
     * @param defaults
     * @return
     */
    public static Properties parseURL(String url, Properties defaults) {
        Properties urlProps = new Properties(defaults);

        String urlServer = url;
        String urlArgs = "";

        int qPos = url.indexOf('?');
        if (qPos != -1) {
            urlServer = url.substring(0, qPos);
            urlArgs = url.substring(qPos + 1);
        }

        if (!urlServer.startsWith(DRIVER_URL_PREFIX)) {
            LOGGER.log(Level.FINE, "JDBC URL must start with \"{0}\" but was: {1}", new String[]{DRIVER_URL_PREFIX, url});
            return null;
        }
        urlServer = urlServer.substring(DRIVER_URL_PREFIX.length());

        if (urlServer.startsWith("//")) {
            urlServer = urlServer.substring(2);
            int slash = urlServer.indexOf('/');
            if (slash == -1) {
                LOGGER.log(Level.WARNING, "JDBC URL must contain a / at the end of the host or port: {0}", url);
                return null;
            }
            try {
                urlProps.setProperty(GRAPH_NAME, URLDecoder.decode(urlServer.substring(slash + 1), StandardCharsets.UTF_8.name()));
            } catch (UnsupportedEncodingException e) {
                LOGGER.log(Level.WARNING, e.getMessage());
                return null;
            }

            String[] addresses = urlServer.substring(0, slash).split(",");
            int index = 0;
            for (String address : addresses) {
                int portIdx = address.lastIndexOf(':');
                if (portIdx != -1) {
                    String portStr = address.substring(portIdx + 1);
                    try {
                        int port = Integer.parseInt(portStr);
                        if (port < 1 || port > 65535) {
                            LOGGER.log(Level.WARNING, "JDBC URL port: {0} not valid (1:65535) ", portStr);
                            return null;
                        }
                    } catch (NumberFormatException ignore) {
                        LOGGER.log(Level.WARNING, "JDBC URL invalid port number: {0}", portStr);
                        return null;
                    }
                } else {
                    LOGGER.log(Level.WARNING, "JDBC URL must contain a port that valid (1:65535) ");
                    return null;
                }
                urlProps.setProperty(GRAPH_ADDRESS + "." + index++, address);
            }
        } else {
            LOGGER.log(Level.WARNING, "JDBC URL format is invalid.");
            return null;
        }

        // parse the args part of the url
        String[] args = urlArgs.split("&");
        for (String token : args) {
            if (token.isEmpty()) {
                continue;
            }
            int pos = token.indexOf('=');
            if (pos == -1) {
                urlProps.setProperty(token, "");
            } else {
                try {
                    urlProps.setProperty(token.substring(0, pos), URLDecoder.decode(token.substring(pos + 1), StandardCharsets.UTF_8.name()));
                } catch (UnsupportedEncodingException e) {
                    LOGGER.warning(e.getMessage());
                    return null;
                }
            }
        }
        return urlProps;
    }
}
