package org.example.부분합;

import java.util.*;
class Solution {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] sequence = {1,2,3,4,5};
        int[] sequence2 = {1,1,1,2,3,4,5};
        int[] sequence3 = {2,2,2,2,2};
        int[] ans = sol.solution(sequence3,5);
        System.out.println(Arrays.toString(ans));
    }
    public int[] solution(int[] sequence, int k) {

        int l=0,r=0;
        int sum = 0;
        int[] answer = {0,Integer.MAX_VALUE};
        int size = sequence.length;
        while(r<=size){

            System.out.println("l : " + l + " r : " + r + " sum : " + sum);
            if(sum<k&&r<size){
                sum+=sequence[r++];
            }else if(sum>k&&l<r){
                sum-=sequence[l++];
            }else if(sum==k){
                if(answer[1]-answer[0]>r-l-1||answer[1]-answer[0]==r-l-1&&answer[0]>l){
                    answer[0] = l;
                    answer[1] = r-1;
                }
                if(r==size) break;
                sum+=sequence[r++];
            }else break;

        }

        return answer;
    }
}