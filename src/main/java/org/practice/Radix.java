package org.practice;

public class Radix {

    public static void main(String[] args){
        Radix radix = new Radix();
        System.out.println(radix.changeRadix(13,4));
        System.out.println(radix.backtoTen("1101",2));
    }
    String changeRadix(int num, int radix){

        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.insert(0,num%radix);
            num/=radix;
        }
        return sb.toString();
    }

    int backtoTen(String str, int radix){

        int answer = 0;
        int temp = 1;
        for(int i=str.length()-1;i>=0;i--){
            answer += temp*(str.charAt(i)-48);
            temp*=radix;
        }
        return answer;
    }
}
