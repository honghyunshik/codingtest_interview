package org.example.date20221221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon15685 {

    static int N;
    static int[][] D = {{0,1},{-1,0},{0,-1},{1,0}};
    static int[][] ARR;
    static ArrayList<ArrayList<Integer>> record;




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ARR = new int[101][101];
        record = new ArrayList<>();

        for(int k=0;k<N;k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragon(x,y,d,g);
        }
        System.out.println(count());




    }


    public static int count(){

        class Pointer{
            int l,r;
            Pointer(int l, int r){
                this.l = l;
                this.r = r;
            }
        }

        boolean[][] visited = new boolean[101][101];
        Queue<Pointer> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new Pointer(0,0));
        int answer = 0;
        while(!queue.isEmpty()){
            Pointer curr = queue.poll();
            int nextL = curr.l+1;
            int nextR = curr.r+1;
            if(nextL>100||nextR>100) continue;
            if(visited[nextL][nextR]) continue;
            visited[nextL][nextR] = true;
            if(ARR[curr.l][curr.r]==1&&ARR[curr.l][curr.r]==ARR[nextL][curr.r]&&ARR[nextL][curr.r]==ARR[curr.l][nextR]&&ARR[curr.l][nextR]==ARR[nextL][nextR]) answer++;
            queue.add(new Pointer(curr.l,nextR));
            queue.add(new Pointer(nextL,curr.r));
            queue.add(new Pointer(nextL,nextR));
        }
        return answer;
    }

    public static void dragon(int x, int y, int d, int g){

        recursion(x,y,d,0,g);

    }

    //재귀를 통해 점 점 찍기
    public static void recursion(int x, int y, int d, int n, int g){

        if(n==g+1) return;
        int nextX = x;
        int nextY = y;
        ArrayList<Integer> temp;
        if(n==0){

            record.clear();
            temp = new ArrayList<>();
            ARR[x][y] = 1;
            nextX += D[d][0];
            nextY += D[d][1];
            temp.add(d);
            record.add(temp);
            ARR[nextX][nextY] = 1;
        }else{

            temp = new ArrayList<>();
            ArrayList<Integer> prev = record.get(n-1);
            temp.addAll(prev);

            for(int i=prev.size()-1;i>=0;i--){
                int now = prev.get(i);
                if(now==0){
                    temp.add(1);
                    nextX += D[1][0];
                    nextY += D[1][1];
                    //System.out.println(nextX + "," + nextY);
                    ARR[nextX][nextY] = 1;
                }else if(now==1){
                    temp.add(2);
                    nextX += D[2][0];
                    nextY += D[2][1];
                    //System.out.println(nextX + "," + nextY);
                    ARR[nextX][nextY] = 1;
                }else if(now==2){
                    temp.add(3);
                    nextX += D[3][0];
                    nextY += D[3][1];
                    //System.out.println(nextX + "," + nextY);
                    ARR[nextX][nextY] = 1;
                }else if(now==3){
                    temp.add(0);
                    nextX += D[0][0];
                    nextY += D[0][1];
                    //System.out.println(nextX + "," + nextY);
                    ARR[nextX][nextY] = 1;
                }
            }
            record.add(temp);
        }


        recursion(nextX, nextY, d,n+1,g);
    }




}
