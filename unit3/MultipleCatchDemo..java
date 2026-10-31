public class MultipleCatchDemo {
    public static void main(String[] args) {
        try {
            int[] numbers = {10, 20, 30};
            int divisor = 0;

            // Step 1: Triggers ArithmeticException (Division by zero)
            System.out.println("Dividing number: " + (numbers[0] / divisor));

            // Step 2: Accessing an invalid index (Will not execute because Step 1 fails first)
            System.out.println("Accessing invalid index: " + numbers[5]);

        } catch (ArithmeticException e) {
            // Handles mathematical errors like division by zero
            System.out.println("Caught ArithmeticException: Cannot divide by zero!");

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handles array index out-of-range errors
            System.out.println("Caught ArrayIndexOutOfBoundsException: Array index is out of bounds!");

        } catch (Exception e) {
            // Generic catch block for any other unexpected exceptions
            System.out.println("Caught General Exception: " + e.getMessage());

        } finally {
            System.out.println("Program execution completed.");
        }
    }
}