package org.example.date20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Interview40 {

    static boolean[] Visited;
    static int[][] Distance;
    static ArrayList<ArrayList<Integer>> Graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        //노드의 개수
        int K = Integer.parseInt(br.readLine());        //시작 노드
        Graph = new ArrayList<>();
        Visited = new boolean[N+1];
        Distance = new int[N+1][N+1];

        for(int i=0;i<N+1;i++){
            Graph.add(new ArrayList<>());
        }

        for(int i=1;i<Distance.length;i++){
            for(int j=1;j<Distance.length;j++){
                if(i==j) continue;
                Distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Distance[K][K] = 0;
        Distance[2][1] = 1;
        Distance[2][3] = 1;
        Distance[3][4] = 1;

        Graph.get(2).add(1);
        Graph.get(2).add(3);
        Graph.get(3).add(4);

        dijkstra(K);
        System.out.println(Arrays.toString(Distance));


    }

    public static void dijkstra(int node){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);        //index 0끼리 비교 후 작은 값부터 반환
        Visited[node] = true;
        pq.add(new int[]{0,node});
        while(!pq.isEmpty()){
            int now = pq.poll()[1];
            for(int next : Graph.get(now)){
            }
        }

    }


}
