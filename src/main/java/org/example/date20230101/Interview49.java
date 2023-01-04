package org.example.date20230101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Interview49 {

    static int N;
    static HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            map.put(i,new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            ArrayList<Integer> left_l = map.get(left);
            left_l.add(right);
            map.put(left,left_l);

            ArrayList<Integer> right_r = map.get(right);
            right_r.add(left);
            map.put(right,right_r);
        }
        findLeafTree();

        for(int key:map.keySet()){
            System.out.print(key + " ");
        }
    }

    public static void solution(int startNum){


    }

    //리프 트리를 찾아낸다
    public static void findLeafTree(){


        while(true){

            //리프 노드는 연결된 노드가 하나인 노드
            ArrayList<Integer> leaf = new ArrayList<>();
            for(int key:map.keySet()){
                if(map.get(key).size()==1){
                    leaf.add(key);
                }
            }

            if(leaf.size()>=map.size()|| map.size() == 1) break;

            for(int key:leaf){
                int l = map.get(key).get(0);
                ArrayList<Integer> temp = map.get(l);
                temp.remove(Integer.valueOf(key));
                map.put(l,temp);
                map.remove(key);
            }
        }

    }


}
