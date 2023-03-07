package org.example.taja;

import java.util.*;


class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[][] D = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
    public int solution(String numbers) {

        int leftL=1, leftR=0, rightL = 1, rightR = 2;
        getAnswer(numbers);
        return answer;
    }

    public void getAnswer(String numbers){

        Queue<Button> queue = new LinkedList<>();
        int[] arr = getButton(numbers.charAt(0));
        queue.add(new Button(1,0,arr[0],arr[1],getPoint(1,2,arr[0],arr[1]),1));
        queue.add(new Button(arr[0],arr[1],1,2,getPoint(arr[0],arr[1],1,0),1));
        while(!queue.isEmpty()){
            Button now = queue.poll();

            if(answer<now.dis) continue;
            if(now.idx==numbers.length()){
                answer = now.dis;
                continue;
            }
            arr = getButton(numbers.charAt(now.idx));
            if(arr[0]==now.leftL&&arr[1]==now.leftR){
                queue.add(new Button(now.leftL,now.leftR,now.rightL,now.rightR,now.dis+1,now.idx+1));
            }
            else if(arr[0]==now.rightL&&arr[1]==now.rightR){
                queue.add(new Button(now.leftL,now.leftR,now.rightL,now.rightR,now.dis+1,now.idx+1));
            }else {
                //오른손이 이미 l,r에 있을 때가 아니면
                if (arr[0] != now.rightL || arr[1] != now.rightR) {
                    queue.add(new Button(arr[0], arr[1], now.rightL, now.rightR, now.dis + getPoint(now.leftL, now.leftR, arr[0], arr[1]), now.idx + 1));
                }
                //왼손이 이미 l,r에 있을 때가 아니면
                if (arr[0] != now.leftL || arr[1] != now.leftR) {
                    queue.add(new Button(now.leftL, now.leftR, arr[0], arr[1], now.dis + getPoint(now.rightL, now.rightR, arr[0], arr[1]), now.idx + 1));
                }
            }
        }

    }
    public int getPoint(int startL, int startR, int endL, int endR){
        if(startL==endL&&startR==endR){
            return 1;
        }else{
            int min = Math.min(Math.abs(startL-endL),Math.abs(startR-endR));
            return min*3 + (Math.abs(startL-endL)-min)*2 + (Math.abs(startR-endR)-min)*2;
        }
    }

    public int[] getButton(char now){
        int[] arr = new int[2];
        int idx = -1;
        if(now=='*'){
            idx = 10;
        }else if(now=='#'){
            idx = 11;
        }else idx = now-48;
        arr[0] = D[idx][0];
        arr[1] = D[idx][1];
        return arr;
    }
}

class Button{
    int leftL, leftR, rightL, rightR, dis,idx;
    Button(int leftL, int leftR, int rightL, int rightR, int dis, int idx){
        this.leftL = leftL;
        this.leftR = leftR;
        this.rightL = rightL;
        this.rightR = rightR;
        this.dis = dis;
        this.idx = idx;
    }
}