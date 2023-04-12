package org.example.등굣길;

import java.util.*;
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(4,3,new int[][]{{3,1}}));
    }
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] ans = new int[n][m];

        ans[0][0] = 1;
        for(int i=0;i<puddles.length;i++){
            ans[puddles[i][1]-1][puddles[i][0]-1] = Integer.MAX_VALUE;
        }
        for(int i=1;i<m;i++){
            if(ans[0][i]==Integer.MAX_VALUE) break;
            ans[0][i] = 1;
        }
        for(int i=1;i<n;i++){
            if(ans[i][0]==Integer.MAX_VALUE) break;
            ans[i][0] = 1;
        }


        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(ans[i][j]==Integer.MAX_VALUE) continue;
                if(ans[i-1][j]!=Integer.MAX_VALUE&&ans[i][j-1]!=Integer.MAX_VALUE)
                    ans[i][j] = ans[i-1][j] + ans[i][j-1];
                else if(ans[i-1][j]!=Integer.MAX_VALUE) ans[i][j] = ans[i-1][j];
                else if(ans[i][j-1]!=Integer.MAX_VALUE) ans[i][j] = ans[i][j-1];
            }
        }
        for(int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }


        return ans[n-1][m-1];
    }
}