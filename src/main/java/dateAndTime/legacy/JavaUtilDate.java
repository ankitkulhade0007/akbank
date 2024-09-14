package dateAndTime.legacy;

;

import java.util.Date;

public class JavaUtilDate {

    public static void main(String[] args) {
        createDate();
    }

    public static void createDate() {

        Date currentDate = new Date(); // Current Date and time value
        System.out.println("Empty Date objects Value :- " + currentDate);  // will return you the current Date and Time

        // All below method are deprecated now due to enhancement in other API.
        currentDate.setYear(200);
        currentDate.setMonth(1);
        currentDate.setDate(10);
        currentDate.setHours(10);
        currentDate.setMinutes(10);
        currentDate.setSeconds(10);

        System.out.println("Setting Year Month date in Date object is :- " + currentDate);

        // Date time in millisecond
        long timeInms = currentDate.getTime();
        System.out.println("Time in millisecond :- " + timeInms);

        // creating date using constructor
        Date futureDate = new Date(200, 8, 26, 8, 15, 39);
        System.out.println(futureDate); //Sun Sep 26 08:15:39 IST 2100

        long timeInMilliseconds = futureDate.getTime();
        System.out.println("Date Sun Sep 26 08:15:39 timeInMilliseconds :- " + timeInMilliseconds);


        // in 24 hours you have 86400000 millisecond.
        //  so if you want to add a day in current date which is in milliseconds sec then add 86400000 millisecond
        Date date = new Date(timeInMilliseconds + 86400000);
        System.out.println(date);


        // For date comparison we have af
        boolean isAfter = date.after(futureDate);
        System.out.println(isAfter);

        boolean isBefore = date.before(futureDate);
        System.out.println(isBefore);
        /*
        In computing, an epoch is a fixed date and time used as a reference from
        which a computer measures system time.
         */

        Date date2 = new Date();
        // date2.compareTo(date);
        System.out.println("To Date :- " + date2);   // Sat Sep 14 16:26:48 IST 2024
        System.out.println("To Instant :- " + date2.toInstant()); // 2024-09-14T10:56:48.604Z

    }

}
