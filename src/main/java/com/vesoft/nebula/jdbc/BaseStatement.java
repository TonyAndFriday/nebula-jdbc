package com.vesoft.nebula.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/**
 * @author captain
 */

public interface BaseStatement extends Statement, BaseWrapper {

    @Override
    default boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean execute(String sql, int[] columnIndexes) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean execute(String sql, String[] columnNames) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int executeUpdate(String sql, String[] columnNames) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxFieldSize() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setMaxFieldSize(int max) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setEscapeProcessing(boolean enable) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setCursorName(String name) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setFetchDirection(int direction) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getFetchDirection() throws SQLException {
        return ResultSet.FETCH_FORWARD;
    }

    @Override
    default ResultSet getGeneratedKeys() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void cancel() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setPoolable(boolean poolable) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean isPoolable() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void closeOnCompletion() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean isCloseOnCompletion() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getQueryTimeout() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setQueryTimeout(int seconds) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getResultSetConcurrency() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getResultSetType() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default SQLWarning getWarnings() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void clearWarnings() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getFetchSize() throws SQLException {
        return 0;
    }
}
