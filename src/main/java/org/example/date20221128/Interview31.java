package org.example.date20221128;

import java.util.*;

//상위 k번 이상 등장하는 요소를 추출하라
public class Interview31 {

    public static void main(String[] args){
        System.out.println(solution(new int[]{1,1,1,2,2,3},2));

    }

    public static ArrayList<Integer> solution(int[] arr, int k){

        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap();


        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new Freq(entry.getKey(),entry.getValue()));
        }

        while(!pq.isEmpty()){
            Freq freq = pq.poll();
            if(freq.value<k) break;
            else{
                answer.add(freq.key);
            }
        }




        return answer;
    }

    static class Freq implements Comparable<Freq>{
        int key;
        int value;
        Freq(int key, int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Freq o) {
            if(this.value>o.value) return -1;
            else if(this.value<o.value) return 1;
            return 0;
        }
    }
}
