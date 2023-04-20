package org.example.괄호회전하기;

import java.util.*;
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution("[](){}"));
    }
    public int solution(String s) {

        int answer = 0;
        int k = 0;
        int len = s.length();
        while(k<len){
            System.out.println(k + "," + len);
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int i=k;i<k+len;i++){

                int forI = i;
                if(i>=len) forI-=len;

                if(s.charAt(forI)=='}'){
                    if(stack.isEmpty()||stack.pop()!='{'){
                        flag = false;
                        break;
                    }
                }else if(s.charAt(forI)==')'){
                    if(stack.isEmpty()||stack.pop()!='('){
                        flag = false;
                        break;
                    }
                }else if(s.charAt(forI)==']'){
                    if(stack.isEmpty()||stack.pop()!='['){
                        flag = false;
                        break;
                    }
                }else{
                    stack.add(s.charAt(forI));
                }
            }

            if(stack.isEmpty()&&flag) answer++;

            k++;
        }

        return answer;
    }
}