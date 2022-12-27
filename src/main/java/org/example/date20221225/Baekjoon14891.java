package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14891 {

    static int[] one;
    static int[] two;
    static int[] three;
    static int[] four;
    static int[][] GEAR;
    static boolean[] VISITED;
    static int[] forCopy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        VISITED = new boolean[5];
        GEAR = new int[5][8];
        forCopy = new int[8];

        for(int i=1;i<=4;i++){
            String[] input = br.readLine().split("");
            int[] temp = new int[input.length];
            for(int j=0;j<temp.length;j++){
                temp[j] = Integer.parseInt(input[j]);
            }
            GEAR[i] = temp;
        }

        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            VISITED[num] = true;
            rotation(num,direction);
            VISITED[num] = false;

        }
        System.out.println(getScore());

    }

    public static int getScore(){
        int answer = 0;

        if(GEAR[1][0]==1) answer++;
        if(GEAR[2][0]==1) answer+=2;
        if(GEAR[3][0]==1) answer+=4;
        if(GEAR[4][0]==1) answer+=8;

        return answer;
    }

    //톱니바퀴 회전
    public static void rotation(int num, int direction){


        //num이 1보다 크다면
        if(num>1&&!VISITED[num-1]&&GEAR[num-1][2]!=GEAR[num][6]){
            VISITED[num-1] = true;
            rotation(num-1,-direction);
            VISITED[num-1] = false;
        }
        //num이 4보다 작다면
        if(num<4&&!VISITED[num+1]&&GEAR[num][2]!=GEAR[num+1][6]){
            VISITED[num+1] = true;
            rotation(num+1,-direction);
            VISITED[num+1] = false;
        }
        //시계방향회전
        if(direction==1){
            for(int i=0;i<8;i++){
                if(i==7) forCopy[0] = GEAR[num][i];
                else forCopy[i+1] = GEAR[num][i];
            }
        }
        //반시계방향회전
        else if(direction==-1){
            for(int i=0;i<8;i++){
                if(i==7) forCopy[i] = GEAR[num][0];
                else forCopy[i] = GEAR[num][i+1];
            }
        }

        //회전한 값 GEAR 변경
        for(int i=0;i<GEAR[num].length;i++){
            GEAR[num][i] = forCopy[i];
        }


    }


}
