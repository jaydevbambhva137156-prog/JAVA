// Step 1: Create a custom exception class extending Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        // Pass the custom message to the parent Exception constructor
        super(message);
    }
}

public class CustomExceptionDemo {

    // Step 2: Method that throws the custom exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is invalid. Must be at least 18 for registration.");
        } else {
            System.out.println("Registration successful! Age: " + age);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Invalid Age
        System.out.println("--- Test Case 1 ---");
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }

        System.out.println("\n--- Test Case 2 ---");
        // Test Case 2: Valid Age
        try {
            validateAge(22);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
    }
}