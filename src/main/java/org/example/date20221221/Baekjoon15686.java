package org.example.date20221221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon15686 {

    static int N,M;
    static int[][] CHICKEN;
    static ArrayList<int[]> CHICKEN_LOCATION;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    static int count = 0;


    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        CHICKEN = new int[N][N];
        CHICKEN_LOCATION = new ArrayList<>();
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            int[] temp = new int[input.length];
            for(int j=0;j<temp.length;j++){
                temp[j] = Integer.parseInt(input[j]);
                if(temp[j]==2) {
                    CHICKEN_LOCATION.add(new int[]{i,j});
                    temp[j] = 0;
                }

            }
            CHICKEN[i] = temp;

        }

        solution();

    }

    public static void solution(){

        bruteForce(0,0,"");
        int answer = Integer.MAX_VALUE;
        for(int[] arr:list){
            int temp_answer = 0;

            for(int num:arr){
                int l = CHICKEN_LOCATION.get(num)[0];
                int r = CHICKEN_LOCATION.get(num)[1];
                CHICKEN[l][r] = 2;
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(CHICKEN[i][j]==1) {
                        bfs(i,j);
                        temp_answer += count;
                    }
                }
            }

            for(int num:arr){
                int l = CHICKEN_LOCATION.get(num)[0];
                int r = CHICKEN_LOCATION.get(num)[1];
                CHICKEN[l][r] = 0;
            }

            answer = Math.min(answer,temp_answer);
        }
        System.out.println(answer);

    }


    public static void bruteForce(int index, int count, String word){


        if(count==M){
            String[] word_list = word.split(" ");
            int[] temp = new int[word_list.length];
            for(int i=0;i<temp.length;i++){
                temp[i] = Integer.parseInt(word_list[i]);
            }
            list.add(temp);
            return;
        }
        if(index>CHICKEN_LOCATION.size()-1) return;
        bruteForce(index+1, count, word);
        bruteForce(index+1, count+1, word + index + " ");


    }



    public static void bfs(int startL, int startR){

        class Pointer{
            int l,r,dis;
            Pointer(int l, int r, int dis){
                this.l = l;
                this.r = r;
                this.dis = dis;
            }
        }
        Queue<Pointer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        visited[startL][startR] = true;
        queue.add(new Pointer(startL,startR,0));
        while(!queue.isEmpty()){
            Pointer curr = queue.poll();

            if(CHICKEN[curr.l][curr.r]==2) {
                count = curr.dis;

                return;
            }
            for(int i=0;i<4;i++){

                int nextL = curr.l + D[i][0];
                int nextR = curr.r + D[i][1];
                if(nextL>N-1||nextL<0||nextR>N-1||nextR<0) continue;
                if(visited[nextL][nextR]) continue;
                visited[nextL][nextR] = true;
                queue.add(new Pointer(nextL, nextR, curr.dis+1));
            }

        }

    }


}
