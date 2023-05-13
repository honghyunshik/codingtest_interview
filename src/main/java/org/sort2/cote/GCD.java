package org.sort2.cote;

public class GCD {

    public static void main(String[] args){

        GCD gcd = new GCD();
        System.out.println(gcd.getGCD(12,23));
        System.out.println(gcd.getLCM(12,23));
    }

    private int getGCD(int a, int b){
        if(a%b==0) return b;
        return getGCD(b,a%b);
    }

    private int getLCM(int a, int b){
        return a*b/getGCD(a,b);
    }
}
