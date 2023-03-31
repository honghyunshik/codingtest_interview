package org.sort;

public class BubbleSort {

    public void bubble_sort(int[] arr){

        //총 라운드 횟수는 전체 배열의 크기-1 -> 끝에서부터 하나씩 정렬됨
        for(int i=1;i<arr.length;i++){
            //각 라운드별 비교횟수는 전체 배열의 크기 - 진행된 라운드 수
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    //배열의 i와 j를 swap하는 method
    private void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
