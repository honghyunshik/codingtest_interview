package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14489_re {

    static int[][] start_link;
    static int N;
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start_link = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=N;j++){
                start_link[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(1,0);
        System.out.println(answer);
    }

    public static void backTracking(int index, int count){

        if(count==N/2){
            diff();
            return;
        }
        for(int i=index;i<visit.length;i++){
            visit[i] = true;
            backTracking(i+1,count+1);
            visit[i] = false;
        }
    }

    public static void diff(){
        int start = 0;
        int link = 0;
        for(int i=1;i<visit.length;i++){
            for(int j=i;j<visit.length;j++){
                if(visit[i]&&visit[j]){
                    start += start_link[i][j];
                    start += start_link[j][i];
                }
                if(!visit[i]&&!visit[j]){
                    link += start_link[i][j];
                    link += start_link[j][i];
                }
            }
        }
        int temp = Math.abs(start-link);
        answer = Math.min(temp,answer);

    }
}
