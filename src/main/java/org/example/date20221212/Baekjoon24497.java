package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon24497 {

    static boolean[] check;

    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){

            st = new StringTokenizer(br.readLine(), " ");


        }


    }


}

class Node{

    int val;
    Node next;

    Node(int val){
        this.val = val;
        next = null;
    }
}
