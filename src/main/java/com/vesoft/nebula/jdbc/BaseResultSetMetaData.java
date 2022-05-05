package com.vesoft.nebula.jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author captain
 */

public interface BaseResultSetMetaData extends ResultSetMetaData, BaseWrapper {

    @Override
    default boolean isAutoIncrement(int column) throws SQLException {
        return false;
    }

    @Override
    default boolean isCaseSensitive(int column) throws SQLException {
        return false;
    }

    @Override
    default boolean isSearchable(int column) throws SQLException {
        return false;
    }

    @Override
    default boolean isCurrency(int column) throws SQLException {
        return false;
    }

    @Override
    default int isNullable(int column) throws SQLException {
        return ResultSetMetaData.columnNullableUnknown;
    }

    @Override
    default boolean isSigned(int column) throws SQLException {
        return false;
    }

    @Override
    default int getColumnDisplaySize(int column) throws SQLException {
        return 0;
    }

    @Override
    default String getSchemaName(int column) throws SQLException {
        return "";
    }

    @Override
    default int getPrecision(int column) throws SQLException {
        return 0;
    }

    @Override
    default int getScale(int column) throws SQLException {
        return 0;
    }

    @Override
    default String getTableName(int column) throws SQLException {
        return "";
    }

    @Override
    default String getCatalogName(int column) throws SQLException {
        return null;
    }

    @Override
    default int getColumnType(int column) throws SQLException {
        return 0;
    }

    @Override
    default String getColumnTypeName(int column) throws SQLException {
        return "";
    }

    @Override
    default boolean isReadOnly(int column) throws SQLException {
        return true;
    }

    @Override
    default boolean isWritable(int column) throws SQLException {
        return false;
    }

    @Override
    default boolean isDefinitelyWritable(int column) throws SQLException {
        return false;
    }

    @Override
    default String getColumnClassName(int column) throws SQLException {
        return "";
    }

    @Override
    default String getColumnLabel(int column) throws SQLException {
        return getColumnName(column);
    }

}
