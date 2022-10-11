package org.example.date20221010;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

//파이썬 알고리즘 인터뷰 책 01번 문제 - 유효한 팰린드롬(139p)
public class Interview01 {
    public static void main(String[] args) throws IOException {
        String input1 = "A man, a plan, a canal: Panama";
        String input2 = "race a car";
        String input3 = "asdfghjklqwertyuioppoiuytrewqlkjhgfdsa";

        String input = input3;

        //printAnswer(getAnsWithList(input));
        printAnswer(getAnsWithDeque(input3));

    }

    public static void printAnswer(Boolean ans){
        if(ans){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    //팰린드롭 첫번째 방법 - 리스트를 통해 풀기
    public static Boolean getAnsWithList(String input){

        //문자열만 남긴 후 리스트로 변환
        input = input.toLowerCase();    //문자 소문자로 변환
        input = input.replaceAll("[^a-z]","");       //정규식으로 알파벳만 남기기
        String[] lst = input.split("");

        //앞뒤가 같으면 넘어가고 다르면 false 반환 후 break
        for(int i =0; i<lst.length;i++){
            if(!lst[i].equals(lst[lst.length-i-1])){
                return false;
            }
        }
        return true;
    }

    //팰린드롭 두번째 방법 - 데크로 풀기
    //데크 : 큐의 양쪽에 데이터를 넣고 뺄 수 있는 구조(큐 + 스택)
    public static Boolean getAnsWithDeque(String input){

        //문자열만 남긴 후 리스트로 변환
        input = input.toLowerCase();    //문자 소문자로 변환
        input = input.replaceAll("[^a-z]","");       //정규식으로 알파벳만 남기기

        //데크 선언 후 문자 넣기
        Deque<Character> deque = new LinkedList<>();
        for(int i=0;i<input.length();i++){
            deque.add(input.charAt(i));
        }
        
        //데크에서 앞뒤문자 제거하면서 다르면 false 반환
        if(deque.removeFirst()!=deque.removeLast()){
            return false;
        }

        return true;
    }

}
