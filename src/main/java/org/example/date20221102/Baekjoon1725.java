package org.example.date20221102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1725 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int
        int[] input = new int[num];
        for(int i=0;i<num;i++){
            input[i] = Integer.parseInt(bf.readLine());
        }
        System.out.println(histogram(input));
    }

    public static long histogram(int[] input){

        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        int temp = 0;

        for(int i=0;i<input.length;i++){


            //stack보다 작은 수가 들어올 경우
            while(!stack.isEmpty()&&input[stack.peek()]>input[i]){

                int lastNum = stack.pop();
                temp = i-lastNum;
                answer = Math.max(answer,(i-lastNum)*input[lastNum]);
            }

            //현재 스택이랑 같은수만 아니면 stack에다가 push
            if(stack.isEmpty()||input[stack.peek()]!=input[i]){
                stack.push(i);
            }

        }
        int cnt = 1;
        while(!stack.isEmpty()){
            int pop = stack.pop();
            answer = Math.max(answer, (long)(input.length-pop)*input[pop]);
            if(cnt==1){
                answer = Math.max(answer, (long)(input.length-pop)*input[pop]+temp*input[pop]);
            }
            cnt++;

        }

        return answer;
    }
}
