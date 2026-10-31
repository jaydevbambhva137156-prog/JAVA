class OuterClass {
    static String staticMessage = "Hello from Outer Class (Static Field)!";
    String nonStaticMessage = "Hello from Outer Class (Instance Field)!";

    // Static Inner Class
    static class StaticInner {
        void display() {
            // Can access static members of the outer class directly
            System.out.println("Inside Static Inner Class: " + staticMessage);

            // Note: Cannot directly access nonStaticMessage without an OuterClass instance
        }
    }
}

public class StaticInnerDemo {
    public static void main(String[] args) {
        // Instantiate the static inner class directly (no outer class object needed)
        OuterClass.StaticInner innerObj = new OuterClass.StaticInner();
        
        // Call the method
        innerObj.display();
    }
}