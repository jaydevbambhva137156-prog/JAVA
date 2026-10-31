public class ThrowKeywordDemo {

    // Method to check voting eligibility
    public static void checkEligibility(int age) {
        if (age < 18) {
            // Manually throwing an ArithmeticException
            throw new ArithmeticException("Access denied: You must be at least 18 years old to vote.");
        } else {
            System.out.println("Access granted: You are eligible to vote!");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Age 15 ---");
        try {
            checkEligibility(15); // This will trigger the throw statement
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("\n--- Testing Age 20 ---");
        try {
            checkEligibility(20); // This will pass normally
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}