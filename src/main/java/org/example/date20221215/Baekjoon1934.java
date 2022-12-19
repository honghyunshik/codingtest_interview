package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1934 {

    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
            StringTokenizer st=  new StringTokenizer(br.readLine()," ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            uclid(l,r);
            System.out.println(l*r/answer);
        }
    }

    public static void uclid(int l, int r){

        int max, min;
        if(l>r){
            max = l;
            min = r;
        }else{
            max = r;
            min = l;
        }

        int remain = max%min;
        if(remain==0) {
            answer = min;
            return;
        }
        uclid(min,remain);

    }
}
