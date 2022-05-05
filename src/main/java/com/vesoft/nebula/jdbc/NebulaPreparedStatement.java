package com.vesoft.nebula.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * @author captain
 */

public class NebulaPreparedStatement extends NebulaStatement implements BasePreparedStatement {

    private static final Logger LOG = LoggerFactory.getLogger(PlaceholderUtil.class);

    private Calendar defaultCalendar = Calendar.getInstance();
    private String stmt;
    protected Map<Integer, Object> parameters;
    protected List<Map<Integer, Object>> batchParameters;
    private int parametersNumber;
    private static final Map<Class<?>, Class<?>> primitiveTypeToWrapperMap = new IdentityHashMap<>(16);

    static {
        primitiveTypeToWrapperMap.put(boolean.class, Boolean.class);
        primitiveTypeToWrapperMap.put(byte.class, Byte.class);
        primitiveTypeToWrapperMap.put(char.class, Character.class);
        primitiveTypeToWrapperMap.put(double.class, Double.class);
        primitiveTypeToWrapperMap.put(float.class, Float.class);
        primitiveTypeToWrapperMap.put(int.class, Integer.class);
        primitiveTypeToWrapperMap.put(long.class, Long.class);
        primitiveTypeToWrapperMap.put(short.class, Short.class);
    }

    private static Class<?> resolvePrimitiveIfNecessary(Class<?> clazz) throws SQLException {
        if (clazz == null) {
            throw new SQLException("Class must not be null");
        }
        return (clazz.isPrimitive() && clazz != void.class ? primitiveTypeToWrapperMap.get(clazz) : clazz);
    }

    public NebulaPreparedStatement(NebulaConnection connection, String sql) {
        super(connection);
        this.stmt = sql;
        /* 默认初试容量16，最多可以存放12个参数而不触发hashmap的扩容。复合大多数情况 */
        this.parameters = new HashMap<>();
        this.batchParameters = new ArrayList<>();
    }

    protected void insertParameter(int index, Object obj) {
        this.parameters.put(index, obj);
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        String s = PlaceholderUtil.replacePlaceholders(stmt, parameters);
        LOG.debug("执行的sql : {}", s);
        curResultSet = super.executeQuery(s);
        return curResultSet;
    }

    @Override
    public int executeUpdate() throws SQLException {
        String s = PlaceholderUtil.replacePlaceholders(stmt, parameters);
        ResultSet exec = exec(s);
        return getUpdateCount();
    }

    @Override
    public void setDate(int parameterIndex, Date x) throws SQLException {
        setDate(parameterIndex, x, defaultCalendar);
    }

    @Override
    public void setTime(int parameterIndex, Time x) throws SQLException {
        setTime(parameterIndex, x, defaultCalendar);
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        setTimestamp(parameterIndex, x, defaultCalendar);
    }

    @Override
    public void clearParameters() throws SQLException {
        this.parameters.clear();
    }

    @Override
    public boolean execute() throws SQLException {
        String s = PlaceholderUtil.replacePlaceholders(stmt, parameters);
        return super.execute(s);
    }

    @Override
    public void addBatch() throws SQLException {
        this.batchParameters.add(new HashMap<>(this.parameters));
        this.parameters.clear();
    }

