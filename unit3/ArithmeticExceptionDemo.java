public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            System.out.println("Attempting to divide " + a + " by " + b + "...");
            // This line triggers an ArithmeticException because division by zero is mathematically undefined
            int result = a / b;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Catches the specific ArithmeticException
            System.out.println("Caught Exception: " + e.getMessage());
            System.out.println("Error: Cannot divide an integer by zero!");

        } finally {
            System.out.println("Program execution completed.");
        }
    }
}