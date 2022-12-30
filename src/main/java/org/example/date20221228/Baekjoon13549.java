package org.example.date20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon13549 {

    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(N,K));

    }

    public static int dijkstra(int start, int end){

        if(start>=end) return start-end;

        class Node{
            int end, dis;
            Node(int end, int dis){
                this.end = end;
                this.dis = dis;
            }
        }
        int[] distance = new int[end*2];
        for(int i=0;i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        boolean[] visited = new boolean[end*2];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int now = curr.end;
            if(now==end){
                return curr.dis;
            }
            if(visited[now]) continue;
            visited[now] = true;
            if(now<end&&distance[now*2]>curr.dis){
                distance[now*2] = curr.dis;
                pq.add(new Node(now*2,curr.dis));
            }
            if(now+1<end*2&&distance[now+1]>curr.dis+1){
                distance[now+1] = curr.dis+1;
                pq.add(new Node(now+1,curr.dis+1));
            }
            if(now-1>0&&distance[now-1]>curr.dis+1){
                distance[now-1] = curr.dis+1;
                pq.add(new Node(now-1,curr.dis+1));
            }
        }

        return -1;
    }
}
