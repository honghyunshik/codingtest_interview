package org.sort2.cote;

public class Radix {

    public static void main(String[] args){

        Radix radix = new Radix();
        String to2 = radix.changeRadix(15,2);
        System.out.println(to2);
        System.out.println(radix.backRadix(to2,2));
    }

    private int backRadix(String str, int radix){

        int ans = 0;
        int temp = 1;
        for(int i=str.length()-1;i>=0;i--){

            ans += temp*(str.charAt(i)-48);
            temp*=radix;
        }

        return ans;
    }

    //10진법 -> 다른진법
    private String changeRadix(int num, int radix){

        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.insert(0,num%radix);
            num/=radix;
        }

        return sb.toString();
    }
}
