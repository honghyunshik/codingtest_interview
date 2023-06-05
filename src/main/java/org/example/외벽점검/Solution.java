package org.example.외벽점검;

import java.util.*;

class Solution {

    int[][] dis;
    boolean[] visited;
    int size;
    int answer = Integer.MAX_VALUE;
    int[] DIST;

    public static void main(String[] args){

        Solution sol = new Solution();
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};
        System.out.println(sol.solution(12,weak,dist));

    }


    public int solution(int n, int[] weak, int[] dist) {

        size = weak.length;

        dis = new int[size][size];
        visited = new boolean[size];
        DIST = dist;
        for(int i=0;i<size;i++){

            for(int j=0;j<size;j++){

                int dif = weak[i]-weak[j]>0?weak[i]-weak[j]:-weak[i]+weak[j];
                dis[i][j] = dif;
                dis[j][i] = dif;

            }
        }
        Arrays.sort(dist);

        for(int i=0;i<size;i++){

            dfs(i,0,dist.length-1);
        }
        if(answer==Integer.MAX_VALUE) return -1;

        return answer;
    }

    private void dfs(int idx, int cnt, int distIdx){


        System.out.println("idx : " + idx);
        if(distIdx<0) return;

        int temp = idx;
        while(visited[idx]){
            System.out.println("idx : " + idx + " temp : " + temp + " " + Arrays.toString(visited));
            idx++;
            if(idx==temp){
                answer = Math.min(answer,cnt);
                return;
            }
            if(idx>=size) idx = 0;
        }

        int max = -1;
        int maxVal = Integer.MIN_VALUE;


        temp = idx;
        idx++;
        if(idx>=size){
            idx = 0;
        }
        while(idx!=temp){

            if(!visited[idx]&&dis[temp][idx]<=DIST[distIdx]&&dis[temp][idx]>maxVal){
                max = idx;
                maxVal = dis[temp][idx];
            }
            idx++;
            if(idx==size) idx = 0;

        }

        if(max!=-1){

            if(max>temp){

                for(int i=temp;i<=max;i++){
                    visited[i] = true;
                }
                dfs(max,cnt+1,distIdx-1);
                for(int i=temp;i<=max;i++){
                    visited[i] = false;
                }

            }else{

                for(int i=0;i<=max;i++){
                    visited[i] = true;
                }
                for(int i=temp;i<size;i++){
                    visited[i] = true;
                }
                dfs(max,cnt+1,distIdx-1);
                for(int i=0;i<=max;i++){
                    visited[i] = false;
                }
                for(int i=temp;i<size;i++){
                    visited[i] = false;
                }
            }
        }


    }
}