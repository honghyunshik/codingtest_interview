package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16236 {

    static int[][] SHARK;
    static int l=0, r = 0;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        SHARK = new int[N][N];

        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            int[] temp = new int[N];
            for(int j=0;j<input.length;j++){
                temp[j] = Integer.parseInt(input[j]);
                if(temp[j]==9){
                    temp[j] = 0;
                    l = i;
                    r = j;
                }
            }
            SHARK[i] = temp;
        }

        find(l,r,2,0,0);
        System.out.println(answer);

    }



    public static void find(int prevL, int prevR, int weight, int count, int eatFish){


        Stack<Pointer> fishes = new Stack<>();

        for(int i=0;i<SHARK.length;i++){
            for(int j=0;j<SHARK[0].length;j++){
                if(SHARK[i][j]>0&&SHARK[i][j]<weight){
                    Pointer point = dbs(prevL,prevR,i,j,weight);
                    if (point != null) {
                        if(fishes.isEmpty()||fishes.peek().dis>point.dis){
                            fishes.push(point);
                        }
                    }

                }
            }
        }
        //잡을 수 있는 물고가기 없다면 종료
        if(fishes.isEmpty()) {
            answer = count;
            return;
        }

        //목표물 좌표 입력
        Pointer point = fishes.pop();
        int targetL = point.l;
        int targetR = point.r;


        //잡아먹은후 좌표 0으로 변경
        SHARK[targetL][targetR] = 0;

        eatFish++;
        if(eatFish==weight){
            weight++;
            eatFish = 0;
        }
        count += point.dis;
        find(targetL,targetR,weight,count, eatFish);

    }

    public static Pointer dbs(int prevL, int prevR, int targetL, int targetR, int weight){
        //물고기를 잡아먹으러 이동
        Queue<Pointer> queue = new LinkedList<>();
        boolean[][] VISITED = new boolean[N][N];
        VISITED[prevL][prevR] = true;
        queue.add(new Pointer(prevL,prevR,0,0));
        while(!queue.isEmpty()){
            Pointer curr = queue.remove();
            if(curr.l==targetL&&curr.r==targetR) {
                return curr;
            }
            for(int i=0;i<4;i++){
                int nextL = curr.l + D[i][0];
                int nextR = curr.r + D[i][1];
                if(nextL<0||nextL>N-1||nextR<0||nextR>N-1) continue;
                if(SHARK[nextL][nextR]>weight) continue;
                if(VISITED[nextL][nextR]) continue;
                VISITED[nextL][nextR] = true;
                queue.add(new Pointer(nextL, nextR, 0,curr.dis+1));
            }
        }
        return null;
    }


}
class Pointer{
    int l, r, dis, weight;
    Pointer(int l, int r, int weight, int dis){
        this.l = l;
        this.r = r;
        this.weight = weight;
        this.dis = dis;
    }



}