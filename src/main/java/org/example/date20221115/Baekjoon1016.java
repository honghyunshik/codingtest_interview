package org.example.date20221115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1016 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(br.readLine());

        long min = Long.parseLong(sk.nextToken());
        long max = Long.parseLong(sk.nextToken());

        System.out.println(notMultiple(min,max));


    }

    public static int notMultiple(long min, long max){

        int answer = 0;

        boolean[] sosu = new boolean[(int) (max-min+1)];     //소수인지를 저장하는 배열 - 소수는 false

        //에라토스테네스의 채로 검사
        for(long i=2;i*i<=max;i++){

            long multi = i*i;
            long start = min%multi == 0 ? min/multi : min/multi+1;

            for(long j=start;j*multi<=max;j++){
                System.out.println("j : " + j + " multi : " + multi + " min : " + min + " sum : " + (int) (j*multi-min));
                sosu[(int) (j*multi-min)] = true;
            }

        }

        for(int i=0;i<sosu.length;i++){
            if(!sosu[i]) answer++;
        }

        return answer;
    }
}
