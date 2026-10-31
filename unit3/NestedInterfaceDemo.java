// Outer Interface
interface Bank {
    void showBankName();

    // Nested Interface inside Bank
    interface InterestCalculator {
        void calculateInterest(double principal, double rate, int time);
    }
}

// Class implementing the nested interface directly (Bank.InterestCalculator)
class FixedDeposit implements Bank.InterestCalculator {
    
    @Override
    public void calculateInterest(double principal, double rate, int time) {
        double interest = (principal * rate * time) / 100;
        System.out.println("Calculated Simple Interest: $" + interest);
    }
}

public class NestedInterfaceDemo {
    public static void main(String[] args) {
        // Creating an object using the OuterInterface.NestedInterface reference type
        Bank.InterestCalculator calculator = new FixedDeposit();
        
        // Calling the method of the nested interface
        calculator.calculateInterest(10000, 5.5, 2);
    }
}