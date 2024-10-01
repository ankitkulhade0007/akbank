package DSAAlgoritham;

public class RecursionFactorial {

//  1!  =  1 * 0!   =   1;
//  2!  =   2*1     =   2*1!
//  3!  =   3*2*1   =   3*2!
//  4!  =   4*3*2*1 =   4*3!
//  5!  =   5*4*3*2*1   = 5*4!
//  n1  =               = n*(n-1)!

    public static void main(String[] args) {

        int result = recursionFactorial(5);
        System.out.println("Factorial of 5 is " + result);
    }

    private static int recursionFactorial(int i) {

        if(i==0){
            return 1;
        }
        return i*recursionFactorial(i-1);
    }
}
