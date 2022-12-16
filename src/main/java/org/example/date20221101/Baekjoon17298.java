package org.example.date20221101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Stream;

public class Baekjoon17298 {

    public static void main(String[] ags) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int
        String[] strInput = bf.readLine().split(" ");
        int[] input = Stream.of(strInput)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(rightBigNum(input));

    }

    public static String rightBigNum(int[] input){

        int[] lst = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<input.length;i++){

            while(stack.size()>0&&input[stack.peek()]<input[i]){
                    lst[stack.pop()] = input[i];
                }
            stack.add(i);
            }

        while(stack.size()>0){
            lst[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i:lst){
            sb.append(i + " ");
        }


        return sb.toString();
    }
}
