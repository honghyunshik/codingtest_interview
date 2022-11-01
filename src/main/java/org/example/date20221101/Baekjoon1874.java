package org.example.date20221101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Baekjoon1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int
        int[] input = new int[num];
        for(int i=0;i<num;i++){
            input[i] = Integer.parseInt(bf.readLine());
        }
        ArrayList<String> answer = stackArray(input);
        if(answer.size()==0){
            System.out.println("NO");
        }else{
            for(String s:answer){
                System.out.println(s);
            }
        }

    }

    public static ArrayList<String> stackArray(int[] arr){

        int num = 1;        //스택에 넣을 오름차순 숫자
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        ArrayList<String> answer = new ArrayList<>();

        for(int i:arr){

            while(num<=i){
                stack.add(num++);
                answer.add("+");
            }
            int lastNum = stack.get(stack.size()-1);        //stack의 마지막에 들어있는 값
            if(lastNum==i){
                stack.pop();
                answer.add("-");
            }else if(lastNum>i){
                return new ArrayList<>();
            }
        }

        return answer;

    }


}
