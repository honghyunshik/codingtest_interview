package org.example.date20230101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11725 {

    static ArrayList<ArrayList<Integer>> nodeList;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodeList = new ArrayList<>();
        parent = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<N+1;i++){
            nodeList.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            nodeList.get(l).add(r);
            nodeList.get(r).add(l);
        }
        getParent(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<parent.length;i++){
            sb.append(parent[i] + "\n");
        }
        System.out.println(sb.toString());
    }


    public static void getParent(int num){

        for(int i=0;i<nodeList.get(num).size();i++){
            int child = nodeList.get(num).get(i);
            if(visited[child]) continue;
            visited[child] = true;
            parent[child] = num;
            getParent(child);
        }


    }
}
