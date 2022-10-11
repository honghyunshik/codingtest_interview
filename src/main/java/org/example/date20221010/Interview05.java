package org.example.date20221010;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//파이썬 알고리즘 인터뷰 책 05번 문제 - 그룹 애너그램(153p)
public class Interview05 {
    public static void main(String[] args){

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for(String str:input){
            
            //문자를 각각 알파벳순으로 정렬
            String[] array = str.split("");
            Arrays.sort(array);
            String sorted_str = String.join("",array);

            ArrayList<String> value = map.get(sorted_str);
            if(value==null){
                value = new ArrayList<>();
            }
            value.add(str);
            map.put(sorted_str,value);
        }

        for(String key:map.keySet()){
            System.out.println(map.get(key));
        }



    }
}
