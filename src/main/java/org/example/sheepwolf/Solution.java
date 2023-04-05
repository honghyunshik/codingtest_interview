package org.example.sheepwolf;//0을 최대한 많이 가야 함
//갈수 있는 0을 찾기
import java.util.*;
class Solution {
    static int answer = 0;
    static int[] info;
    static int[][] edges;
    static ArrayList<ArrayList<Integer>> childs;
    static boolean[] visited;
    int[] temp_arr = new int[3];
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        sol.solution(info,edges);
        System.out.println(answer);
    }

    private void solution(int[] info, int[][] edges) {

        Solution.info = info;
        Solution.edges = edges;
        childs = new ArrayList<>();
        for(int i=0;i<info.length;i++){
            childs.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            childs.get(parent).add(child);
        }
        visited = new boolean[info.length];
        visited[0] = true;
        for(int i=1;i<info.length;i++){
            if(info[i]==0){
                dfs(0,i,1,0);
            }
        }
    }
    private void dfs(int now,int target,int sheep, int wolf){

        System.out.println("now : " + now + " target : " + target + " sheep : " + sheep + " wolf : " + wolf + " " + Arrays.toString(visited));
        if(sheep>wolf){
            answer = Math.max(answer,sheep);
        }
        class Node{
            int now, sheep, wolf;
            Node(int now, int sheep, int wolf){
                this.now = now;
                this.sheep = sheep;
                this.wolf = wolf;
            }
        }
        //now -> target  0 -> 1
        Stack<Node> stack = new Stack<>();
        Node node = new Node(now,sheep,wolf);
        stack.add(node);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.println(temp.now + " "+ childs.get(temp.now));
            for(int i=0;i<childs.get(temp.now).size();i++){

                int next = childs.get(temp.now).get(i);

                //부모 노드를 방문했으면 count 초기화
                if(visited[temp.now]){
                    temp.wolf = node.wolf;
                    temp.sheep = node.sheep;
                }
                //양이냐 늑대냐
                if(info[next]==0) temp.sheep++;
                else temp.wolf++;

                if(temp.wolf>=temp.sheep) continue;     //늑대가 더 많으면 continue

                //다음 node가 target일 경우
                if(next==target){
                    visited[temp.now] = true;
                    node = new Node(next,temp.sheep,temp.wolf);
                    break;
                }

                stack.add(new Node(next,temp.sheep,temp.wolf));
                if(info[next]==0) temp.sheep--;
                else temp.wolf--;

            }
        }
        System.out.println("now : " + now + " target : " + target);
        //도착할 수 있는지?
        if(node.now==target){
            visited[node.now] = true;
            for(int i=0;i<info.length;i++){
                if(info[i]==0&&!visited[i]){
                    dfs(target,i,node.sheep,node.wolf);
                }
            }
        }




    }


}

