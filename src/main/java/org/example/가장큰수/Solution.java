package org.example.가장큰수;

import java.util.*;
class Solution {

    public static void main(String[] args){

        System.out.println("3".compareTo("34"));
    }
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->b.compareTo(a));
        for(int i=0;i<numbers.length;i++){
            pq.add(numbers[i]+"");
        }
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        return answer;
    }
}