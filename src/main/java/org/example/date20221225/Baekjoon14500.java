package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14500 {

    static int[][] BOARD;
    static int N,M;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        BOARD = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                BOARD[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        blue();
        yellow();
        orange();
        green();
        pink();
        System.out.println(answer);
    }

    public static void blue(){

        //가로
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(j>M-4) continue;
                int temp = BOARD[i][j] + BOARD[i][j+1] + BOARD[i][j+2] + BOARD[i][j+3];
                answer = Math.max(temp,answer);
            }
        }

        //세로
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i>N-4) continue;
                int temp = BOARD[i][j] + BOARD[i+1][j] + BOARD[i+2][j] + BOARD[i+3][j];
                answer = Math.max(temp,answer);
            }
        }
    }

    public static void yellow(){

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i>N-2||j>M-2) continue;
                int temp = BOARD[i][j] + BOARD[i+1][j] + BOARD[i][j+1] + BOARD[i+1][j+1];
                answer = Math.max(temp,answer);
            }
        }
    }

    public static void orange(){

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

                //그림모양 위 아래
                if(i<=N-3&&j<=M-2) {
                    int temp = BOARD[i][j] + BOARD[i+1][j] + BOARD[i+2][j] + BOARD[i+2][j+1];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i][j+1] + BOARD[i+1][j+1] + BOARD[i+2][j+1] + BOARD[i+2][j];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i][j] + BOARD[i][j+1] + BOARD[i+1][j+1] + BOARD[i+2][j+1];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i][j] + BOARD[i+1][j] + BOARD[i+2][j] + BOARD[i][j+1];
                    answer = Math.max(temp,answer);
                }
                //90도 회전
                if(i<=N-2&&j<=M-3){
                    int temp = BOARD[i][j] + BOARD[i+1][j] + BOARD[i][j+1] + BOARD[i][j+2];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i][j] + BOARD[i+1][j] + BOARD[i+1][j+1] + BOARD[i+1][j+2];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i][j+2] + BOARD[i+1][j] + BOARD[i+1][j+1] + BOARD[i+1][j+2];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i][j] + BOARD[i][j+1] + BOARD[i][j+2] + BOARD[i+1][j+2];
                    answer = Math.max(temp,answer);
                }

            }
        }
    }

    public static void green(){

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i<=N-3&&j<=M-2){
                    int temp = BOARD[i][j] + BOARD[i+1][j] + BOARD[i+1][j+1] + BOARD[i+2][j+1];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i][j+1] + BOARD[i+1][j] + BOARD[i+1][j+1] + BOARD[i+2][j];
                    answer = Math.max(temp,answer);
                }
                if(i<=N-2&&j<=M-3){
                    int temp = BOARD[i+1][j] + BOARD[i][j+1] + BOARD[i][j+2] + BOARD[i+1][j+1];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i][j] + BOARD[i][j+1] + BOARD[i+1][j+1] + BOARD[i+1][j+2];
                    answer = Math.max(temp,answer);
                }
            }
        }
    }

    public static void pink(){

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i<=N-2&&j<=M-3){
                    int temp = BOARD[i][j] + BOARD[i][j+1] + BOARD[i+1][j+1] + BOARD[i][j+2];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i+1][j] + BOARD[i][j+1] + BOARD[i+1][j+1] + BOARD[i+1][j+2];
                    answer = Math.max(temp,answer);
                }
                if(i<=N-3&&j<=M-2){
                    int temp = BOARD[i][j] + BOARD[i+1][j] + BOARD[i+2][j] + BOARD[i+1][j+1];
                    answer = Math.max(temp,answer);
                    temp = BOARD[i+1][j] + BOARD[i][j+1] + BOARD[i+1][j+1] + BOARD[i+2][j+1];
                    answer = Math.max(temp,answer);
                }
            }
        }
    }


}
