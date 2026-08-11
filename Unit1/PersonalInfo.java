import java.util.Scanner;

public class PersonalInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
                String name = scanner.nextLine();
        System.out.print("Enter Age: ");
                String Age = scanner.nextLine();
        System.out.print("Enter Gender: ");
                String Gender = scanner.nextLine();
        System.out.print("City: ");
                String City = scanner.nextLine();

        System.out.println("\n--- Personal Information ---");
        System.out.println("Hello, " + name + "! Welcome to Java.");
        System.out.println("Your Age: "+ Age);
        System.out.println("Gender: " + Gender);
        System.out.println("City: " + City);
        scanner.close();
    }
}
