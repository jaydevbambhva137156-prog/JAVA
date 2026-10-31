import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateArithmeticDemo {
    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("=== Current Date & Time ===");
        System.out.println("Current: " + currentDateTime.format(formatter));
        System.out.println();

        // 1. Adding Days and Months
        System.out.println("=== Addition Operations ===");
        LocalDateTime plus10Days = currentDateTime.plusDays(10);
        System.out.println("After Adding 10 Days   : " + plus10Days.format(formatter));

        LocalDateTime plus3Months = currentDateTime.plusMonths(3);
        System.out.println("After Adding 3 Months  : " + plus3Months.format(formatter));

        LocalDateTime plus2Years = currentDateTime.plusYears(2);
        System.out.println("After Adding 2 Years   : " + plus2Years.format(formatter));
        System.out.println();

        // 2. Subtracting Days and Months
        System.out.println("=== Subtraction Operations ===");
        LocalDateTime minus15Days = currentDateTime.minusDays(15);
        System.out.println("After Subtracting 15 Days  : " + minus15Days.format(formatter));

        LocalDateTime minus2Months = currentDateTime.minusMonths(2);
        System.out.println("After Subtracting 2 Months : " + minus2Months.format(formatter));

        LocalDateTime minus1Year = currentDateTime.minusYears(1);
        System.out.println("After Subtracting 1 Year   : " + minus1Year.format(formatter));
    }
}