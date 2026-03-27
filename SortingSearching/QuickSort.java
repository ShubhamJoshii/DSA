package SortingSearching;

import java.util.Arrays;

public class QuickSort {
    public static int Partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);

    }

    public static void QuickSortAlgo(int[] arr, int low, int high) {
        if (low < high) {
            int pi = Partition(arr, low, high);
            QuickSortAlgo(arr, low, pi - 1);
            QuickSortAlgo(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 11, 2, 41, 14, 2, 30, 54, 80, 41, 90 };
        int low = 0, high = arr.length - 1;
        QuickSortAlgo(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }
}
