package DSAAlgoritham;

import java.util.Arrays;

public class InsertionSortExample {


    public static void insertionSortExample() {
        int[] arr1 = new int[]{20, 35, -15, 7, 55, 1, -22};
        int[] arr = new int[]{-1, -2, -9, 0, -55, 19, 22};
        System.out.println("Array Before Selection Sort :- " + Arrays.toString(arr));

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = newElement;
        }
        System.out.println("Array After Insertion Sort :- " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        insertionSortExample();
    }
}