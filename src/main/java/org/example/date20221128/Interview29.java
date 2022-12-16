package org.example.date20221128;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

//J는 보석이며, S는 갖고 있는 돌이다. S에는 보석이 몇개나 들어 있을까? (대소문자 구분)
public class Interview29 {

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String J = "aA";
        String S = "aAAbbbb";

        System.out.println(solution(J,S));

    }

    public static int solution(String j, String s){

        int answer = 0;
        HashMap<Character,Integer> map = new HashMap();

        for(int i=0;i<j.length();i++){
            if(map.containsKey(j.charAt(i))){
                map.put(j.charAt(i),map.get(j.charAt(i))+1);
            }else{
                map.put(j.charAt(i),1);
            }
        }

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                answer+=map.get(s.charAt(i));
            }
        }


        return answer;
    }
}
