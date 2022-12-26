package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon12100 {

    static int[][] Board;
    static int answer = Integer.MIN_VALUE;
    static int n;
    static ArrayList<int[]> bruteForce;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Board = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                Board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bruteForce = new ArrayList<>();


        for(int i=0;i<4;i++){
            makeBruteForceList(i,1,i + " ");
        }
        int[][] temp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[i][j] = Board[i][j];
            }
        }
        for(int[] arr:bruteForce){

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    Board[i][j] = temp[i][j];
                }
            }
            for(int num:arr){
                move(num);
            }
        }


        System.out.println(answer);

    }

    //4가지 방향으로 블록을 움직임
    //direction =>  0 - 동, 1 - 서, 2 - 남, 3 - 북
    public static void makeBruteForceList(int direction, int count, String word){

        if(count>4){
            String[] word_list = word.split(" ");
            int[] temp = new int[word_list.length];
            for(int i=0;i<temp.length;i++){
                temp[i] = Integer.parseInt(word_list[i]);
            }
            bruteForce.add(temp);
            return;
        }
        for(int i=0;i<4;i++){
            makeBruteForceList(i,count+1,word + i + " ");
        }


    }

    public static void move(int direction){

        if(direction==0) moveToEast();
        else if(direction==1) moveToWest();
        else if(direction==2) moveToSouth();
        else if(direction==3) moveToNorth();

    }

    public static void moveToEast(){
        for(int i=0;i<n;i++){
            int index = n-1;
            boolean isMerged = false;
            for(int j=n-1;j>=0;j--){
                if(Board[i][j]!=0){
                    if(index<n-1&&Board[i][index+1]==Board[i][j]&&!isMerged){
                        int temp = Board[i][j];
                        Board[i][j] = 0;
                        Board[i][index+1] = temp * 2;
                        answer = Math.max(answer,temp*2);
                        isMerged = true;
                    }
                    else {
                        int temp = Board[i][j];
                        Board[i][j] = 0;
                        Board[i][index--] = temp;
                        answer = Math.max(answer,temp);
                        isMerged = false;
                    }
                }
            }
        }
    }

    public static void moveToWest(){

        for(int i=0;i<n;i++){
            int index = 0;
            boolean isMerged = false;
            for(int j=0;j<n;j++){
                if(Board[i][j]!=0){
                    if(index>0&&Board[i][index-1]==Board[i][j]&&!isMerged){
                        int temp = Board[i][j];
                        Board[i][j] = 0;
                        Board[i][index-1] = temp * 2;
                        answer = Math.max(answer,temp*2);
                        isMerged = true;
                    }
                    else {
                        int temp = Board[i][j];
                        Board[i][j] = 0;
                        Board[i][index++] = temp;
                        answer = Math.max(answer,temp);
                        isMerged = false;
                    }
                }
            }
        }

    }

    public static void moveToSouth(){

        for(int i=0;i<n;i++){
            int index = n-1;
            boolean isMerged = false;
            for(int j=n-1;j>=0;j--){
                if(Board[j][i]!=0){
                    if(index<n-1&&Board[index+1][i]==Board[j][i]&&!isMerged){
                        int temp = Board[j][i];
                        Board[j][i] = 0;
                        Board[index+1][i] = temp * 2;
                        answer = Math.max(answer,temp*2);
                        isMerged = true;
                    }
                    else {
                        int temp = Board[j][i];
                        Board[j][i] = 0;
                        Board[index--][i] = temp;
                        answer = Math.max(answer,temp);
                        isMerged = false;
                    }
                }
            }
        }

    }

    public static void moveToNorth(){


        for(int i=0;i<n;i++){
            int index = 0;
            boolean isMerged = false;
            for(int j=0;j<n;j++){
                if(Board[j][i]!=0){
                    if(index>0&&Board[index-1][i]==Board[j][i]&&!isMerged){
                        int temp = Board[j][i];
                        Board[j][i] = 0;
                        Board[index-1][i] = temp * 2;
                        answer = Math.max(answer,temp*2);
                        isMerged = true;
                    }
                    else {
                        int temp = Board[j][i];
                        Board[j][i] = 0;
                        Board[index++][i] = temp;
                        answer = Math.max(answer,temp);
                        isMerged = false;
                    }
                }
            }
        }
    }


}
