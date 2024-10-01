package DSAAlgoritham;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StableSortAndUnstableSortExample {

    private static void stableSortExample() {
        List<PersonDsa> people = Arrays.asList(
                new PersonDsa("Alice", 30),
                new PersonDsa("Bob", 25),
                new PersonDsa("Charlie", 30),
                new PersonDsa("David", 25)
        );
        // Stable sort by age
        Collections.sort(people, Comparator.comparingInt(person -> person.age));
        System.out.printf("stableSortExample %s %n", people);
    }

    public static void unstableSortExample() {
        int[][] data = {{1, 3}, {2, 3}, {3, 3}, {4, 2}};

        // Unstable sort by second column (index 1)
        Arrays.sort(data, (a, b) -> Integer.compare(a[1], b[1]));

        System.out.print("unstableSortExample :- ");
        for (int[] row : data) {
            System.out.print(Arrays.toString(row));
        }
        System.out.println(" ");
    }

//  output - unstableSortExample :- [4, 2][1, 3][2, 3][3, 3]

/*    The behavior you're observing suggests that Java's Arrays.sort() is using a stable sort internally for your example, which can happen under certain conditions.

    In Java 7 and later, Arrays.sort(Object[]) uses the Timsort algorithm, which is a stable sorting algorithm. Timsort is stable and works on reference types (like Object[], Integer[], and custom objects). However, for primitive types, the sort implementation can differ, and stability is not guaranteed, but often it still appears stable in practice for small inputs or specific conditions.

    For your case, you're sorting arrays of integers (int[][]), which are reference types, so the sort appears stable because of the underlying sorting algorithm.
 */

    public static void forceUnstableSortExample() {
        int[][] data = {{1, 3}, {2, 3}, {3, 3}, {4, 2}};

        // Custom comparator to introduce instability by reversing order
        Arrays.sort(data, (a, b) -> {
            int result = Integer.compare(a[1], b[1]);
            // Force instability by reversing order when elements are equal
            if (result == 0) return -1;
            return result;
        });

        System.out.print("forceUnstableSortExample :- ");
        for (int[] row : data) {
            System.out.print(Arrays.toString(row));
        }
        System.out.println(" ");
    }

    /*  Sorting Person with His Age :- - [ David (25), Bob (25), Eve (30), Charlie (30), Alice (30),  ]
      Sorting Person with His Age :- - [ David (25), Bob (25), Eve (30), Charlie (30), Alice (30),  ]
      Sorting Person with His Age :- - [ Alice (30), Bob (25), Charlie (30), David (25), Eve (30),  ]
      Sorting Person with His Age :- - [ Eve (30), David (25), Charlie (30), Bob (25), Alice (30),  ]
  */
    public static void differentSortingOfPersonExample() {
        List<PersonDsa> people = Arrays.asList(
                new PersonDsa("Alice", 30),
                new PersonDsa("Bob", 25),
                new PersonDsa("Charlie", 30),
                new PersonDsa("David", 25),
                new PersonDsa("Eve", 30)
        );
        // Custom comparator to simulate unstable sort
        Collections.sort(people, (p1, p2) -> {
            int result = Integer.compare(p1.age, p2.age);
            // Introduce instability by always returning -1 when ages are equal
            if (result == 0) return -1;  // This makes the sort unstable
            return result;
        });
        printList(people, "Sorting Person with His Age Unstable Sorting ");

        Collections.sort(people, Comparator.comparingInt(person -> person.age));
        printList(people, "Sorting Person with His Age comparingInt ");


        Collections.sort(people, Comparator.comparing(person -> person.name));
        printList(people, "Sorting Person with his name ");

        /*
        For descending order (if you want):
        If you want to sort the names in descending order, you can reverse the comparison like this:
        */

        Collections.sort(people, Comparator.comparing(person -> person.name, Comparator.reverseOrder()));
        printList(people, "Sorting person with his name in reverse order");
    }

    public static void printList(List<PersonDsa> people, String message) {
        System.out.print("Sorting Person with His Age :- - [ ");
        for (PersonDsa p : people) {
            System.out.print(p + ", ");
        }
        System.out.println(" ]");

    }
}
