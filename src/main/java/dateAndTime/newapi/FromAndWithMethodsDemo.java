package dateAndTime.newapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class FromAndWithMethodsDemo {

    public static void main(String[] args) {

        formAndWithExample();
    }

    public static  void formAndWithExample(){
        LocalDateTime dateTime = LocalDateTime.of(2015, Month.MARCH, 18, 22, 30);
        System.out.println(dateTime);                                           // 2015-03-18T22:30

        LocalDate derivedDate = LocalDate.from(dateTime);
        LocalTime derivedTime = LocalTime.from(dateTime);
        System.out.println(derivedDate);                                        // 2015-03-18
        System.out.println(derivedTime);                                        // 22:30

        LocalDateTime dateTime1 = dateTime.withYear(2030);
        LocalDateTime dateTime2 = dateTime.withYear(2030).withMonth(10);
        System.out.println(dateTime1);                                          // 2030-03-18T22:30
        System.out.println(dateTime2);                                          // 2030-10-18T22:30

    }

}
