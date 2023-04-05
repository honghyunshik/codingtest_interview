package org.practice;

import java.util.Arrays;

public class MergeSort {

    static int[] sorted;

    public static void main(String[] args){

        int[] arr = new int[]{1,4,258,17,0};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }
    void mergesort(int[] arr){
        sorted = new int[arr.length];
        mergesort(arr,0,arr.length-1);
        sorted = null;
    }
    void mergesort(int[] arr, int left, int right){

        if(left>=right) return;
        int mid = (left+right)/2;
        mergesort(arr,left,mid);
        mergesort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    void merge(int[] arr, int left, int mid, int right){

        int l = left;
        int r = mid+1;
        int idx = left;

        while(l<=mid&&r<=right){
            if(arr[l]<arr[r]) sorted[idx++] = arr[l++];
            else sorted[idx++] = arr[r++];
        }
        while(l<=mid){
            sorted[idx++] = arr[l++];
        }
        while(r<=right){
            sorted[idx++] = arr[r++];
        }

        for(int i=left;i<=right;i++){
            arr[i] = sorted[i];
        }
    }


}
