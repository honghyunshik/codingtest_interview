package org.example.hotel;

import java.util.*;
public class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String[][] book_time = {{"09:10","10:10"},{"10:10","5:20"},{"23:30","10:00"}};
        System.out.println(sol.solution(book_time));
    }


    public int solution(String[][] book_time) {
        ArrayList<ArrayList<int[]>> room = new ArrayList<>();
        for(String[] book:book_time){
            int start = Integer.parseInt(book[0].replace(":",""));
            int end = Integer.parseInt(book[1].replace(":","")) + 10;
            boolean isIn = false;
            for(ArrayList<int[]> list:room){
                boolean check = false;      //false면 안겹치는거 true면 겹치는거

                for(int[] one:list){
                    int start_one = one[0];
                    int end_one = one[1];
                    if(start_one>end_one){
                        //둘다 24시를 기준으로 오버될 때
                        if(start>end){
                            check = true;
                            break;
                        }
                        //one은 24시를 기준으로 오버되고 그냥은 아닐때
                        else{
                            if(start>=start_one||end>=start_one||start<end_one+10||end<end_one+10){
                                check = true;
                                break;
                            }
                        }
                    }else{
                        //그냥은 24시를 기준으로 오버되고 one은 아닐때
                        if(start>end){
                            if(start_one>=start||end_one>=start||start_one<end+10||end_one<end+10){
                                check = true;
                                break;
                            }
                        }else{
                            if(start_one<=start&&end_one+10>start||start_one<=end&&end_one+10>end||start<=start_one&&end+10>start_one||start<=end_one&&end+10>end_one){
                                check = true;
                                break;
                            }
                        }
                    }

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