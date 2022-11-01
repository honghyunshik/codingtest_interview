package org.example.date20221101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;



public class Baekjoon4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

        while(true){
            String input = bf.readLine();
            if(input.equals(".")) break;
            System.out.println(isVPS(input));
        }

    }

    public static String isVPS(String input){

        Stack<Character> stack = new Stack();

        for(int i=0;i<input.length();i++){

            if(input.charAt(i)=='('||input.charAt(i)=='['){
                stack.add(input.charAt(i));
            }else if(input.charAt(i)==')'){
                if(stack.size()==0) return "no";
                else if(stack.pop()=='[') return "no";
            }else if(input.charAt(i)==']'){
                if(stack.size()==0) return "no";
                else if(stack.pop()=='(') return "no";
            }
        }
        if(stack.size()==0) return "yes";
        else return "no";
    }
}
