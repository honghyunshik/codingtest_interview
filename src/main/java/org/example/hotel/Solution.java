package org.example.hotel;

import java.util.*;
public class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String[][] book_time = {{"09:10","10:10"},{"10:20","5:20"}};
        System.out.println(sol.solution(book_time));
    }


    public int solution(String[][] book_time) {
        ArrayList<ArrayList<int[]>> room = new ArrayList<>();
        for(String[] book:book_time){
            int start = Integer.parseInt(book[0].replace(":",""));
            int end = Integer.parseInt(book[1].replace(":","")) + 10;
            if(end>2400) end -= 2400;
            boolean isIn = false;
            for(ArrayList<int[]> list:room){
                boolean check = false;      //false면 안겹치는거 true면 겹치는거
                for(int[] one:list){
                    int start_one = one[0];
                    int end_one = one[1] + 10;
                    if(end_one>2400) end_one -= 2400;

                }
                if(!check) {
                    list.add(new int[]{start,end});
                    isIn = true;
                    break;
                }
            }
            if(!isIn){
                ArrayList<int[]> new_r = new ArrayList<>();
                new_r.add(new int[]{start,end});
                room.add(new_r);
            }
        }
        for(ArrayList<int[]> list:room){
            for(int[] i:list){
                System.out.print(Arrays.toString(i) + "  ");
            }
            System.out.println();
        }
        int answer = room.size();
        return answer;
    }
}