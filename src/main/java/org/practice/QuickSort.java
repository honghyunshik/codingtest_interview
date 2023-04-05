package org.practice;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args){
        int[] arr = new int[]{1,4,258,17,0};
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void quicksort(int[] arr){
        quicksort(arr,0,arr.length-1);
    }

    void quicksort(int[] arr, int left, int right){

        if(left>=right) return;
        int pivot = partition(arr,left,right);
        quicksort(arr,left,pivot-1);
        quicksort(arr,pivot+1,right);
    }

    int partition(int[] arr, int left, int right){

        int lo = left;
        int hi = right;
        int pivot = arr[left];

        while(lo<hi){

            while(lo<hi&&arr[hi]>pivot){
                hi--;
            }
            while(lo<hi&&arr[lo]<=pivot){
                lo++;
            }


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
