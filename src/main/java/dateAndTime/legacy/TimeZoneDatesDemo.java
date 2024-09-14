package dateAndTime.legacy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneDatesDemo {

    public static void main(String[] args) {

        getCurrentDateByTimeZone("yyyy-MMMM-dd HH:mm:ss", "America/New_York");
        getCustomtDateByTimeZone(2024, 12,17, "yyyy-MMMM-dd HH:mm:ss", "America/New_York");
    }

    public static String getCurrentDateByTimeZone(String dateFormat, String timeZoneName){
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        format.setTimeZone(TimeZone.getTimeZone(timeZoneName));
       return format.format(new Date());
    }

    public static String getCustomtDateByTimeZone(int year, int month, int date, String inputDateFormat, String timeZoneName){
        SimpleDateFormat dateFormat = new SimpleDateFormat(inputDateFormat);
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneName));
        return dateFormat.format(new Date(year,month,date));
    }

    public static void timeZoneDatesExample(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        String formattedDate = dateFormat.format(new Date());

        System.out.println(formattedDate);

        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Vatican"));
        formattedDate = dateFormat.format(new Date());

        System.out.println(formattedDate);

        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("America/New_York"));
        int year = gregorianCalendar.get(Calendar.YEAR);
        int month = gregorianCalendar.get(Calendar.MONTH);
        int date = gregorianCalendar.get(Calendar.DATE);
        int hour = gregorianCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = gregorianCalendar.get(Calendar.MINUTE);
        int seconds = gregorianCalendar.get(Calendar.SECOND);
        int milliSeconds = gregorianCalendar.get(Calendar.MILLISECOND);

        System.out.printf("Current Date and Time in : %04d-%02d-%02d %02d:%02d:%02d:%04d%n",
                year, month, date, hour, minutes, seconds,milliSeconds);

        String newPrng  = String.format("%04d-%02d-%02d %02d:%02d:%02d:%04d%n" ,year, month, date, hour, minutes, seconds,milliSeconds);
        System.out.println("newPrng - "+  newPrng);

// In the above you have though like instead of writing get for y, m, d, h etc why can't we just call the getTime()
// Ans- getTime() method will return your current timeZone corresponding date and time
// Reason - getTime() create the new Date object where it will consider the current timeZone

        System.out.println(gregorianCalendar.getTime());
    }

}
