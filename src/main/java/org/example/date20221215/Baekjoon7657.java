package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7657{

    static int N,M;
    static int[][] TOMATO;
    static boolean[][] VISITED;
    static Pointer[] START;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        TOMATO = new int[M][N];
        VISITED = new boolean[M][N];
        START = new Pointer[N*M];
        int count = 0;
        for(int i=0;i<M;i++){
            String[] input = br.readLine().split(" ");
            int[] temp = new int[input.length];
            for(int j=0;j<input.length;j++){
                temp[j] = Integer.parseInt(input[j]);
                if(temp[j]==1) START[count++] = new Pointer(i,j,0);
            }

            TOMATO[i] = temp;
        }


        System.out.println(bfs());

        for(int[] arr:TOMATO){
            System.out.println(Arrays.toString(arr));
        }

    }

    public static int bfs(){

        Queue<Pointer> queue = new LinkedList<>();
        for(Pointer p:START){
            if(p==null) break;
            queue.add(p);
            VISITED[p.l][p.r] = true;
        }
        int answer = 0;
        while(!queue.isEmpty()){

            Pointer curr= queue.remove();
            for(int i=0;i<4;i++){
                int nextL = curr.l + D[i][0];
                int nextR = curr.r + D[i][1];
                if(nextL<0||nextL>M-1||nextR<0||nextR>N-1) continue;
                if(VISITED[nextL][nextR]) continue;
                if(TOMATO[nextL][nextR]==0) continue;
                VISITED[nextL][nextR] = true;
                TOMATO[nextL][nextR] = 1;
                queue.add(new Pointer(nextL, nextR, curr.dis+1));

            }
            answer = curr.dis;
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(TOMATO[i][j]==-1) return -1;
            }
        }

        //queue.add(new Pointer())



        return answer;
    }
}

class Pointer{
    int l,r, dis;
    Pointer(int l,int r, int dis){
        this.l = l;
        this.r = r;
        this.dis = dis;

    }
}
