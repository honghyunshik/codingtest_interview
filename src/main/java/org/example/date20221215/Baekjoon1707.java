package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1707 {

    static int V,E;
    static ArrayList<ArrayList<Integer>> GRAPH;
    static int[] COLOR;
    static String answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for(int k=0;k<K;k++){

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            GRAPH = new ArrayList<>();
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            COLOR = new int[V+1];
            answer = "YES";

            for(int i=0;i<=V;i++){
                GRAPH.add(new ArrayList<>());
            }

            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine()," ");
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                GRAPH.get(l).add(r);
                GRAPH.get(r).add(l);
            }
            for(int i=1;i<=V;i++){
                if(COLOR[i]==0) dfs(0,i,1);
            }

            System.out.println(answer);

        }

    }

    public static void dfs(int prev, int next,int color){

        COLOR[next] = color;

        for(int i:GRAPH.get(next)){
            if(COLOR[i]!=0) {
                if(COLOR[i]==color){
                    answer = "NO";
                    return;
                }
                continue;
            }
            if(color==1){
                dfs(next,i,-1);
            }else{
                dfs(next,i,1);
            }


        }



    }

}



