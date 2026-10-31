import java.util.Calendar;
import java.util.TimeZone;

public class CalendarDemo {
    public static void main(String[] args) {
        // Create a Calendar instance with current date and time
        Calendar calendar = Calendar.getInstance();

        System.out.println("=== Basic Date Information ===");
        System.out.println("Year: " + calendar.get(Calendar.YEAR));
        
        // Note: Months are 0-indexed in Calendar class (0 = January, 11 = December)
        int month = calendar.get(Calendar.MONTH) + 1; 
        System.out.println("Month (1-12): " + month);
        System.out.println("Day of Month: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Day of Year: " + calendar.get(Calendar.DAY_OF_YEAR));

        System.out.println("\n=== Time Information ===");
        System.out.println("Hour (12-hour format): " + calendar.get(Calendar.HOUR));
        System.out.println("Hour (24-hour format): " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute: " + calendar.get(Calendar.MINUTE));
        System.out.println("Second: " + calendar.get(Calendar.SECOND));
        System.out.println("AM/PM: " + (calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM"));

        System.out.println("\n=== Week & Month Information ===");
        System.out.println("Day of Week (1=Sun, 7=Sat): " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Week of Month: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Week of Year: " + calendar.get(Calendar.WEEK_OF_YEAR));

        System.out.println("\n=== Calendar Properties & Limits ===");
        System.out.println("Maximum Days in Current Month: " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("Time Zone: " + TimeZone.getDefault().getDisplayName());
    }
}