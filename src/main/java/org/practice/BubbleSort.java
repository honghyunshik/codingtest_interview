package org.practice;

public class BubbleSort {

    void bubbleSort(int[] arr){

        for(int i=1;i<arr.length;i++){
            boolean flag = true;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if(flag) return;
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
