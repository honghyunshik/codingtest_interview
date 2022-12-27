package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14888_re {

    static int N;
    static int[] numArray;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        numArray = new int[N];
        operator = new int[4];
        for(int i=0;i<N;i++){
            numArray[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<4;i++){

            if(operator[i]>0){
                operator[i]--;
                backTracking(1,i,numArray[0]);
                operator[i]++;
            }
        }


        System.out.println(max+"\n"+min);
    }

    public static void backTracking(int index, int sign, int sum){


        if(sign==0) {
            sum+=numArray[index];
        }
        else if(sign==1) {
            sum-=numArray[index];
        }
        else if(sign==2) {
            sum*=numArray[index];
        }
        else if(sign==3){
            if(sum<0){
                sum = -sum;
                sum/=numArray[index];
                sum = -sum;
            }else sum/=numArray[index];
        }
        if(index==N-1){
            max = Math.max(sum,max);
            min = Math.min(sum,min);
            return;
        }

        for(int i=0;i<4;i++){

            if(operator[i]>0){
                operator[i]--;
                backTracking(index+1,i,sum);
                operator[i]++;
            }
        }

    }
}



