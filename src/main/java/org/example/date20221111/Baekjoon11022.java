package org.example.date20221111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11022 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int

        for(int i=0;i<num;i++){
            String input = bf.readLine();

            System.out.printf("Case #%d: %s + %s = %d\n",i+1,input.split(" ")[0],input.split(" ")[1],Integer.parseInt(input.split(" ")[0])+Integer.parseInt(input.split(" ")[1]));
        }

    }
}
