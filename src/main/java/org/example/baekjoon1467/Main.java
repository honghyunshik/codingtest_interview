package org.example.baekjoon1467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String input2 = br.readLine();
        int[][] delete = new int[10][1];
        for(int i=0;i<input2.length();i++){
            int num = input2.charAt(i)-48;
            delete[num][0]++;
        }

        for(int i=0;i<=9;i++){
            if(delete[i][0]>0){

                PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);        //오름차순 정렬
                int k = delete[i][0];

                int cnt = 0;
                //다음숫자가 커지면 최대한 앞에거를 바꿈
                for(int j=0;j<input.length()-1;j++){
                    if(input.charAt(j)-48==i) cnt++;
                    if(input.charAt(j)-48==i&&input.charAt(j)<=input.charAt(j+1)){
                        if(input.charAt(j)==input.charAt(j+1)){
                            int temp = j;
                            while(temp<input.length()-1&&input.charAt(temp)==input.charAt(temp+1)){
                                temp++;
                            }
                            if(temp<input.length()-1&&input.charAt(temp)<input.charAt(temp+1)){
                                pq.add(j);
                                k--;
                                if(k==0) break;
                            }
                        }
                        else{
                            pq.add(j);
                            k--;
                            if(k==0) break;
                        }
                    }
                }

                //다음숫자가 작아지면 최대한 뒤에거를 바꿈
                if(k>0&&cnt>pq.size()){
                    for(int j=input.length()-1;j>=0;j--){
                        if(!pq.isEmpty()&&pq.peek()==j) continue;
                        if(input.charAt(j)-48==i){
                            pq.add(j);
                            k--;
                            if(k==0) break;
                        }
                    }
                }
                String newInput = "";

                for(int j=0;j<input.length();j++){
                    if(!pq.isEmpty()&&pq.peek()==j){
                        pq.poll();
                    }else{
                        newInput += input.charAt(j);
                    }
                }
                input = newInput;
            }
        }
        System.out.println(input);
    }

}
