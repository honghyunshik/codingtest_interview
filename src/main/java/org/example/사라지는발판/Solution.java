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
        int answer = -1;
        return answer;
    }



}