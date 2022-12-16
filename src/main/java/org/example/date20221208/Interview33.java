package org.example.date20221208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//2에서 9까지 숫자가 주어졌을 때 전화 번호로 조합 가능한 모든 문자를 출력하라
public class Interview33 {

    static String[][] PHONE = {{},{},{"a","b","c"}, {"d","e","f"}, {"g","h","i"},
            {"j","k","l"}, {"m","n","o"}, {"p","q","r","s"},
            {"t","u","v"}, {"w","x","y","z"}};

    static ArrayList<String> answer = new ArrayList<>();
    static int[] enteredNum = new int[10];
    static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = input.length();

        for(int i=0;i<input.length();i++){
            enteredNum[i] = Integer.parseInt(input.split("")[i]);
        }

        for(int i=0;i<PHONE[enteredNum[0]].length;i++){
            dfs(0,i,"");
        }

        for(String str:answer){
            System.out.print(str + " ");
        }


    }

    public static void dfs(int num, int charIndex, String prev){

        prev += PHONE[enteredNum[num]][charIndex];
        if(prev.length()==N) {
            answer.add(prev);
            return;
        }

        for(int i=0;i<PHONE[enteredNum[num+1]].length;i++){
            dfs(num+1,i,prev);
        }



    }
}
