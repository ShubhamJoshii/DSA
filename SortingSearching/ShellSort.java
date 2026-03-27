package SortingSearching;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int arr[] = { 11, 2, 41, 14, 2, 30, 54, 80, 41, 90 };
        int n = arr.length;
        for(int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for(j=i;j>=gap && arr[j-gap]>temp;j-=gap){
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }   
        System.out.println(Arrays.toString(arr));
    }
}
