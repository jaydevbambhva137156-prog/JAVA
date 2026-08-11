import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get different values from the user
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        // Display the entered values
        System.out.println("\n--- User Details ---");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Salary : " + salary);

        sc.close();
    }
}