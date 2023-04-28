package org.example.연속펄스;

import java.util.*;

class Solution {

    static long answer = 0;
    static int[] SEQUENCE;

    public static void main(String[] args){

        Solution sol = new Solution();

        int[] sequence = new int[500000];
        for(int i=0;i<sequence.length;i++){
            sequence[i] = 100000;
        }
        System.out.println(sol.solution(sequence));
    }

    public long solution(int[] sequence) {

        SEQUENCE = sequence;

        if(sequence[0]>0) dfs(0,1,0);
        else dfs(0,-1,0);


        return answer;
    }

    private void dfs(int idx, int k, long sum){

        System.out.println("idx : "+ idx + " k: " + k + " sum : " + sum);
        answer = Math.max(answer,sum);
        if(idx==SEQUENCE.length) return;
        if(sum<0){
            if(SEQUENCE[idx-1]>0) dfs(idx-1,1,0);
            else dfs(idx-1,-1,0);
            return;
        }

        dfs(idx+1,-k,sum+(SEQUENCE[idx])*k);

    }


}