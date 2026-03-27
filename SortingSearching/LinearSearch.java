package SortingSearching;

import java.util.Scanner;

public class LinearSearch {
    public static int linearSearch(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 11, 2, 41, 14, 2, 30, 54, 80, 41, 90 };
        System.out.println("Enter Search Element:");
        int target = sc.nextInt();
        int found = linearSearch(arr, target);
        if (found != -1)
            System.out.println("Element Found at index " + found);
        else
            System.out.println("Element Not Found");
        sc.close();
    }
}