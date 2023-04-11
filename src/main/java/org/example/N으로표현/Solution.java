package org.example.N으로표현;

import java.util.*;
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(4,31));
    }
    public int solution(int N, int number) {
        int answer = 0;
        int[] dp = new int[number*N+1];
        Queue<Integer> queue = new LinkedList<>();
        dp[N] = 1;
        if(11<=number) {
            dp[11*N] = 2;
            queue.add(11*N);
        }
        if(111<=number){
            dp[111*N] = 3;
            queue.add(111*N);
        }
        if(1111<=number){
            dp[1111*N] = 4;
            queue.add(1111*N);
        }
        if(11111<=number) {
            dp[11111*N] = 5;
            queue.add(11111*N);
        }

        queue.add(N);
        while(!queue.isEmpty()){
            int now = queue.poll();
            //System.out.println(now + " " + dp[now]);
            if(now==number) {
                if(dp[now]>8) return -1;
                return dp[now];
            }
            if(now>=dp.length) continue;
            if(now/N>0&&dp[now/N]==0) {
                dp[now/N] = dp[now]+1;
                queue.add(now/N);
            }
            if(now+N<dp.length&&dp[now+N]==0) {
                dp[now+N] = dp[now]+1;
                queue.add(now+N);
            }
            if(now*N<dp.length&&dp[now*N]==0) {
                dp[now*N] = dp[now]+1;
                queue.add(now*N);
            }
            if(now-N>0&&dp[now-N]==0){
                dp[now-N] = dp[now]+1;
                queue.add(now-N);
            }
            for(int i=1;i<dp.length;i++){
                if(dp[i]>0){
                    if(i==1) System.out.println(i + "," + now + " " + dp[now] + " " + dp[i]);
                    if(i+now<dp.length&&dp[i+now]==0){
                        dp[i+now] = dp[now]+dp[i];
                        queue.add(i+now);
                    }
                    int minus = Math.abs(i - now);
                    if(i!=now&&dp[minus]==0){
                        dp[minus] = dp[now] + dp[i];
                        queue.add(minus);
                    }
                    if(i*now<dp.length&&dp[i*now]==0){
                        dp[i*now] = dp[now] + dp[i];
                        queue.add(i*now);
                    }
                    if(i/now>0&&dp[i/now]==0){
                        dp[i/now] = dp[now] + dp[i];
                        queue.add(i/now);
                    }
                    if(now/i>0&&dp[now/i]==0){
                        dp[now/i] = dp[now] + dp[i];
                        queue.add(now/i);
                    }
                }
            }
        }
        return -1;
    }
}