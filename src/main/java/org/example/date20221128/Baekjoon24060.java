package org.example.date20221128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon24060 {

    static int counter = 0;
    static int K;
    static int answer = -1;
    static int[] temp;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        temp = new int[N];
        mergeSort(arr,0,arr.length-1);
        System.out.println(answer);

    }


    public static void mergeSort(int[] arr, int p, int r){

        if(counter>K) return;
        int q = (p+r)/2;
        if(p<r){
            mergeSort(arr,p,q);
            mergeSort(arr,q+1,r);
            merge(arr,p,q,r);
        }
    }

    public static void merge(int[] arr,int left, int mid, int right){


        int i = left;
        int j = mid+1;
        int k = left;


        while(i<=mid&&j<=right){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }

        while(j<=right){
            temp[k++] = arr[j++];
        }

        for(int l=left;l<=right;l++){
            arr[l] = temp[l];
            counter++;
            if(counter==K){
                answer = arr[l];
                break;
            }
        }



    }
}
