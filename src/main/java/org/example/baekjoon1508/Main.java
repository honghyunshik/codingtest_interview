package org.example.baekjoon1508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] race;
    static int dif = 0;
    static String answer = "";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        race = new int[k];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<k;i++){
            race[i] = Integer.parseInt(st.nextToken());
        }
        Main main = new Main();
        System.out.println(answer);

    }

    public void binarySearch(int l, int r){


    }
}
