package SortingSearching;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {11, 2, 41, 14, 2, 30, 54, 80, 41, 90};

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}