package org.example.date20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon13458 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());        //시험장의 수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] studentNum = new int[N];      //각 시험장 학생 수

        for(int i=0;i<N;i++){
            studentNum[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine(), " ");
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer = 0;

        for(int i:studentNum){
            answer += getCoachNum(i,B,C);
        }
        System.out.println(answer);


    }

    public static int getCoachNum(int studentNum, int B, int C){

        studentNum = studentNum - B;
        int answer = 1;
        if(studentNum<0) return answer;
        answer += Math.ceil(studentNum/(double)C);
        return answer;

    }
}
