package org.sort2;

public class MergeSort {

    private static int[] sorted;

    public void merge_sort(int[] arr){

        sorted = new int[arr.length];
        merge_sort(arr,0,arr.length-1);
        sorted = null;

    }

    private void merge_sort(int[] arr, int left, int right){

        if(left==right) return;

        int mid = (left+right)/2;

        merge_sort(arr,left,mid);
        merge_sort(arr,mid+1,right);
        merge(arr,left,mid,right);

    }

    private void merge(int[] arr, int left, int mid, int right){

        int l = left;
        int r = mid+1;
        int idx = left;

        while(l<=mid&&r<=right){
            if(arr[l]<=arr[r]) sorted[idx++] = arr[l++];
            else sorted[idx++] = arr[r++];
        }

        while(l<=mid){
            sorted[idx++] = arr[l++];
        }

        while(r<=right) {
            sorted[idx++] = arr[r++];
        }

        for(int i=left;i<=right;i++){
            arr[i] = sorted[i];
        }
    }

}

