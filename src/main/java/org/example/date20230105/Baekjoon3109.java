package org.example.date20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3109 {

    static String[][] bread;
    static boolean[][] visited;
    static int[][] D = {{-1,1},{0,1},{1,1}};
    static int R,C;
    static int pipe = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        bread = new String[R][C];
        visited = new boolean[R][C];
        for(int i=0;i<R;i++){
            String[] input = br.readLine().split("");
            for(int j=0;j<C;j++){
                bread[i][j] = input[j];
            }
        }
        for(int i=0;i<R;i++){
            if(!visited[i][0]){
                getPipe(i,0);
            }
        }

        System.out.println(pipe);


    }

    public static boolean getPipe(int startL, int startR){


        if(startR==C-1){
            pipe++;
            return true;
        }

        for(int i=0;i<D.length;i++){
            int nextL = startL + D[i][0];
            int nextR = startR + D[i][1];
            if(nextL<0||nextL>R-1||nextR<0||nextR>C-1) continue;
            if(bread[nextL][nextR].equals("x")) continue;
            if(visited[nextL][nextR]) continue;
            visited[startL][startR] = true;
            if(getPipe(nextL,nextR)) return true;
        }


        return false;
    }

}
