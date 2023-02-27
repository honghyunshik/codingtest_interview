package org.example.baekjoon1459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());       //한블록
        int s = Integer.parseInt(st.nextToken());       //대각선

        long answer = 0;
        //대각선이 더 빠른 경우 대각선으로 이동
        if(2*w>s){
            int min = Math.min(x,y);
            if(w>s){
                answer = (long)min*s + (long)(x-min)*s + (long)(y-min)*s;
                if((x-min)%2>0||(y-min)%2>0){
                    answer = answer - s + w;
                }
            }else{
                answer = (long)min*s + (long)(x-min)*w + (long)(y-min)*w;
            }
        }else{
            answer = (long)(x+y) * w;
        }
        System.out.println(answer);
    }
}
