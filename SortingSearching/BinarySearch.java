package SortingSearching;

import java.util.Scanner;

public class BinarySearch {
    public static int recursiveBinarySearch(int arr[], int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;            // Preventing from int overflow of 2^32 bits

        if (arr[mid] > target)
            return recursiveBinarySearch(arr, start, mid - 1, target);
        else if (arr[mid] < target)
            return recursiveBinarySearch(arr, mid + 1, end, target);
        else {
            return mid;
        }
    }

    public static int iterativeBinarySearch(int arr[], int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;        // Preventing from int overflow of 2^32 bits

            if (arr[mid] > target)
                end = mid - 1;
            else if (arr[mid] < target)
                start = mid + 1;
            else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int start = 0, end = arr.length - 1, target;
        int found = -1;

        System.out.println("Enter Search Element ");
        target = sc.nextInt();

        // found = iterativeBinarySearch(arr,start,end,target);
        found = recursiveBinarySearch(arr, start, end, target);
        if (found != -1)
            System.out.println("Element Found At index " + found);
        else
            System.out.println("Element Not Found");

        sc.close();
    }
}