package org.sort2.sort;

public class QuickSort {


    public void quick_sort(int[] arr){
        quick_sort(arr,0,arr.length-1);
    }
    private void quick_sort(int[] arr, int lo, int hi){

        if(lo>=hi) return;
        int pivot = partition(arr,lo,hi);
        quick_sort(arr,lo,pivot-1);
        quick_sort(arr,pivot+1,hi);
    }
    private int partition(int[] arr, int left, int right){

        int lo = left;
        int hi = right;
        int pivot = arr[left];
        while(lo<hi){

            while(arr[hi]>pivot&&lo<hi) hi--;
            while(arr[lo]<=pivot&&lo<hi) lo++;
            swap(arr,lo,hi);
        }
        swap(arr,left,lo);
        return lo;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
