package org.sort;

public class SelectionSort {

    public void selection_sort(int[] arr){

        //총 라운드 수는 배열의 크기-1
        for(int i=0;i<arr.length-1;i++){
            int min_index = i;
            //각 라운드마다 정렬횟수는 배열의크기-라운드 수
            for(int j=i+1;j<arr.length;j++){
                if(arr[min_index]>arr[j]){
                    min_index = j;
                }
            }
            swap(arr,i,min_index);
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
