package org.sort2;

public class HeapSort {

    public void heap_sort(int[] arr){

        int size = arr.length;
        if(size<2) return;

        int parentIdx = getParent(arr.length-1);
        for(int i=parentIdx;i>=0;i--){
            heapify(arr,i,size);
        }

        for(int i=size-1;i>=0;i--){
            swap(arr,0,i);
            heapify(arr,0,i-1);
        }
    }


    //오른차순의 경우 최대힙을 구현한다
    private void heapify(int[] arr, int parentIdx, int lastIdx){

        int leftChildIdx = parentIdx*2+1;
        int rightChildIdx = parentIdx*2+2;
        int largestIdx = parentIdx;

        if(leftChildIdx<lastIdx&&arr[largestIdx]<arr[leftChildIdx]){
            largestIdx = leftChildIdx;
        }

        if(rightChildIdx<lastIdx&&arr[largestIdx]<arr[rightChildIdx]){
            largestIdx = rightChildIdx;
        }

        if(parentIdx!=largestIdx){
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
