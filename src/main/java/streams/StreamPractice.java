package streams;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamPractice {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        Product p1 = new Product("apple", 250);
        Product p2 = new Product("chiku", 300);
        Product p3 = new Product("orange", 350);
        Product p4 = new Product("banana", 400);
        List<Product> products1 = List.of(p1, p2, p3, p4);

// -----------------------------------------------------Stream Methods---------------------------------------------------------------

        //------------------------- of, anyMatch, allMatch, nonMatch, filter, findAny, findFirst--------------------------------------
        Stream<Product> productStream = Stream.of(p1, p2, p3);
        productStream.forEach(p -> System.out.println("Stream Of Example :- " + p));

        boolean anyMatchProduct = products1.stream().anyMatch(product -> product.getName().equals("apple"));
        System.out.println("anyMatchProduct :- " + anyMatchProduct);

        boolean allMatch = products1.stream().allMatch(product -> product.getName().equals("apple"));
        System.out.println("allMatch :- " + allMatch);

        boolean noneMatch = products1.stream().noneMatch(product -> product.getName().equals("apple"));
        System.out.println("noneMatch :- " + noneMatch);

        Optional<Product> findFirst = products1.stream().filter(product -> product.getName().equals("apple")).findFirst();
        System.out.println("Find First :- " + (findFirst.isPresent() ? findFirst.get() : "None"));

        Optional<Product> findAny = products1.stream().filter(product -> product.getName().equals("apple")).findAny();
        System.out.println("Find Any :- " + (findAny.isPresent() ? findAny.get() : "None"));

        //------------------------------------mapToDouble, mapToLong, mapToInt----------------------------------------------------------
        List<String> decimalNumbers = Arrays.asList("1.5", "2.5", "3.5", "4.5");
        double sum = decimalNumbers.stream().mapToDouble(Double::parseDouble).sum();  // Sum all double values
        System.out.println("Sum of decimal numbers: " + sum);

        List<String> longNumbers = Arrays.asList("100000", "200000", "300000");
        List<Long> longList2 = longNumbers.stream().mapToLong(Long::parseLong).boxed().toList();
        System.out.println("Sum of long numbers: " + longList2);

        List<String> numbers = Arrays.asList("1", "2", "3", "4");
        int sum3 = numbers.stream().mapToInt(Integer::parseInt).sum();
        System.out.println("Sum of numbers: " + sum3);

        //---------------------------- flatMap, flatMapToInt,  flatMapToLong, flatMapToDouble-------------------------------------------
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("Apple", "Banana"), Arrays.asList("Orange", "Grapes"), Arrays.asList("Mango", "Peach", "Strawberry"));
        List<String> flatList = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(flatList);         // Output: [Apple, Banana, Orange, Grapes, Mango, Peach, Strawberry]

        List<int[]> listOfArrays = Arrays.asList(new int[]{1, 2, 3}, new int[]{4, 5}, new int[]{6, 7, 8, 9});
        IntStream intStream = listOfArrays.stream().flatMapToInt(Arrays::stream);
        System.out.println("flatMapToInt :- ");
        intStream.forEach(System.out::println);

        List<long[]> listOfLongArrays = Arrays.asList(new long[]{100L, 200L}, new long[]{300L, 400L, 500L}, new long[]{600L});
        LongStream longStream = listOfLongArrays.stream().flatMapToLong(Arrays::stream);
        System.out.println("flatMapToLong :- ");
        longStream.forEach(System.out::println);  // Output: 100 200 300 400 500 600

        List<double[]> listOfDoubleArrays = Arrays.asList(new double[]{1.1, 2.2, 3.3}, new double[]{4.4, 5.5}, new double[]{6.6, 7.7, 8.8});
        DoubleStream doubleStream = listOfDoubleArrays.stream().flatMapToDouble(Arrays::stream);
        System.out.println("flatMapToDouble :- ");
        doubleStream.forEach(System.out::println);  // Output: 1.1 2.2 3.3 4.4 5.5 6.6 7.7 8.8


        //-----------------------------Sum, Min, Max, Count--------------------------------------------------------------------------------
        int sum4 = products1.stream().filter(p -> p.getName() != null && p.getPrice() != 0)
                .map(Product::getPrice)
                .reduce(0, Integer::sum);
        System.out.println("reduce SUM example = " + sum4);

        long count = products1.stream().map(Product::getPrice).count();
        System.out.println("reduce COUNT example = " + count);

        OptionalInt min = products1.stream().map(Product::getPrice).mapToInt(num -> num).min();
        System.out.println("reduce MIN example = " + min.getAsInt());

        OptionalInt max = products1.stream().map(Product::getPrice).mapToInt(num -> num).max();
        System.out.println("reduce MAX example = " + max.getAsInt());


        //----------------------------------------mapMulti---------------------------------------------------------------------------------------------
        List<String> sentences = List.of("Hello World", "Java Stream API", "mapMulti Example");   // input
        // List<String> output = List.of("Hello", "World", "Java","Stream","API", "mapMulti","Example"); // output
        List<String> addWords = new ArrayList<>();

        // way- 01
        sentences.forEach(s-> {
            String[] splitString = s.split(" ");
            addWords.addAll(Arrays.asList(splitString));
        });
        System.out.println(addWords);

        // way-02
        List<String> flatMapSplit =  sentences.stream().flatMap(word-> List.of(word.split(" ")).stream()).collect(Collectors.toList());
        System.out.println("Stream FlatMap Split Example :- " + flatMapSplit);

        // Way-03 Using mapMulti() to split each sentence into words and flatten into a single stream
        List<String> mapMultiSplit = sentences.stream()
                .<String>mapMulti((sentence, downstream) -> {
                    for (String word : sentence.split(" ")) {
                        downstream.accept(word);
                    }
                })
                .toList();
        System.out.println("Stream MapMulti Split Example :- " + mapMultiSplit);

        // MapMulti example - 02
        List<Integer> mapMultiNumber = List.of(2, 3, 5); // input
        // 0,1,2,0,1,2,3,0,1,2,3,4,5    output
        List<Integer> mapMultiNumberList = mapMultiNumber.stream().<Integer>mapMulti((number, consumer) -> {
            for(int i =0; i<=number ; i++ ){
                consumer.accept(i);
            }
        }).toList();
        System.out.println("Stream MapMulti Number Example :- " + mapMultiNumberList);

 // --------------------------------------------------------distinct, peek, takeWhile, dropWhile---------------------------------------------
        List<Integer> duplicateNumberList = List.of(10,12,15,12,10,19,5,6,8,42,100,260,230,260,2, 3, 5);
        System.out.print("distinctNumberList :- ");
        duplicateNumberList.stream().distinct().forEach(System.out::println);

        // The peek() method performs an action for each element of the stream as it is consumed. It’s primarily used for debugging or to inspect elements of a stream without modifying them.
        // Using peek() to log/inspect elements
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        names.stream()
                .peek(name -> System.out.println("Processing After Stream Creation : " + name))
                .filter(name-> name != "ankit")
                .peek(name -> System.out.println("Processing After Filtering : " + name))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // The takeWhile() method returns elements from the stream as long as the given predicate evaluates to true. It stops processing as soon as the predicate evaluates to false.
        List<Integer> sequenceOrderNumbers  = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 0);

        List<Integer> filterNumberList = sequenceOrderNumbers.stream().filter(number-> number <= 5 ).toList();
        System.out.println("filter number list- "+ filterNumberList); // filter number list- [1, 2, 3, 4, 5, 0]

        List<Integer> takeWhileList1 = sequenceOrderNumbers.stream().takeWhile(number-> number <= 5 ).toList();
        System.out.println("Take while number list- "+ takeWhileList1); // Take while number list- [1, 2, 3, 4, 5]

        // The dropWhile() method discards elements from the stream as long as the given predicate evaluates to true. Once the predicate evaluates to false, it returns the rest of the elements.
        List<Integer> dropWhileList = sequenceOrderNumbers.stream().dropWhile(num-> num < 5).toList();
        System.out.println("drop While number list- "+ dropWhileList);


        // -----------------------------------------------------Collectors Methods---------------------------------------------------------------
        // Identify the product name with highest price
        String maxPriceProductName = products1.stream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Product::getPrice)), product -> product.isPresent() ? product.get().getName() : "None"));
        System.out.println("Stream collectingAndThen Example, maxPriceProductName :- " + maxPriceProductName);

        // Collectors.groupingBy
        Map<Integer, List<Product>> productGroup = products1.stream().collect(Collectors.groupingBy(Product::getPrice));
        for (Map.Entry pGroup : productGroup.entrySet()) {
            System.out.println("Product of price " + pGroup.getKey() + "{ ");
            List<Product> lProduct = (List<Product>) pGroup.getValue();
            lProduct.stream().forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));
            System.out.println("}");
        }

        // Collectors.partitioningBy
        Map<Boolean, List<Product>> partisionProduct = products1.stream().collect(Collectors.partitioningBy(p -> p.getPrice() >= 400));
        for (Map.Entry pGroup : partisionProduct.entrySet()) {
            System.out.println("partisionProduct is condition matched product " + pGroup.getKey() + "{ ");
            List<Product> lProduct = (List<Product>) pGroup.getValue();
            lProduct.stream().forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));
            System.out.println("}");
        }

        //Here’s a list of the commonly used methods in the Collectors utility class in Java, along with a short summary for each. Collectors is part of the java.util.stream package and provides implementations of reduction operations, such as accumulating elements into collections, summarizing data, or computing averages.
        Stream<String> stream = Stream.of("John", "Jane", "Doe");
        Stream<String> stream2 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream3 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream4 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream5 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream6 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream7 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream8 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream9 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream10 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream11 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream12 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream13 = Stream.of("John", "Jane", "Doe");
        Stream<String> stream14 = Stream.of("John", "Jane", "Doe");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 0);

            // 1. toList()  -   Summary: Collects elements of a stream into a List. Example:
        List<String> list = stream.toList();
            // 2. toSet()   -   Summary: Collects elements of a stream into a Set. Example:
        Set<String> set = stream2.collect(Collectors.toSet());

            //3. toMap()    -   Summary: Collects elements of a stream into a Map. Takes two functions: one for the key and one for the value.
        //Map<Integer, String> map = stream.collect(Collectors.toMap(String::length, Function.identity()));

            //4. joining()  -   Summary: Concatenates stream elements into a single String. Can also specify a delimiter, prefix, and suffix.
        String result = stream3.collect(Collectors.joining(", ", "[", "]"));

            //5. counting() -   Summary: Counts the number of elements in the stream.
        long countCollectorMethod = stream4.collect(Collectors.counting());

            //6. summingInt() / summingLong() / summingDouble()         Summary: Sums the elements of a stream by mapping them to an int, long, or double value.
        int summmingInt = stream5.collect(summingInt(String::length));

            //7. averagingInt() / averagingLong() / averagingDouble()   Summary: Computes the average of the elements in a stream, by mapping them to int, long, or double.
        double avg = stream6.collect(averagingInt(String::length));

            //8. reducing() Summary: Performs a reduction on the elements of the stream using an associative accumulation function and optionally an identity value.
        int sumReducing = integerStream.collect(Collectors.reducing(0, Integer::sum));

            //9. groupingBy()   -   Summary: Groups the elements of a stream based on a classifier function and returns a Map where the keys are the group keys.
        Map<Integer, List<String>> grouped = stream7.collect(Collectors.groupingBy(String::length));

            //10. partitioningBy()  -   Summary: Partitions the elements of a stream into two groups based on a predicate. Returns a Map<Boolean, List<T>>.
        Map<Boolean, List<String>> partitioned = stream8.collect(Collectors.partitioningBy(s -> s.length() > 3));

            //11. mapping() Summary: Applies a mapping function to each element before collecting the results using another collector.
        List<Integer> lengths = stream9.collect(Collectors.mapping(String::length, Collectors.toList()));

            //12. maxBy() / minBy() -   Summary: Returns the maximum or minimum element of the stream, based on a comparator.
        Optional<String> maxComparatorMethod = stream10.collect(Collectors.maxBy(Comparator.comparing(String::length)));

            // 13. summarizingInt() / summarizingLong() / summarizingDouble()
            //  Summary: Returns a summary of the elements in the stream, including count, sum, min, average, and max.
        IntSummaryStatistics stats = stream11.collect(Collectors.summarizingInt(String::length));

            //14. collectingAndThen()   -   Summary: Applies a collector and then transforms its result with a function.

        List<String> immutableList = stream12.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

            //15. filtering() (Java 9+) -   Summary: Applies a filter before collecting the elements into another collector.

        List<String> filtered = stream13.collect(Collectors.filtering(s -> s.length() > 3, Collectors.toList()));

    }
}
