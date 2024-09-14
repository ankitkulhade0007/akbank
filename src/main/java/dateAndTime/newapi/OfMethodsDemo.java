package dateAndTime.newapi;

import java.time.*;

public class OfMethodsDemo {

    public static void main(String[] args) {

        createCustmeDateTimeAndZone();

        LocalDate someDate = LocalDate.ofEpochDay(1000);
        System.out.println(someDate);

    }

    public static void createCustmeDateTimeAndZone() {
        LocalDate date = LocalDate.of(2015, Month.MARCH, 18);
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dateTime = LocalDateTime.of(2015,3,18,14,30);
        ZoneId newYorkTimeZone = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2015,3,18,14,30,0, 0, newYorkTimeZone);
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(zonedDateTime);
    }
    public static LocalDate getTheDateOfGiveYearAndDays(int year, int days){
        // days can not be more than 366 days
        LocalDate dateOfTheDays = LocalDate.ofYearDay(year, days);
        System.out.println(dateOfTheDays);
        return dateOfTheDays;
    }

    public static LocalDate getDateAfterDays(long days){
       LocalDate localDate = LocalDate.ofEpochDay(days);
       System.out.println(localDate);
       return localDate;
    }

}
