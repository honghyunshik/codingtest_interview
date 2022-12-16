package org.example.date20221128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int count = Integer.parseInt(first[0]);
        int P = Integer.parseInt(first[2]);
        int score = Integer.parseInt(first[1]);

        String input = "";
        if(count!=0) {
            input = br.readLine();
        }

        System.out.println(solution(score,P,input + " "));


    }

    public static int solution(int score,int P, String input){

        int rank = 1;
        int counter = 0;
        if(input.equals(" ")){
            return 1;
        }

        String temp = "";
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' '){
                int num = Integer.parseInt(temp);
                temp = "";
                counter++;
                if(num>score) rank++;
                else if(num==score&&counter==P) return -1;
            }else{
                temp += input.charAt(i);
            }
        }

        if(rank>P) return -1;


        return rank;
    }
}
