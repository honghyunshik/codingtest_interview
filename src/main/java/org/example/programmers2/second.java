package org.example.programmers2;

import java.util.*;
//절반 이상부터는 의미가 없다
//1부터 절반까지만 for loop

//"aabbaccc" 7
//"ababcdcdababcdcd" 9
//"abcabcdede" 8
//"abcabcabcabcdededededede" 14
//"xababcdcdababcdcd" 17
class second {


    public static void main(String[] args){
        String input = "a";
        second se = new second();
        System.out.println(se.solution(input));
    }
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=s.length()/2;i++){
            answer = Math.min(change(s,i),answer);
        }
        if(s.length()==1) return 1;
        return answer;
    }

    public int change(String s, int k){

        int idx = 0;
        String ans = "";
        String back = "";
        int isRepeat = 0;
        while(idx<s.length()){
            String temp = "";
            for(int i=idx;i<idx+k;i++){

                //뒤에 자잘한 index는 그냥 +
                if(idx+k>s.length()){
                    //System.out.println(idx + " " + k);
                    for(int j=i;j<s.length();j++){
                        ans += s.charAt(j);
                    }
                    break;
                }else{
                    temp += s.charAt(i);
                    //System.out.println(temp + "  " + back);
                }
            }
            if(temp.equals(back)){
                if(isRepeat==0) {
                    ans += 1;
                }else if(isRepeat>=8){
                    ans += 1;
                }
                isRepeat++;
            }else{
                ans += temp;
                isRepeat = 0;
            }
            idx += k;
            back = temp;
        }

        System.out.println(s.length());
        return ans.length();
    }
}