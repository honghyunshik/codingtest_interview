package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {

    static int N;
    static boolean VISITED[][];
    static int[][] D = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            VISITED = new boolean[N][N];
            int prevL = Integer.parseInt(st.nextToken());
            int prevR = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            int targetL = Integer.parseInt(st.nextToken());
            int targetR = Integer.parseInt(st.nextToken());
            System.out.println(bfs(prevL, prevR, targetL, targetR));
        }
    }

    public static int bfs(int prevL, int prevR, int targetL, int targetR){

        class Pointer{
            int l,r,dis;
            Pointer(int l, int r, int dis){
                this.l = l;
                this.r = r;
                this.dis = dis;

            }
        }

        Queue<Pointer> queue = new LinkedList<>();
        VISITED[prevL][prevR] = true;
        queue.add(new Pointer(prevL,prevR,0));

        while(!queue.isEmpty()){

            Pointer curr = queue.remove();
            if(curr.l==targetL&&curr.r==targetR){
                return curr.dis;
            }

            for(int i=0;i<8;i++){

                int nextL = D[i][0] + curr.l;
                int nextR = D[i][1] + curr.r;

                if(nextL<0||nextL>N-1||nextR<0||nextR>N-1) continue;
                if(VISITED[nextL][nextR]) continue;
                VISITED[nextL][nextR] = true;
                queue.add(new Pointer(nextL,nextR,curr.dis+1));

            }

        }


        return -1;
    }
}
