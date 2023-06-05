package org.example.baekjoon12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n,k));

    }

    private static String bfs(int n, int k){

        if(n>=k) return (n-k) + "\n1";
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n,0));
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        int[] dp = new int[k*2+1];
        Arrays.fill(dp,999999);
        while(!queue.isEmpty()){

            Node node = queue.poll();
            int now = node.num;
            int dis = node.dis;


        }


        return min+"\n"+cnt;
    }
}

class Node{
    int num, dis;
    Node(int num, int dis){
        this.num = num;
        this.dis = dis;
    }
}