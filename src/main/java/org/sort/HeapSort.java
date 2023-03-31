package org.sort;

public class HeapSort {

    public void heapSort(int[] arr){

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

    public void heapify(int[] arr, int parentIdx, int lastIdx){

        //현재 트리에서 자식노드의 인덱스를 구한다
        //부모 인덱스를 가장 큰 값이라고 가정한다
        int leftChildIdx = parentIdx*2+1;
        int rightChildIdx = parentIdx*2+2;
        int largetsIdx = parentIdx;

        //left child node 비교
        //자식노드와 lastIdx를 비교해 IndexOutOfBoundsException 방지
        if(leftChildIdx<lastIdx&&arr[largetsIdx]<arr[leftChildIdx]){
            largetsIdx = leftChildIdx;
        }

        //right child node 비교
        if(rightChildIdx<lastIdx&&arr[largetsIdx]<arr[rightChildIdx]){
            largetsIdx = rightChildIdx;
        }

        //부모노드와 largestIdx 같지 않다 -> 교환해줘야한다
        if(parentIdx!=largetsIdx){
            swap(arr,largetsIdx,parentIdx);
            heapify(arr,largetsIdx,lastIdx);
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
