public class ExceptionPropagationDemo {

    // Method 1: Exception originates here
    void method1() {
        System.out.println("Inside method1: Performing division by zero...");
        int data = 50 / 0; // Throws ArithmeticException
    }

    // Method 2: Calls method1 without handling the exception
    void method2() {
        System.out.println("Inside method2: Calling method1...");
        method1(); // Exception propagates to method2
    }

    // Method 3: Calls method2 and handles the propagated exception
    void method3() {
        System.out.println("Inside method3: Calling method2 inside try block...");
        try {
            method2(); // Exception propagates here from method2
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception in method3: " + e.getMessage());
            System.out.println("Handled division by zero error successfully.");
        }
    }

    public static void main(String[] args) {
        ExceptionPropagationDemo obj = new ExceptionPropagationDemo();
        obj.method3();
        System.out.println("Program execution completed normally.");
    }
}