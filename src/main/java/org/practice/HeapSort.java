package org.practice;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args){

        int[] arr = new int[]{1,4,258,17,0};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void heapSort(int[] arr){


        int size = arr.length;
        if(size<2) return;

        //처음 시작인덱스는 마지막 노드의 부모 인덱스
        //Heap 만들기
        int parentIdx = getParent(arr.length-1);
        for(int i=parentIdx;i>=0;i--){
            heapify(arr,i,size);
        }

        for(int i=size-1;i>=0;i--){
            swap(arr,0,i);      //arr의 0번째 index값이 root노드이고 이를 배열의 마지막으로 이동
            heapify(arr,0,i-1);
        }
    }
    void heapify(int[] arr, int parentIdx, int lastIdx){

        int leftChildIdx = parentIdx*2+1;
        int rightChildIdx = parentIdx*2+2;
        int largestIdx = parentIdx;

        if(leftChildIdx<lastIdx&&arr[largestIdx]<arr[leftChildIdx]){
            largestIdx = leftChildIdx;
        }
        if(rightChildIdx<lastIdx&&arr[largestIdx]<arr[rightChildIdx]){
            largestIdx = rightChildIdx;
        }

        if(largestIdx!=parentIdx){
            swap(arr,largestIdx,parentIdx);
            heapify(arr,largestIdx,lastIdx);
        }

    }

    private int getParent(int child){
        return (child-1)/2;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
