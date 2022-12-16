package org.example.date20221128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon11729 {

    static StringBuilder sb = new StringBuilder();
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        hanoi(1,3,2,num);

        System.out.println(counter);
        System.out.println(sb.toString());

    }

    public static void hanoi(int from, int to, int mid, int val){


        if(val==1){
            sb.append(from + " " + to + "\n");
            counter++;
        }else{
            hanoi(from,mid,to,val-1);
            sb.append(from + " " + to + "\n");
            counter++;
            hanoi(mid,to,from,val-1);
        }
    }

}
