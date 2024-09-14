package dateAndTime.legacy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarDemo {

    public static void main(String[] args) {
        gregorianCalendarExample();
    }

    public static void gregorianCalendarExample(){
        // creating Calendar Object
        Calendar currentDate = Calendar.getInstance();

        GregorianCalendar gregorianCalendar = new GregorianCalendar(2100, Calendar.JANUARY, 1);

        Date currentDateObj = gregorianCalendar.getTime();
        System.out.println("gregorianCalendar :- "+ currentDateObj);


//----------------------- It return a Yeas, month, dat, hour, minute, second and milliSeconds All give a Method to set all this property
        int year = gregorianCalendar.get(Calendar.YEAR);
        int month = gregorianCalendar.get(Calendar.MONTH);
        int date = gregorianCalendar.get(Calendar.DATE);
        int hour = gregorianCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = gregorianCalendar.get(Calendar.MINUTE);
        int seconds = gregorianCalendar.get(Calendar.SECOND);
        int milliSeconds = gregorianCalendar.get(Calendar.MILLISECOND);

        System.out.printf("Current Date and Time in : %04d-%02d-%02d %02d:%02d:%02d:%04d%n",
                year, month, date, hour, minutes, seconds,milliSeconds);

//------------- Also provide a method to set the fiels
        gregorianCalendar.set(Calendar.YEAR, 2101);
        gregorianCalendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        Date currentDateObj1 = gregorianCalendar.getTime();
        System.out.println("Calendar date After setting :- " + currentDateObj1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(gregorianCalendar.getTime());
        System.out.println(formattedDate);

//---------------- It Provide the method to add and subtract the  year, month, date, hour, minutes, seconds,milliSeconds
        gregorianCalendar.add(Calendar.HOUR, 2);
        gregorianCalendar.add(Calendar.MONTH, -3);
        formattedDate = dateFormat.format(gregorianCalendar.getTime());
        System.out.println(formattedDate);


//------------------It has a IsLeapYear method to check the LeapYear
        boolean isLeapYear = gregorianCalendar.isLeapYear(2049);
        System.out.println(isLeapYear);

//---------------- Different Method available in GregorianCalendar calendar--------------------------------------------
        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println("GregorianCalendar calendar object" + calendar);

        Date cDate = calendar.getTime();
        System.out.println("GregorianCalendar calendar Date" + cDate);

        String calendarType = calendar.getCalendarType();
        System.out.println("GregorianCalendar calendar Type" + calendarType);

        TimeZone timeZone = calendar.getTimeZone();
        System.out.println("TimeZone :- " + timeZone);

        System.out.println("Current Date And Time is :- "+ cDate);

        System.out.println(" DAY_OF_MONTH :-   " +  calendar.getMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(" DAY_OF_WEEK :-   " +  calendar.getMaximum(Calendar.DAY_OF_WEEK));
        System.out.println(" DAY_OF_YEAR :-   " +  calendar.getMaximum(Calendar.DAY_OF_YEAR));
        System.out.println(" DAY_OF_WEEK_IN_MONTH :-   " +  calendar.getMaximum(Calendar.DAY_OF_WEEK_IN_MONTH));

        System.out.println(" DAY_OF_MONTH :-   " +  calendar.getMinimum(Calendar.DAY_OF_MONTH));
        System.out.println(" DAY_OF_WEEK :-   " +  calendar.getMinimum(Calendar.DAY_OF_WEEK));
        System.out.println(" DAY_OF_YEAR :-   " +  calendar.getMinimum(Calendar.DAY_OF_YEAR));
        System.out.println(" DAY_OF_WEEK_IN_MONTH :-   " +  calendar.getMinimum(Calendar.DAY_OF_WEEK_IN_MONTH));

        System.out.println("Get Actual DAY_OF_MONTH :-   " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  //  give current month total days
        System.out.println("Get Actual DAY_OF_MONTH :-   " + calendar.getActualMinimum(Calendar.DAY_OF_MONTH));  // current month  min days - 1

        System.out.println("Get getFirstDayOfWeek :-   " + calendar.getFirstDayOfWeek());               //1
        System.out.println("Get getWeekYear :-   " + calendar.getWeekYear());                           // 2024 Year
        System.out.println("Get getTimeInMillis :-   " + calendar.getTimeInMillis());


    }

}
