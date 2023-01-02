package org.example.date20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon9370 {

    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());       //교차로 개수
            int m = Integer.parseInt(st.nextToken());       //도로의 개수
            int t = Integer.parseInt(st.nextToken());       //목적지 개수

            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());       //예술가들 출발지
            int g = Integer.parseInt(st.nextToken());       //지나간 교차로 점
            int h = Integer.parseInt(st.nextToken());       //지나간 교차로 점

            list = new ArrayList<>();
            for(int j=0;j<n+1;j++){
                list.add(new ArrayList<Node>());
            }
            for(int j=0;j<m;j++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                list.get(a).add(new Node(b,d));
                list.get(b).add(new Node(a,d));
            }
            int[] hubo = new int[t];
            for(int j=0;j<t;j++){
                hubo[j] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(hubo);

            for(int num:hubo){
                int firstRoad = dijkstra(s,g) + dijkstra(g,h) + dijkstra(h,num);
                int secondRoad = dijkstra(s,num);
                if(firstRoad==secondRoad) sb.append(num + " ");
                else{
                    firstRoad = dijkstra(s,h) + dijkstra(h,g) + dijkstra(g,num);
                    secondRoad = dijkstra(s,num);
                    if(firstRoad==secondRoad) sb.append(num + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int dijkstra(int start, int end){

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[list.size()];
        int[] distance = new int[list.size()];
        int INF = 99999999;
        for(int i=0;i<distance.length;i++){
            distance[i] = INF;
        }
        distance[start] = 0;
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
            for(int i=0;i<list.get(now).size();i++){
                int next = list.get(now).get(i).end;
                int dis = list.get(now).get(i).dis;
                if(distance[next]>distance[now] + dis){
                    distance[next] = distance[now] + dis;
                    pq.add(new Node(next, distance[next]));
                }
            }

        }

        return -1;
    }
}

