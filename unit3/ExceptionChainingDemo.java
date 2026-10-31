public class ExceptionChainingDemo {

    public static void divideNumbers() {
        try {
            int result = 10 / 0; // Triggers original ArithmeticException
        } catch (ArithmeticException e) {
            // Create a higher-level exception and chain the original cause to it
            NullPointerException newExc = new NullPointerException("Higher-level exception: Calculation failed.");
            newExc.initCause(e); // Setting the original cause
            throw newExc;
        }
    }

    public static void main(String[] args) {
        try {
            divideNumbers();
        } catch (Exception e) {
            // Display the current (higher-level) exception
            System.out.println("Caught Outer Exception: " + e.getMessage());

            // Display the root cause using getCause()
            System.out.println("Original Root Cause: " + e.getCause());
        }
    }
}