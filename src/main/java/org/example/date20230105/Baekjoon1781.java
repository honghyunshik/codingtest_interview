package org.example.date20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Quiz implements Comparable<Quiz>{
    int deadLine, cupNum;
    Quiz(int deadLine, int cupNum){
        this.deadLine = deadLine;
        this.cupNum = cupNum;
    }

    @Override
    public int compareTo(Quiz o) {
        if(this.deadLine==o.deadLine){
            return o.cupNum-this.cupNum;
        }
        return this.deadLine-o.deadLine;
    }
}
public class Baekjoon1781{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Quiz> pq = new PriorityQueue<>();
        PriorityQueue<Integer> temp = new PriorityQueue<>((a,b)->a-b);

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pq.add(new Quiz(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int ans = 0;
        while(!pq.isEmpty()){
            Quiz curr = pq.poll();
            temp.add(curr.cupNum);
            while(temp.size()>curr.deadLine){
                temp.poll();
            }
        }
        while(!temp.isEmpty()){
            ans += temp.poll();
        }
        System.out.println(ans);



    }

}
