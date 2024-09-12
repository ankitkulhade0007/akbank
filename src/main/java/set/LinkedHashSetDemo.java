package set;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

    public static void main(String[] args) {
        var visitedCountries = new LinkedHashSet<String>();
        visitedCountries.add("India");
        visitedCountries.add("USA");
        visitedCountries.add("Dubai");
        visitedCountries.add("Singapore");
        visitedCountries.add("France");

        for (String countryName: visitedCountries) {
            System.out.println(countryName);
        }

       /* SequencedSet<String> reversedVisitedCountries = visitedCountries.reversed();
        System.out.println(reversedVisitedCountries);*/

    }

}
