package com.vesoft.nebula.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author captain
 */

public class NebulaStatement implements BaseStatement {

    private static final Logger LOG = LoggerFactory.getLogger(NebulaStatement.class);

    private static final Integer EXEC_FAIL = -1;

    private static final Integer EXEC_SUCCESS = 1;

    private NebulaConnection connection;
    protected ResultSet curResultSet = null;
    private List<String> sqlBatch;
    private int maxRows;

    /**
     * 执行sql影响的数据条数， nebula无法返回条数，这里用它标记一下执行状态，-1：失败， 1：成功
     * 执行完成后需要赋值，否则mybatis永远拿到的是1
     */
    protected int currentUpdateCount;

    public NebulaStatement(NebulaConnection connection) {
        this.connection = connection;
        this.currentUpdateCount = EXEC_FAIL;
    }

    public NebulaStatement(ResultSet resultSet) {
        this.curResultSet = resultSet;
        this.currentUpdateCount = EXEC_FAIL;
    }


    protected ResultSet exec(String stmt) throws SQLException {
        com.vesoft.nebula.client.graph.data.ResultSet rs = connection.execute(stmt);
        if (!rs.isSucceeded()) {
            LOG.info("error sql :{}", stmt);
            throw new SQLException(String.format("Error code: %d, Msg: %s", rs.getErrorCode(), rs.getErrorMessage()));
        }
        // rowSize在查询的时候有值
        if (rs.rowsSize() > 0) {
            this.currentUpdateCount = rs.rowsSize();
        } else {
            this.currentUpdateCount = EXEC_SUCCESS;
        }
        curResultSet = new NebulaResultSet(rs);
        return curResultSet;
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        return exec(sql);
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        exec(sql);
        return this.currentUpdateCount;
    }

    @Override
    public void close() throws SQLException {
        connection = null;
        sqlBatch = null;
        if (curResultSet != null) {
            curResultSet.close();
        }
        curResultSet = null;
        currentUpdateCount = -1;
    }

    @Override
    public int getMaxRows() throws SQLException {
        return this.maxRows;
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        this.maxRows = max;
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        exec(sql);
        return this.currentUpdateCount == EXEC_SUCCESS;
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return curResultSet;
    }

    @Override
    public int getUpdateCount() throws SQLException {
        if (curResultSet == null) {
            return EXEC_FAIL;
        }
        return this.currentUpdateCount;
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        return this.curResultSet != null;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        if (rows != Integer.MIN_VALUE && (this.getMaxRows() > 0 && rows > this.getMaxRows())) {
            throw ExceptionUtil.unsupportedFeatureException();
        }
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        if (sqlBatch == null) {
            sqlBatch = new ArrayList<>();
        }
        sqlBatch.add(sql);
    }

    @Override
    public void clearBatch() throws SQLException {
        if (sqlBatch != null) {
            sqlBatch.clear();
        }
    }

    @Override
    public int[] executeBatch() throws SQLException {
        if (sqlBatch != null) {
            exec(String.join(";", sqlBatch));
        }
        return new int[0];
    }

    @Override
    public NebulaConnection getConnection() throws SQLException {
        return connection;
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        return getMoreResults();
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return ResultSet.HOLD_CURSORS_OVER_COMMIT;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return connection == null;
    }

}
