package org.example.date20221124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon3015 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        for(int i=0;i<num;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(arr));

    }

    public static long solution(int[] arr){

        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        int sameCount = 0;

        for(int i=0;i<arr.length;i++){

            //새로 들어온 수(arr[i])가 stack.peek 보다 클 때 pop
            //stack에는 내림차순으로 저장
            while(!stack.isEmpty()&&arr[i]>arr[stack.peek()]){

                int pop = stack.pop();
                if(!stack.isEmpty()&&arr[pop]==arr[stack.peek()]){

                    if(arr[stack.get(0)]>arr[pop]){
                        answer++;
                    }
                    answer += sameCount;
                    sameCount++;

                }else{
                    sameCount = 0;
                }

                if(!stack.isEmpty()){
                    answer++;
                }

            }


            stack.add(i);
        }

        sameCount = 0;
        while(!stack.isEmpty()){
            int pop = stack.pop();
            if(!stack.isEmpty()&&arr[pop]==arr[stack.peek()]){
                answer+=sameCount;
                sameCount++;
            }else{
                sameCount = 0;
            }
        }


        return answer+arr.length-1;
    }
}
