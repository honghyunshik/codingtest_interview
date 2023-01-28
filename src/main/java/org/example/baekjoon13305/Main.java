package org.example.baekjoon13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] road_len = new int[n-1];
        int[] road_cost = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n-1;i++){
            road_len[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            road_cost[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        long min = Long.MAX_VALUE;
        for(int i=0;i<road_len.length;i++){
            if(min>road_cost[i]){
                min = road_cost[i];
            }
            ans += min*road_len[i];
        }

        System.out.println(ans);
    }

}
