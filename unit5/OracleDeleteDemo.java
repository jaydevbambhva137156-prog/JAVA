import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleDeleteDemo {
    // Database connection parameters
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Adjust SID/Service Name as needed
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        // SQL DELETE query with placeholder
        String deleteQuery = "DELETE FROM employees WHERE employee_id = ?";

        // Try-with-resources manages closing Connection and PreparedStatement automatically
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {

            System.out.println("Connected to Oracle Database successfully.");

            // Specify the ID of the record to delete
            int targetEmpId = 101;
            pstmt.setInt(1, targetEmpId);

            // Execute delete operation
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully! Rows affected: " + rowsDeleted);
            } else {
                System.out.println("No record found with Employee ID: " + targetEmpId);
            }

        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}