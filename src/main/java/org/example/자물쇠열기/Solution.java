package org.example.자물쇠열기;

import java.util.Arrays;

class Solution {

    public static void main(String[] args){

        Solution sol = new Solution();
        int[][] key = {{1,2,3},{4,5,6},{7,8,9}};
        sol.solution(key,null);
    }
    public boolean solution(int[][] key, int[][] lock) {

        boolean answer = true;
        int n = key.length;
        int[][] key_1 = new int[n][n];      //시계방향 90도 회전
        int[][] key_2 = new int[n][n];      //시계방향 180도 회전
        int[][] key_3 = new int[n][n];      //시계방향 270도 회전

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                key_1[j][n-1-i] = key[i][j];
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(key[i]));
        }
        System.out.println("\n\n\n");
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(key_1[i]));
        }
        return answer;
    }
}