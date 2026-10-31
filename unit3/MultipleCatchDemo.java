public class MultipleCatchDemo {
    public static void main(String[] args) {
        try {
            int[] numbers = {10, 20, 30};
            int divisor = 0;

            // Example 1: Triggers ArithmeticException (Division by zero)
            System.out.println("Dividing number: " + (numbers[0] / divisor));

            // Example 2: Would trigger ArrayIndexOutOfBoundsException if line above didn't fail
            // System.out.println("Accessing invalid index: " + numbers[5]);

        } catch (ArithmeticException e) {
            // Catches math errors like division by zero
            System.out.println("Caught ArithmeticException: Cannot divide by zero!");

        } catch (ArrayIndexOutOfBoundsException e) {
            // Catches array indexing errors
            System.out.println("Caught ArrayIndexOutOfBoundsException: Array index is out of bounds!");

        } catch (Exception e) {
            // General catch block for any other unexpected exceptions
            System.out.println("Caught General Exception: " + e.getMessage());

        } finally {
            System.out.println("Execution finished.");
        }
    }
}