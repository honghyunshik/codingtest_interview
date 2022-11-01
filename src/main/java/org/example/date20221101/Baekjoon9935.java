package org.example.date20221101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        System.out.println(bombString(bf.readLine(),bf.readLine()));
    }

    public static String bombString(String input,String bomb){

        Stack<Character> stack = new Stack<>();
        int len = bomb.length();        //bomb의 글자길이 저장
        String answer = "";

        for(int i=0;i<input.length();i++){

            //input의 i번째 char이 폭탄단어의 마지막 글자와 같은지 비교
            stack.add(input.charAt(i));
            if(stack.size()>=len){
                if(input.charAt(i)==bomb.charAt(len-1)){
                    boolean isBomb = true;
                    for(int j=0;j<len;j++){
                        if(stack.get(stack.size()-j-1)!=bomb.charAt(len-j-1)){
                            isBomb = false;
                            break;
                        }
                    }
                    if(isBomb){
                        for(int j=0;j<len;j++){
                            stack.pop();
                        }
                    }
                }
            }

        }
        if(stack.size()==0){
            return "FRULA";
        }else{
            StringBuilder sb = new StringBuilder();
            for(char c :stack){
                sb.append(c);
            }
            return sb.toString();
        }
    }



}
