package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14890 {

    static int N,L;
    static int[][] ROAD;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        ROAD = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                ROAD[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(getAllRoad());

    }

    public static int getAllRoad(){

        int roadNum = 0;

        for(int i=0;i<N;i++){

            roadNum += isRoad(ROAD[i]);
            int[] temp = new int[N];
            for(int j=0;j<N;j++){
                temp[j] = ROAD[j][i];
            }

            roadNum += isRoad(temp);
        }

        return roadNum;
    }

    public static int isRoad(int[] array){

        boolean isRoad = true;
        int roadCount = 0;      //현재가 경사로를 설치한 곳인지 - 0이면 없다는 뜻
        int sameCount = 1;      //현재 몇번째 같은 높이인지
        for(int i=0;i<array.length-1;i++){

            int now = array[i];
            int next = array[i+1];
            //현재랑 다음길의 높이가 같을 때
            if(now==next) {
                if(roadCount==0) sameCount++;
                if(roadCount>0) roadCount--;
            }
            //현재의 길의 높이가 1 높을때
            else if(now-1==next){
                if(i+L<array.length){
                    boolean isSame = true;
                    for(int j=i+1;j<i+L;j++){
                        if(array[j]!=array[j+1]){
                            isSame = false;
                            break;
                        }
                    }
                    if(isSame){
                        sameCount = 1;
                        roadCount = L;
                    }else{
                        isRoad = false;
                        break;
                    }

                }else{
                    isRoad = false;
                    break;
                }

            }
            //다음 길의 높이가 1 높을때
            else if(now==next-1){
                if(sameCount>=L&&roadCount==0){
                    sameCount = 1;
                    roadCount = 0;
                }else{
                    isRoad = false;
                    break;
                }
            }else{
                isRoad = false;
                break;
            }

        }


        if(isRoad){

             return 1;}
        else {
            return 0;
        }
    }




}
