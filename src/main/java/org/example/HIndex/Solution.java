package org.example.HIndex;


import java.util.*;

class Solution {

    public static void main(String[] args){

        int[] input = {3, 4, 5, 11, 15, 16, 17, 18, 19, 20};
        Solution sol = new Solution();
        System.out.println(sol.solution(input));
    }
    public int solution(int[] citations) {

        int[] arr = new int[10001];

        for(int num:citations){
            if(num>0){
                arr[1]++;
                if(num+1<10001) arr[num+1]--;
            }
        }

        for(int i=1;i<= citations.length;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=citations.length;i>=0;i--){
            if(arr[i]>=i) return i;
        }
        int answer = 0;
        return answer;
    }
}