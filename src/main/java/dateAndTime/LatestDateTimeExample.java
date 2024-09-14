package dateAndTime;

import java.time.*;

import static dateAndTime.newapi.FromAndWithMethodsDemo.formAndWithExample;
import static dateAndTime.newapi.GetPlusMinusMethodsDemo.getAndPlusMethodsExample;
import static dateAndTime.newapi.OfMethodsDemo.*;
import static dateAndTime.newapi.ToAndAtMethodsDemo.toAndAtMethodExample;

/*
        Difference between With and At method is
        With method return the same dataType object from that it's getting Called - If you are calling  LocalDate.With(---) it will return LocalDate only
        At method can return you other dataType object as well.

        How to convert Date obj to LocalDate
        How to convert DateTime Obj to LocalDateTime
        How to convert DateTime Obj to LocalTime
 */

public class LatestDateTimeExample {

    public static void main(String[] args) {

        getCurrentDateTimeAndZone();

        createCustmeDateTimeAndZone();

        LocalDate dateOfDays = getTheDateOfGiveYearAndDays(2024, 100);
        System.out.println(dateOfDays);

        // what will be date after epcho date that is 1970 after  1000 days
        LocalDate dateAfterDays = getDateAfterDays(1000);
        System.out.println(dateAfterDays);

        // you have a DateAndTime Object extract only date only time from it
        // create a date from existing date object by updating year or month etc
        // same can be achieved using To and At
        formAndWithExample();
        toAndAtMethodExample();

        getAndPlusMethodsExample();

        scenarioTest();

    }

    private static void scenarioTest() {

// 1) Inside localDateOperations method, create a LocalDate object with the date as Dec 25th 2025.
//    Add 6 months, 18 days to the LocalDate object and return the new LocalDate object

        LocalDate testDate1 = LocalDate.of(2025, 12, 25);
        LocalDate plusTestDate1 = testDate1.plusMonths(6).plusDays(18);
        System.out.println("plusTestDate1 :- " + plusTestDate1);        // 2026-7-13

// 2)  Inside localTimeOperations method, create a LocalTime object with the time as 9:00 AM.
//      Add 8 hours, 15 minutes to the LocalTime object and return the new LocalTime object.

        LocalTime testTime1 = LocalTime.of(9, 00);
        LocalTime plusTestTime1 = testTime1.plusHours(8).plusMinutes(15);
        System.out.println("plusTestTime1 :- " + plusTestTime1);        // 17:15

// 3) Inside localDateTimeOperations method, create a LocalDateTime object with the date & time as Dec 25th 2025, 9:30 AM.
//      Subtract 4 weeks, 30 minutes to the LocalDateTime object and return the new LocalDateTime object.

        LocalDateTime testDateTime1 = LocalDateTime.of(2025, 12, 25, 9, 30);
        LocalDateTime minusTest1 = testDateTime1.minusWeeks(4).minusMinutes(30);
        System.out.println("minusTest1 :- " + minusTest1);              // 2025-11-27T09:00
    }


    public static void getCurrentDateTimeAndZone() {

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println("java 8 - locaDate :-  " + localDate);
        System.out.println("java 8 - localTime :- " + localTime);
        System.out.println("java 8 - localDateTime :- " + localDateTime);
        System.out.println("java 8 - localDateTime2 :- " + localDateTime2);
        System.out.println("java 8 - zonedDateTime :- " + zonedDateTime);
        System.out.println("java 8 - zonedDateTime2 :- " + zonedDateTime2);
    }
}
