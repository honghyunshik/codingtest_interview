package org.example.사라지는발판;

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
        dfs(aloc[0],aloc[1],bloc[0],bloc[1],0);
        return answer;
    }

    void dfs(int aL, int aR, int bL, int bR, int cnt){

        //System.out.println(aL + "," + aR + "   " + bL + "," + bR + " cnt : " + cnt);
        if(cnt%2==0){
            //발판이 없어졌을 경우 패배
            if(VISITED[aL][aR]){
                System.out.println("a가 " + cnt + "라운드에 패배");
                return;
            }
            VISITED[aL][aR] = true;
            boolean flag = false;
            for(int i=0;i<4;i++){
                int nextL = aL + D[i][0];
                int nextR = aR + D[i][1];
                if(nextL<0||nextL>L-1||nextR<0||nextR>R-1) continue;
                if(VISITED[nextL][nextR]) continue;
                if(BOARD[nextL][nextR]==0) continue;
                flag = true;
                dfs(nextL,nextR,bL,bR,cnt+1);
            }
            VISITED[aL][aR] = false;
            if(!flag) {
                System.out.println("a가 " + cnt + "라운드에 패배");
                return;
            }
        }else{
            //발판이 없어졌을 경우 패배
            if(VISITED[bL][bR]){
                System.out.println("b가 " + cnt + "라운드에 패배");
                return;
            }
            VISITED[bL][bR] = true;
            boolean flag = false;
            for(int i=0;i<4;i++){
                int nextL = bL + D[i][0];
                int nextR = bR + D[i][1];
                if(nextL<0||nextL>L-1||nextR<0||nextR>R-1) continue;
                if(VISITED[nextL][nextR]) continue;
                if(BOARD[nextL][nextR]==0) continue;
                flag = true;
                dfs(aL,aR,nextL,nextR,cnt+1);
            }
            VISITED[bL][bR] = false;
            if(!flag) {
                System.out.println("b가 " + cnt + "라운드에 패배");
                return;
            }
        }
    }


}