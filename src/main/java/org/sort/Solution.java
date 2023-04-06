package org.sort;

import java.util.*;
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        long[] numbers = {7,8};
        int[] answer = sol.solution(numbers);
        System.out.println(Arrays.toString(answer));
    }
    static boolean check;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        for(long number:numbers){
            if(number==1){
                answer[idx++] = 1;
                continue;
            }
            check = true;
            String binary = toBinary(number);
            char[] list = new char[binary.length()+1];
            for(int i=1;i<list.length;i++){
                list[i] = binary.charAt(i-1);
                System.out.print(i + " : " + list[i] + " ");
            }
            int rootIdx = list.length/2;
            dfs(rootIdx,rootIdx,list);
            if(check) answer[idx++] = 1;
            else answer[idx++] = 0;
            System.out.println("\n\n-----\n\n");
        }
        return answer;
    }

    private void dfs(int parentIdx, int temp, char[] list){

        temp/=2;
        if(temp==0||!check) return;
        int leftChildIdx = parentIdx-temp;
        int rightChildIdx = parentIdx+temp;
        System.out.println("\n" + parentIdx + " " + leftChildIdx + " " + rightChildIdx + " " + temp);
        if(list[parentIdx]==48&&(list[leftChildIdx]==49||list[rightChildIdx]==49)){
            check = false;
            return;
        }
        dfs(leftChildIdx,temp,list);
        dfs(rightChildIdx,temp,list);
    }


    private String toBinary(long num){

        StringBuilder sb = new StringBuilder(Long.toBinaryString(num));
        int j = 1;
        while(Math.pow(2,j)<=num){
            j = j*2+1;
        }
        int cnt = j-sb.length();
        while(cnt>0){
            sb.insert(0,0);
            cnt--;
        }
        System.out.println(sb + " " + j);
        return sb.toString();
    }
}
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
    }
}