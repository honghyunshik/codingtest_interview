package org.sort2;

public class InsertionSort {

    public void insert_sort(int[] arr){

        for(int i=1;i<arr.length;i++){

            int target = arr[i];
            int j = i-1;

            while(j>=0&&target<arr[j]){
                arr[j+1] = arr[j--];
            }

            arr[j+1] = target;

        }
    }

}
