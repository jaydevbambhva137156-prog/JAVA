public class FinallyBlockDemo {
    public static void main(String[] args) {
        
        // Case 1: Exception occurs and is handled
        System.out.println("--- Case 1: Exception occurs ---");
        try {
            int result = 10 / 0; // Throws ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Catch Block: Cannot divide by zero!");
        } finally {
            System.out.println("Finally Block: This always executes (Cleanup code goes here).");
        }

        System.out.println(); // Blank line for readability

        // Case 2: No exception occurs
        System.out.println("--- Case 2: No exception ---");
        try {
            int result = 10 / 2; // Normal division
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Catch Block: This will NOT run.");
        } finally {
            System.out.println("Finally Block: This still executes!");
        }
    }
}