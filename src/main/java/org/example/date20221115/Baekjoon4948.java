package org.example.date20221115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        boolean[] sosu = new boolean[123456*2+1];
        sosu[0] = sosu[1] = true;
        for(int i=2;i*i<sosu.length;i++){
            if(!sosu[i]){
                for(int j=i*2;j<sosu.length;j+=i){
                    sosu[j] = true;
                }
            }
        }



        while(true){
            StringTokenizer sk = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(sk.nextToken());
            if(num==0) break;
            System.out.println(bertrang(num,sosu));
        }

    }

    public static int bertrang(int num,boolean[] sosu){

        int answer = 0;
        for(int i=num+1;i<=num*2;i++){

            if(!sosu[i]) answer++;
        }


        return answer;

    }
}
