import java.util.Scanner;

public class PrintNameTenTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ". " + name);
        }

        sc.close();
    }
}