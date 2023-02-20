package org.example.hotel;

import java.util.*;
public class Solution {

    public int solution(String[][] book_time) {
        int answer = 0;
        Time[] time = new Time[book_time.length];
        for(int i=0;i<book_time.length;i++){
            time[i] = new Time(book_time[i][0],book_time[i][1]);
        }
        Arrays.sort(time);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<time.length;i++){

            int now_start = time[i].start;
            int now_end = time[i].end;
            while(!pq.isEmpty()&&pq.peek()<=now_start){
                pq.poll();
            }
            pq.add(now_end);
            answer = Math.max(answer,pq.size());
        }
        return answer;
    }
}

class Time implements Comparable<Time>{

    int start, end;

    @Override
    public int compareTo(Time o){
        if(this.start==o.start){
            return o.end-this.end;
        }
        return this.start-o.start;
    }

    int getTime(String time, boolean isEnd){

        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        if(isEnd) minute += 10;
        return hour*60 + minute;
    }

    Time(String startTime, String endTime){
        start = getTime(startTime,false);
        end = getTime(endTime,true);
    }
}