import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDisplayDemo {
    // Database connection parameters
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Adjust SID/Service Name if needed
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        String selectQuery = "SELECT employee_id, first_name, last_name, salary FROM employees";

        // Try-with-resources manages closing Connection, Statement, and ResultSet automatically
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            System.out.println("Connected to Oracle Database successfully.\n");
            System.out.println("---------------------------------------------------------");
            System.out.printf("%-12s %-15s %-15s %-10s%n", "EMP ID", "FIRST NAME", "LAST NAME", "SALARY");
            System.out.println("---------------------------------------------------------");

            // Iterate through the result set
            boolean hasRecords = false;
            while (rs.next()) {
                hasRecords = true;
                int id = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                double salary = rs.getDouble("salary");

                System.out.printf("%-12d %-15s %-15s $%-10.2f%n", id, firstName, lastName, salary);
            }

            if (!hasRecords) {
                System.out.println("No records found in the table.");
            }
            System.out.println("---------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}