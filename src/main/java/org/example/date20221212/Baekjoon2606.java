package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2606 {

    static int[][] computer;
    static boolean[][] VISITED;
    static boolean[] check;
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        computer = new int[N+1][N+1];
        VISITED = new boolean[N+1][N+1];
        check = new boolean[N+1];

        for(int i=1;i<=num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            computer[l][r] = 1;
            computer[r][l] = 1;
        }

        /*for(int[] array : computer){
            System.out.println(Arrays.toString(array));
        }*/

        dfs(0,1);

        System.out.println(count);

    }

    public static void dfs(int prev, int next){


        if(!check[next]&&next!=1){
            check[next] = true;
            count++;
        }
        VISITED[prev][next] = true;

        for(int i=1;i<=N;i++){
            if(computer[next][i]==1&&!VISITED[next][i]){
                dfs(next,i);
            }
        }







    }


}
