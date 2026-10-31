import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleUpdateDemo {
    // Database connection parameters
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Adjust SID/Service Name as needed
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        // SQL UPDATE query with placeholders
        String updateQuery = "UPDATE employees SET salary = ? WHERE employee_id = ?";

        // Try-with-resources manages closing Connection and PreparedStatement automatically
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            System.out.println("Connected to Oracle Database successfully.");

            // Setting new values
            pstmt.setDouble(1, 85000.00); // New salary
            pstmt.setInt(2, 101);          // Employee ID to update

            // Execute update operation
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully! Rows affected: " + rowsUpdated);
            } else {
                System.out.println("No record found with the given Employee ID.");
            }

        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}