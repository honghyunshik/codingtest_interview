package org.practice;

public class Fibonacci {

    static int[] arr = new int[100];
    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.recursionFibonacci(10));
        System.out.println(fibonacci.forFibonacci(10));
        System.out.println(fibonacci.dpFibonacci(10));
    }

    int recursionFibonacci(int n){
        if(n<2) return n;
        return recursionFibonacci(n-1) + recursionFibonacci(n-2);
    }

    int forFibonacci(int n){
        if(n<2) return n;
        int backback = 0;
        int back = 1;
        int now = 1;
        for(int i=2;i<=n;i++){
            now = backback+back;
            backback = back;
            back = now;
        }
        return now;
    }

    int dpFibonacci(int n){

        if(arr[n]>0) return arr[n];
        arr[1] = 1;

        for(int i=2;i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
