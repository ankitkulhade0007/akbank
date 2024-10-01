package codingPractice;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}


public class ReverseString {
    private static int factorial(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return i * factorial(i - 1);
    }

    private static boolean isPrimeNumber(int i) {
        if (i <= 1 || (i % 2 == 0)) {
            System.out.printf("Given Number %s is not a prime number %n", i);
            return false;                                                       // 0,1,negative and All other even numbers are not prime
        }
        if (i == 2) {
            System.out.printf("Given Number %s is a prime number %n", i);
            return true;
        }
        for (int j = 2; j < i / 2; j++) {
            if (i % j == 0) {
                System.out.printf("Given Number %s is not a prime number %n", i);
                return false;
            }
        }
        System.out.printf("Given Number %s is a prime number %n", i);
        return false;
    }

    private static void stringContainsVowels(String value) {
        String[] arr = value.toLowerCase().split("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                System.out.printf("Is Given String have Vowels %s %n", true);
                break;
            }
        }

        // 2nd approach
        System.out.printf("Is Given String have Vowels %s %n", value.toLowerCase().matches(".*[aeiou].*"));

        StringBuilder builder1 = new StringBuilder("arth");
        System.out.printf("%s %n", value.toLowerCase().contentEquals(builder1));
    }

    private static void contentEqualMethodExample() {
        String value = "HelloWorld";
        CharSequence cs = "helloworld";
        StringBuilder sb = new StringBuilder("helloworld");
        System.out.println("The contents are equal. " + value.toLowerCase().contentEquals(cs));          // true
        System.out.println("The contents are equal. " + value.toLowerCase().contentEquals(sb));          // true
    }

    // the codePoint methods operate on Unicode code points in a String. These methods are useful for working with Unicode characters,
    // especially those that require more than one char to represent (like emoji or certain accented characters).
    private static void codePointMethodExample() {
        String value = "Hello";
        int codePoint = value.toLowerCase().codePointAt(1);
        System.out.println("The Unicode code point at index 1 is: " + codePoint);   // The Unicode code point at index 1 is: 101 (101 is the code point for the character 'e').

        IntStream codePoints = value.toLowerCase().codePoints();
        codePoints.forEach(cp -> System.out.println("Code point: " + cp));          // Code point: 104  Code point: 101    Code point: 108  Code point: 108 Code point: 111

        int codePoint1 = value.toLowerCase().codePointBefore(2);  // Code point before index 2
        System.out.println("The Unicode code point before index 2 is: " + codePoint1);  // The Unicode code point before index 2 is: 101

        int count = value.toLowerCase().codePointCount(0, value.length());
        System.out.println("The number of Unicode code points is: " + count);       // The number of Unicode code points is: 5
    }


    private static void swapTwoNumber(int a, int b) {
        System.out.printf("Previously A  %s and B %s ", a, b);
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
        System.out.printf("After Swap A %s and B %s %n", a, b);
    }

    private static void swapTwoNumber2(int a, int b) {
        System.out.printf("Previously A  %s and B %s ", a, b);
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.printf("After Swap A %s and B %s %n", a, b);
    }

    private static void reverseTheString(String value) {
        String[] valueArr = value.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = value.length() - 1; i >= 0; i--) {
            stringBuilder.append(valueArr[i]);
        }
        System.out.println(stringBuilder);
    }

    private static void printAsciiValue() {
        char small_a = 'a';
        char capital_A = 'A';
        System.out.println("small_a  " + small_a);
        System.out.println("capital_A " + capital_A);

        System.out.println("small_a  " + (int) small_a);
        System.out.println("capital_A " + (int) capital_A);
    }

    // How do you check if a list of integers contains only odd numbers in Java?
    private static void checkOddFromList(List<Integer> list) {
        System.out.printf("This is %s that list is having an Odd Number", list.stream().anyMatch(number -> number % 2 != 0));
    }

    private static void stringDifferentMethods() {
        // You can remove only the first occurrence of a character or substring from a string
        String str = "abc ABC 123 abc";
        String strNew = str.replaceFirst("ab", "");

        // Remove all the Lowercase Letters from a String in Java
        String removedLowerCase = str.replaceAll("([a-z])", "");

        // Remove the Last Character from a String in Java
        str.substring(0, str.length() - 1);

        /* Remove space from String // other way by
         String result = str.replaceAll("\\s", "");  String result = str.replace(" ", "");
         String result = str.trim();  remove space leading and trailing whitespaces
         s = s.strip();
         */
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                result.append(c);
            }
        }

        String str1 = " H e l l o \n W o r l d ";
        Pattern pattern = Pattern.compile("\\s+");  // Compile the pattern for reusability
        String result1 = pattern.matcher(str1).replaceAll("");
        System.out.println(result1);  // Output: "HelloWorld"

    }

    // 10. How do you sort an array in Java?
    public static void sortingAnArray() {
        int[] intArray = {5, 6, 7, 1, 3, 8, 9};
        System.out.printf(intArray.toString());

        Arrays.sort(intArray);
        for (int i : intArray) {
            System.out.print(i);
        }
    }

    public static void reverseList() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(10);

        //1st Aproach
        Collections.reverse(integerList);
        System.out.println("Reverse List 1st Approach " + integerList);

        // 2nd Approach
        LinkedList<Integer> integerList2 = new LinkedList<>();
        LinkedList<Integer> integerList3 = new LinkedList<>();
        integerList2.add(2);
        integerList2.add(10);
        integerList2.descendingIterator().forEachRemaining(integerList3::add);
        System.out.println("Reverse List 2nd Approach " + integerList3);

    }

    public static void reverseSet() {
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(10, 5, 16, 0));

        // 1st Approach -   Collections.reverse(integerList);
        List<Integer> integerList = new ArrayList<>(set);
        LinkedHashSet<Integer> reverseSet1 = new LinkedHashSet<>(integerList);

        Collections.reverse(integerList);
        System.out.println("ReverseLinkedHashSet :- " + reverseSet1);


        // 2nd Approach     -   linkedList.descendingIterator().forEachRemaining(reversedLinkedList::add);
        LinkedList<Integer> linkedList = new LinkedList<>(set);
        LinkedList<Integer> reversedLinkedList = new LinkedList<>();
        linkedList.descendingIterator().forEachRemaining(reversedLinkedList::add);

        LinkedHashSet<Integer> reversedSet1 = new LinkedHashSet<>(reversedLinkedList);
        System.out.println("ReverseLinkedHashSet :- " + reversedSet1);

        // 3rd Approach -   treeSet.descendingSet(); Only if Set is TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        reversedLinkedList.clear();
        NavigableSet<Integer> reversedSet2 = treeSet.descendingSet();
        System.out.println("Reversed Set Using Stack using descendingSet(): " + reversedSet2);

        // 4th Approach     - Stack - First In Last Out
        Set<Integer> stackSet = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        // Use a stack to reverse the elements
        Stack<Integer> stack = new Stack<>();
        for (Integer i : stackSet) {
            stack.push(i);
        }
        // Pop elements from the stack to get them in reverse order
        Set<Integer> reversedSet = new LinkedHashSet<>();
        while (!stack.isEmpty()) {
            reversedSet.add(stack.pop());
        }
        System.out.println("Reversed Set Using Stack: " + reversedSet);

        // 5th Approach - using Java - 8
        Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> reversedList = new ArrayList<>(set2.stream().toList());
        Collections.reverse(reversedList);
        Set<Integer> reversedSet3 = new LinkedHashSet<>(reversedList);
        System.out.println("Reversed Set Using Java- 8: " + reversedSet3);

    }

    public static int diagonalSumArr(List<List<Integer>> list) {

        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> row1 = List.of(5);
        List<Integer> row2 = List.of(-10, 3, 0, 5, -4);
        List<Integer> row3 = List.of(2, -1, 0, 2, -8);
        List<Integer> row4 = List.of(9, -2, -5, 6, 0);
        List<Integer> row5 = List.of(9, -7, 4, 8, -2);
        List<Integer> row6 = List.of(3, 7, 8, -5, 0);

        arr.add(row1);
        arr.add(row2);
        arr.add(row3);
        arr.add(row4);
        arr.add(row5);
        arr.add(row6);

        if (arr.size() == 0) {
            return 0;
        }

        int rowConter = arr.size();                             // 4
        List<List<Integer>> arr1 = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {                      //
            if (rowConter == arr.get(i).size()) {                 // 4 = 1    3= 3    3=3
                arr1.add(arr.get(i));                           //  -       true
            } else {
                --rowConter;                                    // 3        3
            }
        }
        if (arr1.size() == 0) {
            return 0;
        }
        int leftdiagonalSum = 0;
        int rightDiagonalSum = 0;

        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr1.get(i).size(); j++) {
                if (i == j) {
                    leftdiagonalSum = leftdiagonalSum + arr1.get(i).get(j);
                    break;
                }
            }

            int diagonalPlaceCounter1 = arr1.get(i).size() - 1 - i;
            for (int j = arr1.get(i).size() - 1; j >= 0; j--) {
                if (diagonalPlaceCounter1 == j) {
                    rightDiagonalSum = rightDiagonalSum + arr1.get(i).get(j);
                    break;
                }
            }
        }

        return Math.abs(leftdiagonalSum - rightDiagonalSum);


    }

    public static int diagonalDifference(List<List<Integer>> list) {
        List<Integer> row1 = List.of(3, 0, 0, 0);
        List<Integer> row2 = List.of(11, 2, 4, 0);
        List<Integer> row3 = List.of(4, 5, 6, 0);
        List<Integer> row4 = List.of(10, 8, -12, 0);

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(row1);
        arr.add(row2);
        arr.add(row3);
        arr.add(row4);

        int r = 0, l = 0, n = arr.size();
        for (int i = 0; i < n; i++) {
            r += arr.get(i).get(i);
            l += arr.get(i).get(n - i - 1);
        }
        return Math.abs(r - l);
    }

    public static void printList(List<Person> people, String message) {
        System.out.print("Sorting Person with His Age :- - [ ");
        for (Person p : people) {
            System.out.print(p + ", ");
        }
        System.out.println(" ]");

    }

    //

    public static void main(String[] args) {
        int res = diagonalSumArr(null);
        System.out.println(res);
        System.out.println(diagonalDifference(null));
        /*
        reverseList();
        reverseSet();
        String greeting = "Welcome To The Earth!";
        printAsciiValue();
        reverseTheString(greeting);
        swapTwoNumber(10, 20);
        swapTwoNumber2(10, 20);
        stringContainsVowels(greeting);
        contentEqualMethodExample();
        codePointMethodExample();
        isPrimeNumber(13);
        int fac = factorial(8);
        System.out.printf(" Factorial of Number is %s %n", fac);
        sortingAnArray();*/
    }
}



