package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon21611 {

    static int N;
    static int M;
    static int[][] MARBLE;
    static int direction, distance;
    static int[][] D = {{-1,0},{1,0},{0,1},{0,-1}};

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

        int startL = N/2 + D[direction-1][0];
        int startR = N/2 + D[direction-1][1];

        if(direction==1){
            startR--;
        }else if(direction==2){
            startR++;
        }else if(direction==3){
            startL++;
        }else if(direction==4){
            startL--;
        }
        System.out.println("startL : " + startL + " startR : " + startR);

        int centerL = N/2;
        int centerR = N/2;
        //마법이 발동한 후 구슬이 사라진다
        for(int i=0;i<distance;i++){
            centerL += D[direction-1][0];
            centerR += D[direction-1][1];
            MARBLE[centerL][centerR] = 0;
        }

        /*for(int[] arr:MARBLE){
            System.out.println(Arrays.toString(arr));
        }*/

        //구슬이 사라진 후 구슬이 이동한다
        dfs(startL,startR);



    }

    static void dfs(int startL, int startR){

        class Pointer{
            int l, r;
            Pointer(int l, int r){
                this.l = l;
                this.r = r;
            }
        }
        boolean[][] VISITED = new boolean[N][N];
        VISITED[startL][startR] = true;
        Queue<Pointer> queue = new LinkedList<>();
        queue.add(new Pointer(startL,startR));
        while(!queue.isEmpty()){
            Pointer curr = queue.remove();
            for(int i=0;i<4;i++){

                if(direction==1){
                    if(curr.l==startL&&curr.r==startR+1&&i==direction-1) continue;
                }else if(direction==2){
                    if(curr.l==startL&&curr.r==startR-1&&i==direction-1) continue;
                }else if(direction==3){
                    if(curr.l==startL-1&&curr.r==startR&&i==direction-1) continue;
                }else if(direction==4){
                    if(curr.l==startL+1&&curr.r==startR&&i==direction-1) continue;
                }

                int nextL = curr.l + D[i][0];
                int nextR = curr.l + D[i][1];
                if(nextL<0||nextL>N-1||nextR<0||nextR>N-1) continue;
                if(VISITED[nextL][nextR]) continue;
                if(MARBLE[nextL][nextR]!=0) continue;
                VISITED[nextL][nextR] = true;
                int temp = MARBLE[curr.l][curr.r];
                MARBLE[curr.l][curr.r] = MARBLE[nextL][nextR];
                MARBLE[nextL][nextR] = temp;



                queue.add(new Pointer(nextL,nextR));

            }
        }


    }

}
