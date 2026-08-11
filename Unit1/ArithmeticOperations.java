public class ArithmeticOperations {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("java ArithmeticOperations <num1> <num2>");
            return;
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        System.out.println("Addition = " + (num1 + num2));
        System.out.println("Subtraction = " + (num1 - num2));
        System.out.println("Multiplication = " + (num1 * num2));
        System.out.println("Division = " + (num1 / num2));
        System.out.println("Modulus = " + (num1 % num2));
    }

}
