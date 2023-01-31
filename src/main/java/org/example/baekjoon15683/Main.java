package org.example.baekjoon15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] array = new int[row][col];
        for(int i=0;i<row;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<col;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Solution sol = new Solution();
        int ans = sol.minWidth(array);
        System.out.println(ans);

    }
}

class Solution{

    static int ans = Integer.MAX_VALUE;
    static int[][] BOARD;

    int minWidth(int[][] array){

        ArrayList<int[]> cctv = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]!=6&&array[i][j]!=0&&array[i][j]!=-1){
                    cctv.add(new int[]{i,j});
                }
            }
        }
        BOARD = array;
        backTracking(cctv,0);
        return ans;
    }

    void backTracking(ArrayList<int[]> cctv, int index){

        if(index==cctv.size()){
            int count = 0;
            for(int i=0;i<BOARD.length;i++){
                for(int j=0;j<BOARD[i].length;j++){
                    if(BOARD[i][j]==0) count++;
                }
            }
            ans = Math.min(ans,count);
            return;
        }

        int[] now = cctv.get(index);
        int cctvNum = BOARD[now[0]][now[1]];
        ArrayList<int[]> nowAdd = new ArrayList<>();
        if(cctvNum==1){

            //오른쪽
            right(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

            //왼쪽
            left(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

            //아래
            down(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();


            //위
            up(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

        }else if(cctvNum==2){

            //좌 우
            left(nowAdd,now[0],now[1]);
            right(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

            //위 아래
            up(nowAdd,now[0],now[1]);
            down(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

        }else if(cctvNum==3){

            //위 오른쪽
            up(nowAdd,now[0],now[1]);
            right(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

            //오른쪽 아래
            right(nowAdd,now[0],now[1]);
            down(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

            //아래 왼쪽
            left(nowAdd,now[0],now[1]);
            down(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

            //왼쪽 위
            left(nowAdd,now[0],now[1]);
            up(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

        }else if(cctvNum==4){

            //왼쪽 위 오른쪽
            left(nowAdd,now[0],now[1]);
            up(nowAdd,now[0],now[1]);
            right(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();


            //위 오른쪽 아래
            up(nowAdd,now[0],now[1]);
            right(nowAdd,now[0],now[1]);
            down(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();


            //오른쪽 아래  왼쪽
            left(nowAdd,now[0],now[1]);
            down(nowAdd,now[0],now[1]);
            right(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();


            //아래 왼쪽 위
            down(nowAdd,now[0],now[1]);
            left(nowAdd,now[0],now[1]);
            up(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

        }else if(cctvNum==5){

            //다
            down(nowAdd,now[0],now[1]);
            left(nowAdd,now[0],now[1]);
            up(nowAdd,now[0],now[1]);
            right(nowAdd,now[0],now[1]);
            backTracking(cctv,index+1);
            for(int[] temp:nowAdd){
                BOARD[temp[0]][temp[1]] = 0;
            }
            nowAdd.clear();

        }



    }

    //오른쪽으로 쭉
    void right(ArrayList<int[]> nowAdd, int row, int col){
        for(int i = col;i<BOARD[0].length;i++){
            if(BOARD[row][i]==6) break;
            if(BOARD[row][i]==0){
                BOARD[row][i] = -1;
                nowAdd.add(new int[]{row,i});
            }
        }
    }

    //왼쪽으로 쭉
    void left(ArrayList<int[]> nowAdd, int row, int col){
        for(int i = col;i>=0;i--){
            if(BOARD[row][i]==6) break;
            if(BOARD[row][i]==0){
                BOARD[row][i] = -1;
                nowAdd.add(new int[]{row,i});
            }
        }
    }

    //위로 쭉
    void up(ArrayList<int[]> nowAdd, int row, int col){
        for(int i = row;i>=0;i--){
            if(BOARD[i][col]==6) break;
            if(BOARD[i][col]==0){
                BOARD[i][col] = -1;
                nowAdd.add(new int[]{i,col});
            }
        }
    }

    //아래로 쭉
    void down(ArrayList<int[]> nowAdd, int row, int col){
        for(int i = row;i<BOARD.length;i++){
            if(BOARD[i][col]==6) break;
            if(BOARD[i][col]==0){
                BOARD[i][col] = -1;
                nowAdd.add(new int[]{i,col});
            }
        }
    }
}


