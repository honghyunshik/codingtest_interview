package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Baekjoon21611{

    static int[][] LOCATION;
    static int[][] MARBLE;
    static int N;
    static int M;
    static int direction, distance;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};

    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MARBLE = new int[N][N];

        //MARBLE 배열 생성
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            int[] temp = new int[input.length];
            for(int j=0;j<input.length;j++){
                temp[j] = Integer.parseInt(input[j]);
            }
            MARBLE[i] = temp;
        }

        //LOCATION 배열 생성
        LOCATION = new int[N*N][2];
        makeLocation();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            direction = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            magic();
            bomb();
            for(int j=0;j<MARBLE.length;j++){
                System.out.println(Arrays.toString(MARBLE[j]));
            }
            System.out.println();
            System.out.println();
            change();

        }

        System.out.println(answer);

    }

    //다시 늘리기
    static void change(){

        Queue<int[]> queue = getCount();
        int[][] clone = new int[N][N];
        int index = 1;
        while(!queue.isEmpty()&&index<N*N){
            int[] arr = queue.poll();
            for(int i=0;i<2;i++){
                int l = LOCATION[index+i][0];
                int r = LOCATION[index+i][1];
                if(i==0) clone[l][r] = arr[0];
                else clone[l][r] = arr[1];
            }
            index+=2;
        }

        for(int i=0;i<clone.length;i++){
            MARBLE[i] = clone[i];
        }

    }

    static Queue<int[]> getCount(){

        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        for(int i=1;i<LOCATION.length-1;i++){

            int l = LOCATION[i][0];
            int r = LOCATION[i][1];
            int nextL = LOCATION[i+1][0];
            int nextR = LOCATION[i+1][1];

            if(MARBLE[l][r]!=MARBLE[nextL][nextR]){
                queue.add(new int[]{MARBLE[l][r],Math.min(3,count)});
                count = 1;
            }else count++;


        }

        return queue;

    }

    //연속되는 숫자들 0으로 변환 후 땡기기
    static void bomb(){


        while(true){
            ArrayList<ArrayList<Integer>> bombList = getBombList();
            if(bombList.size()==0) break;
            for(ArrayList<Integer> list : bombList){
                answer += list.size() * MARBLE[LOCATION[list.get(0)][0]][LOCATION[list.get(0)][1]];
                for(int i=0;i<list.size();i++){

                    int index = list.get(i);
                    int l = LOCATION[index][0];
                    int r = LOCATION[index][1];

                    MARBLE[l][r] = Integer.MIN_VALUE;
                }
            }
        moveZero();
        }
    }




    //연속되는 숫자들 리스트 반환
    static ArrayList<ArrayList<Integer>> getBombList(){

        ArrayList<ArrayList<Integer>> bombList = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 1;

        for(int i=1;i<LOCATION.length-1;i++){

            int l = LOCATION[i][0];
            int r = LOCATION[i][1];
            int nextL = LOCATION[i+1][0];
            int nextR = LOCATION[i+1][1];

            temp.add(i);
            if(MARBLE[l][r]!=MARBLE[nextL][nextR]){
                if(temp.size()>=4){
                    bombList.add(temp);
                }
                temp = new ArrayList<>();
            }
            if(MARBLE[nextL][nextR]==0) break;



        }
        return bombList;
    }

    //마법으로 0으로 변환
    static void magic(){

        int centerL = N/2;
        int centerR = N/2;

        //마법이 발동한 후 구슬이 사라진다
        for(int i=0;i<distance;i++){
            centerL += D[direction-1][0];
            centerR += D[direction-1][1];
            MARBLE[centerL][centerR] = Integer.MIN_VALUE;
        }

        for(int k=distance;k>=1;k--){

            int startL = N/2 + D[direction-1][0]*k;
            int startR = N/2 + D[direction-1][1]*k;


            //구슬이 사라진 후 구슬이 이동한다
            moveZero();
        }
    }

    //계속해서 swqp
    public static void dfs(int index){

        for(int i=index;i<LOCATION.length-1;i++){

            int nowL = LOCATION[i][0];
            int nowR = LOCATION[i][1];
            int nextL = LOCATION[i+1][0];
            int nextR = LOCATION[i+1][1];

            int temp = MARBLE[nowL][nowR];
            MARBLE[nowL][nowR] = MARBLE[nextL][nextR];
            if(i==LOCATION.length-2) MARBLE[nextL][nextR] = 0;
            else MARBLE[nextL][nextR] = temp;

        }


    }

    //생성된 0들을 옮김
    public static void moveZero(){

        int nowL = 0;
        int nowR = 0;
        for(int i=LOCATION.length-2;i>=1;i--){

            if(MARBLE[LOCATION[i][0]][LOCATION[i][1]]==0) continue;
            if(MARBLE[LOCATION[i][0]][LOCATION[i][1]]!=Integer.MIN_VALUE) continue;
            dfs(i);
        }
    }

    //회전 배열 생성
    public static void makeLocation(){

        int nowL = N/2;
        int nowR = N/2-1;
        int state = 0;
        int count = 1;
        LOCATION[0] = new int[]{0,0};
        while(nowL!=0||nowR!=0){

            LOCATION[count++] = new int[]{nowL,nowR};

            //왼쪽 대각선 위
            if(nowL==nowR+1&&nowL<=N/2){
                nowL++;
                state = 1;
            }
            //왼쪽 대각선 아래
            else if(nowL-N/2==N/2-nowR&&nowR<N/2){
                nowR++;
                state = 6;
            }
            //오른쪽 대각선 위
            else if(nowL-N/2==N/2-nowR&&nowR>N/2){
                nowR--;
                state = 3;
            }
            //오른쪽 대각선 아래
            else if(nowL==nowR&&nowL>N/2){
                nowL--;
                state = 8;
            }
            //그냥 위
            else if(state==3||state==2){
                nowR--;
                state = 2;
            }

            //그냥 왼쪽
            else if(state==1||state==4){
                nowL++;
                state = 4;
            }
            //그냥 오른쪽
            else if(state==8||state==5){
                nowL--;
                state = 5;
            }

            //그냥 아래
            else if(state==6||state==7){
                nowR++;
                state = 7;
            }

        }
        LOCATION[count] = new int[]{0,0};


    }
}
