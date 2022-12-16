package org.example.date20221117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon1644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(continueSum(Integer.parseInt(br.readLine())));

    }

    public static int continueSum(int num){

        int answer = 0;

        boolean[] sosu = new boolean[num+1];
        sosu[0] = sosu[1] = true;

        for(int i=2;i*i<sosu.length;i++){
            if(!sosu[i]){
                for(int j=i*2;j<sosu.length;j+=i) sosu[j] = true;
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=2;i<sosu.length;i++){
            if(!sosu[i]) arr.add(i);
        }

        int l = -1;      //제일 오른쪽 index
        int cnt = 0;        //더해진 숫자의 개수
        int tempNum = 0;

        while(l<arr.size()){

            while(tempNum<num&&arr.size()>l){
                cnt++;
                l++;
                if(arr.size()>l) tempNum += arr.get(l);

            }

            while(tempNum>num&&cnt>0){
                tempNum -= arr.get(l-cnt+1);
                cnt--;
            }

            if(tempNum==num&&l<arr.size()) {
                answer++;
                l++;
                cnt++;
                if(l<arr.size()) tempNum += arr.get(l);
            }

        }


        return answer;
    }
}
