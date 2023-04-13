package org.example.광고삽입;
import java.util.*;

class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String[] logs = {"00:00:01-00:00:06","00:00:01-00:00:04","00:00:01-00:00:03"};
        System.out.println(sol.solution("00:00:10","00:00:01",logs));
    }
    public String solution(String play_time, String adv_time, String[] logs) {

        int play = strToInt(play_time);     //총 상영시간
        int ad = strToInt(adv_time);        //총 광고시간
        //빨리 끝나는 순서대로 정렬
        int[] cntList = new int[play+1];
        for(int i=0;i<logs.length;i++){
            String[] log = logs[i].split("-");
            int start = strToInt(log[0]);
            int end = strToInt(log[1]);
            for(int j=start;j<end;j++){
                cntList[j]++;
            }
        }

        for(int i=0;i<play;i++){
            cntList[i+1]+=cntList[i];
        }

        long max = cntList[ad-1];
        long sum = 0;
        int start = 0;


        System.out.println(Arrays.toString(cntList));

        //i는 start고 i+ad가 end
        for(int i=1;i<play-ad;i++){

            if(max<cntList[i+ad-1]-cntList[i-1]){
                max = cntList[i+ad-1]-cntList[i-1];
                start = i;
            }
        }
        String answer = intToStr(start);

        return answer;
    }

    private String intToStr(int num){

        int hour = num/3600;
        num %= 3600;
        int minute = num/60;
        num %= 60;
        int second = num;
        String str = "";
        if(hour<10) str+="0";
        str+=hour + ":";
        if(minute<10) str+="0";
        str+=minute + ":";
        if(second<10) str+="0";
        str+=second;
        return str;
    }


    private int strToInt(String str){

        String[] p = str.split(":");
        int hour = Integer.parseInt(p[0]);
        int minute = Integer.parseInt(p[1]);
        int second = Integer.parseInt(p[2]);
        return hour*3600+minute*60+second;
    }
}
