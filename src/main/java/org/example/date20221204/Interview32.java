package org.example.date20221204;

import java.util.Arrays;

//1을 육지로, 0을 물로 가정한 2D 그리드 맵이 주어졌을 때, 섬의 개수를 계산하라
public class Interview32 {

    static int[][] Board =
                            {{1,1,1,1,0},
                            {1,1,0,1,0},
                            {1,1,0,0,0},
                            {0,0,0,0,0}};

    static int[][] Board1 =
                            {{1,1,0,0,0},
                            {1,1,0,0,0},
                            {0,0,1,0,0},
                            {0,0,0,1,1}};

    static int count = 0;
    static int[][] D = {{1,0},{-1,0},{0,1},{0,-1}};


    public static void main(String[] args){


        for(int i=0;i<Board.length;i++){
            for(int j=0;j<Board[i].length;j++){
                if(Board1[i][j]==1){
                    dfs(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    public static void dfs(int Row, int Col){

        if(Board1[Row][Col]!=1) return;
        Board1[Row][Col] = 0;

        for(int i=0;i<4;i++){
            int tRow = Row + D[i][0], tCol = Col + D[i][1];
            if(tRow<0||tRow>3||tCol<0||tCol>4) continue;
            dfs(tRow,tCol);
        }

    }
}
