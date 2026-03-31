package SortingSearching;

import java.util.Arrays;

public class MergeSort {
    public static void conquer(int arr[], int l, int m, int r) {
        int LL = m-l+1;
        int RL = r-m;
        int L[] = new int[LL];
        int R[] = new int[RL];
        for (int i = 0; i < LL; i++) L[i] = arr[l+i];
        for (int j = 0; j < RL; j++) R[j] = arr[m+j+1];
        int i = 0, j = 0,k=l;
        while (i<LL && j < RL) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < LL) {
            arr[k++] = L[i++];
        }
        while (j < RL) {
            arr[k++] = R[j++];
        }
    }
    public static void divide(int arr[], int l, int r) {
        if(l < r){
            int m = l + (r - l )/2;
            divide(arr,l,m);
            divide(arr,m+1,r);
            conquer(arr, l, m, r);
        }
        
    }
    public static void main(String[] args) {
        int arr[] = { 11, 2, 41, 14, 2, 30, 54, 80, 41, 90 };
        int l = 0, r= arr.length - 1;
        divide(arr, l, r);
        System.out.println(Arrays.toString(arr));
    }
}
