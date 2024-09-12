package exception;

import java.util.Scanner;

public class ThrowDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the numerator value");
        String num1 = scanner.next();
        System.out.println("Please enter the denominator value");
        String num2 = scanner.next();
        com.eazybytes.exception.Division division = new com.eazybytes.exception.Division();
        if(num2.equals("0")) {
            throw new ArithmeticException("Division by zero");
        }
        double output = division.divide(num1, num2);
        System.out.println(output);
    }

}
