package org.example.date20221101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon17298 {

    public static void main(String[] ags) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int
        int[] input = new int[num];
        for(int i=0;i<num;i++){
            input[i] = Integer.parseInt(bf.readLine());
        }
        int[] answer = rightBigNum(input);
        for(int i:answer){
            System.out.print(i + " ");
        }

    }

    public static int[] rightBigNum(int[] input){

        int[] answer = new int[input.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<input.length;i++){
            stack.add(input[i]);
        }

        for(int i=input.length-1;i>=0;i--){
            int last = stack.pop();
        }


        return answer;
    }
}
