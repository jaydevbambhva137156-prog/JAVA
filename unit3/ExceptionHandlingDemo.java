import java.util.Scanner;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            // Attempting division (will throw ArithmeticException if denominator is 0)
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handles division by zero
            System.out.println("Error: Cannot divide by zero!");
        } catch (Exception e) {
            // Handles any other invalid input (e.g., entering text instead of numbers)
            System.out.println("Error: Invalid input provided.");
        } finally {
            // Clean up resources
            scanner.close();
            System.out.println("Execution completed.");
        }
    }
}