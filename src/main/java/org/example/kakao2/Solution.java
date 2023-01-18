package org.example.kakao2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    static String[][] array;
    static HashMap<String, HashSet<String>> map;

    public static void main(String[] args){

        Solution sol = new Solution();
        String[] input1 = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        String[] input2 = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
        String[] input3 = {"UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 4 4", "UNMERGE 3 3", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"};
        String[] answer = sol.solution(input3);
        System.out.println(Arrays.toString(answer));
    }

    public String[] solution(String[] commands) {

        ArrayList<String> ans = new ArrayList<>();

        array = new String[50][50];
        map = new HashMap<>();

        //HashMap안에 HashSet을 넣어주고, 자기 자신도 넣어준다
        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++){
                HashSet<String> set = new HashSet<>();
                set.add(i+","+j);
                map.put(i+","+j,set);
            }
        }
        for(String str:commands){
            String[] command = str.split(" ");
            if(command[0].equals("UPDATE")){
                if(command.length==4){
                    update(Integer.parseInt(command[1])-1,Integer.parseInt(command[2])-1,command[3]);
                }else if(command.length==3){
                    update(command[1],command[2]);
                }
            }else if(command[0].equals("MERGE")){
                merge(Integer.parseInt(command[1])-1,Integer.parseInt(command[2])-1,Integer.parseInt(command[3])-1,Integer.parseInt(command[4])-1);
            }else if(command[0].equals("UNMERGE")){
                unMerge(Integer.parseInt(command[1])-1,Integer.parseInt(command[2])-1);
            }else if(command[0].equals("PRINT")){
                String temp = array[Integer.parseInt(command[1])-1][Integer.parseInt(command[2])-1];
                if(temp==null) ans.add("EMPTY");
                else ans.add(temp);
            }
        }
        String[] answer = new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }

        return answer;

    }

    public void update(int r, int c, String val){

        HashSet<String> set = map.get(r+","+c);
        for(String str:set){
            int row = Integer.parseInt(str.split(",")[0]);
            int col = Integer.parseInt(str.split(",")[1]);
            array[row][col] = val;
        }
    }

    public void update(String val1, String val2){

        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++){
                if(array[i][j]==null) continue;
                if(array[i][j].equals(val1)) array[i][j] = val2;
            }
        }
    }

    public void merge(int r1, int c1, int r2, int c2){

        if(r1==r2&&c1==c2) return;      //같은 셀일 경우 무시

        String for1 = r1+","+c1;
        String for2 = r2+","+c2;
        HashSet<String> set1 = map.get(for1);
        HashSet<String> set2 = map.get(for2);
        String val = null;
        if(array[r1][c1]!=null) {
            val = array[r1][c1];
            for(String str:set2){
                int row = Integer.parseInt(str.split(",")[0]);
                int col = Integer.parseInt(str.split(",")[1]);
                array[row][col] = val;
                set1.add(str);
            }
        }
        else if(array[r2][c2]!=null){
            val = array[r2][c2];
            for(String str:set1){
                int row = Integer.parseInt(str.split(",")[0]);
                int col = Integer.parseInt(str.split(",")[1]);
                array[row][col] = val;
                set2.add(str);
            }
        }

        if(set1.size()>set2.size()){
            for(String str:set1){
                map.put(str,set1);
            }
        }else{
            for(String str:set2){
                map.put(str,set2);
            }
        }



    }

    public void unMerge(int r, int c){

        HashSet<String> set = map.get(r+","+c);
        //현재 점과 병합된 점들
        for(String str:set){

            int row = Integer.parseInt(str.split(",")[0]);
            int col = Integer.parseInt(str.split(",")[1]);
            if(row==r&&col==c) continue;
            HashSet<String> nowSet = new HashSet<>();
            nowSet.add(str);
            map.put(str,nowSet);
            array[row][col] = null;
         }
        HashSet<String> nowSet = new HashSet<>();
        nowSet.add(r+","+c);
        map.put(r+","+c,nowSet);



    }

}
