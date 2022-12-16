package org.example.date20221204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon24497 {

    static ArrayList<ArrayList<Integer>> ROAD;
    static boolean[] check;
    static int N, M;
    static int[] answer;
    static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());       //정점의 수
        M = Integer.parseInt(st.nextToken());       //간선의 수
        int R = Integer.parseInt(st.nextToken());       //시작 정점

        ROAD = new ArrayList<>();
        answer = new int[N+1];
        for(int i=0;i<=N;i++){
            ROAD.add(new ArrayList<Integer>());
        }
        check = new boolean[N+1];

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            ROAD.get(l).add(r);
            ROAD.get(r).add(l);
        }

        for(int i=0;i<ROAD.size();i++){
            Collections.sort(ROAD.get(i),Collections.reverseOrder());
        }


        dfs(0,R);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<answer.length;i++){
            sb.append(answer[i] + "\n");
        }


        System.out.println(sb.toString());


    }

    public static void dfs(int prev, int next){

        if(check[next]) return;
        check[next] = true;
        answer[next] = count++;

        ArrayList<Integer> now = ROAD.get(next);
        for(int num:now){
            if(!check[num]){
                dfs(next,num);
            }
        }

    }
}
