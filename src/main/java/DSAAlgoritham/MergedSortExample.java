package DSAAlgoritham;

import java.util.Arrays;

public class MergedSortExample {
    public static void main(String[] args) {
        int[] arr = {7, 4, 9, 1, 3, 8, 9, 2};
        System.out.println("Original Arr :- "+ Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println("After Array Merge Sort  :- "+ Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            mergeSort(arr, startIndex, mid);
            mergeSort(arr, mid + 1, endIndex);
            merge(arr, startIndex, mid,endIndex);
        }
    }

    private static void merge(int[] arr, int startIndex, int mid, int endIndex) {
        // Create an auxiliary array to help merge
        int[] aux = new int[endIndex - startIndex + 1];

        // Indices for start subarray, right subarray, and auxiliary array
        int i = startIndex;     // Initial index of left subarray
        int j = mid + 1;  // Initial index of right subarray
        int k = 0;        // Index for the auxiliary array

        // Merge the two subarrays into the auxiliary array
        while (i <= mid && j <= endIndex) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }
        // Copy the remaining elements of the start subarray, if any
        while (i <= mid) {
            aux[k++] = arr[i++];
        }

        // Copy the remaining elements of the right subarray, if any
        while (j <= endIndex) {
            aux[k++] = arr[j++];
        }

        // Copy the sorted elements back into the original array
        for (k = 0; k < aux.length; k++) {
            arr[startIndex + k] = aux[k];
        }
    }
}
