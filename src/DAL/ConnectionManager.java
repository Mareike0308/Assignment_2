package DAL;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionManager {
    private final SQLServerDataSource ds;
    private static ConnectionManager instance;

    public ConnectionManager() throws IOException
    {
        ds = new SQLServerDataSource();
        ds.setServerName("10.176.111.31");
        ds.setDatabaseName("Assignment2-march2022");
        ds.setPortNumber(1433);
        ds.setUser("CSe21B_9");
        ds.setPassword("CSe21B_9");
    }

    public static ConnectionManager getInstance() throws IOException {
        return instance == null ? instance = new ConnectionManager() : instance;
    }

    public static Connection getConnection() throws SQLServerException, IOException {
        return getInstance().ds.getConnection();
    }
    public static void main (String[] args) throws SQLException, IOException {
        ConnectionManager ds = new ConnectionManager();
        try (Connection connection= ds.getConnection()){
            System.out.println("Is it open"+!connection.isClosed());}
    }
}