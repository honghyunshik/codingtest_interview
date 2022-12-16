package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 {

    static int N,M;
    static int[][] MIRO;
    static boolean[][] VISITED;
    static int[][] D = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MIRO = new int[N][M];
        VISITED = new boolean[N][M];

        for(int i=0;i<N;i++){
            String[] input = br.readLine().split("");
            int[] temp = new int[input.length];
            for(int j=0;j<input.length;j++){
                temp[j] = Integer.parseInt(input[j]);
            }
            MIRO[i] = temp;
        }

        System.out.println(bfs(0,0));





    }

    public static int bfs(int l, int r){

        class Pointer{
            int l,r,dis;
            Pointer(int l,int r,int dis){
                this.l = l;
                this.r = r;
                this.dis = dis;
            }
        }
        Queue<Pointer> queue= new LinkedList<>();
        queue.add(new Pointer(l,r,1));
        VISITED[l][r] = true;
        int answer = 0;
        while(!queue.isEmpty()){

            Pointer curr = queue.remove();
            if(curr.l==N-1&&curr.r==M-1){

                answer = curr.dis;
                return answer;
            }
            for(int i=0;i<4;i++){
                int nextL = curr.l + D[i][0];
                int nextR = curr.r + D[i][1];
                if(nextL<0||nextL>N-1||nextR<0||nextR>M-1) continue;
                if(VISITED[nextL][nextR]) continue;
                if(MIRO[nextL][nextR]==0) continue;
                VISITED[nextL][nextR] = true;
                queue.add(new Pointer(nextL,nextR,curr.dis+1));
            }
        }

        return answer;
    }
}
