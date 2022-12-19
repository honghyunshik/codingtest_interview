package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon21161re {
    static int N;
    static int M;
    static int[][] MARBLE;
    static int[][] CLONE;
    static int direction, distance;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};
    static int state;

    static ArrayList<int[]> delete = new ArrayList<>();
    static Queue<int[]> forChange = new LinkedList<>();
    static int forNextL,forNextR,forNextState = 0;
    static int answer = 0;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MARBLE = new int[N][N];

        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            int[] temp = new int[input.length];
            for(int j=0;j<input.length;j++){
                temp[j] = Integer.parseInt(input[j]);
            }
            MARBLE[i] = temp;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            direction = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            magic();
            bomb();
            change(N/2,N/2-1);
            for(int j=0;j<CLONE.length;j++){
                MARBLE[j] = CLONE[j];
            }
            for(int j=0;j<MARBLE.length;j++){
                System.out.println(Arrays.toString(MARBLE[j]));
            }
        }


        System.out.println(answer);


    }

    static void change(int startL, int startR){



        CLONE = new int[N][N];
        int noojuk = 1;


        while(!forChange.isEmpty()&&noojuk<N*N){

            int[] arr = forChange.poll();
            int num = arr[0];
            int count = arr[1];
            int nextL = startL;
            int nextR = startR;

            for(int k=0;k<2;k++){
                //왼쪽 대각선 위
                if(startL==startR+1&&startL<=N/2){
                    nextL++;
                    state = 1;
                }
                //왼쪽 대각선 아래
                else if(startL-N/2==N/2-startR&&startR<N/2){
                    nextR++;
                    state = 6;
                }
                //오른쪽 대각선 위
                else if(startL-N/2==N/2-startR&&startR>N/2){
                    nextR--;
                    state = 3;
                }
                //오른쪽 대각선 아래
                else if(startL==startR&&startL>N/2){
                    nextL--;
                    state = 8;
                }
                //그냥 위
                else if(state==3||state==2){
                    nextR--;
                    state = 2;
                }

                //그냥 왼쪽
                else if(state==1||state==4){
                    nextL++;
                    state = 4;
                }
                //그냥 오른쪽
                else if(state==8||state==5){
                    nextL--;
                    state = 5;
                }

                //그냥 아래
                else if(state==6||state==7){
                    nextR++;
                    state = 7;
                }
                if(k==0){
                    CLONE[startL][startR] = count;
                    CLONE[nextL][nextR] = num;
                    noojuk+=2;
                }
                startL = nextL;
                startR = nextR;
            }








        }

    }


    static void magic(){

        int centerL = N/2;
        int centerR = N/2;

        //마법이 발동한 후 구슬이 사라진다
        for(int i=0;i<distance;i++){
            centerL += D[direction-1][0];
            centerR += D[direction-1][1];
            MARBLE[centerL][centerR] = 0;
        }

        for(int k=distance;k>=1;k--){

            int startL = N/2 + D[direction-1][0]*k;
            int startR = N/2 + D[direction-1][1]*k;


            if(direction==1){
                startR--;
            }else if(direction==2){
                startR++;
            }else if(direction==3){
                startL++;
            }else if(direction==4){
                startL--;
            }

            //구슬이 사라진 후 구슬이 이동한다
            dfs(startL,startR,0);
        }


    }

    static void bomb(){

        while(true){
            dfs2();
            if(delete.size()<4) return;
            for(int i=0;i<delete.size();i++){
                answer += MARBLE[delete.get(i)[0]][delete.get(i)[1]];
                MARBLE[delete.get(i)[0]][delete.get(i)[1]] = 0;
            }
            for(int i=delete.size();i>0;i--){
                if(i==delete.size()){
                    dfs(forNextL,forNextR,state);
                }else{
                    dfs(delete.get(i)[0],delete.get(i)[1],delete.get(i)[2]);
                }
            }
        }


    }

    static void dfs2(){

        class Pointer{
            int l, r, dis;
            Pointer(int l, int r,int dis){
                this.l = l;
                this.r = r;
                this.dis = dis;
            }

        }

        delete.clear();
        forChange.clear();
        Stack<Pointer> stack = new Stack<>();
        ;
        stack.add(new Pointer(N/2,N/2-1,1));

        while(!stack.isEmpty()){

            Pointer curr = stack.pop();
            delete.add(new int[]{curr.l,curr.r,state});
            int nextL = curr.l;
            int nextR = curr.r;
            //왼쪽 대각선 위
            if(curr.l==curr.r+1&&curr.l<=N/2){
                nextL++;
                state = 1;
            }
            //왼쪽 대각선 아래
            else if(curr.l-N/2==N/2-curr.r&&curr.r<N/2){
                nextR++;
                state = 6;
            }
            //오른쪽 대각선 위
            else if(curr.l-N/2==N/2-curr.r&&curr.r>N/2){
                nextR--;
                state = 3;
            }
            //오른쪽 대각선 아래
            else if(curr.l==curr.r&&curr.l>N/2){
                nextL--;
                state = 8;
            }
            //그냥 위
            else if(state==3||state==2){
                nextR--;
                state = 2;
            }

            //그냥 왼쪽
            else if(state==1||state==4){
                nextL++;
                state = 4;
            }
            //그냥 오른쪽
            else if(state==8||state==5){
                nextL--;
                state = 5;
            }

            //그냥 아래
            else if(state==6||state==7){
                nextR++;
                state = 7;
            }

            forNextL = nextL;
            forNextR = nextR;

            if(MARBLE[nextL][nextR]!=MARBLE[curr.l][curr.r]){
                forChange.add(new int[]{MARBLE[curr.l][curr.r],Math.min(curr.dis,3)});
                if(curr.dis>=4){
                    System.out.println(curr.dis);
                    return;
                }
                curr.dis = 0;
                delete.clear();
            }
            if(MARBLE[nextL][nextR]==0) return;
            stack.push(new Pointer(nextL,nextR,curr.dis+1));



        }
    }

    static void dfs(int startL, int startR, int forState){

        class Pointer{
            int l, r;
            Pointer(int l, int r){
                this.l = l;
                this.r = r;
            }

        }

        Stack<Pointer> stack = new Stack<>();
        stack.add(new Pointer(startL,startR));
        if(forState==0){
            if(direction==1){
                state = 2;
            }else if(direction==2){
                state = 7;
            }else if(direction==3){
                state = 4;
            }else if(direction==4){
                state = 5;
            }
        }else{
            state = forState;
        }

        while(!stack.isEmpty()){

            Pointer curr = stack.pop();
            int nextL = curr.l;
            int nextR = curr.r;
            //왼쪽 대각선 위
            if(curr.l==curr.r+1&&curr.l<=N/2){
                nextL++;
                state = 1;
            }
            //왼쪽 대각선 아래
            else if(curr.l-N/2==N/2-curr.r&&curr.r<N/2){
                nextR++;
                state = 6;
            }
            //오른쪽 대각선 위
            else if(curr.l-N/2==N/2-curr.r&&curr.r>N/2){
                nextR--;
                state = 3;
            }
            //오른쪽 대각선 아래
            else if(curr.l==curr.r&&curr.l>N/2){
                nextL--;
                state = 8;
            }
            //그냥 위
            else if(state==3||state==2){
                nextR--;
                state = 2;
            }

            //그냥 왼쪽
            else if(state==1||state==4){
                nextL++;
                state = 4;
            }
            //그냥 오른쪽
            else if(state==8||state==5){
                nextL--;
                state = 5;
            }

            //그냥 아래
            else if(state==6||state==7){
                nextR++;
                state = 7;
            }



            for(int i=0;i<4;i++){


                //상하좌우에서 0을 찾아서 swap
                int zeroL = curr.l + D[i][0];
                int zeroR = curr.r + D[i][1];


                if(zeroL<0||zeroL>N-1||zeroR<0||zeroR>N-1) continue;
                if(MARBLE[zeroL][zeroR]!=0) continue;
                if(zeroL==N/2&&zeroR==N/2) continue;
                int temp = MARBLE[curr.l][curr.r];

                if((state==1||state==2)&&i!=3) continue;
                if((state==4||state==6)&&i!=0) continue;
                if((state==7||state==8)&&i!=2) continue;
                if((state==3||state==5)&&i!=1) continue;

                MARBLE[curr.l][curr.r] = MARBLE[zeroL][zeroR];
                MARBLE[zeroL][zeroR] = temp;
                if(nextL<0||nextL>N-1||nextR<0||nextR>N-1||MARBLE[nextL][nextR]==0) return;

                stack.push(new Pointer(nextL,nextR));


            }




        }


    }



}
