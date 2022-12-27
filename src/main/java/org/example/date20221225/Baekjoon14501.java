package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14501 {

    static int[][] consulting;
    static int answer = 0;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        consulting = new int[N+1][2];

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            consulting[i][0] = Integer.parseInt(st.nextToken());
            consulting[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(answer);


    }

    public static void dfs(int day, int sum){

        if(day>=N+1) {
            answer = Math.max(sum,answer);
            return;
        }

        if(day>0&&day+consulting[day][0]<=N+1) dfs(day+consulting[day][0],sum + consulting[day][1]);
        dfs(day+1,sum);
    }


}