    @Override
    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        if (cal == null) {
            throw new SQLException("Calendar can not be null !");
        }
        if (x == null) {
            insertParameter(parameterIndex, null);
        } else {
            String s = "date(\"" + DateTimeUtil.formatDate(x.getTime(), cal.getTimeZone().toZoneId()) + "\")";
            insertParameter(parameterIndex, s);
        }
    }

    @Override
    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        if (cal == null) {
            throw new SQLException("Calendar can not be null !");
        }
        if (x == null) {
            insertParameter(parameterIndex, null);
        } else {
            String s = "time(\"" + DateTimeUtil.formatTime(x.getTime(), cal.getTimeZone().toZoneId()) + "\")";
            insertParameter(parameterIndex, s);
        }
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        if (cal == null) {
            throw new SQLException("Calendar can not be null !");
        }
        if (x == null) {
            insertParameter(parameterIndex, null);
        } else {
            insertParameter(parameterIndex, x.getTime() / 1000);
        }
    }

    public void setDatetime(int parameterIndex, java.util.Date datetime) throws SQLException {
        if (datetime == null) {
            insertParameter(parameterIndex, null);
        } else {
            String s = "datetime(\"" + DateTimeUtil.formatDateTime(datetime.getTime(), defaultCalendar.getTimeZone().toZoneId()) + "\")";
            insertParameter(parameterIndex, s);
        }
    }

    @Override
    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        insertParameter(parameterIndex, null);
    }

    @Override
    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        insertParameter(parameterIndex, null);
    }

    @Override
    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        insertParameter(parameterIndex, x);
    }

    @Override
    public void setByte(int parameterIndex, byte x) throws SQLException {
        insertParameter(parameterIndex, x);
    }

    @Override
    public void setShort(int parameterIndex, short x) throws SQLException {
        insertParameter(parameterIndex, x);
    }

    @Override
    public void setInt(int parameterIndex, int x) throws SQLException {
        insertParameter(parameterIndex, x);
    }

    @Override
    public void setLong(int parameterIndex, long x) throws SQLException {
        insertParameter(parameterIndex, x);
    }

    @Override
    public void setFloat(int parameterIndex, float x) throws SQLException {
        insertParameter(parameterIndex, x);
    }

    @Override
    public void setDouble(int parameterIndex, double x) throws SQLException {
        insertParameter(parameterIndex, x);
    }

    @Override
    public void setString(int parameterIndex, String x) throws SQLException {
        x = x == null ? null : ("'" + x.replace("\\", "\\\\").replace("'", "\\'") + "'").replace("\n", "\\n");
        insertParameter(parameterIndex, x);
    }

    @Override
    public void setObject(int parameterIndex, Object x) throws SQLException {
        if (x == null) {
            insertParameter(parameterIndex, null);
            return;
        }
        if (x instanceof LocalDate) {
            setDate(parameterIndex, Date.valueOf((LocalDate) x));
            return;
        }
        if (x instanceof LocalDateTime) {
            setTimestamp(parameterIndex, Timestamp.valueOf((LocalDateTime) x));
            return;
        }
        if (x instanceof LocalTime) {
            setTime(parameterIndex, Time.valueOf((LocalTime) x));
            return;
        }

        Class<?> clazz = resolvePrimitiveIfNecessary(x.getClass());
        if (clazz.isAssignableFrom(Integer.class)) {
            setInt(parameterIndex, (int) x);
            return;
        }
        if (clazz.isAssignableFrom(Boolean.class)) {
            setBoolean(parameterIndex, (boolean) x);
            return;
        }
        if (clazz.isAssignableFrom(Byte.class)) {
            setByte(parameterIndex, (byte) x);
            return;
        }
        if (clazz.isAssignableFrom(Character.class)) {
            setString(parameterIndex, x.toString());
            return;
        }
        if (clazz.isAssignableFrom(Double.class)) {
            setDouble(parameterIndex, (double) x);
            return;
        }
        if (clazz.isAssignableFrom(Float.class)) {
            setFloat(parameterIndex, (float) x);
            return;
        }
        if (clazz.isAssignableFrom(Long.class)) {
            setLong(parameterIndex, (long) x);
            return;
        }
        if (clazz.isAssignableFrom(Short.class)) {
            setShort(parameterIndex, (short) x);
            return;
        }
        if (Date.class.isAssignableFrom(x.getClass())) {
            setDate(parameterIndex, (Date) x);
            return;
        }
        if (Time.class.isAssignableFrom(x.getClass())) {
            setTime(parameterIndex, (Time) x);
            return;
        }
        if (Timestamp.class.isAssignableFrom(x.getClass())) {
            setTimestamp(parameterIndex, (Timestamp) x);
            return;
        }
        if (java.util.Date.class.isAssignableFrom(x.getClass())) {
            setDatetime(parameterIndex, (java.util.Date)x);
            return;
        }
        if (byte[].class.isAssignableFrom(x.getClass())) {
            setString(parameterIndex, new String((byte[]) x));
            return;
        }
        throw new SQLException("不支持的类型：" + x.getClass().getName());
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }
}
