package com.vesoft.nebula.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author captain
 */

public class NebulaDatabaseMetaData implements BaseDatabaseMetaData {

    private final NebulaConnection connection;

    private static final List<String> KEYWORDS;

    private static final String DRIVER_NAME;
    private static final String DRIVER_VERSION;
    private static final Pattern VERSION_REGEX = Pattern.compile("^(\\d+)\\.(\\d+)(\\.|-)?(.*)?$");

    static {
        try (InputStream stream = NebulaDatabaseMetaData.class.getResourceAsStream("/graph.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            DRIVER_NAME = properties.getProperty("driver.name");
            DRIVER_VERSION = properties.getProperty("driver.version");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static {
        KEYWORDS = Arrays.asList(
                "ADD", "ALTER", "AND", "AS", "ASC", "BALANCE", "BOOL", "BY", "CASE", "CHANGE",
                "COMPACT", "CREATE", "DATE", "DATETIME", "DELETE", "DESC", "DESCRIBE", "DISTINCT",
                "DOUBLE", "DOWNLOAD", "DROP", "EDGE", "EDGES", "EXISTS", "EXPLAIN", "FETCH",
                "FIND", "FIXED_STRING", "FLOAT", "FLUSH", "FORMAT", "FROM", "GET", "GO", "GRANT",
                "IF", "IN", "INDEX", "INDEXES", "INGEST", "INSERT", "INT", "INT16", "INT32", "INT64",
                "INT8", "INTERSECT", "IS", "LIMIT", "LOOKUP", "MATCH", "MINUS", "NO", "NOT", "NULL",
                "OF", "OFFSET", "ON", "OR", "ORDER", "OVER", "OVERWRITE", "PROFILE", "PROP", "REBUILD",
                "RECOVER", "REMOVE", "RETURN", "REVERSELY", "REVOKE", "SET", "SHOW", "STEP", "STEPS",
                "STOP", "STRING", "SUBMIT", "TAG", "TAGS", "TIME", "TIMESTAMP", "TO", "UNION", "UPDATE",
                "UPSERT", "UPTO", "USE", "VERTEX", "WHEN", "WHERE", "WITH", "XOR", "YIELD"
        );
    }

    public NebulaDatabaseMetaData(NebulaConnection connection) {
        this.connection = connection;
    }

    @Override
    public String getURL() throws SQLException {
        return connection.getUrl();
    }

    @Override
    public String getUserName() throws SQLException {
        return connection.getUserName();
    }

    @Override
    public String getDatabaseProductName() throws SQLException {
        return "NebulaGraph";
    }

    @Override
    public String getDatabaseProductVersion() throws SQLException {
        return getDriverVersion();
    }

    @Override
    public String getDriverName() throws SQLException {
        return DRIVER_NAME;
    }

    @Override
    public String getDriverVersion() {
        return DRIVER_VERSION;
    }

    private int extractVersionPart(int position) {
        int result = -1;
        Matcher matcher = VERSION_REGEX.matcher(this.getDriverVersion());
        if (matcher.find()) {
            result = Integer.parseInt(matcher.group(position));
        }
        return result;
    }

    @Override
    public int getDriverMajorVersion() {
        return this.extractVersionPart(1);
    }

    @Override
    public int getDriverMinorVersion() {
        return this.extractVersionPart(2);
    }

    @Override
    public String getSQLKeywords() throws SQLException {
        return String.join(",", KEYWORDS);
    }

    @Override
    public String getNumericFunctions() throws SQLException {
        return "abs,floor,ceil,round,sqrt,cbrt,hypot,pow,exp,exp2,log,log2,log10,sin,asin,cos,acos,tan,atan,rand,rand32,rand64,collect,avg,count,max,min,std,sum,bit_and,bit_or,bit_xor,size,range,sign,e,pi,radians";
    }

    @Override
    public String getStringFunctions() throws SQLException {
        return "strcasecmp,lower,toLower,upper,toUpper,length,trim,ltrim,rtrim,left,right,lpad,rpad,substr,substring,reverse,replace,split,toString,hash";
    }

    @Override
    public String getTimeDateFunctions() throws SQLException {
        return "now,date,time,datetime";
    }

    @Override
    public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types) throws SQLException {
        List<List<String>> rows = Collections.emptyList();
        List<String> columnNames = Arrays.asList("TABLE_CAT", "TABLE_SCHEM", "TABLE_NAME", "TABLE_TYPE", "TYPE_CAT", "TYPE_SCHEM", "TYPE_NAME", "SELF_REFERENCING_COL_NAME", "REF_GENERATION");
        return new InternalResultSet<>(rows, columnNames);
    }

    @Override
    public ResultSet getSchemas() throws SQLException {
        return new InternalResultSet<>(Collections.emptyList(), Arrays.asList("TABLE_SCHEM", "TABLE_CATALOG"));
    }

    @Override
    public ResultSet getCatalogs() throws SQLException {
        return new InternalResultSet<>(Collections.emptyList(), Collections.singletonList("TABLE_CAT"));
    }

    @Override
    public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern) throws SQLException {
        return new InternalResultSet<>(Collections.emptyList(), Collections.emptyList());
    }

    /**
     * Retrieves the table types available in this database.  The results
     * are ordered by table type.
     *
     * <P>The table type is:
     * <OL>
     * <LI><B>TABLE_TYPE</B> String {@code =>} table type.  Typical types are "VERTEX", "EDGE".
     * </OL>
     *
     * @return a <code>ResultSet</code> object in which each row has a
     * single <code>String</code> column that is a table type
     * @throws SQLException if a database access error occurs
     */
    @Override
    public ResultSet getTableTypes() throws SQLException {
        return new InternalResultSet<>(Collections.singletonList(Collections.singletonList("TABLE")), Collections.singletonList("TABLE_TYPE"));
    }

    @Override
    public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
        List<String> columnNames = Arrays.asList(
                "TABLE_CAT",
                "TABLE_SCHEM",
                "TABLE_NAME",
                "COLUMN_NAME",
                "DATA_TYPE",
                "TYPE_NAME",
                "COLUMN_SIZE",
                "BUFFER_LENGTH",
                "DECIMAL_DIGITS",
                "NUM_PREC_RADIX",
                "NULLABLE",
                "REMARKS",
                "COLUMN_DEF",
                "SQL_DATA_TYPE",
                "SQL_DATETIME_SUB",
                "CHAR_OCTET_LENGTH",
                "ORDINAL_POSITION",
                "IS_NULLABLE",
                "SCOPE_CATALOG",
                "SCOPE_SCHEMA",
                "SCOPE_TABLE",
                "SOURCE_DATA_TYPE",
                "IS_AUTOINCREMENT",
                "IS_GENERATEDCOLUMN"
        );
        return new InternalResultSet<>(Collections.emptyList(), columnNames);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connection;
    }

    @Override
    public int getDatabaseMajorVersion() throws SQLException {
        return getDriverMajorVersion();
    }

    @Override
    public int getDatabaseMinorVersion() throws SQLException {
        return getDriverMinorVersion();
    }

    @Override
    public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
        List<List<String>> rows = Collections.emptyList();
        return new InternalResultSet<>(rows, Arrays.asList("TABLE_CATALOG", "TABLE_SCHEM"));
    }

    @Override
    public ResultSet getClientInfoProperties() throws SQLException {
        return new InternalResultSet<>(Collections.emptyList(), Arrays.asList("NAME", "MAX_LEN", "DEFAULT_VALUE", "DESCRIPTION"));
    }
}
