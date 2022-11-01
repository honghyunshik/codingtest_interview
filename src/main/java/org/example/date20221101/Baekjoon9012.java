package org.example.date20221101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int
        for(int i=0;i<num;i++){
            System.out.println(isVPS(bf.readLine()));
        }

    }

    public static String isVPS(String input){

        Stack<Character> stack = new Stack();

        for(int i=0;i<input.length();i++){

            if(input.charAt(i)==')'){
                if(stack.size()==0) {
                    return "NO";
                }else{
                    stack.pop();
                }

            }else{
                stack.add(input.charAt(i));
            }
        }
        if(stack.size()==0) return "YES";
        else return "NO";
    }
}
