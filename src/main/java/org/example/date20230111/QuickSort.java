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

    }

    public static int partition(int[] arr, int left, int right){

        return 1;
    }



}
