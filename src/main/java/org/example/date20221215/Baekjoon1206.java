package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1206 {

    static int[][] D = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[] VISITED_dfs, VISITED_bfs;

    static ArrayList<ArrayList<Integer>> list;
    static StringBuilder STRING_dfs, STRING_bfs;
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        VISITED_bfs = new boolean[N+1];
        VISITED_dfs = new boolean[N+1];


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.get(l).add(r);
            list.get(r).add(l);
        }

        for(int i=0;i<list.size();i++){
            Collections.sort(list.get(i));
        }

        STRING_dfs = new StringBuilder();
        STRING_bfs = new StringBuilder();

        dfs(0,V);
        bfs(0,V);
        System.out.println(STRING_dfs);
        System.out.println(STRING_bfs);
    }

    public static void dfs(int prev, int next){

        VISITED_dfs[next] = true;
        STRING_dfs.append(next + " ");
        for(int num:list.get(next)){
            if(VISITED_dfs[num]) continue;
            dfs(next,num);
        }

    }

    public static void bfs(int prev, int next){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(next);
        VISITED_bfs[next] = true;
        while(!queue.isEmpty()){
            int curr = queue.remove();
            STRING_bfs.append(curr + " ");
            for(int num:list.get(curr)){
                if(VISITED_bfs[num]) continue;
                VISITED_bfs[num] = true;
                queue.add(num);
            }
        }
    }
}
