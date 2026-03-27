package SortingSearching;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[l+i];
        for (int j = 0; j < n2; j++) R[j] = arr[m+j+1];
        int i = 0, j = 0,k=l;
        while (i<n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
        
    }
    public static void MergeSortAlgo(int arr[], int l, int r) {
        if(l < r){
            int m = l + (r - l )/2;
            MergeSortAlgo(arr,l,m);
            MergeSortAlgo(arr,m+1,r);
            merge(arr, l, m, r);
        }
        
    }
    public static void main(String[] args) {
        int arr[] = { 11, 2, 41, 14, 2, 30, 54, 80, 41, 90 };
        int l = 0, r= arr.length - 1;
        MergeSortAlgo(arr, l, r);
        System.out.println(Arrays.toString(arr));
    }
}
