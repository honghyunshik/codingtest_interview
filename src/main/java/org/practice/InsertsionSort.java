package org.practice;

import java.util.Arrays;

public class InsertsionSort {

    public static void main(String[] args){
        int[] arr = new int[]{1,4,258,17,0};
        InsertsionSort insertsionSort = new InsertsionSort();
        insertsionSort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    void insertionSort(int[] arr){

        for(int i=1;i<arr.length;i++){

            int target = arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>target){
                arr[j+1] = arr[j--];
            }
            arr[j+1] = target;
        }
    }

}
