package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baekjoon13460 {

    static int N,M;
    static String[][] BOARD;
    static int[][] D = {{0,1},{1,0},{-1,0},{0,-1}};
    static boolean[][] VISITED_RED;
    static boolean[][] VISITED_BLUE;
    static boolean redIn, blueIn;
    static ArrayList<int[]> VISITED;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        BOARD = new String[N][M];
        VISITED = new ArrayList<>();
        int startBlueL = 0, startBlueR = 0, startRedL = 0, startRedR = 0 , targetL = 0, targetR = 0;
        for(int i=0;i<N;i++){
            String[] input= br.readLine().split("");
            for(int j=0;j<M;j++){
                BOARD[i][j] = input[j];
                if(BOARD[i][j].equals("B")){
                    startBlueL = i;
                    startBlueR = j;
                    BOARD[startBlueL][startBlueR] = ".";
                }else if(BOARD[i][j].equals("R")){
                    startRedL = i;
                    startRedR = j;
                    BOARD[startRedL][startRedR] = ".";
                }else if(BOARD[i][j].equals("O")){
                    targetL = i;
                    targetR = j;
                    BOARD[targetL][targetR] = ".";
                }
            }
        }
        int answer = bfs(startBlueL,startBlueR,startRedL,startRedR,targetL,targetR);
        if(answer>10) System.out.println(-1);
        else System.out.println(answer);

    }

    public static int bfs(int startBlueL, int startBlueR, int startRedL, int startRedR, int targetL, int targetR){

        class Pointer{
            int redL,redR,blueL, blueR, dis;
            Pointer(int redL, int redR, int blueL, int blueR, int dis){
                this.redL = redL;
                this.redR = redR;
                this.blueL = blueL;
                this.blueR = blueR;
                this.dis = dis;
            }
        }

        Queue<Pointer> queue= new LinkedList<>();
        queue.add(new Pointer(startRedL, startRedR, startBlueL, startBlueR, 1));
        VISITED.add(new int[]{startRedL,startRedR,startBlueL,startBlueR});
        while(!queue.isEmpty()){

            Pointer curr = queue.poll();
            for(int i=0;i<4;i++){
                int plusL = D[i][0];
                int plusR = D[i][1];
                int nextRedL = curr.redL;
                int nextRedR = curr.redR;
                int nextBlueL = curr.blueL;
                int nextBlueR = curr.blueR;
                blueIn = false;
                redIn = false;
                if(plusL==1){
                    if(nextRedL>nextBlueL){
                        nextRedL = getNextRedL(plusL, nextRedL, nextRedR, nextBlueL, nextBlueR, targetL, targetR);
                        nextBlueL = getNextBlueL(plusL,nextRedL, nextRedR, nextBlueL, nextBlueR, targetL, targetR);
                    }else{
                        nextBlueL = getNextBlueL(plusL,nextRedL, nextRedR, nextBlueL, nextBlueR, targetL, targetR);
                        nextRedL = getNextRedL(plusL, nextRedL, nextRedR,nextBlueL, nextBlueR, targetL, targetR);
                    }
                }else if(plusL==-1){
                    if(nextRedL<nextBlueL){
                        nextRedL = getNextRedL(plusL, nextRedL, nextRedR,nextBlueL, nextBlueR, targetL, targetR);
                        nextBlueL = getNextBlueL(plusL,nextRedL, nextRedR, nextBlueL, nextBlueR, targetL, targetR);
                    }else{
                        nextBlueL = getNextBlueL(plusL,nextRedL, nextRedR, nextBlueL, nextBlueR, targetL, targetR);
                        nextRedL = getNextRedL(plusL, nextRedL, nextRedR,nextBlueL, nextBlueR, targetL, targetR);
                    }
                }
                if(plusR==1){
                    if(nextRedR>nextBlueR){
                        nextRedR = getNextRedR(plusR, nextRedL, nextRedR, nextBlueL, nextBlueR,targetL, targetR);
                        nextBlueR = getNextBlueR(plusR,nextRedL, nextRedR, nextBlueL, nextBlueR, targetL, targetR);
                    }else{
                        nextBlueR = getNextBlueR(plusR, nextRedL, nextRedR,nextBlueL, nextBlueR, targetL, targetR);
                        nextRedR = getNextRedR(plusR, nextRedL, nextRedR,nextBlueL, nextBlueR, targetL, targetR);
                    }
                }else if(plusR==-1){
                    if(nextRedR<nextBlueR){
                        nextRedR = getNextRedR(plusR, nextRedL, nextRedR, nextBlueL, nextBlueR,targetL, targetR);
                        nextBlueR = getNextBlueR(plusR,nextRedL, nextRedR, nextBlueL, nextBlueR, targetL, targetR);
                    }else{
                        nextBlueR = getNextBlueR(plusR,nextRedL, nextRedR, nextBlueL, nextBlueR, targetL, targetR);
                        nextRedR = getNextRedR(plusR, nextRedL, nextRedR,nextBlueL, nextBlueR, targetL, targetR);
                    }
                }


                if(blueIn) continue;
                if(redIn) {
                    return curr.dis;
                }

                boolean isVisited = false;
                for(int[] arr:VISITED){
                    if(arr[0]==nextRedL&&arr[1]==nextRedR&&arr[2]==nextBlueL&&arr[3]==nextBlueR){
                        isVisited = true;
                    }
                }
                if(isVisited) continue;
                VISITED.add(new int[]{nextRedL,nextRedR,nextBlueL,nextBlueR});
                queue.add(new Pointer(nextRedL,nextRedR,nextBlueL,nextBlueR,curr.dis+1));
            }
        }

        return -1;

    }

    public static int getNextRedL(int plusL, int nextRedL, int nextRedR, int nextBlueL, int nextBlueR, int targetL, int targetR){

        while(plusL!=0){
            if(BOARD[nextRedL+plusL][nextRedR].equals("#")) break;
            else if(nextRedL+plusL==targetL&&nextRedR==targetR) redIn = true;
            else if(nextRedL+plusL==nextBlueL&&nextRedR==nextBlueR) break;
            nextRedL += plusL;
        }
        return nextRedL;
    }

    public static int getNextRedR(int plusR, int nextRedL, int nextRedR, int nextBlueL, int nextBlueR, int targetL, int targetR){
        while(plusR!=0){
            if(BOARD[nextRedL][nextRedR+plusR].equals("#")) break;
            else if(nextRedL==targetL&&nextRedR+plusR==targetR) redIn = true;
            else if(nextRedL==nextBlueL&&nextRedR+plusR==nextBlueR) break;
            nextRedR += plusR;
        }
        return nextRedR;
    }

    public static int getNextBlueL(int plusL, int nextRedL, int nextRedR, int nextBlueL, int nextBlueR, int targetL, int targetR){
        while(plusL!=0){
            if(BOARD[nextBlueL+plusL][nextBlueR].equals("#")) break;
            else if(nextBlueL+plusL==targetL&&nextBlueR==targetR) blueIn = true;
            else if(nextRedL==nextBlueL+plusL&&nextRedR==nextBlueR) break;
            nextBlueL += plusL;
        }
        return nextBlueL;
    }

    public static int getNextBlueR(int plusR,int nextRedL, int nextRedR, int nextBlueL, int nextBlueR, int targetL, int targetR){
        while(plusR!=0){
            if(BOARD[nextBlueL][nextBlueR+plusR].equals("#")) break;
            else if(nextBlueL==targetL&&nextBlueR+plusR==targetR) blueIn = true;
            else if(nextRedL==nextBlueL&&nextRedR==nextBlueR+plusR) break;
            nextBlueR += plusR;
        }
        return nextBlueR;
    }



}
