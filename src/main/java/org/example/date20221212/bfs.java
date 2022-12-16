package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs {

    static int N;
    static int[][] BOARD;
    static boolean[][] VISITED;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        BOARD = new int[N][N];
        VISITED = new boolean[N][N];

        for(int i=0;i<N;i++){

            String[] input = br.readLine().split(" ");
            int[] temp = new int[input.length+1];
            for(int j=0;j<input.length;j++){
                temp[j] = Integer.parseInt(input[j]);
            }
            BOARD[i] = temp;
        }

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int sRow = Integer.parseInt(st.nextToken());
        int sCol = Integer.parseInt(st.nextToken());
        int dRow = Integer.parseInt(st.nextToken());
        int dCol = Integer.parseInt(st.nextToken());


        System.out.println(bfs(sRow,sCol,dRow,dCol));

    }

    public static int bfs(int sRow, int sCol, int dRow, int dCol){

        class Pointer{
            int row,col,dis;
            Pointer(int row, int col, int dis){
                this.row = row;
                this.col = col;
                this.dis = dis;
            }
        }

        Queue<Pointer> queue = new LinkedList<>();
        VISITED[sRow][sCol] = true;
        queue.add(new Pointer(sRow,sCol,0));


        while(!queue.isEmpty()){

            Pointer curr = queue.remove();
            if(curr.row==dRow&&curr.col==dCol) return curr.dis;
            for(int i=0;i<4;i++){
                int nextRow = curr.row + D[i][0];
                int nextCol = curr.col + D[i][1];
                if(nextRow<0||nextRow>N-1||nextCol<0||nextCol>N-1) continue;
                if(BOARD[nextRow][nextCol]==1) continue;
                if(VISITED[nextRow][nextCol]) continue;
                VISITED[nextRow][nextCol] = true;
                queue.add(new Pointer(nextRow,nextCol,curr.dis+1));
            }
        }
        return -1;
    }
}
