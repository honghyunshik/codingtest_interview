package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon21611 {

    static int N;
    static int M;
    static int[][] MARBLE;
    static int direction, distance;
    static int[][] D = {{-1,0},{1,0},{0,1},{0,-1}};
    static int state;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MARBLE = new int[N][N];

        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            int[] temp = new int[input.length];
            for(int j=0;j<input.length;j++){
                temp[j] = Integer.parseInt(input[j]);
            }
            MARBLE[i] = temp;
        }
        st = new StringTokenizer(br.readLine()," ");
        direction = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        magic();


    }

    static void magic(){

        int centerL = N/2;
        int centerR = N/2;
        //마법이 발동한 후 구슬이 사라진다
        for(int i=0;i<distance;i++){
            centerL += D[direction-1][0];
            centerR += D[direction-1][1];
            MARBLE[centerL][centerR] = 0;
        }

        for(int k=1;k<=distance;k++){
            int startL = N/2 + D[direction-1][0]*k;
            int startR = N/2 + D[direction-1][1]*k;

            if(direction==1){
                startR--;
            }else if(direction==2){
                startR++;
            }else if(direction==3){
                startL++;
            }else if(direction==4){
                startL--;
            }



            //구슬이 사라진 후 구슬이 이동한다
            dfs(startL,startR);
            System.out.println("--------------------------------------------------");
            System.out.println();



        }





    }

    static void dfs(int startL, int startR){

        class Pointer{
            int l, r;
            Pointer(int l, int r){
                this.l = l;
                this.r = r;
            }
        }
        if(direction==1){
            state = 3;
        }else if(direction==2){
            state = 4;
        }else if(direction==3){
            state = 2;
        }else if(direction==4){
            state = 1;
        }
        boolean[][] VISITED = new boolean[N][N];
        VISITED[startL][startR] = true;
        Stack<Pointer> stack = new Stack<>();
        stack.add(new Pointer(startL,startR));
        while(!stack.isEmpty()){

            Pointer curr = stack.pop();
            int nextL = curr.l;
            int nextR = curr.r;
            //오른쪽 대각선 아래
            if(curr.l==curr.r&&curr.l>N/2){
                nextL--;
                state = 1;
            }
            //왼쪽 대각선 위
            else if(curr.l==curr.r+1&&curr.l<=N/2){
                nextL++;
                state = 2;
            }
            //오른쪽 대각선 위
            else if(curr.l-N/2==N/2-curr.r&&curr.r>N/2){
                nextR--;
                state = 3;
            }
            //왼쪽 대각선 아래
            else if(curr.l-N/2==N/2-curr.r&&curr.r<N/2){
                nextR++;
                state = 4;
            }
            //그냥 오른쪽
            else if(state==1){
                nextL--;
                state = 5;
            }
            //그냥 왼쪽
            else if(state==2){
                nextL++;
                state = 6;
            }
            //그냥 위
            else if(state==3){
                nextR--;
                state = 7;
            }
            //그냥 아래
            else if(state==4){
                nextR++;
                state = 8;
            }


            for(int i=0;i<4;i++){


                //상하좌우에서 0을 찾아서 swap
                int zeroL = curr.l + D[i][0];
                int zeroR = curr.r + D[i][1];


                if(zeroL<0||zeroL>N-1||zeroR<0||zeroR>N-1) continue;
                //if(VISITED[zeroL][zeroR]) continue;
                if(MARBLE[zeroL][zeroR]!=0) continue;
                if(zeroL==N/2&&zeroR==N/2) continue;
                //VISITED[zeroL][zeroR] = true;
                int temp = MARBLE[curr.l][curr.r];

                if(state==5&&(i==0||i==2)) continue;
                if(state==6&&(i==1||i==3)) continue;
                if(state==7&&(i==0||i==3)) continue;
                if(state==8&&(i==1||i==2)) continue;
                if(state==1&&i!=0) continue;
                if(state==2&&i!=1) continue;
                if(state==3&&i!=3) continue;
                if(state==4&&i!=2) continue;
                //System.out.println(curr.l + " , " + curr.r + " " + zeroL + " , " + zeroR);
                MARBLE[curr.l][curr.r] = MARBLE[zeroL][zeroR];
                MARBLE[zeroL][zeroR] = temp;
                if(MARBLE[nextL][nextR]==0) return;
                stack.push(new Pointer(nextL,nextR));


            }
            for(int[] arr:MARBLE){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();



        }


    }

}
