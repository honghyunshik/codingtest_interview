package org.example.date20221012;

import java.util.*;

//파이썬 알고리즘 인터뷰 책 21번 문제 - 중복 문자 제거(247p)
//중복된 문자를 제외하고 사전식 순서로 나열하라
public class Interview21 {

    public static void main(String[] args){
        String input1 = "bcabc";
        String input2 = "cbacdcbc";
        System.out.println(getSetString(input2));
    }

    public static String getSetString(String input){

        String answer = "";     //정답을 answer에 저장
        Character lastChar = 'A';

        char[] array = input.toCharArray();

        Set<Character> hashSet = new HashSet<>();
        List<Character> newList = new ArrayList<>();
        for(char a:array){
            hashSet.add(a);
            newList.add(a);
        }


        HashMap<Character,Integer> map = new HashMap<>();      //<알파벳,counter>
        Iterator<Character> it = hashSet.iterator();

        while(it.hasNext()){
            char next = it.next();
            map.put(next,Collections.frequency(newList,next));
        }

        Stack<String> stack = new Stack<>();
        for(int i=0;i<input.length();i++){
            char letter = input.charAt(i);
            map.put(letter,map.get(letter)-1);      //문자가 나왔으니까 map에서 1만큼 감소
            //이게 마지막으로 나올 문자 + answer에서 존재하지 않는 값일 때
            if(map.get(letter)==0&&answer.indexOf(letter)==-1){
                answer+=letter;
            }
        }


        return answer;
    }



}
