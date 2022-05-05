package com.vesoft.nebula.jdbc;

import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.data.TimeWrapper;
import com.vesoft.nebula.client.graph.data.ValueWrapper;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.Collections;
import java.util.List;

/**
 * @author captain
 */

public class NebulaResultSet implements BaseResultSet {

    private int cursor;
    private int size;
    private ResultSet resultSet;
    private ResultSet.Record curRecord;
    private List<String> columnNames;
    private int cols;
    private boolean isClosed;

    public NebulaResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
        this.cursor = -1;
        this.size = resultSet.rowsSize();
        this.columnNames = resultSet.getColumnNames();
        if (columnNames == null) {
            columnNames = Collections.emptyList();
        }
        this.cols = columnNames.size();
    }

    @Override
    public void beforeFirst() throws SQLException {
        cursor = -1;
        curRecord = null;
    }

    @Override
    public boolean next() throws SQLException {
        if (++cursor < size) {
            curRecord = resultSet.rowValues(cursor);
            return true;
        }
        return false;
    }

    @Override
    public void close() throws SQLException {
        isClosed = true;
    }

    @Override
    public boolean wasNull() throws SQLException {
        return curRecord.get(cols - 1) == null;
    }

    @Override
    public String getString(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        if (value.isNull() || value.isEmpty()) {
            return null;
        }
        try {
            return value.isString() ? value.asString() : value.toString();
        } catch (UnsupportedEncodingException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public boolean getBoolean(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        return !value.isNull() && !value.isEmpty() && value.asBoolean();
    }

    @Override
    public short getShort(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        return value.isNull() || value.isEmpty() ? 0 : (short) value.asLong();
    }

    @Override
    public int getInt(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        return value.isNull() || value.isEmpty() ? 0 : (int) value.asLong();
    }

    @Override
    public long getLong(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        return value.isNull() || value.isEmpty() ? 0 : value.asLong();
    }

    @Override
    public float getFloat(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        return value.isNull() || value.isEmpty() ? 0 : (float) value.asDouble();
    }

    @Override
    public double getDouble(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        return value.isNull() || value.isEmpty() ? 0 : value.asDouble();
    }

    @Override
    public Date getDate(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        return value.isNull() || value.isEmpty() ? null : Date.valueOf(value.asDate().toString());
    }

    @Override
    public Time getTime(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        final TimeWrapper wrapper = value.asTime();
        return value.isNull() || value.isEmpty() ? null : new Time(wrapper.getHour(), wrapper.getMinute(), wrapper.getSecond());
    }

    @Override
    public Time getTime(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        final TimeWrapper wrapper = value.asTime();
        return value.isNull() || value.isEmpty() ? null : new Time(wrapper.getHour(), wrapper.getMinute(), wrapper.getSecond());
    }

    @Override
    public Date getDate(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        return value.isNull() || value.isEmpty() ? null : Date.valueOf(value.asDate().toString());
    }

    @Override
    public Timestamp getTimestamp(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        return value.isNull() || value.isEmpty() ? null : new Timestamp(value.asLong() * 1000);
    }

    @Override
    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        return value.isNull() || value.isEmpty() ? null : new Timestamp(value.asLong() * 1000);
    }

    @Override
    public String getString(String columnLabel) throws SQLException {
        try {
            final ValueWrapper value = curRecord.get(columnLabel);
            return value.isNull() || value.isEmpty() ? null : value.asString();
        } catch (UnsupportedEncodingException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public boolean getBoolean(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        return !value.isNull() && !value.isEmpty() && value.asBoolean();
    }

    @Override
    public short getShort(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        return value.isNull() || value.isEmpty() ? 0 : (short) value.asLong();
    }

    @Override
    public int getInt(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        return value.isNull() || value.isEmpty() ? 0 : (int) value.asLong();
    }

    @Override
    public long getLong(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        return value.isNull() || value.isEmpty() ? 0 : value.asLong();
    }

    @Override
    public float getFloat(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        return value.isNull() || value.isEmpty() ? 0 : (float) value.asDouble();
    }

    @Override
    public double getDouble(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        return value.isNull() || value.isEmpty() ? 0 : value.asDouble();
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return new NebulaResultSetMetaData(this);
    }

    /**
     * cast to {@link com.vesoft.nebula.client.graph.data.ValueWrapper}
     *
     * @param columnIndex index of column
     * @return {@link com.vesoft.nebula.client.graph.data.ValueWrapper}
     * @throws SQLException
     */
    @Override
    public Object getObject(int columnIndex) throws SQLException {
        final ValueWrapper value = curRecord.get(columnIndex - 1);
        return value.isNull() || value.isEmpty() ? null : value;
    }

    /**
     * cast to {@link com.vesoft.nebula.client.graph.data.ValueWrapper}
     *
     * @param columnLabel name of column
     * @return {@link com.vesoft.nebula.client.graph.data.ValueWrapper}
     * @throws SQLException
     */
    @Override
    public Object getObject(String columnLabel) throws SQLException {
        final ValueWrapper value = curRecord.get(columnLabel);
        return value.isNull() || value.isEmpty() ? null : value;
    }

    @Override
    public int findColumn(String columnLabel) throws SQLException {
        return columnNames.indexOf(columnLabel) + 1;
    }

    @Override
    public int getRow() throws SQLException {
        return cursor + 1;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return isClosed;
    }

    @Override
    public List<String> getColumnNames() {
        return this.columnNames;
    }
}
