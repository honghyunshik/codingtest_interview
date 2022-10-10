package org.example;

import java.util.Comparator;
import java.util.HashMap;

//파이썬 알고리즘 인터뷰 책 04번 문제 - 가장 흔한 단어(151p)
//금지된 단어를 제외한 가장 흔하게 등장하는 단어를 출력하라. 대소문자 구분을 하지 않으며, 구두점 또한 무시한다.
public class Interview04 {

    public static void main(String[] args){

        String input = "Bob hit a ball, the hit BALL flew far after it was hit";
        input = input.toLowerCase();
        String[] banned = {"hit"};

        //벤된 문자들 제거
        for(String str:banned){
            input = input.replaceAll(str,"");
        }

        input = input.replaceAll("\\s+"," ");       //사이 공백 여러개인것들 제거
        input = input.replaceAll("[^a-z\\s]","");       //알파벳 제외한 단어들 제거
        String[] cleanInput = input.split("\\s");

        HashMap<String,Integer> map = new HashMap<>();
        for(String str:cleanInput){
            Integer nowNum = map.get(str);
            map.put(str,nowNum == null ? 1 : ++nowNum);     //현재 map에 counter가 0이면 1을, 이미 존재하면 1을 더해준다
        }

        String maxKey = map.keySet().stream()
                .max(Comparator.comparing(map::get))
                .orElse(null);              //최대 value를 가진 key값 찾기

        System.out.println(maxKey);
        

    }

}
