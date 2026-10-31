class OuterClass {
    private String outerData = "Data from Outer Class";

    // Method containing the local inner class
    void displayMethod() {
        int localVariable = 100; // Local variable of the method

        // Local Inner Class defined inside the method
        class LocalInner {
            void printDetails() {
                System.out.println("Inside Local Inner Class:");
                System.out.println("Outer Class Member: " + outerData);
                System.out.println("Method Local Variable: " + localVariable);
            }
        }

        // Object of Local Inner Class must be created within the method
        LocalInner localObj = new LocalInner();
        localObj.printDetails();
    }
}

public class LocalInnerDemo {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.displayMethod();
    }
}