import java.io.FileReader;
import java.io.FileNotFoundException;

public class ThrowsKeywordDemo {

    // Method declaring that it can throw a checked exception (FileNotFoundException)
    public static void openFile(String fileName) throws FileNotFoundException {
        System.out.println("Attempting to open file: " + fileName);
        // This line attempts to open a non-existent file
        FileReader file = new FileReader(fileName);
    }

    public static void main(String[] args) {
        // Calling the method inside a try-catch block to handle the declared exception
        try {
            openFile("non_existent_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught Exception in main: File was not found on the system.");
        } finally {
            System.out.println("Execution completed.");
        }
    }
}