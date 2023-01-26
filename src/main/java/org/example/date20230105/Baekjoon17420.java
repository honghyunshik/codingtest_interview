package org.example.date20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon17420 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        Gift[] giftList = new Gift[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            giftList[i] = new Gift(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            giftList[i].willDay = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(giftList);

        System.out.println(minNum(giftList));


    }

    public static long minNum(Gift[] giftList){

        int count = 0;
        int prevDay = 0;        //이전의 prevDay를 저장
        int sameMaxDay = 0;     //willDay가 같은 날짜 중에서 최고의 prevDay를 저장
        int prevWillDay = 0;        //이전의 willDay값 저장
        //1. 이전 선물의 남아있는 일수보다 많이 남아있어야 함

        int n = giftList.length;
        for(int i=0;i<n;i++){
            Gift gift = giftList[i];

            int lastDay = gift.lastDay;
            int willDay = gift.willDay;

            if(willDay!=prevWillDay&&prevWillDay!=0) {
                prevDay = sameMaxDay;
            }

            if(prevDay>lastDay||willDay>lastDay){
                int max = Math.max(prevDay,willDay);
                int tempCount = (int) Math.ceil(((double)max-lastDay)/30);
                count += tempCount;
                lastDay = 30*tempCount+lastDay;
            }
            sameMaxDay = Math.max(lastDay,sameMaxDay);
            prevWillDay = willDay;
        }


        return count;
    }
}



class Gift implements Comparable<Gift>{

    int lastDay, willDay;
    Gift(int lastDay){
        this.lastDay = lastDay;
    }
    @Override
    public int compareTo(Gift o) {
        if(o.willDay==this.willDay){
            return this.lastDay-o.lastDay;
        }
        return this.willDay-o.willDay;
    }
}
