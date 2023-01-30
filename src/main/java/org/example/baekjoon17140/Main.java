package org.example.baekjoon17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());       //찾는 row값
        int c = Integer.parseInt(st.nextToken());       //찾는 col값
        int k = Integer.parseInt(st.nextToken());       //target
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<=3;i++){
            list.add(new ArrayList<>());
            if(i==0) continue;
            st = new StringTokenizer(br.readLine(), " ");
            list.get(i).add(0);
            for(int j=0;j<3;j++){
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        Solution sol = new Solution();
        sol.getMinMinute(list,r,c,k,0);
        System.out.println(sol.answer);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    }
}

class Solution{

    int answer = 0;
    void getMinMinute(ArrayList<ArrayList<Integer>> list, int r, int c, int k, int ans){

        if(ans>100){
            answer = -1;
            return;
        }
        if(r<list.size()&&c<list.get(1).size()&&list.get(r).get(c)==k){
            answer = ans;
            return;
        }else{
            int row_size = list.size();
            int col_size = list.get(1).size();
            ArrayList<ArrayList<Integer>> new_list = null;
            if(row_size>=col_size){
                new_list = R(list);
            }else{
                new_list = L(list);
            }
            getMinMinute(new_list,r,c,k,ans+1);
        }
    }

    ArrayList<ArrayList<Integer>> R(ArrayList<ArrayList<Integer>> list){

        int max = getMaxR(list);
        ArrayList<ArrayList<Integer>> new_list = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            new_list.add(new ArrayList<>());
            new_list.get(i).add(0);
            if(i==0) continue;
            HashMap<Integer,Integer> map = new HashMap<>();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int j=1;j<list.get(i).size();j++){
                if(list.get(i).get(j)==0) continue;
                map.put(list.get(i).get(j),map.getOrDefault(list.get(i).get(j),0)+1);
            }
            map.forEach((key, value)->{
                pq.add(new Node(key,value));
            });
            int count = 0;
            while(!pq.isEmpty()){
                if(count>100) break;
                Node now = pq.poll();
                new_list.get(i).add(now.val);
                new_list.get(i).add(now.count);
                count += 2;
            }

            //모자란 만큼 0 추가
            for(;count<max;count++){
                new_list.get(i).add(0);
            }
        }

        return new_list;
    }

    ArrayList<ArrayList<Integer>> L(ArrayList<ArrayList<Integer>> list){

        int max = getMaxL(list);
        ArrayList<ArrayList<Integer>> new_list = new ArrayList<>();

        for(int i=0;i<=max;i++){
            new_list.add(new ArrayList<>());
            new_list.get(i).add(0);
        }

        for(int i=1;i<list.get(1).size();i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int j=1;j<list.size();j++){
                if(list.get(j).get(i)==0) continue;
                map.put(list.get(j).get(i),map.getOrDefault(list.get(j).get(i),0)+1);
            }
            map.forEach((key, value)->{
                pq.add(new Node(key,value));
            });
            int count = 1;
            while(!pq.isEmpty()){
                if(count>100) break;
                Node now = pq.poll();
                new_list.get(count++).add(now.val);
                new_list.get(count++).add(now.count);
            }
            //모자란 만큼 0 추가
            for(;count<=max;count++){
                new_list.get(count).add(0);
            }

        }
        return new_list;
    }


    //늘어나는 행의 크기를 반환
    int getMaxR(ArrayList<ArrayList<Integer>> list){
        int max = 0;
        for(int i=1;i<list.size();i++){
            HashSet<Integer> temp = new HashSet<>();
            for(int j=1;j<list.get(1).size();j++){
                if(list.get(i).get(j)==0) continue;
                temp.add(list.get(i).get(j));
            }
            max = Math.max(max,temp.size());
        }
        max = Math.min(50,max)*2;
        return Math.max(list.get(1).size()-1,max);
    }

    //늘어나는 열의 크기를 반환
    int getMaxL(ArrayList<ArrayList<Integer>> list){
        int max = 0;
        for(int i=1;i<list.get(1).size();i++){
            HashSet<Integer> temp = new HashSet<>();
            for(int j=1;j<list.size();j++){
                if(list.get(j).get(i)==0) continue;
                temp.add(list.get(j).get(i));
            }
            max = Math.max(max,temp.size());
        }
        max=  Math.min(50,max)*2;
        return Math.max(list.size()-1,max);
    }
}

class Node implements Comparable<Node>{
    int val, count;
    Node(int val, int count){
        this.val = val;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        if(this.count==o.count){
            return this.val - o.val;
        }
        return this.count - o.count;

    }
}