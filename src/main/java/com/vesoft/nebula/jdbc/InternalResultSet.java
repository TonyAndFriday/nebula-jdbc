package com.vesoft.nebula.jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @author captain
 */

public class InternalResultSet<T> implements BaseResultSet {

    private Iterator<List<T>> records;
    private List<String> colNames;
    private List<T> curRecord;
    private int size;
    /**
     * the first is 1
     */
    private int curRow;

    public InternalResultSet(List<List<T>> records, List<String> colNames) throws SQLException {
        if (records == null || colNames == null) {
            throw new SQLException("Column names and values should not be null!");
        }
        this.records = records.iterator();
        this.size = records.size();
        this.colNames = colNames;
        // start from 1
        this.curRow = 0;
    }

    @Override
    public boolean next() throws SQLException {
        if (records.hasNext()) {
            curRecord = records.next();
            curRow++;
            if (curRecord.size() != colNames.size()) {
                throw new SQLException("Column names and values should has the same size!");
            }
            return true;
        }
        return false;
    }

    @Override
    public void close() throws SQLException {
        this.records = null;
        this.colNames = null;
        this.curRecord = null;
    }

    @Override
    public boolean wasNull() throws SQLException {
        return false;
    }

    @Override
    public String getString(int columnIndex) throws SQLException {
        return (String) getByIndex(columnIndex);
    }

    @Override
    public boolean getBoolean(int columnIndex) throws SQLException {
        return (boolean) getByIndex(columnIndex);
    }

    @Override
    public short getShort(int columnIndex) throws SQLException {
        return (short) getByIndex(columnIndex);
    }

    @Override
    public int getInt(int columnIndex) throws SQLException {
        return (int) getByIndex(columnIndex);
    }

    @Override
    public long getLong(int columnIndex) throws SQLException {
        return (long) getByIndex(columnIndex);
    }

    @Override
    public float getFloat(int columnIndex) throws SQLException {
        return (float) getByIndex(columnIndex);
    }

    @Override
    public double getDouble(int columnIndex) throws SQLException {
        return (double) getByIndex(columnIndex);
    }

    @Override
    public String getString(String columnLabel) throws SQLException {
        return getByName(columnLabel).toString();
    }

    @Override
    public boolean getBoolean(String columnLabel) throws SQLException {
        return (boolean) getByName(columnLabel);
    }

    @Override
    public short getShort(String columnLabel) throws SQLException {
        return (short) getByName(columnLabel);
    }

    @Override
    public int getInt(String columnLabel) throws SQLException {
        return (int) getByName(columnLabel);
    }

    @Override
    public long getLong(String columnLabel) throws SQLException {
        return (long) getByName(columnLabel);
    }

    @Override
    public float getFloat(String columnLabel) throws SQLException {
        return (float) getByName(columnLabel);
    }

    @Override
    public double getDouble(String columnLabel) throws SQLException {
        return (double) getByName(columnLabel);
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return new NebulaResultSetMetaData(this);
    }

    @Override
    public Object getObject(int columnIndex) throws SQLException {
        return getByIndex(columnIndex);
    }

    @Override
    public Object getObject(String columnLabel) throws SQLException {
        return getByName(columnLabel);
    }

    @Override
    public int findColumn(String columnLabel) throws SQLException {
        return colNames.indexOf(columnLabel);
    }

    @Override
    public int getRow() throws SQLException {
        return curRow;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return records == null;
    }

    private Object getByIndex(int columnIndex) {
        return curRecord.get(columnIndex - 1);
    }

    private Object getByName(String columnName) {
        return curRecord.get(colNames.indexOf(columnName));
    }

    @Override
    public List<String> getColumnNames() {
        return colNames;
    }
}
