package org.sort2.sort;

public class BubbleSort {

    public void bubble_sort(int[] arr){

        for(int i=1;i<arr.length;i++){

            for(int j=0;j<arr.length-i;j++){

                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
