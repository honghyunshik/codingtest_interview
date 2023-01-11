package org.example.date20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MergeSort {

    static int[] sorted;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sorted = new int[N];
        int[] temp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(temp);
        System.out.println(Arrays.toString(sorted));
    }

    public static void merge_sort(int[] a){

        merge_sort(a,0,a.length-1);
    }

    public static void merge_sort(int[] a, int l, int r){

        if(l==r) return;
        int mid = (l+r)/2;
        merge_sort(a,0,mid);
        merge_sort(a,mid+1,r);

        merge(a,l,mid,r);
    }

    public static void merge(int[] a, int left, int mid, int right){

        int l = left;
        int r = mid+1;
        int idx = left;

        while(l<=mid&&r<=right){

            if(a[l]<=a[r]){
                sorted[idx++] = a[l++];
            }
            if(a[l]>a[r]){
                sorted[idx++] = a[r++];
            }
        }
        if(l>mid){
            while(r<=right){
                sorted[idx++] = a[r++];
            }
        } else{
            while(l<=mid){
                sorted[idx++] = a[l++];
            }
        }
        for(int i=left;i<=right;i++){
            a[i] = sorted[i];
        }
    }
}
