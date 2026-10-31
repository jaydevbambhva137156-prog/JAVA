// Outer Class
class Outer {
    private String message = "Hello from the Outer class private variable!";

    // Inner Class
    class Inner {
        void display() {
            // Inner class can directly access outer class members
            System.out.println("Inside Inner Class: " + message);
        }
    }

    // Method inside Outer class to instantiate and run Inner class method
    void createAndShowInner() {
        Inner innerObj = new Inner();
        innerObj.display();
    }
}

public class OuterDemo {
    public static void main(String[] args) {
        // Method 1: Access inner class via outer class method
        System.out.println("--- Access via Outer Method ---");
        Outer outer = new Outer();
        outer.createAndShowInner();

        // Method 2: Instantiate inner class directly using outer class object
        System.out.println("\n--- Access via Direct Outer.Inner Instantiation ---");
        Outer.Inner directInner = outer.new Inner();
        directInner.display();
    }
}