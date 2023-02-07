package org.example.kakao4;

import java.util.ArrayList;
import java.util.Arrays;

public class W {
    public static void main(String[] args){
        Solution_1 sol = new Solution_1();
        String today = "2019.01.01";
        String[] terms = {"B 14"};
        String[] privacies = {"2017.10.21 B"};
        System.out.println(Arrays.toString(sol.solution(today,terms,privacies)));

    }
}


class Solution_1 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> ans = new ArrayList<>();

        int[][] privacies_int = new int[privacies.length][3];
        for(int i=0;i<privacies.length;i++){
            String s = privacies[i];
            String[] temp = s.split("\\.");
            int year = Integer.parseInt(temp[0]);
            int month = Integer.parseInt(temp[1]);
            String three = temp[2];
            int day = Integer.parseInt(three.split(" ")[0]);
            String now_term = three.split(" ")[1];
            String front = "";
            int delay = 0;
            for(String term:terms){
                temp = term.split(" ");
                front = temp[0];
                delay = Integer.parseInt(temp[1]);
                if(front.equals(now_term)) break;
            }
            if(delay>0){
                if(day==1){
                    month--;
                    day=28;
                    if(month==0){
                        year--;
                        month = 12;
                    }
                }else{
                    day--;
                }
                month += delay;
                if(month>12){
                    year += month/12;
                    month = month%12;
                    if(month==0) {
                        month = 12;
                        year--;
                    }
                }
            }
            String[] today_lst = today.split("\\.");
            int today_year = Integer.parseInt(today_lst[0]);
            int today_month = Integer.parseInt(today_lst[1]);
            int today_day = Integer.parseInt(today_lst[2]);
            boolean check = false;
            System.out.println(year + " " + today_year);
            System.out.println(month + " " + today_month);
            System.out.println(day + " " + today_day);
            System.out.println();
            System.out.println();
            if(today_year>year){
                check = true;
            }else if(today_year==year){
                if(today_month>month){
                    check = true;
                }else if(today_month==month){
                    if(today_day>day){
                        check = true;
                    }
                }
            }
            if(check){
                ans.add(i+1);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }
        Arrays.sort(answer);
        return answer;


    }


}

