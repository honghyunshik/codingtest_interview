package org.example.date20221012;

import java.util.Stack;

//파이썬 알고리즘 인터뷰 책 22번 문제 - 일일 온도(252p)
//매일의 화씨 온도 리스트를 입력받아서, 더 따뜻한 날씨를 위해서는 며칠을 더 기다려야 하는지를 출력하라
public class Interview22 {
    public static void main(String[] args){
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        printAnswer(getHotter(input));
    }

    public static int[] getHotter(int[] input){

        int[] answer = new int[input.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<input.length;i++){

            while(stack.size()>0){
                int top = stack.get(stack.size()-1);
                if(input[top]<input[i]){
                    stack.pop();
                    answer[top] = i-top;
                }else{
                    break;
                }
            }
            stack.add(i);
        }

        return answer;
    }

    public static void printAnswer(int[] ans){
        for(int num:ans){
            System.out.print(num + " ");
        }
    }

}
