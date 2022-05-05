import com.vesoft.nebula.client.graph.NebulaPoolConfig;
import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.exception.AuthFailedException;
import com.vesoft.nebula.client.graph.exception.IOErrorException;
import com.vesoft.nebula.client.graph.exception.NotValidConnectionException;
import com.vesoft.nebula.client.graph.net.NebulaPool;
import com.vesoft.nebula.client.graph.net.Session;
import com.vesoft.nebula.jdbc.NebulaDriver;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class RunMeBeforeTest {

    public static final String IP = "localhost";
    public static final int PORT = 9669;

    public static final String USERNAME = "test";
    public static final String PASSWORD = "test";

    public static final String GRAPH_SPACE = "test";
    public static final String URL = "jdbc:nebula://"+ IP + ":" + PORT +"/" + GRAPH_SPACE;

    public static final String SHOW_SPACES = "show spaces";
    public static final String CREATE_SPACE = "CREATE SPACE test(partition_num=15, replica_factor=1, vid_type=fixed_string(30));";

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void createTestGraphSchema() throws SQLException, IOErrorException, AuthFailedException, NotValidConnectionException, UnknownHostException, InterruptedException, UnsupportedEncodingException {

        NebulaPoolConfig nebulaPoolConfig = new NebulaPoolConfig();
        List<HostAddress> addresses = Arrays.asList(new HostAddress(IP, PORT));
        NebulaPool pool = new NebulaPool();
        pool.init(addresses, nebulaPoolConfig);
        Session session = pool.getSession(USERNAME, PASSWORD, false);
        boolean JDBCTestSpaceNotExist = true;
        ResultSet result = session.execute(SHOW_SPACES);
        int spaceSize = result.rowsSize();
        for(int i = 0; i < spaceSize; ++i){
            if(RunMeBeforeTest.GRAPH_SPACE.equals(result.rowValues(i).get(0).asString())){
                JDBCTestSpaceNotExist = false;
            }
        }

        if(JDBCTestSpaceNotExist){
            ResultSet execute = session.execute(CREATE_SPACE);
            log.info("Wait a heartbeat cycle to make sure that graph space been created.");
            Thread.sleep(10001);
            if(execute.isSucceeded()){
                log.info("Graph space has been created.");
            }else{
                throw new SQLException(String.format("Graph space created failed, please check server status: [%s]", execute.getErrorMessage()));
            }
            session.release();
            pool.close();
        }

        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        String CREATE_TAG  = "CREATE TAG testNode(theString string, theInt int, theDouble double, theTrueBool bool, theFalseBool bool, theDate date, theTime time, theDatetime datetime)";

        statement.executeUpdate(CREATE_TAG);

        log.info("Tag is created asynchronously, wait a heartbeat cycle to perform subsequently.");
        Thread.sleep(10001);

    }

}
