package com.vesoft.nebula.jdbc;

import java.sql.SQLException;
import java.util.List;

/**
 * @author captain
 */

public class NebulaResultSetMetaData implements BaseResultSetMetaData {

    private final List<String> columnNames;

    public NebulaResultSetMetaData(BaseResultSet resultSet) {
        this.columnNames = resultSet.getColumnNames();
    }

    @Override
    public int getColumnCount() throws SQLException {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        return columnNames.get(column - 1);
    }
}
