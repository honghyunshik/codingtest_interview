package org.example.date20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] array = new int[input.length];
        for(int i=0;i<array.length;i++){
            array[i] = Integer.parseInt(input[i]);
        }

    }

    public static void pivotSort(int[] arr){
        pivotSort(arr,0,arr.length-1);
    }

    public static void pivotSort(int[] arr,int lo, int hi){

        if(lo>=hi) return;

        int pivot = partition(arr,lo,hi);

        pivotSort(arr,lo,pivot-1);
        pivotSort(arr,pivot+1,hi);

    }

    public static int partition(int[] arr, int left, int right){

        int lo = left;
        int hi = right;
        int pivot = arr[left];

        while(lo<hi){
            while(arr[hi]>pivot&&lo<hi){
                hi--;
            }
            while(arr[lo]<=pivot&&lo<hi){
                lo++;
            }
            swap(arr,lo,hi);
        }

        swap(arr,left, lo);
        return lo;
    }

    public static void swap(int[] a, int i, int j){

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



}
