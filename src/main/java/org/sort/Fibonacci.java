package org.sort;

import java.util.Arrays;

public class Fibonacci {

    //O(N) 시간복잡도
    public int forLoop(int n){

        if(n==0) return 0;
        if(n==1) return 1;
        int backback = 0;
        int back = 1;
        int now=0;
        for(int i=2;i<=n;i++){
            now = backback+back;
            backback = back;
            back = now;
        }
        return now;
    }

    //O(2^N) 시간복잡도
    public int recursionFibonacci(int n){

        if(n<2) return n;
        return recursionFibonacci(n-1) + recursionFibonacci(n-2);
    }


    //O(N) 시간복잡도
    public int dpFibonacci(int n){

        int[] arr = new int[n+1];
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
