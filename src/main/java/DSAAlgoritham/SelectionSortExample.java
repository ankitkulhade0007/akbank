package DSAAlgoritham;

import java.util.Arrays;

public class SelectionSortExample {

    public static void selectionSortAscendingOrderExample() {
        int[] arr = new int[]{20, 35, -15, 7, 55, 1, -22};
        System.out.println("Array Before Selection Sort :- " + Arrays.toString(arr));
        int lastUnsortedndex = arr.length - 1;
        for (int j = 0; j < arr.length; j++) {
            int largestNumberIndex = 0;
            int temp;
            for (int i = 0; i <= lastUnsortedndex; i++) {          // i-1          i-2 ,   i-3     ,   i-4     ,    i-5,   i-6
                if (arr[largestNumberIndex] < arr[i]) {            // 20<35 [35], 35<-15,  35<7    ,   35<55   ,   55<1,   55< -22
                    largestNumberIndex = i;                          //  1      ,   1   ,   1       ,   4       ,   4   ,   4
                }
            }
            // if you find lasgestNumberIndex has updated then swap the numbers
            if (arr[largestNumberIndex] != arr[lastUnsortedndex]) {
                temp = arr[largestNumberIndex];
                arr[largestNumberIndex] = arr[lastUnsortedndex];
                arr[lastUnsortedndex] = temp;
            }
            --lastUnsortedndex;
            // now remove the last sorted index from loop.
        }
        System.out.println("Array After Selection Sort Ascending Order :- " + Arrays.toString(arr));
    }

    public static void selectionSortDesendingOrderExample() {

        int[] arr = new int[]{20, 35, -15, 7, 55, 1, -22};

        System.out.println("Array Before Selection Sort :- " + Arrays.toString(arr));

        int lastUnsortedndex = arr.length - 1;

        for (int j = 0; j < arr.length; j++) {
            int largestNumberIndex = 0;
            int temp;
            for (int i = 0; i <= lastUnsortedndex; i++) {          // i-1          i-2 ,   i-3     ,   i-4     ,    i-5,   i-6
                if (arr[largestNumberIndex] > arr[i]) {            // 20<35 [35], 35<-15,  35<7    ,   35<55   ,   55<1,   55< -22
                    largestNumberIndex = i;                          //  1      ,   1   ,   1       ,   4       ,   4   ,   4
                }
            }
            // if you find lasgestNumberIndex has updated then swap the numbers
            if (arr[largestNumberIndex] != arr[lastUnsortedndex]) {
                temp = arr[largestNumberIndex];
                arr[largestNumberIndex] = arr[lastUnsortedndex];
                arr[lastUnsortedndex] = temp;
            }
            --lastUnsortedndex;
            // now remove the last sorted index from loop.
        }
        System.out.println("Array After Selection Sort Descending Order :- " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        selectionSortAscendingOrderExample();
        selectionSortDesendingOrderExample();
    }

}
