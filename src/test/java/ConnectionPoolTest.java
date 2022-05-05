import com.vesoft.nebula.jdbc.NebulaDriver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolTest {
    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:nebula://localhost:9669/kdp_dev");
        config.setDriverClassName(NebulaDriver.class.getName());
        config.setUsername("test");
        config.setPassword("test");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        try(HikariDataSource ds = new HikariDataSource(config)) {
            try (Connection connection = ds.getConnection()) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("show tags");
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
        }
    }
}
