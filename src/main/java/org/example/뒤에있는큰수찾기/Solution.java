package org.example.뒤에있는큰수찾기;

import java.util.*;
class Solution {

    public static void main(String[] args){
        int[] numbers = {2,2,2,2,3,5,87};
        Solution sol = new Solution();
        int[] ans = sol.solution(numbers);
        System.out.println(Arrays.toString(ans));
    }
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(numbers[answer.length-1]);
        for(int i=numbers.length-2;i>=0;i--){
            //뒤의 수가 자신보다 크다면
            if(numbers[i]<numbers[i+1]){
                answer[i] = numbers[i+1];
            }
            //뒤의 수가 자신보다 작다면 큰 수가 있을때까지 찾기
            else{

                while(!stack.isEmpty()&&stack.peek()<=numbers[i]){
                    stack.pop();
                }

                if(stack.size()==0) answer[i] = -1;
                else answer[i] = stack.peek();
            }
            stack.add(numbers[i]);
        }
        answer[answer.length-1] = -1;
        return answer;
    }
}