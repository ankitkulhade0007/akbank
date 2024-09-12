package functionInterfacePractice;

import java.time.LocalDate;
import java.util.function.*;

public class FunctioninterPractice {


    public static void main(String[] args) {


        Function<String, String> upperCase = (input)-> input.toUpperCase();
        System.out.println(upperCase.apply("ankit"));

        Function<String, Integer> size = (input)-> input.length();
        System.out.println(size.apply("ankit"));


        Function<String, String> sameValues = Function.identity();
        System.out.println(sameValues.apply("ankit"));

        Function<Integer, Integer> doubleNumber  = input->  input*2;
        Function<Integer, Integer> addThree  = input->  input+ 3;

        Function<Integer, Integer> output1 = doubleNumber.andThen(addThree); // first left side will get execute then right side
        Function<Integer, Integer> output2 = doubleNumber.compose(addThree); // first right side will get execute then left side


        System.out.println("AndThen :- "+ output1.apply(5));  // [5*2] + 3
        System.out.println("Compose :- "+ output2.apply(5));  // [5+3] * 2


        Consumer<String> printString = name -> System.out.println("Welcome to our hotel Mr. "+ name);
        printString.accept("Ankit");

        Consumer<String> printString2 = name -> System.out.print("Welcome to our hotel Mr. "+ name + ". ");
        Consumer<String> printString3 = name -> System.out.println(" you'r in the Best Hotel in the city Mr."+ name);
        printString2.andThen(printString3);
        printString2.andThen(printString3).accept("Ankit");


        Supplier<Integer> currentTime = ()-> LocalDate.now().getMonthValue();
        System.out.println("Current Months is :- "+ currentTime.get());

        Supplier<Integer> dayOfTheyear = ()-> LocalDate.now().getDayOfYear();
        System.out.println("Day Of the year is :- "+ dayOfTheyear.get());

        Supplier<String> dayOfTheWeek = ()-> LocalDate.now().getDayOfWeek().name();
        System.out.println("Current Day of the week :- "+ dayOfTheWeek.get());

        BiConsumer<String, String> welcomemessage = (a, b)-> System.out.println("Hello Mr. " + a + "Welcome to "+ b);
        welcomemessage.accept("ankit", "pune");

        BinaryOperator<Double> calculatePowerWithBO = (a, b)-> Math.pow(a, b);
        System.out.println("Power of 5 is " + calculatePowerWithBO.apply(5.0, 2.0));

        BinaryOperator<Integer> calculateMax = BinaryOperator.maxBy((a, b)-> Integer.compare(a, b));
        System.out.println("maximum number between number is - "+ calculateMax.apply(10, 30));

        BinaryOperator<Integer> calculateMin = BinaryOperator.minBy((a, b)-> Integer.compare(a, b));
        System.out.println("minimum number between number is - "+ calculateMin.apply(10, 30));


        // Method Reference
        ArthematicOperationInterface staticMethodReference = (a, b)->{
            int c = a +b;
            System.out.println("method reference :- "+  c);
            return c;
        };

        staticMethodReference.operation(5, 10);

        ArthematicOperationInterface staticMethodReference2 = FunctioninterPractice::sumOfTwoNumber;
        staticMethodReference2.operation(10,20);

        FunctioninterPractice functioninterPractice = new FunctioninterPractice();
        ArthematicOperationInterface instanceMethodReference = functioninterPractice::sumOfTwoNumber2;
        instanceMethodReference.operation(20, 30);
    }

    public static  int sumOfTwoNumber(int a, int b){
        int c = a +b;
        System.out.println("method reference 2 :- "+  c);
        return  c;
    };

    public int sumOfTwoNumber2(int a, int b){
        int c = a +b;
        System.out.println("instance method reference :- "+  c);
        return  c;
    };
}
