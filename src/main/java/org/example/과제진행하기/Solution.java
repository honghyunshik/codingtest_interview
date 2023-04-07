package org.example.과제진행하기;

import java.util.*;
class Solution {
    //기존 진행중 과제 멈추고 새로운 과제 시작
    //과제 끝난 후 새로 시작해야 하는 과제 시작
    //없으면 멈춰둔 과제 시작
    //멈춰둔게 여러개면 최근에 멈춘 과제부터 시작
    //0 : name   1 : start    2 : playtime
    //시작 순서대로 우선순위큐

    public static void main(String[] args){
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        String[][] plans2 = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        Solution sol = new Solution();
        String[] ans = sol.solution(plans2);
        System.out.println(Arrays.toString(ans));
    }
    public String[] solution(String[][] plans) {

        Node[] list = new Node[plans.length];
        for(int i=0;i<plans.length;i++){
            list[i] = new Node(plans[i][0],plans[i][1],plans[i][2]);
        }
        Arrays.sort(list,(a,b)->a.start-b.start);
        Stack<Node> stack = new Stack<>();
        String[] answer = new String[plans.length];
        int idx = 0;
        for(int i=0;i<list.length-1;i++){
            Node now = list[i];
            Node next = list[i+1];
            int nowStart = now.start;
            int nowPlayTime = now.playTime;
            int nextStart = next.start;
            //현재 과제를 다 완료할 수 있다
            if(nowStart+nowPlayTime<=nextStart){
                answer[idx++] = now.name;
                //다 완료한 후 남은 시간만큼 이전 과제들 수행
                int leftTime = nextStart-nowStart-nowPlayTime;
                if(leftTime>0){
                    while(!stack.isEmpty()&&stack.peek().playTime<=leftTime){
                        Node temp = stack.pop();
                        answer[idx++] = temp.name;
                        leftTime -= temp.playTime;
                    }
                    if(leftTime>0){
                        stack.peek().playTime -= leftTime;
                    }
                }
            }
            //현재 과제를 다 완료할 수 없다
            else{
                now.playTime = nowStart + nowPlayTime - nextStart;
                stack.add(now);
            }
        }
        answer[idx++] = list[list.length-1].name;
        while(!stack.isEmpty()){
            answer[idx++] = stack.pop().name;
        }

        return answer;
    }

    //시간 변환 함수
    int getTime(String str){
        String[] list = str.split(":");
        int hour = Integer.parseInt(list[0]);
        int time = Integer.parseInt(list[1]);
        return hour*60+time;
    }
    class Node{
        String name;
        int start,playTime;
        Node(String name, String start, String playTime){
            this.name = name;
            this.start = getTime(start);
            this.playTime = Integer.parseInt(playTime);
        }
    }

}

