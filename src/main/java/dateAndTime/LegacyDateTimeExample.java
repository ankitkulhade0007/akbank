package dateAndTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static dateAndTime.legacy.CalendarDemo.gregorianCalendarExample;
import static dateAndTime.legacy.JavaSQLDate.exampleOfJavaSqlDateCreation;
import static dateAndTime.legacy.JavaUtilDate.createDate;

public class LegacyDateTimeExample {

    public static void main(String[] args) {

        differentWayToCreateTheDate();
        exampleOfSimpleDateFormat();
        exampleOfJavaSqlDate();
        exampleOfGregorianCalendar();
        printAllTheTimeZone();
    }

    private static void printAllTheTimeZone() {
        String[] timeZoneIds = TimeZone.getAvailableIDs();
        for(String timeZoneId : timeZoneIds){
            System.out.println(timeZoneId);
        }
    }

    private static void exampleOfGregorianCalendar() {
        gregorianCalendarExample();
    }

    private static void exampleOfJavaSqlDate() {
        exampleOfJavaSqlDateCreation();
    }

    private static void exampleOfSimpleDateFormat() {
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatter-01 :- " + dateFormat.format(currentDate));

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yy-MM-dd");
        System.out.println("Formatter-02 :- " + dateFormat2.format(currentDate));

        SimpleDateFormat dateFormat3 = new SimpleDateFormat("yy-MMMM-dd HH:mm:ss");
        SimpleDateFormat dateFormat4 = new SimpleDateFormat("yy-MMMM-dd");

        System.out.println("Formatter-03 :- " + dateFormat3.format(currentDate));  // 24-September-14 16:35:44
        System.out.println("Formatter-04 :- " + dateFormat4.format(currentDate));  // 24-September-14

        String dateString = "2100-09-26 14:30:00";
        SimpleDateFormat dateFormat6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date parsedDate = dateFormat6.parse(dateString);
            System.out.println("Formatter-06 :- " + parsedDate);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Date date10 = new Date(126, 11, 25);
            SimpleDateFormat testFormat = new SimpleDateFormat("yy-MMMM-dd HH:mm:ss");
            System.out.println(testFormat.format(date10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void differentWayToCreateTheDate() {
        Date currentDate = new Date(); // Current Date and time value
        System.out.println("Empty Date objects Value :- " + currentDate);  // will return you the current Date and Time

        createDate();
    }
}