/*
CONTENTS
1. How do you reverse a string in Java?
2. How do you swap two numbers without using a third variable in Java?
3. Write a Java program to check if a vowel is present in a string.
4. Write a Java program to check if the given number is a prime number.
5. Write a Java program to print a Fibonacci sequence using recursion.
6. How do you check if a list of integers contains only odd numbers in Java?
7. How do you check whether a string is a palindrome in Java?
8. How do you remove spaces from a string in Java?
9. How do you remove leading and trailing spaces from a string in Java?
10. How do you sort an array in Java?
11. How do you create a deadlock scenario programmatically in Java?
12. How can you find the factorial of an integer in Java?
13. How do you reverse a linked list in Java?
14. How do you implement a binary search in Java?
15. Write a Java program that illustrates merge sort.
16. Can you create a pyramid of characters in Java?
17. Write Java program that checks if two arrays contain the same elements.
18. How do you get the sum of all elements in an integer array in Java?
19. How do you find the second largest number in an array in Java?
20. How do you shuffle an array in Java?
21. How can you find a string in a text file in Java?
22. How do you print a date in specific format in Java?
23. How do you merge two lists in Java?
24. Write a Java program that sorts HashMap by value.
25. How do you remove all occurrences of a given character from an input string in Java?
26. How do you get distinct characters and their count in a string in Java?
27. Can you prove that a String object in Java is immutable programmatically?
28. Can you write some code to showcase inheritance in Java?
29. How do you show a diamond problem with multiple inheritance in Java?
30. How do you illustrate a try catch example in Java?
31. Write a Java program to show a NullPointerException.
32. How do you create a record in Java?
33. How do you create text blocks in Java?
34. Show an example of switch expressions and multi-label case statements in Java.
35. How do you compile and run a Java class from the command line?
36. How do you create an enum in Java?
37. How do you use the forEach() method in Java?
38. How do you write an interface with default and static method?
39. How do you create a functional interface?
40. Show an example of using lambda expressions in Java.
41. Show examples of overloading and overriding in Java.
42.-49. Guess the Output
50. Find 5 mistakes in the following code snip*/
