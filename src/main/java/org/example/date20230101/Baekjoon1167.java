package org.example.date20230101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Node_1167{
    int end, dis;
    Node_1167(int end, int dis){
        this.end = end;
        this.dis = dis;
    }
}

public class Baekjoon1167 {

    static ArrayList<ArrayList<Node_1167>> list;
    static int V;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<V+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = 0;
            int dis = 0;
            while(true){
                end = Integer.parseInt(st.nextToken());
                if(end==-1) break;
                dis = Integer.parseInt(st.nextToken());
                list.get(start).add(new Node_1167(end,dis));
                list.get(end).add(new Node_1167(start,dis));
            }

        }

        int left = dfs(1);
        dfs(left);
        System.out.println(answer);


    }

    public static int dfs(int startNum){

        Stack<Node_1167> stack = new Stack<>();
        stack.add(new Node_1167(startNum,0));
        boolean[] visited = new boolean[V+1];
        int Max = Integer.MIN_VALUE;

        while(!stack.isEmpty()){
            Node_1167 curr = stack.pop();
            if(visited[curr.end]) continue;
            visited[curr.end] = true;
            if(Max<curr.dis){
                Max = curr.dis;
                startNum = curr.end;
                answer = Max;
            }
            for(int i=0;i<list.get(curr.end).size();i++){
                stack.add(new Node_1167(list.get(curr.end).get(i).end,curr.dis+list.get(curr.end).get(i).dis));
            }
        }
        return startNum;
    }
}
