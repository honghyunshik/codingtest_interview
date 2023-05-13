package org.sort2.cote;

public class Factorial {

    public static void main(String[] args){

        Factorial factorial = new Factorial();
        System.out.println(factorial.recursionFac(5));
        System.out.println(factorial.forLoopFac(5));

    }

    private int forLoopFac(int n){

        int ans = 1;
        for(int i=2;i<=n;i++){
            ans*=i;
        }
        return ans;
    }

    private int recursionFac(int n){

        if(n==1) return 1;

        return recursionFac(n-1)*n;
    }
}
