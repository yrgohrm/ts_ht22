package se.yrgo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SimpleTest 
{
    @Test
    @Disabled
    void testMySqlConnection()
    {
        try (Connection conn = DriverManager.getConnection("jdbc:tc:mysql:8.0.29:///test", "root", "test")) {
            assertTrue(conn.isValid(0));
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
