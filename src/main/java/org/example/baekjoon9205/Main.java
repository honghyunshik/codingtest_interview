package org.example.baekjoon9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int sangHouse_x = 0, sangHouse_y = 0, festival_x = 0, festival_y = 0;

        Solution sol = new Solution();
        for(int k=0;k<t;k++){
            int n = Integer.parseInt(br.readLine());
            int[][] convin_store = new int[n][2];
            for(int i=0;i<n+2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                if(i==0){
                    sangHouse_x = Integer.parseInt(st.nextToken());
                    sangHouse_y = Integer.parseInt(st.nextToken());
                }else if(i==n+1){
                    festival_x = Integer.parseInt(st.nextToken());
                    festival_y = Integer.parseInt(st.nextToken());
                }else{
                    convin_store[i-1] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
                }
            }
            System.out.println(sol.canGo(sangHouse_x,sangHouse_y,festival_x,festival_y,convin_store));

        }

    }
}

class Solution{

    String canGo(int startX, int startY, int endX, int endY, int[][] convin_store){

        int n = convin_store.length;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        while(!queue.isEmpty()){

            Node now = queue.poll();
            int now_x = now.x;
            int now_y = now.y;
            if(getDistance(now_x,now_y,endX,endY)<=1000) return "happy";
            for(int[] array:convin_store){
                if((array[0]!=Integer.MIN_VALUE&&array[1]!=Integer.MIN_VALUE)&&getDistance(now_x,now_y,array[0],array[1])<=1000){
                    queue.add(new Node(array[0],array[1]));
                    array[0] = Integer.MIN_VALUE;
                    array[1] = Integer.MIN_VALUE;
                }
            }
        }
        return "sad";
    }

    int getDistance(int startX, int startY, int endX, int endY){

        return Math.abs(startX-endX) + Math.abs(startY-endY);
    }

}

class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
