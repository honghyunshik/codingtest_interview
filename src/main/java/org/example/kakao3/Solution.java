package org.example.kakao3;

public class Solution {

    public static void main(String[] args){

        Solution sol = new Solution();
        //System.out.println(sol.solution(3,4,2,3,3,1,5));
        //System.out.println(sol.solution(2,2,1,1,2,2,2));
        //System.out.println(sol.solution(3,3,1,2,3,3,4));
        //System.out.println(sol.solution(2,1,0,0,1,0,5));
        //System.out.println(sol.solution(3,1,0,0,3,1,6));
        System.out.println(sol.solution(1,3,1,3,1,1,2));

    }


    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        //n,m은 각각 세로 좌표, 가로 좌표
        //x,y는 출발 위치를 뜻하는 좌표
        //r,c 는 탈출 지점을 나타내는 좌표
        //k는 탈출해야 하는 이동거리

        String answer = "";
        int minNum = Math.abs(x-r) + Math.abs(y-c);     //최소 걸리는 시간
        if(minNum%2!=k%2||minNum>k) return "impossible";        //최소 걸리는 시간보다 k가 작거나 2로 나누엇을때 나머지가 다를경우 불가능

        //최대한 d, l, r , u순서대로 이동해야 한다
        //얼마나 많이 d를 이동할 수 있냐?
        int spare = k-minNum;       //여유분


        //아래로 이동하는게 베스트
        int count = 0;
        if(x<r){
            for(int i=0;i<r-x;i++){
                answer += "d";
                count++;
            }
            x=r;
        }




        //그다음은 왼쪽으로 이동한느것
        if(y>c){
            for(int i=0;i<y-c;i++){
                answer += "l";
            }
            y=c;
        }

        if(spare!=0&&y<m){

            for(int i=0;i<spare/2;i++){
                answer += "rl";
            }
            spare = 0;
        }

        //그다음은 오른쪽으로 이동하는것
        if(y<c){
            for(int i=0;i<c-y;i++){
                answer += "r";
            }
            y=c;
        }
        if(spare!=0){
            for(int i=0;i<spare/2;i++){
                answer += "ud";
            }
        }

        //마지막은 위로 이동하는것
        if(x>r){
            for(int i=0;i<x-r;i++){
                answer += "u";
            }
            x=r;
        }



        return answer;
    }
}
