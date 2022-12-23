package org.example.date20221221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14502 {

    static int N,M;
    static int[][] LABORATORY;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] VISITED;
    static int WALL_COUNT, VIRUS_COUNT, BLANK_COUNT = 0;

    static ArrayList<int[]> BLANK_LIST;
    static ArrayList<int[]> BLANK_LOCATION;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        LABORATORY = new int[N][M];
        BLANK_LIST = new ArrayList<>();
        BLANK_LOCATION = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                LABORATORY[i][j] = Integer.parseInt(st.nextToken());
                if(LABORATORY[i][j]==1) WALL_COUNT++;
                else if(LABORATORY[i][j]==2) VIRUS_COUNT++;
                else {
                    BLANK_LOCATION.add(new int[]{i,j});
                    BLANK_COUNT++;
                }
            }
        }
        WALL_COUNT += 3;
        System.out.println(solution());

    }

    public static void bruteforce(int index, int count, String word){

        if(count==3) {
            String[] list = word.split(" ");
            int[] temp = new int[list.length];
            for(int i=0;i<temp.length;i++){
                temp[i] = Integer.parseInt(list[i]);
            }
            BLANK_LIST.add(temp);
            return;
        }

        if(index==BLANK_COUNT) return;

        bruteforce(index+1,count, word);
        bruteforce(index+1,count+1, word + index + " ");



    }



    public static int solution(){

        bruteforce(0,0,"");
        int answer = Integer.MIN_VALUE;
        int fixed_virus_count = VIRUS_COUNT;

        int c = 0;
        for(int[] arr:BLANK_LIST){

            for(int index:arr){
                int l = BLANK_LOCATION.get(index)[0];
                int r = BLANK_LOCATION.get(index)[1];
                LABORATORY[l][r] = 1;
            }



            VISITED = new boolean[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(LABORATORY[i][j]==2){

                        dfs(i,j);
                    }
                }
            }

            int temp_answer = N*M- VIRUS_COUNT - WALL_COUNT;
            answer = Math.max(answer,temp_answer);
            VIRUS_COUNT = fixed_virus_count;

            for(int index:arr){
                int l = BLANK_LOCATION.get(index)[0];
                int r = BLANK_LOCATION.get(index)[1];
                LABORATORY[l][r] = 0;
            }
        }

        return answer;
    }

    //바이러스가 퍼짐
    public static void dfs(int startL, int startR){

        VISITED[startL][startR] = true;

        for(int i=0;i<4;i++){
            int nextL = startL + D[i][0];
            int nextR = startR + D[i][1];
            if(nextL<0||nextL>N-1||nextR<0||nextR>M-1) continue;
            if(VISITED[nextL][nextR]) continue;
            if(LABORATORY[nextL][nextR]!=0) continue;
            VISITED[nextL][nextR] = true;
            VIRUS_COUNT++;
            dfs(nextL,nextR);
        }
    }








}
