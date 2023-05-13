package org.sort2.cote;
import java.util.Arrays;
import java.util.Arrays.*;
public class Sosu {

    public static void main(String[] args){

        Sosu sosu = new Sosu();
        System.out.println(sosu.isSosu(17));
        System.out.println(sosu.isSosu(3));
        System.out.println(sosu.isSosu(2));
        System.out.println(sosu.isSosu(8));
        sosu.getSosu(17);
    }

    //num은 소수인가요?
    private boolean isSosu(int num){

        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }

    //num 이하의 소수 출력하기
    private void getSosu(int num){

        boolean[] arr = new boolean[num+1];

        Arrays.fill(arr,true);
        arr[0] = arr[1] = false;
        for(int i=2;i*i<=num;i++){

            if(arr[i]){

                for(int j=i+i;j<=num;j+=i){
                    arr[j] = false;
                }
            }
        }
        for(int i=2;i<=num;i++){
            if(arr[i]) System.out.print(i + " ");
        }
    }
}
