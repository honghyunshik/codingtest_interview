package org.example.date20221225;

import sun.security.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14889 {

    static int[][] start_link;
    static ArrayList<int[]> startTeam;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start_link = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=N;j++){
                start_link[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        startTeam = new ArrayList<>();
        bruteForce(0,0,"");


        System.out.println(getMinVal());

    }

    public static int getMinVal(){

        int answer = Integer.MAX_VALUE;
        int startNum,linkNum;

        int[] link = new int[N/2];

        int[] checkArray = new int[N];
        for(int i=0;i<N;i++){
            checkArray[i] = i+1;
        }

        for(int[] arr:startTeam){
            startNum = 0;
            linkNum = 0;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if(i==j) continue;
                    startNum += start_link[arr[i]][arr[j]];
                }
            }
            int counter=0;

            for(int num:checkArray){
                boolean check = false;
                for(int i:arr){
                    if(i==num) check = true;

                }
                if(!check)  link[counter++] = num;

            }
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if(i==j) continue;
                    linkNum += start_link[link[i]][link[j]];
                }
            }

            int temp = Math.abs(startNum-linkNum);
            answer = Math.min(temp,answer);
        }



        return answer;
    }

    public static void bruteForce(int index, int count, String word){

        if(count==N/2){

            String[] word_list = word.split(" ");
            int[] temp = new int[word_list.length];
            for(int i=0;i<word_list.length;i++){
                temp[i] = Integer.parseInt(word_list[i]);
            }
            startTeam.add(temp);
            return;
        }
        if(index>N) return;


        if(index>0)  bruteForce(index+1,count+1,word + (index) + " ");
        bruteForce(index+1,count,word);
    }



}
