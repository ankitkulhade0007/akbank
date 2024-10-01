package dateAndTime.newapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

// Truncat method use populate the Date Tme till Passing unit. It's like subString.
// if
public class TruncatedToMethodDemo {

    public static void main(String[] args) {
        Duration duration = Duration.ofDays(28).plusHours(6).plusMinutes(56).plusSeconds(19); // PT678H56M19S
        Duration daysTruncated = duration.truncatedTo(ChronoUnit.DAYS); // PT672H
        Duration hoursTruncated = duration.truncatedTo(ChronoUnit.HOURS); // PT678H
        Duration minutesTruncated = duration.truncatedTo(ChronoUnit.MINUTES); // PT678H56M

        LocalDate localDate = LocalDate.now();              // Do not support truncate operation
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime truncatedHours = localDateTime.truncatedTo(ChronoUnit.HOURS);
        LocalDateTime truncatedMinute = localDateTime.truncatedTo(ChronoUnit.MINUTES);
        LocalDateTime truncatedDays = localDateTime.truncatedTo(ChronoUnit.DAYS);

        System.out.printf("localDateTime %s%n", localDateTime);         // 2024-09-16T16:10:29.829952700
        System.out.printf("truncatedHours %s%n", truncatedHours);       // 2024-09-16T16:00
        System.out.printf("truncated minute %s%n", truncatedMinute);    // 2024-09-16T16:10
        System.out.printf("truncatedDays %s%n", truncatedDays);         // 2024-09-16T00:00
    }

}
