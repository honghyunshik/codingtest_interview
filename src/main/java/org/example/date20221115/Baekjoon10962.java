package org.example.date20221115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10962 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(sk.nextToken());
        sb.append("??!");
        System.out.println(sb.toString());
    }
}
