package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2667 {

    static int[][] BOARD;
    static boolean[][] VISITED;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int d=0;d<N;d++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            BOARD = new int[l][r];
            VISITED = new boolean[l][r];

            for(int i=0;i<k;i++){

                st = new StringTokenizer(br.readLine()," ");
                BOARD[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            int count = 0;
            for(int i=0;i<BOARD.length;i++){
                for(int j=0;j<BOARD[0].length;j++){
                    if(!VISITED[i][j]&&BOARD[i][j]==1) dfs(i,j,++count,l,r);
                }
            }


            System.out.println(count);
        }








    }

    public static void dfs(int l, int r, int count, int Left, int Right){

        VISITED[l][r] = true;
        BOARD[l][r] = count;

        for(int i=0;i<4;i++){

            int nextL = D[i][0] + l;
            int nextR = D[i][1] + r;

            if(nextL<0||nextL>Left-1||nextR<0||nextR>Right-1) continue;
            if(VISITED[nextL][nextR]) continue;
            if(BOARD[nextL][nextR]!=1) continue;
            dfs(nextL,nextR,count,Left,Right);
        }

    }
}
