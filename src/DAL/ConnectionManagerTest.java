package DAL;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class ConnectionManagerTest {
    @Test
    public void testGetters() throws Exception {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = ConnectionManager.getConnection();

        assertNotNull(connectionManager);
        assertNotNull(connection);

    }
}