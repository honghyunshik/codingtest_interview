package org.example.date20221031;

public class Baekjoon24060 {

    public static void main(String[] args){
        int[] arr = {4, 5, 1, 3, 2};
        mergeSort(arr);
        for(int num:arr){
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr){
        sort(arr,0,arr.length-1);

    }

    //배열을 나눌 수 없을 때까지 나눠주는 함수
    public static void sort(int[] arr, int start, int end){

        if(start<end){
            int mid = (start+end)/2;
            sort(arr,start,mid);
            sort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }

    }

    //나눠진 배열을 다시 합쳐주는 함수
    public static void merge(int[] arr, int low, int mid, int high){

        int[] sorted = new int[arr.length];
        int l = low;
        int m = mid+1;
        int temp = low;

        while(l<=mid&&m<=high){
            if(arr[l]<arr[m]){
                sorted[l++] = arr[temp++];
            }else{
                sorted[m++] = arr[temp++];
            }
        }

        while(l<=mid){
            sorted[temp++] = arr[l++];
        }

        while(m<high){
            sorted[temp++] = arr[m++];
        }

        for(int i=low;i<=high;i++){
            arr[i] = sorted[i];
        }
    }



}
