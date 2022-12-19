package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16928 {

    static int N,M;
    static HashMap<Integer,Integer> LADDER;
    static HashMap<Integer,Integer> SNAKE;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        LADDER = new HashMap<>();
        SNAKE = new HashMap<>();
        VISITED = new boolean[101];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            LADDER.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            SNAKE.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        System.out.println(bfs(1,100));



    }

    public static int bfs(int start, int target){

        class Pointer{
            int val;
            int dis;
            Pointer(int val, int dis){
                this.val = val;
                this.dis = dis;
            }


        }

        Queue<Pointer> queue = new LinkedList<>();
        queue.add(new Pointer(start,0));
        VISITED[start] = true;
        while(!queue.isEmpty()){

            Pointer curr = queue.remove();
            if(curr.val==target) return curr.dis;

            for(int i=1;i<=6;i++){
                int nextVal = curr.val + i;
                if(nextVal>100) continue;
                if(LADDER.get(nextVal)!=null) nextVal = LADDER.get(nextVal);
                if(SNAKE.get(nextVal)!=null) nextVal = SNAKE.get(nextVal);
                if(VISITED[nextVal]) continue;
                VISITED[nextVal] = true;
                queue.add(new Pointer(nextVal, curr.dis+1));
            }



        }


        return -1;
    }
}
