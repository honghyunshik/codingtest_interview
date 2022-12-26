package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14499 {

    static int[][] MAP;
    static int[][] D = {{},{0,1},{0,-1},{-1,0},{1,0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());       //세로 크기
        int M = Integer.parseInt(st.nextToken());       //가로 크기
        int x = Integer.parseInt(st.nextToken());       //주사위 x좌표
        int y = Integer.parseInt(st.nextToken());       //주사위 y좌표
        int K = Integer.parseInt(st.nextToken());       //명령의 개수

        MAP = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] command = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<K;i++){
            command[i] = Integer.parseInt(st.nextToken());
        }


    }

    public static int dicing(){
        return 1;
    }


}
