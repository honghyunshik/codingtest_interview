package org.example.코딩테스트공부;

import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int[][] dp = new int[problems.length][3];
        for(int i=1;i<dp.length;i++){
            dp[i][2] = 1000000;
        }
        dp[0][0] = alp;
        dp[0][1] = cop;
        dp[0][2] = Math.max(problems[0][0]-alp,0) + Math.max(problems[0][1]-cop,0);
        Arrays.sort(problems,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        for(int i=1;i<problems.length;i++){

            int needAlp = problems[i][0];
            int needCop = problems[i][1];

            for(int j=0;j<i;j++){

                //알고리즘 공부
                int temp = dp[j][2] + Math.max(0,needAlp-dp[j][0]) + Math.max(0,needCop-dp[j][1]);
                if(dp[i][2]>temp){
                    dp[i][0] = needAlp;
                    dp[i][1] = needCop;
                    dp[i][2] = temp;
                }

                //문제 풀기
                int tempAlp = dp[j][0];
                int tempCop = dp[j][1];
                int tempTime = dp[j][2];
                while(tempCop<needCop&&tempAlp<needAlp){
                    tempAlp += problems[j][2];
                    tempCop += problems[j][3];
                    tempTime += problems[j][4];
                }
                if(dp[i][2]>=tempTime + Math.max(0,needAlp-tempAlp) + Math.max(0,needCop-tempCop)){
                    dp[i][0] = Math.max(needAlp,tempAlp);
                    dp[i][1] = Math.max(needCop,tempCop);
                    dp[i][2] = tempTime + Math.max(0,needAlp-tempAlp) + Math.max(0,needCop-tempCop);

                }
                while(tempCop<needCop||tempAlp<needAlp){
                    tempAlp += problems[j][2];
                    tempCop += problems[j][3];
                    tempTime += problems[j][4];
                }
                if(dp[i][2]>=tempTime){
                    dp[i][0] = tempAlp;
                    dp[i][1] = tempCop;
                    dp[i][2] = tempTime;
                }

            }
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return answer;
    }
}