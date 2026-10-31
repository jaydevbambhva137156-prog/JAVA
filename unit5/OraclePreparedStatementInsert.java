import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class OraclePreparedStatementInsert {
    // Database connection parameters
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Adjust SID/Service Name as needed
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        // SQL INSERT query using parameter placeholders (?)
        String insertQuery = "INSERT INTO employees (employee_id, first_name, last_name, salary) VALUES (?, ?, ?, ?)";

        try (Scanner scanner = new Scanner(System.in);
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            System.out.println("Connected to Oracle Database successfully.");

            // Taking input from user
            System.out.print("Enter Employee ID: ");
            int empId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            // Binding parameters to the SQL query
            pstmt.setInt(1, empId);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setDouble(4, salary);

            // Executing the query
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully using PreparedStatement!");
            }

        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}