package org.example.date20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.IntFunction;



public class Baekjoon1753 {

    static int[] Distance;
    static ArrayList<ArrayList<Node>> list;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());       //정점의 개수
        int e = Integer.parseInt(st.nextToken());       //간선의 개수
        int k = Integer.parseInt(br.readLine());        //시작 정점의 번호
        int INF = 99999999;
        Distance = new int[V+1];
        for(int i=0;i<V+1;i++) {
            Distance[i] = INF;
        }

        list = new ArrayList<>();
        for(int i=0;i<=V;i++){
            list.add(new ArrayList<Node>());
        }



        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine(), " ");
            list.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        dijkstra(k,V);
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<Distance.length;i++){
            if(Distance[i]==INF) sb.append("INF\n");
            else sb.append(Distance[i] + "\n");
        }
        System.out.println(sb.toString());
    }

    public static void dijkstra(int node,int V){


        boolean[] visited = new boolean[V+1];

        Distance[node] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new Node(node,0));

        int next = 0, dis = 0;
        while(!pq.isEmpty()){
            int now = pq.poll().end;
            if(visited[now]) continue;
            visited[now] = true;
            for(int i=0;i<list.get(now).size();i++){
                next = list.get(now).get(i).end;
                dis = list.get(now).get(i).dis;
                if(Distance[next]>Distance[now]+dis){
                    Distance[next] = Distance[now] + dis;
                    pq.add(new Node(next,Distance[next]));
                }
            }


            }
        }

    }

