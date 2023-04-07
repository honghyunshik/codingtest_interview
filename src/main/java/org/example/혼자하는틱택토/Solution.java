package org.example.혼자하는틱택토;

class Solution {
    //실수한 경우
    //1. O보다 X가 더 많다
    //2. X가 한줄이 있을 경우 O 한줄은 없어야 한다

    public static void main(String[] args){
        String[] board = {"O.X", ".O.", "..X"};
        Solution sol = new Solution();
        System.out.println(sol.solution(board));
    }
    public int solution(String[] board) {
        int answer = -1;
        int oCnt = 0;
        int xCnt = 0;

        //가로 검사
        for(int i=0;i<3;i++){
            boolean flag = true;
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='O') oCnt++;
                else if(board[i].charAt(j)=='X') xCnt++;
            }
        }
        if(oCnt<xCnt) return 0;     //x의 수가 더 많을 경우는 불가능
        if(oCnt>xCnt+1) return 0;       //o의 수가 하나 이상 더 많으면 불가능 
        boolean isO = isO(board);
        boolean isX = isX(board);
        if(isX&&isO) return 0;      //둘다 한줄이 완성될수는 없다
        if(isX&&xCnt<oCnt) return 0;    //X가 완성되었다면 둘의 갯수는 같다
        if(isO&&xCnt==oCnt) return 0;       //O가 완성되었다면 o가 더 많아야한다
        return 1;
    }
    boolean isO(String[] board){

        //가로 검사
        for(int i=0;i<3;i++){
            boolean flag = true;
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)!=board[i].charAt(0)) flag = false;
            }
            if(flag){
                if(board[i].charAt(0)=='O') return true;
            }
        }

        //세로 검사
        for(int i=0;i<3;i++){
            boolean flag = true;
            for(int j=0;j<3;j++){
                if(board[j].charAt(i)!=board[0].charAt(i)) flag = false;
            }
            if(flag&&board[0].charAt(i)=='O') return true;
        }

        //대각선 검사
        if(board[0].charAt(0)==board[1].charAt(1)&&board[1].charAt(1)==board[2].charAt(2)){
            if(board[0].charAt(0)=='O') return true;

        }
        if(board[0].charAt(2)==board[1].charAt(1)&&board[1].charAt(1)==board[2].charAt(0)){
            if(board[0].charAt(2)=='O') return true;
        }
        return false;
    }

    boolean isX(String[] board){

        //가로 검사
        for(int i=0;i<3;i++){
            boolean flag = true;
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)!=board[i].charAt(0)) flag = false;
            }
            if(flag){
                if(board[i].charAt(0)=='X') return true;
            }
        }

        //세로 검사
        for(int i=0;i<3;i++){
            boolean flag = true;
            for(int j=0;j<3;j++){
                if(board[j].charAt(i)!=board[0].charAt(i)) flag = false;
            }
            if(flag&&board[0].charAt(i)=='X') return true;
        }
        //대각선 검사
        if(board[0].charAt(0)==board[1].charAt(1)&&board[1].charAt(1)==board[2].charAt(2)){
            if(board[0].charAt(0)=='X') return true;

        }
        if(board[0].charAt(2)==board[1].charAt(1)&&board[1].charAt(1)==board[2].charAt(0)){
            if(board[0].charAt(2)=='X') return true;
        }
        return false;
    }
}