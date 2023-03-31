package org.sort;

public class InsertionSort {

    public void insertionSort(int[] arr){

        //라운드는 배열의 크기-1 만큼 진행
        for(int i=1;i<arr.length;i++){
            int target = arr[i];        //target은 1부터 시작
            int j=i-1;      //이전 값들이랑 비교
            while(j>=0&&target<arr[j]){
                arr[j+1] = arr[j--];
            }
            arr[j+1] = target;
        }
    }
}
