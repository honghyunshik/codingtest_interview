package org.example.kakao4;

import java.util.*;
import java.io.*;


public class Programmers {
    public static String solution(String s, String skip, int index) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);
            int count = 0;
            while(count<5){
                boolean check = false;
                now++;
                if(now==123) now = 97;
                if(!skip.contains(Character.toString(now))){
                    count++;
                }

            }
            answer += now;
        }
        return answer;
    }

    public static void main(String[] args){
        String ans = solution("aukks","wbqd",5);
        System.out.println(ans);
    }

}