package org.example.리코첸로봇;

import java.util.*;
class Solution {
    //R은 처음 로봇 위치   D는 장애물 위치     G는 목표지점
    static char[][] BOARD;
    static boolean[][] VISITED;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args){
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        Solution sol = new Solution();
        System.out.println(sol.solution(board));
    }
    public int solution(String[] board) {
        int answer = 0;
        BOARD = new char[board.length][board[0].length()];
        VISITED = new boolean[board.length][board[0].length()];
        int startL = 0,startR = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                BOARD[i][j] = board[i].charAt(j);
                if(BOARD[i][j]=='R'){
                    startL = i;
                    startR = j;
                }
            }
        }
        return bfs(startL,startR);
    }
    int bfs(int startL, int startR){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startL,startR,0));
        VISITED[startL][startR] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int nowL = now.l;
            int nowR = now.r;
            int dis = now.dis;
            System.out.println(nowL + " " + nowR + " " + dis);
            if(BOARD[nowL][nowR]=='G') return dis;      //목표지점 도착
            for(int i=0;i<D.length;i++){
                int nextL = now.l + D[i][0];
                int nextR = now.r + D[i][1];
                while(nextL>=0&&nextL<BOARD.length&&nextR>=0&&nextR<BOARD[0].length&& BOARD[nextL][nextR]!='G'&&BOARD[nextL][nextR]!='D'){
                    nextL += D[i][0];
                    nextR += D[i][1];
                }
                nextL -= D[i][0];
                nextR -= D[i][1];
                if(VISITED[nextL][nextR]) continue;
                VISITED[nextL][nextR] = true;
                queue.add(new Node(nextL,nextR,dis+1));
            }

        }

        return -1;
    }

    class Node{
        int l,r,dis;
        Node(int l, int r, int dis){
            this.l = l;
            this.r = r;
            this.dis = dis;
        }
    }
}