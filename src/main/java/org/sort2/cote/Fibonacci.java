package org.sort2.cote;

public class Fibonacci {

    public static void main(String[] args){

        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.recursionFibo(10));
        System.out.println(fibonacci.dpFibo(10));
        System.out.println(fibonacci.forLoopFibo(10));
    }

    private int forLoopFibo(int n){

        if(n<2) return n;

        int a = 0, b = 1;
        int c = 0;
        for(int i=2;i<=n;i++){

            c = a+b;
            a = b;
            b = c;

        }
        return c;
    }
    //O(2^n) 시간복잡도
    private int recursionFibo(int n){

        if(n<2) return n;
        return recursionFibo(n-1) + recursionFibo(n-2);
    }

    //O(n) 시간복잡도
    private int dpFibo(int n){

        int[] arr = new int[n+1];
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
