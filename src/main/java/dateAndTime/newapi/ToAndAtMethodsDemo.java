package dateAndTime.newapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class ToAndAtMethodsDemo {

    public static void main(String[] args) {

        toAndAtMethodExample();

    }

    public static void toAndAtMethodExample() {
        LocalDateTime dateTime = LocalDateTime.of(2015, Month.MARCH, 18, 22, 30);
        System.out.println(dateTime);                                               // 2015-03-18T22:30

        LocalDate date = dateTime.toLocalDate();
        LocalTime time = dateTime.toLocalTime();

        System.out.println(date);                                                   // 2015-03-18
        System.out.println(time);                                                   // 22:30

        LocalDate localDate = LocalDate.of(2015, 3, 18);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        System.out.println(startOfDay);                                             // 2015-03-18T00:00
        LocalDateTime localDateTime = localDate.atTime(18, 20);
        System.out.println(localDateTime);                                          //2015-03-18T18:20
    }

}
