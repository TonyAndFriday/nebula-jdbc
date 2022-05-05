package com.vesoft.nebula.jdbc;

import java.sql.SQLException;

/**
 * @author captain
 */

public class Wrapper {

    public static <T> T unwrap(Class<T> iface, Object object) throws SQLException {
        if (isWrapperFor(iface, object)) {
            return (T) object;
        }
        throw new SQLException(String.format("The object: [%s] can not implement the interface: [%s]", object, iface));
    }

    public static boolean isWrapperFor(Class<?> iface, Object obj) throws SQLException {
        return iface.isAssignableFrom(obj.getClass());
    }
}
