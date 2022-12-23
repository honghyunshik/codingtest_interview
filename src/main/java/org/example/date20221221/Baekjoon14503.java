package org.example.date20221221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon14503 {

    static int N,M;
    static int[][] ROBOT;
    static boolean[][] VISITED;
    static int[][] D = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());       //로봇 청소기가 있는 칸의 x좌표
        int y = Integer.parseInt(st.nextToken());       //로봇 청소기가 있는 칸의 y좌표
        int d = Integer.parseInt(st.nextToken());       //로봇 청소기가 바라보는 방향

        ROBOT = new int[N][M];
        VISITED = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                ROBOT[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(cleaning(x,y,d));

    }

    public static int cleaning(int startL, int startR, int d){


        class Pointer{
            int l,r;
            Pointer(int l, int r){
                this.l = l;
                this.r = r;
            }
        }
        VISITED[startL][startR] = true;
        Stack<Pointer> stack = new Stack<>();
        stack.add(new Pointer(startL,startR));
        int count = 1;
        while(!stack.isEmpty()){
            Pointer curr = stack.pop();
            boolean isClean = false;

            //1단계 -> 왼쪽 방향에 청소 할 곳이 있다면 그 방향으로 회전한 다음 한 칸 전진하고 1부터 진행한다.
            //2단계 -> 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
            for(int i=0;i<4;i++){
                if(d==0) d = 3;
                else d--;
                int nextL = curr.l + D[d][0];
                int nextR = curr.r + D[d][1];
                if(nextL<0||nextL>N-1||nextR<0||nextR>M-1) continue;
                if(VISITED[nextL][nextR]) continue;
                if(ROBOT[nextL][nextR]==1) continue;
                VISITED[nextL][nextR] = true;
                stack.add(new Pointer(nextL, nextR));
                isClean = true;
                count++;
                break;
            }
            //사방이 벽이어서 청소를 못했을 경우
            if(!isClean){
                int nextL = curr.l - D[d][0];
                int nextR = curr.r - D[d][1];
                if(ROBOT[nextL][nextR]==1) return count;
                stack.add(new Pointer(nextL, nextR));
            }

        }
        return count;
    }


}
