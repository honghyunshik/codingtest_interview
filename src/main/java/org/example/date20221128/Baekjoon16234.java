package org.example.date20221128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon16234 {

    static int N;
    static final int MAX_N = 50;
    static int[][] Board = new int[MAX_N][MAX_N];
    static int[][] boundary;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    static int min;
    static int max;

    static BufferedReader br;


    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        min = Integer.parseInt(input[1]);
        max = Integer.parseInt(input[2]);
        System.out.println(solution(min,max));





    }

    public static int solution(int min, int max) throws IOException {

        int answer = 0;
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++){
            String[] line = br.readLine().split(" ");
            Board[i] = Arrays.stream(line)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int count = 0;

        while(count!=N*N){

            boundary = new int[MAX_N][MAX_N];

            count = 0;


            for(int i=0;i<N;i++){

                for(int j=0;j<N;j++){

                    if(boundary[i][j]==0){
                        dfs(i,j,i,j,++count);

                    }
                }
            }
            int temp = 0;
            if(count!=N*N) {
                answer++;
                int[][] avg = new int[count+1][2];
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        temp = boundary[i][j];
                        avg[temp][0] += Board[i][j];
                        avg[temp][1]++;
                    }
                }
                int[] rAvg = new int[count+1];
                for(int i=1;i<=count;i++){
                    rAvg[i] = avg[i][0]/avg[i][1];
                }
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        Board[i][j] = rAvg[boundary[i][j]];
                    }
                }
            }else return answer;



        }

        return answer;
    }

    public static void dfs(int prevRow, int prevCol, int nowRow, int nowCol, int count){

        if((prevRow==nowRow&&prevCol==nowCol)||(Math.abs(Board[nowRow][nowCol]-Board[prevRow][prevCol])>=min&&Math.abs(Board[nowRow][nowCol]-Board[prevRow][prevCol])<=max)){
            boundary[nowRow][nowCol] = count;
        }else return;

        for(int i=0;i<4;i++){
            int nextRow = nowRow + D[i][0], nextCol = nowCol + D[i][1];
            if(nextRow<0||nextRow>N-1||nextCol<0||nextCol>N-1) continue;
            if(boundary[nextRow][nextCol]>0) continue;
            dfs(nowRow,nowCol,nextRow,nextCol,count);
        }



    }
}
