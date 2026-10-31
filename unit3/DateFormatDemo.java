import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatDemo {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println("=== Default Output ===");
        System.out.println("Default Date: " + currentDate);
        System.out.println();

        System.out.println("=== Different Formats ===");

        // Format 1: DD/MM/YYYY
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("1. DD/MM/YYYY       : " + currentDate.format(fmt1));

        // Format 2: MM-DD-YYYY
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println("2. MM-DD-YYYY       : " + currentDate.format(fmt2));

        // Format 3: Month Name, DD, YYYY
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println("3. Text Month Format : " + currentDate.format(fmt3));

        // Format 4: Short Day, DD Mon YYYY
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");
        System.out.println("4. Day & Short Month: " + currentDate.format(fmt4));

        // Format 5: Date with Time (12-hour format with AM/PM)
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss a");
        System.out.println("5. Date with Time   : " + currentDateTime.format(fmt5));
    }
}
