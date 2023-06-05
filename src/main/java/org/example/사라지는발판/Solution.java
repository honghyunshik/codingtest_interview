package org.example.사라지는발판;

import java.util.Arrays;

class Solution {

    static int[][] BOARD;
    static boolean[][] VISITED;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    static int L,R;


    public int solution(int[][] board, int[] aloc, int[] bloc) {

        BOARD = board;
        L = board.length;
        R = board[0].length;
        VISITED = new boolean[L][R];

        return dfs(aloc[0],aloc[1],bloc[0],bloc[1]).dis;
    }

    //이길 수 있는 방법이 있으면 무조건 이기고
    //질 수 밖에 없다면 최대한 높은 숫자를 반환
    private Result dfs(int x1, int y1,int x2, int y2){

        if(x1==x2&&y1==y2){
            return new Result(true,1);
        }
        boolean win = false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<4;i++){

            int nextX1 = x1 + D[i][0];
            int nextY1 = y1 + D[i][0];
            if(nextX1<0||nextX1>L-1||nextY1<0||nextY1>R-1
                    ||BOARD[nextX1][nextY1]==0) continue;
            Result re = dfs(x2,y2,nextX1,nextY1);
            if(!re.win){
                win = true;
                min = re.dis;
            }else max = re.dis;
        }

        if(!win&&max==Integer.MIN_VALUE) return new Result(false,1);

        return new Result(win,win?min:max);

    }


}

class Result{
    boolean win;
    int dis;
    Result(boolean win, int dis){
        this.win = win;
        this.dis = dis;
    }
}