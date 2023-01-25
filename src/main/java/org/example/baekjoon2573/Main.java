package org.example.baekjoon2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] bingsan = new int[row][col];

        for(int i=0;i<row;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<col;j++){
                bingsan[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution sol = new Solution();
        System.out.println(sol.getMinTime(bingsan));

    }
}

class Solution{

    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visited;

    int getMinTime(int[][] bingsan){

        int count = 0;
        int piece = 0;
        boolean allMelt = false;

        //빙산이 다 녹을때까지 while문
        while(!allMelt){

            allMelt = true;
            piece = 0;
            visited = new boolean[bingsan.length][bingsan[0].length];
            int[][] temp = new int[bingsan.length][bingsan[0].length];
            //dfs 탐색을 통해 두덩어리 이상으로 분리되었는지 확인
            for(int i=0;i<bingsan.length;i++){
                for(int j=0;j<bingsan[0].length;j++){
                    if(!visited[i][j]&&bingsan[i][j]>0){
                        dfs(bingsan,i,j);
                        piece++;
                    }
                }
            }
            if(piece>=2) return count;

            //빙산이 녹는다
            for(int i=0;i<bingsan.length;i++){
                for(int j=0;j<bingsan[0].length;j++){
                    if(bingsan[i][j]>0) {
                        melt(temp, bingsan,i,j);
                        allMelt = false;
                    }

                }
            }
            for(int i=0;i<bingsan.length;i++){
                for(int j=0;j<bingsan[0].length;j++){
                    bingsan[i][j] = temp[i][j];
                }
            }
            count++;
        }

        return 0;
    }

    void dfs(int[][] bingsan, int row, int col){

        if(visited[row][col]) return;
        visited[row][col] = true;
        for(int i=0;i<D.length;i++){
            int nextRow = row + D[i][0];
            int nextCol = col + D[i][1];
            if(nextRow>bingsan.length-1||nextRow<0||nextCol>bingsan[0].length-1||nextCol<0) continue;      //index를 벗어나면 continue
            if(bingsan[nextRow][nextCol]==0) continue;
            dfs(bingsan,nextRow,nextCol);
        }


    }

    //빙산이 녹는다
    void melt(int[][] temp, int[][] bingsan, int row, int col){

        int count = 0;
        if(bingsan[row][col]==0) return;
        for(int i=0;i<D.length;i++){
            int nextRow = row + D[i][0];
            int nextCol = col + D[i][1];
            if(nextRow>bingsan.length-1||nextRow<0||nextCol>bingsan[0].length-1||nextCol<0) continue;      //index를 벗어나면 continue
            if(bingsan[nextRow][nextCol]>0) continue;       //주위에 빙산이 있으면 continue
            count++;
        }
        temp[row][col] = Math.max(bingsan[row][col]-count,0);

    }

}
