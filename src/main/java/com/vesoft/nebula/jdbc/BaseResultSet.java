package com.vesoft.nebula.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author captain
 */

public interface BaseResultSet extends ResultSet, BaseWrapper {

    @Override
    default byte getByte(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default byte[] getBytes(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Date getDate(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Time getTime(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Timestamp getTimestamp(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default InputStream getAsciiStream(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default InputStream getUnicodeStream(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default InputStream getBinaryStream(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default byte getByte(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default byte[] getBytes(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Date getDate(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Time getTime(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Timestamp getTimestamp(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default InputStream getAsciiStream(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default InputStream getUnicodeStream(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default InputStream getBinaryStream(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getCursorName() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Reader getCharacterStream(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Reader getCharacterStream(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean isBeforeFirst() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean isAfterLast() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean isFirst() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean isLast() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void beforeFirst() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void afterLast() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean first() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean last() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean absolute(int row) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean relative(int rows) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean previous() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void setFetchDirection(int direction) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getFetchDirection() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean rowUpdated() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean rowInserted() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean rowDeleted() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNull(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBoolean(int columnIndex, boolean x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateByte(int columnIndex, byte x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateShort(int columnIndex, short x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateInt(int columnIndex, int x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateLong(int columnIndex, long x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateFloat(int columnIndex, float x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateDouble(int columnIndex, double x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateString(int columnIndex, String x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBytes(int columnIndex, byte[] x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateDate(int columnIndex, Date x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateTime(int columnIndex, Time x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateObject(int columnIndex, Object x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNull(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBoolean(String columnLabel, boolean x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateByte(String columnLabel, byte x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateShort(String columnLabel, short x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateInt(String columnLabel, int x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateLong(String columnLabel, long x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateFloat(String columnLabel, float x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateDouble(String columnLabel, double x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateString(String columnLabel, String x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBytes(String columnLabel, byte[] x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateDate(String columnLabel, Date x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateTime(String columnLabel, Time x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateObject(String columnLabel, Object x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void insertRow() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateRow() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void deleteRow() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void refreshRow() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void cancelRowUpdates() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void moveToInsertRow() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void moveToCurrentRow() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default java.sql.Statement getStatement() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Ref getRef(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Blob getBlob(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Clob getClob(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Ref getRef(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Blob getBlob(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Clob getClob(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Date getDate(int columnIndex, Calendar cal) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Date getDate(String columnLabel, Calendar cal) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Time getTime(int columnIndex, Calendar cal) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Time getTime(String columnLabel, Calendar cal) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default URL getURL(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default URL getURL(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateRef(int columnIndex, Ref x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateRef(String columnLabel, Ref x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBlob(int columnIndex, Blob x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBlob(String columnLabel, Blob x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateClob(int columnIndex, Clob x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateClob(String columnLabel, Clob x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateArray(int columnIndex, java.sql.Array x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateArray(String columnLabel, java.sql.Array x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default RowId getRowId(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default RowId getRowId(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateRowId(int columnIndex, RowId x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateRowId(String columnLabel, RowId x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNString(int columnIndex, String nString) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNString(String columnLabel, String nString) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default NClob getNClob(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default NClob getNClob(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default SQLXML getSQLXML(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default SQLXML getSQLXML(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getNString(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getNString(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Reader getNCharacterStream(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Reader getNCharacterStream(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateClob(int columnIndex, Reader reader) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateClob(String columnLabel, Reader reader) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNClob(int columnIndex, Reader reader) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default void updateNClob(String columnLabel, Reader reader) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
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
    default void setFetchSize(int rows) throws SQLException {
        if (rows < 0) {
            throw new SQLException("Fetch size must be >= 0");
        }
    }

    @Override
    default int getFetchSize() throws SQLException {
        return 1;
    }

    @Override
    default int getConcurrency() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Array getArray(int columnIndex) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default Array getArray(String columnLabel) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getHoldability() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getType() throws SQLException {
        return ResultSet.TYPE_FORWARD_ONLY;
    }

    List<String> getColumnNames();
}
