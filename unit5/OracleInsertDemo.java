import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleInsertDemo {
    // Database connection credentials
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Replace 'xe' with your SID/Service Name
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        // SQL INSERT query using placeholders (?) to prevent SQL injection
        String insertQuery = "INSERT INTO employees (employee_id, first_name, last_name, salary) VALUES (?, ?, ?, ?)";

        // Try-with-resources automatically closes Connection and PreparedStatement
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            System.out.println("Connected to Oracle Database successfully.");

            // Setting values for the placeholders
            pstmt.setInt(1, 101);
            pstmt.setString(2, "John");
            pstmt.setString(3, "Doe");
            pstmt.setDouble(4, 75000.50);

            // Execute the insert operation
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully! Rows affected: " + rowsInserted);
            }

        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}