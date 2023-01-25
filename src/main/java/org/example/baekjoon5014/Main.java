package org.example.baekjoon5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int F = Integer.parseInt(st.nextToken());       //건물 높이
        int S = Integer.parseInt(st.nextToken());       //현재 높이
        int G = Integer.parseInt(st.nextToken());       //가려는 높이
        int U = Integer.parseInt(st.nextToken());       //위로 U만큼 올라감
        int D = Integer.parseInt(st.nextToken());       //아래로 D만큼 내려감
        Solution sol = new Solution();
        int ans = sol.getButtonNum(F,S,G,U,D);
        System.out.println(ans==-1?"use the stairs":ans);
    }
}

class Solution{

    int getButtonNum(int F, int S, int G, int U, int D){

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[F+1];
        queue.add(new Node(S,0));
        while(!queue.isEmpty()){

            Node now = queue.poll();
            int now_val = now.val;
            int now_count = now.count;
            if(now_val==G) return now.count;
            if(now_val>F) continue;
            if(now_val<1) continue;
            if(visited[now_val]) continue;
            visited[now_val] = true;
            queue.add(new Node(now_val+U,now_count+1));
            queue.add(new Node(now_val-D,now_count+1));

        }
        return -1;

    }

}

class Node{
    int val, count;
    Node(int val, int count){
        this.val = val;
        this.count = count;
    }
}
