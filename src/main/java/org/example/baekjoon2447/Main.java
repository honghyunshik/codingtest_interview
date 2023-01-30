package org.example.baekjoon2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Solution sol = new Solution();
        char[][] ans = sol.getAns(n);
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

class Solution{

    char[][] arr;
    char[][] getAns(int n){
        arr = new char[n][n];
        makeStar(n,0,0, false);
        return arr;
    }

    void makeStar(int n, int l, int r, boolean blank){

        if(n==1){
            if(!blank)arr[l][r] = '*';
            else arr[l][r] = ' ';
        }else{
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(i==1&&j==1) makeStar(n/3,l+i*n/3,r+j*n/3, true);
                    else makeStar(n/3,l+i*n/3,r+j*n/3, blank);
                }
            }
        }


    }
}
