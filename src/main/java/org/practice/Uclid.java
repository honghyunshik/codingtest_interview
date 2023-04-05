package org.practice;

public class Uclid {

    int getGCD(int a, int b){
        if(a%b==0) return b;
        return getGCD(b,a%b);
    }
    int getLCM(int a, int b){
        return a*b/getGCD(a,b);
    }
}
