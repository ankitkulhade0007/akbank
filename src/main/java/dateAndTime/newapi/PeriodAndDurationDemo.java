package dateAndTime.newapi;

import java.time.*;

public class PeriodAndDurationDemo {

    public static void main(String[] args) {

        periodExample();
        durationExample();

    }

    private static void periodExample() {
        Period periodDays = Period.ofDays(10); // Output: P10D
        Period periodMonths = Period.ofMonths(3); // Output: P3M
        Period periodYears = Period.ofYears(2); // Output: P2Y
        Period periodCombined = Period.of(1, 6, 15); // Output: P1Y6M15D
        Period periodBetween = Period.between(LocalDate.of(2022, 1, 1), LocalDate.of(2024, 5, 10)); // Output: P2Y4M9D
        Period periodFromString = Period.parse("P1Y2M3D"); // Output: P1Y2M3D
        Period periodNegated = Period.of(1, 6, 15).negated(); // Output: P-1Y-6M-15D
        Period periodPlus = Period.of(1, 2, 3).plus(Period.ofDays(10)); // Output: P1Y2M13D
        Period periodMinus = Period.of(1, 2, 3).minus(Period.ofDays(10)); // Output: P1Y2M-7D

        LocalDate localDate1 = LocalDate.of(2013, 1, 1); // 2013-01-01
        LocalDate localDate2 = LocalDate.of(2015, 3, 18); // 2015-03-18
        Period period = Period.between(localDate1, localDate2); // P2Y2M17D
        System.out.println("period.getYears() :-  " + period.getYears());
        System.out.println("period.getMonths() :- " + period.getMonths());
        System.out.println("period .getDays() :-  " + period.getDays());
        System.out.println("period.getUnits() :- " + period.getUnits());
        System.out.println("period.isNegative() :- " + period.isNegative());
        System.out.println("period.isZero() :- " + period.isZero());
        System.out.println("period.withYears(1) :- " + period.withYears(1));
        System.out.println("period.withMonths(1) :- " + period.withMonths(1));
        System.out.println("period.withDays(10) :- " + period.withDays(10));
        System.out.println("period.minusDays(1) :- " + period.minusDays(1));
        System.out.println("period.plusDays(1) :- " + period.plusDays(1));
        System.out.println("period.minusMonths(1) :- " + period.minusMonths(1));
        System.out.println("period.minusYears(1) :- " + period.minusYears(1));
        System.out.println(" period.minusYears(1) :- " + period.minusYears(1));
        System.out.println("period.multipliedBy(2) :- " + period.multipliedBy(2));
        System.out.println("period.plusDays(1) :- " + period.plusDays(1));
        System.out.println("period.plusMonths(1) :- " + period.plusMonths(1));
        System.out.println("period.plusYears(1) :- " + period.plusYears(1));
    }

    private static void durationExample() {

// Given two times, how would you add a duration of 5 hours to the first time?
        LocalTime initialTime = LocalTime.of(10, 30); // 10:30 AM
        Duration duration = Duration.ofHours(5);
        LocalTime newTime = initialTime.plus(duration);
        System.out.printf("The time after adding 5 hours is: %s%n", newTime);   // Output: The time after adding 5 hours is: 15:30

// Given two LocalDateTime instances, how would you calculate the duration between them?
        LocalDateTime startDateTime = LocalDateTime.of(2024, 9, 1, 10, 0); // 1st Sept 2024, 10:00 AM
        LocalDateTime endDateTime = LocalDateTime.of(2024, 9, 2, 12, 30); // 2nd Sept 2024, 12:30 PM
        Duration durationBetween = Duration.between(startDateTime, endDateTime);
        System.out.printf("The duration between the two dates is: %s%n", durationBetween);      // Output: The duration between the two dates is: PT26H30M


// How would you create a duration representing 2 days, 4 hours, and 30 minutes?
        Duration customDuration = Duration.ofDays(2).plusHours(4).plusMinutes(30);
        System.out.printf("The custom duration is: %s%n", customDuration); // Output: The custom duration is: PT52H30M

// How would you check if a Duration is zero?
        boolean isZero = customDuration.isZero();
        System.out.printf("Is the duration zero? %b%n", isZero);        // Output: Is the duration zero? false

// How would you check if a Duration is negative?
        boolean isNegative = customDuration.isNegative();
        System.out.printf("Is the duration negative? %b%n", isNegative);    // Output: Is the duration negative? false

// How would you subtract 3 hours from a Duration?
        Duration minusDaysDuration = customDuration.minusDays(1);
        Duration minusHoursDuration = customDuration.minusHours(1);
        Duration minusMillisDuration = customDuration.minusMillis(1);
        Duration minusMinutesDuration = customDuration.minusMinutes(1);
        Duration minusSecondsDuration = customDuration.minusSeconds(1);

// How would you multiply a Duration by 2?
        Duration duration7 = Duration.ofMinutes(45); // 45 minutes
        Duration multipliedDuration = duration7.multipliedBy(2);
        System.out.printf("The duration after multiplying by 2 is: %s%n", multipliedDuration);  // Output: The duration after multiplying by 2 is: PT1H30M

// How would you convert a Duration to seconds?
        Duration duration8 = Duration.ofMinutes(10); // 10 minutes
        long durationInSeconds = duration.getSeconds();
        System.out.printf("The duration in seconds is: %d%n", durationInSeconds);   // Output: The duration in seconds is: 600

// How would you negate a Duration?
        Duration duration9 = Duration.ofHours(3); // 3 hours
        Duration negatedDuration = duration9.negated();
        System.out.printf("The negated duration is: %s%n", negatedDuration);        // Output: The negated duration is: PT-3H

// How would you parse a Duration from a string in the format PT2H30M?
        Duration parsedDuration = Duration.parse("PT2H30M");
        System.out.printf("The parsed duration is: %s%n", parsedDuration);          // Output: The parsed duration is: PT2H30M

    }
}
