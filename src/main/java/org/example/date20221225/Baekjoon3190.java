package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3190 {

    static int[][] BOARD;
    static int[][] D = {{0,1},{0,-1},{-1,0},{1,0}};
    static boolean stop = false;
    static int answer = 0;
    static int N;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        BOARD = new int[N][N];

        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            BOARD[l][r] = 1;
        }


        int L = Integer.parseInt(br.readLine());


        int[] minute = new int[L];
        String[] direct = new String[L];
        for(int i=0;i<L;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            minute[i] = Integer.parseInt(st.nextToken());
            direct[i] = st.nextToken();
        }
        Snake snake = snakeMoving(0,0,0,1,"R",1,0,minute[0]);
        for(int i=0;i<L-1;i++){
            if(stop) break;
            snake = snakeMoving(snake.headL, snake.headR,snake.tailL, snake.tailR, direct[i],snake.distance,minute[i],minute[i+1]);
        }
        if(!stop) snakeMoving(snake.headL, snake.headR,snake.tailL, snake.tailR, direct[L-1],snake.distance,0,Integer.MAX_VALUE);
        System.out.println(answer);


    }
    //오 왼 위 아래
    public static Snake snakeMoving(int startheadL, int startheadR, int startTailL, int startTailR, String direction, int distance, int prevNum, int nextNum){


        Queue<Snake> queue = new LinkedList<>();
        queue.add(new Snake(startheadL, startheadR, startTailL, startTailR,  direction, distance));
        for(int i=prevNum;i<nextNum;i++){

            answer ++;

            int plusL = 0, plusR = 0;
            if(direction.equals("R")){
                plusL += D[0][0];
                plusR += D[0][1];
            }else if(direction.equals("L")){
                plusL += D[1][0];
                plusR += D[1][1];
            }else if(direction.equals("U")){
                plusL += D[2][0];
                plusR += D[2][1];
            }else if(direction.equals("D")){
                plusL += D[3][0];
                plusR += D[3][1];
            }

            Snake curr = queue.poll();
            int nextL = curr.headL + plusL;
            int nextR = curr.headR + plusR;
            int tailL = curr.headL + plusL;
            int tailR = curr.headR + plusR;

            if(nextL<0||nextL>N-1||nextR<0||nextR>N-1){
                stop = true;
                return null;
            }
            //사과 만남
            if(BOARD[nextL][nextR]==1){
                BOARD[nextL][nextR] = 0;        //사과가 없어짐, 꼬리 그대로
                curr.distance++;
            }else{                              //사과 안먹음, 꼬리 줄어듬
                tailL -= plusL;
                tailR -= plusR;
            }


            queue.add(new Snake(nextL,nextR,tailL,tailR, curr.direction, curr.distance));

        }

        return queue.poll();

    }

}

class Snake{
    int headL, headR, tailL, tailR ,distance;
    String direction;
    Snake(int headL, int headR, int tailL, int tailR, String direction, int distance){

        this.headL = headL;
        this.headR = headR;
        this.tailL = tailL;
        this.tailR = tailR;
        this.direction = direction;
        this.distance = distance;
    }
}
