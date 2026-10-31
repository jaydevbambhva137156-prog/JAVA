import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class OraclePreparedStatementUpdateDelete {
    // Database connection parameters
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Adjust SID/Service Name as needed
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        // Parameterized SQL Queries
        String updateQuery = "UPDATE employees SET salary = ? WHERE employee_id = ?";
        String deleteQuery = "DELETE FROM employees WHERE employee_id = ?";

        try (Scanner scanner = new Scanner(System.in);
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {

            System.out.println("Connected to Oracle Database successfully.\n");
            System.out.println("Select Operation:");
            System.out.println("1. Update Employee Salary");
            System.out.println("2. Delete Employee Record");
            System.out.print("Enter choice (1 or 2): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Perform Update
                    try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery)) {
                        System.out.print("Enter Employee ID to update: ");
                        int empId = scanner.nextInt();
                        System.out.print("Enter new Salary: ");
                        double newSalary = scanner.nextDouble();

                        // Bind parameters
                        pstmtUpdate.setDouble(1, newSalary);
                        pstmtUpdate.setInt(2, empId);

                        int rowsUpdated = pstmtUpdate.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Record updated successfully! Rows affected: " + rowsUpdated);
                        } else {
                            System.out.println("No employee found with ID: " + empId);
                        }
                    }
                    break;

                case 2:
                    // Perform Delete
                    try (PreparedStatement pstmtDelete = conn.prepareStatement(deleteQuery)) {
                        System.out.print("Enter Employee ID to delete: ");
                        int empId = scanner.nextInt();

                        // Bind parameter
                        pstmtDelete.setInt(1, empId);

                        int rowsDeleted = pstmtDelete.executeUpdate();
                        if (rowsDeleted > 0) {
                            System.out.println("Record deleted successfully! Rows affected: " + rowsDeleted);
                        } else {
                            System.out.println("No employee found with ID: " + empId);
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}