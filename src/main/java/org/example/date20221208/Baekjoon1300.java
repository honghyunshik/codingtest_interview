package org.example.date20221208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1300 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = Integer.parseInt(br.readLine());
        System.out.println(solution(N,index));

    }

    public static long solution(int N, int index){

        long l = 1, r = index;
        while(l<r){
            long sum = 0;    //mid까지의 수의 개수
            long mid = (l+r)/2;
            for(int i=1;i<=N;i++){
                sum += mid/i>N?N:mid/i;
            }

            //수를 작게
            if(sum>=index){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return r;
    }
}
