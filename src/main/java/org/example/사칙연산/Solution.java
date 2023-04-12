package org.example.사칙연산;
import java.util.*;
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String[] input = {"3","-","5","-","8","-","2","-","1"};
        System.out.println(sol.solution(input));
    }
    public int solution(String arr[]) {
        int answer = -1;
        int[] num = new int[arr.length];
        num[num.length-1] = Integer.parseInt(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            System.out.println(Arrays.toString(num));
            //-가 뜨면 모두 -를 하던가 or 이전글자 하나만 -를 하던가
            if(arr[i].equals("-")){
                if(i+3<arr.length) num[i+1] = Math.max(-num[i+1],-num[i+1]+num[i+3]);
                else num[i+1] = -num[i+1];
            }else if(arr[i].equals("+")){
                continue;
            }else{
                num[i] = Integer.parseInt(arr[i]) + num[i+2];
            }
        }
        return num[0];
    }
}
