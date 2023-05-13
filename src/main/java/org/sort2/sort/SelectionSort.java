package org.sort2.sort;

public class SelectionSort {

    public void selection_sort(int[] arr){

        for(int i=0;i<arr.length-1;i++){

            int min_idx = i;

            for(int j=i+1;j<arr.length;j++){

                if(arr[min_idx]>arr[j]) min_idx = j;
            }

            swap(arr,i,min_idx);
        }

    }

    private void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
