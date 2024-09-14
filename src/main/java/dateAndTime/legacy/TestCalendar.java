package dateAndTime.legacy;

import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/*

1) Create a "America/New_York" TimeZone object and using the same create a GregorianCalendar object that can store 2026-12-25 11:30:00
2) Parse the calendar object into a 2026-12-25 11:30:00 and return the same from the method as a String

Expected Output:
        2026-12-25 11:30:00
*/

public class TestCalendar {


    public static void main(String[] args) {
    String output = createCalendarDateAndParse();

    System.out.println("Is Equal :- " + output.equals("2026-12-25 11:30:00"));
    }

    public static String createCalendarDateAndParse() {
        TimeZone newYorkTimeZone = TimeZone.getTimeZone("America/New_York");
        Calendar calendar = new GregorianCalendar(newYorkTimeZone);
        // Set the date and time
        calendar.set(Calendar.YEAR, 2026);
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 25);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        // Display the date and time in New York time zone
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(newYorkTimeZone);
        String formattedDate = dateFormat.format(calendar.getTime());
        return formattedDate;
    }
}
