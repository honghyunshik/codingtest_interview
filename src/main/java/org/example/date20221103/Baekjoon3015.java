package org.example.date20221103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon3015 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int
        int[] input = new int[num];

        for(int i=0;i<num;i++){

            input[i] = Integer.parseInt(bf.readLine());

        }
        System.out.println(oasis(input));

    }

    public static long oasis(int[] input){

        long answer = 0;
        int sameCount = 1;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<input.length;i++){

            boolean isUp = false;

            //현재 들어온 input값보다 작은 숫자들은 stack에서 pop, 나머지는 오름차순으로 stack에 정렬
            while(stack.size()>0 && input[stack.peek()]<=input[i]){

                if(i>0&&input[i]==input[i-1]){
                    sameCount++;
                }else{
                    sameCount = 1;
                }
                stack.pop();
                answer++;
                isUp = true;
            }

            if(!isUp&&i!=0){
                answer++;
            }else if(isUp) {
                answer += stack.size();
                if(sameCount>1&&stack.size()>0){
                    answer ++;
                }else if(sameCount>=3){
                    answer += sameCount-2;
                }
            }
            stack.push(i);
        }
        return answer;
    }
}
