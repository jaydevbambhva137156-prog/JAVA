import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarDemo {
    public static void main(String[] args) {
        // Create an instance of GregorianCalendar with current date and time
        GregorianCalendar gcal = new GregorianCalendar();

        System.out.println("=== Gregorian Calendar Details ===");
        System.out.println("Year: " + gcal.get(Calendar.YEAR));
        
        // Months are 0-indexed (0 = January, 11 = December)
        int month = gcal.get(Calendar.MONTH) + 1;
        System.out.println("Month (1-12): " + month);
        System.out.println("Date: " + gcal.get(Calendar.DATE));
        System.out.println("Day of Week (1=Sun, 7=Sat): " + gcal.get(Calendar.DAY_OF_WEEK));

        System.out.println("\n=== Time Information ===");
        System.out.println("Time: " + gcal.get(Calendar.HOUR) + ":" 
                                   + gcal.get(Calendar.MINUTE) + ":" 
                                   + gcal.get(Calendar.SECOND) + " "
                                   + (gcal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM"));

        System.out.println("\n=== Gregorian Specific Features ===");
        int currentYear = gcal.get(Calendar.YEAR);
        
        // isLeapYear() is a specific method in GregorianCalendar
        if (gcal.isLeapYear(currentYear)) {
            System.out.println(currentYear + " is a Leap Year.");
        } else {
            System.out.println(currentYear + " is NOT a Leap Year.");
        }

        System.out.println("Era: " + (gcal.get(Calendar.ERA) == GregorianCalendar.AD ? "AD" : "BC"));
        System.out.println("Total Days in Current Month: " + gcal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("Total Days in Current Year: " + gcal.getActualMaximum(Calendar.DAY_OF_YEAR));
    }
}