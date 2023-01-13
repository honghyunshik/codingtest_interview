package org.example.date20230111;

import javax.jws.Oneway;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InjectionSort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        injectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void injectionSort(int[] arr){

        for(int i=1;i<arr.length;i++){
            int j = i-1;
            while(j>=0&&arr[j]>arr[j+1]){
                swap(arr,j,j+1);
                j--;
            }
        }
    }

    public static void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
