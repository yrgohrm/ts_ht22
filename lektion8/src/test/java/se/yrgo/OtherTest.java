package se.yrgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
// @Disabled
class OtherTest {
    @Container
    private static MySQLContainer<?> mySqlContainer = new MySQLContainer<>("mysql:8.0.29");

    @Test
    @Order(1)
    void testCreateTable() {
        try (Connection conn = DriverManager.getConnection(mySqlContainer.getJdbcUrl(),
                mySqlContainer.getUsername(), mySqlContainer.getPassword())) {
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate("CREATE TABLE foobar (id INT PRIMARY KEY, data INT);");
            stmt.close();

            assertEquals(0, res);
        } catch (SQLException ex) {
            fail(ex);
        }
    }

    @Test
    @Order(2)
    void testInsert() {
        try (Connection conn = DriverManager.getConnection(mySqlContainer.getJdbcUrl(),
                mySqlContainer.getUsername(), mySqlContainer.getPassword())) {
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate("INSERT INTO foobar VALUES (1, 1)");
            stmt.close();

            assertEquals(1, res);
        } catch (SQLException ex) {
            fail(ex);
        }
    }
}
