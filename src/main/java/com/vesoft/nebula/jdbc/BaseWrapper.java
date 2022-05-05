package com.vesoft.nebula.jdbc;

import java.sql.SQLException;
import java.sql.Wrapper;

/**
 * @author captain
 */

public interface BaseWrapper extends Wrapper {

    @Override
    default <T> T unwrap(Class<T> iface) throws SQLException {
        return com.vesoft.nebula.jdbc.Wrapper.unwrap(iface, this);
    }

    @Override
    default boolean isWrapperFor(Class<?> iface) throws SQLException {
        return com.vesoft.nebula.jdbc.Wrapper.isWrapperFor(iface, this);
    }
}
