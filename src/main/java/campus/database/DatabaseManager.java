package campus.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseManager {
    private static final String URL =
            "jdbc:sqlite:smartcampus.db";
    public static Connection getConnection()
            throws SQLException {
        return DriverManager.getConnection(URL);
    }
    public static void testConnection() {
        try (Connection connection = getConnection()) {
            System.out.println(
                    "Database connection successful."
            );
        } catch (SQLException e) {
            System.out.println(
                    "Database connection unavailable: "
                    + e.getMessage()
            );
        }
    }
}
