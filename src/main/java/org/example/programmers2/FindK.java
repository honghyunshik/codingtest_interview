package org.example.programmers2;

import java.util.*;
class FindK {

    public static void main(String[] args){
        FindK findK = new FindK();
        System.out.println(findK.solution(6,3));
    }
    public int solution(int n, int k) {
        int answer = 0;
        String num = changeNum(n,k);
        String temp = "";
        for(int i=0;i<num.length();i++){
            char now = num.charAt(i);
            if(now=='0'){
                if(!temp.equals("")){
                    if(isSosu(temp)) answer++;
                }
                temp = "";
            }else{
                temp += now;
            }
        }
        if(!temp.equals("")){
            if(isSosu(temp)) answer++;
        }
        return answer;
    }

    public boolean isSosu(String s){

        Long num = Long.parseLong(s);
        if(num<=1) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;

    }

    public String changeNum(int n, int k){

        String ans = "";
        while(n>0){
            ans += n%k;
            n/=k;
        }
        return ans;
    }
}