package org.example.baekjoon2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        //전체 사람 수
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list.get(parent).add(child);
            list.get(child).add(parent);
        }

        Solution sol = new Solution();
        System.out.println(sol.bfs(first, second, n , list));
    }

}

class Solution{


    public int bfs(int first, int second, int n, ArrayList<ArrayList<Integer>> list){

        Queue<Node> queue = new LinkedList<>();
        int[][] visited_1 = new int[n+1][2];      //0은 미방문 1은 방문, 뒤에는 방문했을때의 count
        int[][] visited_2 = new int[n+1][2];      //0은 미방문 1은 방문, 뒤에는 방문했을때의 count
        queue.add(new Node(first, 0,1));
        queue.add(new Node(second,0,2));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int now_from = now.from;
            int now_val = now.val;
            int now_count = now.count;
            //Node가 1에서부터 출발한 노드라면
            if(now_from==1){
                //이미 방문한 노드이면 continue
                if(visited_1[now_val][0]==1){
                    continue;
                }
                //방문하지 않았다면 방문한 값을 visited에 저장
                else{
                    visited_1[now_val] = new int[]{1,now_count};
                }
                //visited_2에서 이미 방문한 Node이면
                if(visited_2[now_val][0]==1){
                    return now.count + visited_2[now_val][1];
                }

            }else{
                //이미 방문한 노드이면 continue
                if(visited_2[now_val][0]==1){
                    continue;
                }
                //방문하지 않았다면 방문한 값을 visited에 저장
                else{
                    visited_2[now_val] = new int[]{1,now_count};
                }
                //visited_1에서 이미 방문한 Node이면
                if(visited_1[now_val][0]==1){
                    return now_count + visited_2[now_val][1];
                }
            }
            for(int num:list.get(now_val)){
                queue.add(new Node(num,now_count+1, now_from));
            }
        }

        return -1;
    }
}

class Node{
    int val, count, from;
    Node(int val, int count, int from){
        this.val = val;
        this.count = count;
        this.from = from;
    }
}
