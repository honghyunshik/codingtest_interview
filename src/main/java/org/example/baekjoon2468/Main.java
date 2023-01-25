package org.example.baekjoon2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static  void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] BOARD = new int[n][n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                BOARD[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,BOARD[i][j]);
            }
        }
        Solution sol = new Solution();
        System.out.println(sol.getMaxWidth(BOARD,max));
    }

}

class Solution{

    static boolean[][] visited;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    static int n;
    int getMaxWidth(int[][] BOARD, int max){

        int count = 0;
        n = BOARD.length;
        for(int k=0;k<=max;k++){
            int temp = 0;
            visited = new boolean[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    //물높이보다 높게 있고 방문이 안되었을 경우
                    if(!visited[i][j]&&BOARD[i][j]>k){
                        temp++;
                        dfs(i,j,BOARD,k);
                    }
                }
            }
            count = Math.max(count,temp);
        }
        return count;


    }

    void dfs(int row, int col,int[][] BOARD,int k){

        if(BOARD[row][col]<=k) return;      //물에 잠기면 안됨
        if(visited[row][col]) return;
        visited[row][col] = true;
        for(int i=0;i<D.length;i++){
            int nextRow = row + D[i][0];
            int nextCol = col + D[i][1];
            if(nextRow<0||nextRow>n-1||nextCol<0||nextCol>n-1) continue;
            dfs(nextRow,nextCol,BOARD,k);
        }

    }
}