package org.example.순위검색;
import java.util.*;

class Solution {
    static HashMap<String,ArrayList<Integer>> map = new HashMap<>();


    public static void main(String[] args){
        Solution sol = new Solution();
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150",
                "cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100",
                "- and - and - and - 150"};
        System.out.println(sol.solution(info,query));
    }

    public int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];

        for(int i=0;i<info.length;i++) {

            String[] temp = info[i].split(" ");
            makeMap(0,"",temp);
        }

        for(int i=0;i<query.length;i++){
            query[i] = query[i].replaceAll(" and ","");
            String[] q = query[i].split(" ");
            ArrayList<Integer> now = map.get(q[0]);
            if(now!=null){
                Collections.sort(now);
                answer[i] = binarySearch(now,Integer.parseInt(q[1]));
            }

        }
        return answer;
    }

    private void makeMap(int idx,String now, String[] p){

        if(idx==4){
            ArrayList<Integer> list = map.get(now);
            if(list==null) list = new ArrayList<>();
            list.add(Integer.parseInt(p[4]));
            map.put(now,list);
            return;
        }
        makeMap(idx+1,now+"-",p);
        makeMap(idx+1,now+p[idx],p);
    }

    //이진탐색 lower bound
    private int binarySearch(ArrayList<Integer> list, int target){

        int l = 0, r = list.size();
        while(l<r){
            int mid = (l+r)/2;
            if(list.get(mid)<target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return list.size()-r;
    }

}