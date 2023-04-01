package org.sort;

public class Radix {

    public static void main(String[] args){
        Radix radix = new Radix();
        String answer = radix.changeRadix(13,2);
        System.out.println(answer);
        int num = radix.backRadix(answer,2);
        System.out.println(num);

    }
    String changeRadix(int num,int radix){

        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.insert(0,num%radix);
            num/=radix;
        }
        return sb.toString();
    }

    int backRadix(String str, int radix){

        int temp = 1;
        int answer = 0;
        for(int i=str.length()-1;i>=0;i--){
            answer += temp*(str.charAt(i)-48);
            temp*=radix;
        }

        return answer;
    }


}
