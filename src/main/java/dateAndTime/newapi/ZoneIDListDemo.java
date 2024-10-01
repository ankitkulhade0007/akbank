package dateAndTime.newapi;

import java.time.ZoneId;
import java.util.Set;

public class ZoneIDListDemo {

    public static void main(String[] args) {
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        System.out.printf("Available ZoneIds Number: %s%n", allZones.size());
        for(String zoneId : allZones) {
            System.out.println(zoneId);
        }
        System.out.printf("Available ZoneIds Number: %s%n", allZones.size());   // 603
    }

}
