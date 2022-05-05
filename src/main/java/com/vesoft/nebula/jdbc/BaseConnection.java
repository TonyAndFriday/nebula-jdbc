package com.vesoft.nebula.jdbc;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.stream.Stream;

/**
 * @author captain
 */

public abstract class BaseConnection implements Connection, BaseWrapper {

    private Properties clientInfo;
    private boolean readOnly;
    private boolean autoCommit;
    /**
     * {@link #TRANSACTION_NONE} 0
     * {@link #TRANSACTION_READ_UNCOMMITTED} 1
     * {@link #TRANSACTION_READ_COMMITTED} 2
     * {@link #TRANSACTION_REPEATABLE_READ} 4
     * {@link #TRANSACTION_SERIALIZABLE} 8
     */
    private static final int TRANSACTION_ISOLATION = 1 << 4 - 1;

    protected BaseConnection(Properties properties) throws SQLException {
        this.clientInfo = properties;
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return sql;
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        this.autoCommit = autoCommit;
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return autoCommit;
    }

    @Override
    public void commit() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void rollback() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        this.readOnly = readOnly;
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return readOnly;
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public String getCatalog() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        checkTransactionIsolation(level);
        if (level != TRANSACTION_READ_COMMITTED) {
            throw new SQLException("Unsupported isolation level");
        }
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return TRANSACTION_READ_COMMITTED;
    }

    /**
     * Check if the transaction isolation level parameter conform to specification.
     * If it doesn't, we throw an exception.
     *
     * @param level The transaction isolation level value to check
     * @throws SQLException sqlexception
     */
    protected void checkTransactionIsolation(int level) throws SQLException {
        boolean b = Stream.of(TRANSACTION_NONE,
                TRANSACTION_READ_COMMITTED,
                TRANSACTION_READ_UNCOMMITTED,
                TRANSACTION_REPEATABLE_READ,
                TRANSACTION_SERIALIZABLE)
                .anyMatch(integer -> integer == level);
        if (!b) {
            throw new SQLException();
        }
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void clearWarnings() throws SQLException {
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public int getHoldability() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public Clob createClob() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public Blob createBlob() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public NClob createNClob() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        if (name != null && value != null) {
            if (this.clientInfo == null) {
                this.clientInfo = new Properties();
            }
            this.clientInfo.setProperty(name, value);
        }
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        this.clientInfo = properties;
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return (this.clientInfo == null) ? null : this.clientInfo.getProperty(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return clientInfo;
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public String getSchema() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    public String getUserName() {
        return clientInfo.getProperty("user", "");
    }
}
