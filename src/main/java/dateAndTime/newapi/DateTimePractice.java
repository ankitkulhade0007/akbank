package dateAndTime.newapi;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class DateTimePractice {

    public static void main(String[] args) {

        LocalDate randomDate = LocalDate.now();

//  Given a random date, how would you find the 3rd Friday of that month?
        System.out.printf("The 3rd Friday of the month is: %s%n",
                randomDate.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.FRIDAY)));

//  Given a random date, how would you find the first date of the month?
        System.out.printf("The first day of the month is: %s%n",
                randomDate.with(TemporalAdjusters.firstDayOfMonth()));

//  Given a random date, how would you find the first day name of the month?
        System.out.printf("The first day name of the month is: %s%n",
                randomDate.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek());

//  Given a random date, how would you find the first day of the next month?
        System.out.printf("The first day of the next month is: %s%n",
                randomDate.with(TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek());

        System.out.printf("The first day of the next month by adding 1 year is: %s%n",
                randomDate.with(TemporalAdjusters.firstDayOfNextMonth()).plusYears(1));

//  Given a random date, how would you find the first day of the next year?
        System.out.printf("The first day of the next year is: %s%n",
                randomDate.with(TemporalAdjusters.firstDayOfNextYear()));

        System.out.printf("The first day name of the next year is: %s%n",
                randomDate.with(TemporalAdjusters.firstDayOfNextYear()).getDayOfWeek());

//  Given a random date, how would you find the first day of the year?
        System.out.printf("The first day of the year is: %s%n",
                randomDate.with(TemporalAdjusters.firstDayOfYear()));

//  Given a random date, how would you find the first Monday of that month?
        System.out.printf("The first Monday of the month is: %s%n",
                randomDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));

//  Given a random date, how would you find the last day of the month?
        System.out.printf("The last day of the month is: %s%n",
                randomDate.with(TemporalAdjusters.lastDayOfMonth()));

//  Given a random date, how would you find the last day of the year?
        System.out.printf("The last day of the year is: %s%n",
                randomDate.with(TemporalAdjusters.lastDayOfYear()));

//  Given a random date, how would you find the last Friday of that month?
        System.out.printf("The last Friday of the month is: %s%n",
                randomDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));

//  Given a random date, how would you find the next Friday after that date?
        System.out.printf("The next Friday is: %s%n",
                randomDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));

//  Given a random date, how would you find the next Friday, or the same date if it is already Friday?
        System.out.printf("The next or same Friday is: %s%n",
                randomDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)));

//  Given a random date, how would you create a custom adjuster that sets the date to the first day of the previous quarter?
        System.out.printf("First day of the previous quarter: %s%n",
                randomDate.with(TemporalAdjusters.ofDateAdjuster(date ->

                {
                    int currentMonth = date.getMonthValue();
                    int previousQuarterStartMonth = ((currentMonth - 1) / 3) * 3 - 2;
                    return date.withMonth(previousQuarterStartMonth).withDayOfMonth(1);
                })));

//  Given a random date, how would you find the previous Monday before that date?

        System.out.printf("The previous Monday is: %s%n",
                randomDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));


//  Given a random date, how would you find the previous Monday, or the same date if it is already Monday?

        System.out.printf("The previous or same Monday is: %s%n",
                randomDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)));

// You can convert an Instant to a ZonedDateTime by using the ZonedDateTime.ofInstant method. You also need to supply a ZoneId:
        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());

        // OR

        ZonedDateTime zdt2 = Instant.now().atZone(ZoneId.systemDefault());

        // You can use the toInstant method in the ChronoZonedDateTime interface, implemented by the ZonedDateTime class, to convert from a ZonedDateTime to an Instant:

        Instant instant = zdt2.toInstant();
        Instant instant1 = ZonedDateTime.now().toInstant();
        LocalDate localDate1 = ZonedDateTime.now().toLocalDate();
        LocalDateTime localDateTime1 = ZonedDateTime.now().toLocalDateTime();
        LocalTime localTime = ZonedDateTime.now().toLocalTime();


    }
}
