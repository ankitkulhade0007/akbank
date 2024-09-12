package exception;

public class ThrowsDemo {

    public static void main(String[] args) {
        com.eazybytes.exception.Division division = new com.eazybytes.exception.Division();
        try{
            double ouput = division.divide("4", "2");
            System.out.println(ouput);
        } catch (NumberFormatException | ArithmeticException ex) {
            System.out.println("Invalid data provided. Please provide valid numbers and try again..");
        }
    }

}
