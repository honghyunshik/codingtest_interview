package org.sort;

public class Uclid {

    //유클리드 호재법
    int getGCD(int a, int b){

        if(a%b==0) return b;
        return getGCD(b,a%b);
    }

    int getGCD(int[] arr){

        if(arr.length==1) return arr[0];
        int temp = getGCD(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            temp = getGCD(arr[i],temp);
        }
        return temp;
    }

    int getLCM(int a,int b){
        return a*b/getGCD(a,b);
    }

}
