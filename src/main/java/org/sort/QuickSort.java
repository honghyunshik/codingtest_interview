package org.sort;

public class QuickSort {

    public void quickSort(int[] arr){
        l_pivor_sort(arr,0,arr.length-1);
    }

    private void l_pivor_sort(int[] arr, int lo, int hi){

        if(lo>=hi) return;
        int pivot = partition(arr,lo,hi);
        l_pivor_sort(arr,lo,pivot-1);
        l_pivor_sort(arr,pivot+1,hi);

    }

    //피벗보다 작은 값들을 왼쪽에, 큰 값들을 오른쪽에 치중
    private int partition(int[] arr, int left, int right){

        int lo = left;
        int hi = right;
        int pivot = arr[left];      //부분리스트 왼쪽 요소를 피벗으로 지정

        while(lo<hi){

            //hi값 조정
            while(arr[hi]>pivot&&lo<hi){
                hi--;
            }
            //lo값 조정
            while(arr[lo]<=pivot&&lo<hi){
                lo++;
            }
            swap(arr,lo,hi);
        }
        swap(arr,left,lo);
        return lo;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
