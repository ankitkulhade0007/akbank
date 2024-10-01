package DSAAlgoritham;

import java.util.Arrays;

public class BubbleSortExample {

    private static void bubbleSort() {
        int[] intArray = new int[]{20, 7, -15, 35, 1, -22, 55};
        System.out.printf("unsorted Array %s %n", Arrays.toString(intArray));
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = 0; j < intArray.length - 1; j++) {
                int temp = 0;
                if (intArray[j] > intArray[j + 1]) {
                    temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
            }
        }

        System.out.printf("sorted Array %s %n", Arrays.toString(intArray));
    }
}
