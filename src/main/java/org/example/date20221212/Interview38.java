package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//[from,to]로 구성된 항공권 목록을 이용해 JFK에서 출발하는 여행 일정을 구성하라. 여러 일정이 있는 경우 사전 어휘 순으로 방문한다.
public class Interview38 {

    static HashMap<String,ArrayList<String>> map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        sb = new StringBuilder();

        for(int i=0;i<num;i++){

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String from = st.nextToken();
            String to = st.nextToken();
            ArrayList<String> temp = map.get(from);
            if(temp==null){
                temp = new ArrayList<>();
                temp.add(to);
                map.put(from,temp);
            }else{
                temp.add(to);
                Collections.sort(temp);
                map.put(from,temp);
            }
        }

        dfs("", "JFK");

        System.out.println(sb.toString());


    }

    public static void dfs(String from, String to){

        sb.append(to + " ");

        ArrayList<String> temp = map.get(to);
        if(temp==null||temp.isEmpty()) return;
        String toto = temp.get(0);
        temp.remove(0);
        map.put("to",temp);
        dfs(to,toto);

    }

    public static void dfs_stack(String from, String to){

        class Flight{
            String from,to;
            Flight(String from, String to){
                this.from = from;
                this.to = to;
            }
            String getFrom(){
                return from;
            }
            String getTo(){
                return to;
            }
        }
        Stack<Flight> stack = new Stack<>();
        stack.push(new Flight(from,to));

        while(!stack.isEmpty()){

            Flight flight = stack.pop();

        }


    }


}
