package org.practice;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args){
        int[] arr = new int[]{1,4,258,17,0};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void selectionsort(int[] arr){

        for(int i=0;i<arr.length-1;i++){
            int maxIdx = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[maxIdx]>arr[j]){
                    maxIdx = j;
                }
            }
            swap(arr,i,maxIdx);
        }

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
