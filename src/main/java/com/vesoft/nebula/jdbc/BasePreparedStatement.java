package com.vesoft.nebula.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;

/**
 * @author captain
 */

public interface BasePreparedStatement extends BaseStatement, PreparedStatement {

    @Override
    default int getResultSetHoldability() throws SQLException {
        return ResultSet.HOLD_CURSORS_OVER_COMMIT;
    }

    //------------------------------------------------

    @Override
    default void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setBytes(int parameterIndex, byte[] x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setObject(int parameterIndex, Object x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setRef(int parameterIndex, Ref x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setBlob(int parameterIndex, Blob x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setClob(int parameterIndex, Clob x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setArray(int parameterIndex, Array x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setURL(int parameterIndex, URL x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setRowId(int parameterIndex, RowId x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setNString(int parameterIndex, String value) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setNClob(int parameterIndex, NClob value) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setClob(int parameterIndex, Reader reader) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setNClob(int parameterIndex, Reader reader) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSetMetaData getMetaData() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ParameterMetaData getParameterMetaData() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }
}
