package dateAndTime.newapi;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDSTDemo {

    public static void main(String[] args) {
        // Flight departure in PST
        ZonedDateTime departure = ZonedDateTime.of(2024, 3, 9, 21, 0, 0, 0, ZoneId.of("America/Los_Angeles"));
        // Expected arrival in NYC (assuming flight duration is 4 hours)
        ZonedDateTime arrival = departure.plusHours(4).withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Departure (PST): " + departure);
        System.out.println("Arrival (EST): " + arrival);

        // Departure (PST): 2024-02-02T21:00-08:00[America/Los_Angeles]
        //Arrival (EST): 2024-02-03T04:00-05:00[America/New_York]

        // Departure (PST): 2024-03-09T21:00-08:00[America/Los_Angeles]
        // Arrival (EST): 2024-03-10T05:00-04:00[America/New_York]
    }

    public static void test() {
        ZonedDateTime londonStartTime, londonEndTime, newYorkStartTime, newYorkEndTime;

        // Assign the londonStartTime as Oct 15, 2024 14:00 with the timezone as Europe/London
        londonStartTime = ZonedDateTime.of(2024, 10, 15, 14, 0, 0, 0, ZoneId.of("Europe/London"));
        londonEndTime = londonStartTime.plusHours(2);

        newYorkStartTime = londonStartTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        newYorkEndTime = londonEndTime.withZoneSameInstant(ZoneId.of("America/New_York"));


        System.out.println("Conference Call Start Time (London): " + londonStartTime);
        System.out.println("Conference Call End Time (London): " + londonEndTime);
        System.out.println("Conference Call Start Time (New York): " + newYorkStartTime);
        System.out.println("Conference Call End Time (New York): " + newYorkEndTime);
    }

}
