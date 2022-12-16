package org.example.date20221128;

import java.util.HashMap;

//중복 문자 없는 가장 긴 부분 문자열의 길이를 리턴하라
public class Interview30 {

    public static void main(String[] args){
        System.out.println(solution("abcabcbb"));
        System.out.println(solution("bbbbbb"));
        System.out.println(solution("pwwkew"));

    }

    public static int solution(String input){
        int answer = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<input.length();i++){
            if(map.containsKey(input.charAt(i))){
                map.clear();
                map.put(input.charAt(i),1);
            }else{
                map.put(input.charAt(i),1);
                answer = Math.max(answer,map.size());
            }
        }


        return answer;
    }
}
