package org.sort;

public class MergeSort {

    private static int[] sorted;

    public void merge_sort(int[] arr){
        sorted = new int[arr.length];
        merge_sort(arr,0,arr.length-1);
        sorted = null;      //메모리 해제
    }

    //mergeSort Top - Bottom 방식
    public void merge_sort(int[] arr, int left, int right){

        //부분리스트의 길이가 1인경우 더이상 쪼갤 수 없다
        if(left==right) return;
        int mid = (left+right)/2;
        merge_sort(arr,left,mid);
        merge_sort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    //mergeSort Bottom - Top 방식
    public void merge_sortToTop(int[] arr, int left, int right){

        for(int size=1;size<=right;size+=size){

            int mergedSize = size*2;

            for(int l=0;l<=right-size;l+=mergedSize){
                int low = l;
                int mid = l+size-1;
                int high = Math.min(l+mergedSize-1,right);
                merge(arr,low,mid,high);
            }
        }
    }
    public void merge(int[] arr, int left,int mid, int right){

        int l = left;       //왼쪽 부분리스트 시작점
        int r = mid+1;      //오른쪽 부분리스트 시작점
        int idx = left;     //채워넣을 배열의 인덱스

        while(l<=mid&&r<=right){

            if(arr[l]<=arr[r]){
                sorted[idx++] = arr[l++];
            }else{
                sorted[idx++] = arr[r++];
            }
        }
        while(l<=mid){
            sorted[idx++] = arr[l++];
        }
        while(r<=right){
            sorted[idx++] = arr[r++];
        }

        for(int i=left;i<=right;i++){
            arr[i] = sorted[i];
        }
    }
}
