package org.practice;

public class Factorial {

    public static void main(String[] args){
        Factorial factorial = new Factorial();
        System.out.println(factorial.recursionFactorial(5));
        System.out.println(factorial.forFactorial(5));
    }

    int recursionFactorial(int n){
        if(n==1) return 1;
        return n*recursionFactorial(n-1);
    }

    int forFactorial(int n){
        int answer = 1;
        for(int i=2;i<=n;i++){
            answer *= i;
        }
        return answer;
    }
}
