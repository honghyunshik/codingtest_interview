package org.example.programmers2;

import java.util.*;
class four {

    public static void main(String[] args){

        four f = new four();

        int[][] input = {{3,6,4},{4,2,5},{1,0,5},{5,0,5}};
        System.out.println(Arrays.toString(f.solution(input)));

    }

    public long[] solution(int[][] programs) {
        long[] answer = new long[11];
        //0 : priority    1 : start     2 : len
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);        //시간 빠른순으로 정렬
        PriorityQueue<int[]> wait = new PriorityQueue<>((a,b)->a[0]-b[0]);     //우선순위 높은거부터 정렬
        for(int i=0;i<programs.length;i++){
            pq.add(programs[i]);
        }

        int now = 0;
        while(!pq.isEmpty()){
            int[] pop = pq.poll();
            System.out.println(Arrays.toString(pop) + " " + now );
            //0 : priority    1 : start     2 : len
            //바로 시작가능
            if(now<=pop[1]){
                //대기하는 프로그램이 있고 그 프로그램이 우선순위가 더 높을경우
                if(!wait.isEmpty()&&wait.peek()[0]<pop[0]){
                    int[] waitPop = wait.poll();
                    answer[waitPop[0]] += now-waitPop[1];
                    now += waitPop[2];
                    wait.add(pop);
                }
                //그외에는 현재프로그램을 바로시작
                else{
                    now = pop[1] + pop[2];
                }
            }else{
                wait.add(pop);
            }
        }
        System.out.println(now + "\n\n");

        //남은 대기열
        while(!wait.isEmpty()){
            int[] pop = wait.poll();
            System.out.println(Arrays.toString(pop) + " " + now );
            //0 : priority    1 : start     2 : len
            //대기했다면
            if(now>pop[1]){
                answer[pop[0]] += now-pop[1];
                now += pop[2];
            }else{
                now = pop[1] + pop[2];
            }
        }
        answer[0] = now;

        return answer;
    }
}
