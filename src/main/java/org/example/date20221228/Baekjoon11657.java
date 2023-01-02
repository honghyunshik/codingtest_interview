package org.example.date20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1{
    int start, end, cost;
    Node_1(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
public class Baekjoon11657 {

    static ArrayList<Node_1> list;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node_1(start,end,cost));
        }

        StringBuilder sb = new StringBuilder();
        long[] arr = belman_ford(1);
        if(arr[0]==-1) sb.append(-1);
        else{
            for(int i=2;i<arr.length;i++){
                if(arr[i]==Long.MAX_VALUE) sb.append(-1 + "\n");
                else sb.append(arr[i] + "\n");
            }
        }
        System.out.println(sb.toString());

    }

    public static long[] belman_ford(int start){



        long[] distance = new long[N+1];
        long INF = Long.MAX_VALUE;
        Arrays.fill(distance,INF);
        distance[start] = 0;

        for(int i=0;i<N;i++){

            for(Node_1 node:list){

                if(distance[node.start]==Long.MAX_VALUE) continue;
                if(distance[node.end]>distance[node.start]+node.cost){
                    distance[node.end] = distance[node.start] + node.cost;
                    if(i==N-1){
                        distance[0] = -1;
                        return distance;
                    }
                }

            }
        }



        return distance;


    }
}
