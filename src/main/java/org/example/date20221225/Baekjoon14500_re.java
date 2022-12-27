package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14500_re {

    static int N,M;
    static int[][] BOARD;
    static boolean[][] VISITED;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        BOARD = new int[N][M];
        VISITED = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                BOARD[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                VISITED[i][j] = true;
                backTracking(i,j,1,BOARD[i][j]);
                VISITED[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    public static void backTracking(int l, int r, int count, int sum){

        if(count==4){
            answer = Math.max(sum,answer);
            return;
        }

        for(int i=0;i<4;i++){
            int nextL = l+D[i][0];
            int nextR = r+D[i][1];
            if(nextL<0||nextL>N-1||nextR<0||nextR>M-1) continue;
            if(VISITED[nextL][nextR]) continue;
            if(count==2){
                VISITED[nextL][nextR] = true;
                backTracking(l,r,count+1,sum+BOARD[nextL][nextR]);
                VISITED[nextL][nextR] = false;
            }
            VISITED[nextL][nextR] = true;
            backTracking(nextL,nextR,count+1,sum+BOARD[nextL][nextR]);
            VISITED[nextL][nextR] = false;
        }


    }


}
