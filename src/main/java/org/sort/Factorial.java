package org.sort;

public class Factorial {

    public int recursionFactorial(int n){
        if(n==1) return 1;
        return recursionFactorial(n-1)*n;
    }

    public int forFactorial(int n){

        int answer = 1;
        for(int i=2;i<=n;i++){
            answer*=i;
        }
        return answer;
    }
}
