package org.example.date20221012;

import java.util.HashMap;
import java.util.Stack;

//파이썬 알고리즘 인터뷰 책 20번 문제 - 유효한 괄호(245p)
//괄호로 된 입력값이 올바른지 판별하라
public class Interview20 {

    public static void main(String[] args){
        String input1 = "()[]{}{[]}";
        System.out.println(check(input1));
    }

    public static Boolean check(String input){

        Stack<String> stack = new Stack<>();
        HashMap<String,String> map = new HashMap<>();

        //hashmap에 괄호 짝들 넣어주기
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");

        for(String str:input.split("")){

            if(map.containsKey(str)){
                stack.push(map.get(str));
            }else{
                String pop = stack.pop();
                if(!pop.equals(str)){
                    return false;
                }
            }
        }
        if(stack.size()!=0){
            return false;
        }
        return true;
    }
}
