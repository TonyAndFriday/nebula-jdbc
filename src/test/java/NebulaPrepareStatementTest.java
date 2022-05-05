import com.vesoft.nebula.jdbc.NebulaPreparedStatement;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertEquals;

/**
 * Attention: Please run {@link RunMeBeforeTest#createTestGraphSchema()} if you do not run that method before,
 * it will create graph space for test and insert data into it.
 */

public class NebulaPrepareStatementTest {

    @Test
    public void prepareStatementTest() throws SQLException {
        Connection connection = DriverManager.getConnection(RunMeBeforeTest.URL, RunMeBeforeTest.USERNAME, RunMeBeforeTest.PASSWORD);

        String insert = "INSERT VERTEX testNode (theString, theInt, theDouble, theTrueBool, theFalseBool, theDate, theTime, theDatetime) VALUES " +
                " ? :(?, ?, ?, ?, ?, ?, ?, ?); ";
        String query = "MATCH (v:testNode) where id(v) == ? RETURN id(v) as id, v.theInt as theInt ORDER BY id ASC;";
        String update = "UPDATE VERTEX ON testNode ? SET theInt = theInt + ?; ";
        String delete = "DELETE VERTEX ?; ";

        PreparedStatement insertPreparedStatement = connection.prepareStatement(insert);

        insertPreparedStatement.setString(1, "testNode_1");
        insertPreparedStatement.setString(2, "YYDS");
        insertPreparedStatement.setInt(3, 98);
        insertPreparedStatement.setDouble(4, 12.56);
        insertPreparedStatement.setBoolean(5, true);
        insertPreparedStatement.setBoolean(6, false);
        insertPreparedStatement.setDate(7, Date.valueOf("1919-09-09"));
        insertPreparedStatement.setTime(8, Time.valueOf("16:16:16"));
        NebulaPreparedStatement nebulaPreparedStatement = (NebulaPreparedStatement) insertPreparedStatement;
        nebulaPreparedStatement.setDatetime(9, new java.util.Date());

        assertEquals(1, insertPreparedStatement.executeUpdate());

        PreparedStatement updatePreparedStatement = connection.prepareStatement(update);
        updatePreparedStatement.setString(1, "testNode_1");
        updatePreparedStatement.setInt(2, 2);
        assertEquals(1, updatePreparedStatement.executeUpdate());

        PreparedStatement queryPreparedStatement = connection.prepareStatement(query);
        queryPreparedStatement.setString(1, "testNode_1");
        ResultSet resultSet = queryPreparedStatement.executeQuery();
        resultSet.next();
        assertEquals(100, resultSet.getInt("theInt"));

        PreparedStatement deletePreparedStatement = connection.prepareStatement(delete);
        deletePreparedStatement.setString(1, "testNode_1");
        deletePreparedStatement.executeUpdate();

        connection.close();
    }


}
