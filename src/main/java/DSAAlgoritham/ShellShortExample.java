package DSAAlgoritham;

import java.util.Arrays;

public class ShellShortExample {

    public static void shellShortExample() {

        int[] arr = new int[]{20, 35, -15, 7, 55, 1, -22};
        System.out.println("Array Before Shell Sort :- " + Arrays.toString(arr));

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int newElement = arr[i];               //  3- 7, 4-55,  5-1  6- -22
                int j = i;                              // 3   , 4   ,   5   6
                while (j >= gap && arr[j - gap] > newElement) {             // 20>7, 35>55 -15>1  7> -22
                    arr[j] = arr[j - gap];
                    j -= gap;                                           // reset j because we are saying to check element from index number = gap value and we have condition j>= gap
                }
                arr[j] = newElement;                                    // Now as J is the place of gap index where we need to put the new element. and above we are putting greater value
            }
        }
        System.out.println("Array After Shell Sort :- " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        shellShortExample();
    }
}
