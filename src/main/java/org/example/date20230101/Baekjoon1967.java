package org.example.date20230101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node_1967{
    int end, dis;
    Node_1967(int end, int dis){
        this.end = end;
        this.dis = dis;
    }
}
public class Baekjoon1967 {

    static ArrayList<ArrayList<Node_1967>> list;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node_1967(end,dis));
            list.get(end).add(new Node_1967(start,dis));
        }
        visited = new boolean[n+1];

        dfs(1,0);
        visited = new boolean[n+1];
        dfs(idx,0);
        System.out.println(max);


    }

    public static void dfs(int startNum,int sum){

        if(visited[startNum]) return;
        visited[startNum] = true;
        if(max<sum){
            idx = startNum;
            max = sum;
        }
        for(int i=0;i<list.get(startNum).size();i++){

            int child = list.get(startNum).get(i).end;
            int dis = list.get(startNum).get(i).dis;
            dfs(child,sum+dis);
        }


    }
}
