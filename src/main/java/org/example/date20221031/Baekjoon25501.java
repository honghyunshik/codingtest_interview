package org.example.date20221031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon25501 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int
        for(int i=0;i<num;i++){
            String s = bf.readLine();
            int[] answer = isPalindrome(s);
            System.out.println(answer[0] + " " + answer[1]);
        }

    }

    public static int[] recursion(String s, int l, int r){
        if(l>=r) return new int[]{1, l+1};
        else if (s.charAt(l)!=s.charAt(r)) return new int[]{0,l+1};
        else return recursion(s,l+1,r-1);
    }

    public static int[] isPalindrome(String str){
        return recursion(str,0,str.length()-1);
    }

}
