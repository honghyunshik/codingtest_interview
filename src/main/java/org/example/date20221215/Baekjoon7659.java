package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7659{

    static int N,M,H;
    static int[][][] TOMATO;
    static boolean[][][] VISITED;
    static Pointer3[] START;
    static int[][] D = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        TOMATO = new int[H][M][N];
        VISITED = new boolean[H][M][N];
        START = new Pointer3[N*M*H];
        int count = 0;
        for(int k=0;k<H;k++){
            for(int i=0;i<M;i++){
                String[] input = br.readLine().split(" ");
                int[] temp = new int[input.length];
                for(int j=0;j<input.length;j++){
                    temp[j] = Integer.parseInt(input[j]);
                    if(temp[j]==1) START[count++] = new Pointer3(i,j,k,0);
                }
                TOMATO[k][i] = temp;
            }
        }

/*

        for(Pointer3 p:START){
            if(p!=null)
            System.out.println(11);
        }

*/


        System.out.println(bfs());



    }

    public static int bfs(){

        Queue<Pointer3> queue = new LinkedList<>();
        for(Pointer3 p:START){
            if(p==null) break;
            queue.add(p);
            VISITED[p.h][p.l][p.r]= true;
        }




        int answer = 0;
        while(!queue.isEmpty()){

            Pointer3 curr= queue.remove();
            for(int i=0;i<6;i++){
                int nextL = curr.l + D[i][0];
                int nextR = curr.r + D[i][1];
                int nextH = curr.h + D[i][2];
                if(nextL<0||nextL>M-1||nextR<0||nextR>N-1||nextH<0||nextH>H-1) continue;
                if(VISITED[nextH][nextL][nextR]) continue;
                if(TOMATO[nextH][nextL][nextR]==-1) continue;
                VISITED[nextH][nextL][nextR] = true;
                TOMATO[nextH][nextL][nextR] = 1;
                queue.add(new Pointer3(nextL, nextR, nextH,curr.dis+1));

            }

            answer = curr.dis;
        }

        for(int k=0;k<H;k++){
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(TOMATO[k][i][j]==0) return -1;
                }
            }
        }


        //queue.add(new Pointer())



        return answer;
    }
}

class Pointer3{
    int l, r,h,dis;
    Pointer3(int l, int r, int h, int dis){
        this.l = l;
        this.r = r;
        this.h = h;
        this.dis = dis;
    }
}


