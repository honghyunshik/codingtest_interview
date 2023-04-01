package org.sort;

public class Sosu {

    public static void main(String[] args){
        Sosu sosu = new Sosu();
        sosu.getSosu(100);
    }

    boolean isSosu(int n){

        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    void getSosu(int n){

        boolean[] arr = new boolean[n+1];       //true는 소수아님   false가 소수
        arr[0] = arr[1] = true;
        for(int i=2;i*i<=n;i++){
            if(!arr[i]){
                for(int j=i+i;j<=n;j+=i){
                    arr[j] = true;
                }
            }
        }

        for(int i=2;i<arr.length;i++){
            if(!arr[i]) System.out.print(i + " ");
        }
    }
}
