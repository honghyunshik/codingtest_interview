package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon2981 {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input==0) break;
            list.add(input);
        }
    }

    public static void solution(){

    }
}
