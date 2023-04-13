package org.example.아방가르드타일링;

class Solution {


    public int solution(int n) {

        int answer = 0;


        long[] dp = new long[n+1];

        if(n==1) return 1;
        if(n==2) return 3;
        if(n==3) return 10;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;

        for(int num=4;num<=n;num++){

            for(int left=1;left<=num-1;left++){

                int right = num-left;
                dp[num]+=dp[left]*dp[right];
            }
            dp[num]-=num-2;
        }

        return (int)dp[n]%1000000007;
    }

}