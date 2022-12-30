package org.example.date20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Baekjoon1504 {

    static ArrayList<ArrayList<Node>> list;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());       //정점의 개수
        int E = Integer.parseInt(st.nextToken());       //간선의 개수
        list = new ArrayList<>();


        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<Node>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end,dis));
            list.get(end).add(new Node(start,dis));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());


        int first_1 = dijkstra(1,v1);
        int first_2 = dijkstra(v1, v2);
        int first_3 = dijkstra(v2,N);
        int first = Integer.MAX_VALUE;

        if(first_1!=-1&&first_2!=-1&&first_3!=-1){
            first = Math.min(first,first_1+first_2+first_3);
        }

        int second_1 = dijkstra(1,v2);
        int second_2 = dijkstra(v2,v1);
        int second_3 = dijkstra(v1,N);
        int second = Integer.MAX_VALUE;
        if(second_1!=-1&&second_2!=-1&&second_3!=-1){
            second = Math.min(second, second_1+second_2+second_3);
        }
        int answer = Math.min(first,second);
        if(answer!=Integer.MAX_VALUE) System.out.println(answer);
        else System.out.println(-1);

    }

    public static int dijkstra(int start, int target){

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new Node(start,0));
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];
        int INF = 2000000000;
        for(int i=0;i<distance.length;i++){
            distance[i] = INF;
        }

        distance[start] = 0;

        while(!pq.isEmpty())
        {
            int now = pq.poll().end;
            if(visited[now]) continue;
            visited[now] = true;
            for(int i=0;i<list.get(now).size();i++){
                int next = list.get(now).get(i).end;
                int dis = list.get(now).get(i).dis;
                if(distance[next]>distance[now]+dis){
                    distance[next] = distance[now] + dis;
                    pq.add(new Node(next,distance[next]));
                }
            }
        }
        if(distance[target]==INF) return -1;
        return distance[target];
    }

}
class Node{
    int end, dis;
    Node(int end, int dis){
        this. end = end;
        this.dis = dis;
    }
}



