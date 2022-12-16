package org.example.date20221128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2447 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[][] arr= new String[num][num];
        stars(arr,0,0,num,false);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }



    public static void stars(String[][] arr, int x,int y, int size, boolean blank){

        if(size==1&&!blank){
            arr[x][y] = "*";
        }else if(blank){
            for(int i=x;i<x+size;i++){
                for(int j=y;j<y+size;j++){
                    arr[i][j] = " ";
                }
            }
        }else{
            for(int i=x;i<size+x;i+=size/3){
                for(int j=y;j<size+y;j+=size/3){
                    if(i==x+size/3&&j==y+size/3){
                        stars(arr,i,j,size/3,true);
                    }else{
                        stars(arr,i,j,size/3,false);
                    }
                }
            }

        }


    }
}
