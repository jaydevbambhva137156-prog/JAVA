
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OraclePreparedStatementDisplay {
    // Database connection parameters
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Adjust SID/Service Name as needed
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        // Parameterized SQL SELECT query
        String selectQuery = "SELECT employee_id, first_name, last_name, salary FROM employees WHERE salary >= ?";

        try (Scanner scanner = new Scanner(System.in);
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {

            System.out.println("Connected to Oracle Database successfully.");

            // Take minimum salary criteria from user
            System.out.print("Enter minimum salary to filter employees: ");
            double minSalary = scanner.nextDouble();

            // Bind parameter to PreparedStatement
            pstmt.setDouble(1, minSalary);

            // Execute query and process ResultSet
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n---------------------------------------------------------");
                System.out.printf("%-12s %-15s %-15s %-10s%n", "EMP ID", "FIRST NAME", "LAST NAME", "SALARY");
                System.out.println("---------------------------------------------------------");

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    int id = rs.getInt("employee_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    double salary = rs.getDouble("salary");

                    System.out.printf("%-12d %-15s %-15s $%-10.2f%n", id, firstName, lastName, salary);
                }

                if (!found) {
                    System.out.println("No employees found matching the given criteria.");
                }
                System.out.println("---------------------------------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}