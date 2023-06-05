package org.example.카드짝맞추기;

import java.lang.reflect.Array;
import java.util.*;
class Solution {

    static HashMap<Integer, ArrayList<int[]>> map;
    static boolean[] visited;
    static int[][] D = {{0,1},{1,0},{-1,0},{0,-1}};
    static int[][] BOARD;
    static int cnt = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args){


        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        Solution sol = new Solution();
        sol.solution(board,1,0);
    }

    public int solution(int[][] board, int r, int c) {

        BOARD = board;
        map = new HashMap<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]>0){
                    ArrayList<int[]> now = map.get(board[i][j]);
                    if(now==null) now = new ArrayList<>();
                    now.add(new int[]{i,j});
                    map.put(board[i][j],now);
                    cnt++;
                }
            }
        }
        cnt/=2;
        visited = new boolean[cnt+1];

        //getDis(1,0,3,0);
        //getDis(3,0,3,2);
        getDis(1,0,3,2);
        //getDis(3,0,3,3);
        for(int i=1;i<=cnt;i++){
            visited[i] = true;
            //bfs(r,c,i,0);
            visited[i] = false;
        }

        return answer;
    }


    public void bfs(int r, int c, int num, int dis){

        //System.out.println("r : " + r + " c : " + c + " num : " + num +
          //      " dis : " + dis);

        int[] target1 = map.get(num).get(0);
        int[] target2 = map.get(num).get(1);


        int x1 = target1[0];
        int y1 = target1[1];
        int x2 = target2[0];
        int y2 = target2[1];

        //System.out.println("num : " + num + " dis : " + dis);


        boolean flag = true;
        for(int i=1;i<=cnt;i++){
            if(!visited[i]){
                visited[i] = true;
                flag = false;
                /*System.out.println("x1 : " + r + " y1 : " + c + " x2 : "
                        + x2 + " y2 : " + y2 + " dis : " + getDis(r,c,x2,y2));

                System.out.println("x1 : " + x2 + " y1 : " + y2 + " x2 : "
                        + x1 + " y2 : " + y1 + " dis : " + getDis(x2,y2,x1,y1));
               */
                bfs(x1,y1,i,dis + getDis(r,c,x2,y2) + getDis(x2,y2,x1,y1) + 2);
                bfs(x2,y2,i,dis + getDis(r,c,x1,y1) + getDis(x1,y1,x2,y2) + 2);
                visited[i] = false;
            }
        }
        if(flag){
            answer = Math.min(answer,dis);
        }

    }

    private int getDis(int x1, int y1, int x2, int y2){

        class Node{
            int x,y,dis;
            Node(int x, int y, int dis){
                this.x = x;
                this.y = y;
                this.dis = dis;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x1,y1,0));
        boolean[][] vis = new boolean[4][4];
        while(!queue.isEmpty()){

            Node node = queue.poll();
            System.out.println("x : " + node.x + " y : " + node.y +
                            " dis : " + node.dis);
            if(vis[node.x][node.y]) continue;
            vis[node.x][node.y] = true;
            /*for(int j=0;j<4;j++){
                System.out.println(Arrays.toString(vis[j]));
            }
            System.out.println("\n\n");*/
            int dis = node.dis;

            if(node.x==x2&&node.y==y2) {
               return dis;
            }


            for(int i=0;i<4;i++){

                int nextX = node.x + D[i][0];
                int nextY = node.y + D[i][1];
                if(nextX<0||nextX>3||nextY<0||nextY>3) continue;
                if(vis[nextX][nextY]) continue;
                queue.add(new Node(nextX, nextY, dis+1));

                int ctrlX = nextX + D[i][0];
                int ctrlY = nextY + D[i][1];

                while(D[i][0]!=0&&(ctrlX!=x2||nextY!=y2)&&ctrlX>=0&&ctrlX<=3&&(BOARD[ctrlX][nextY]==0||visited[BOARD[ctrlX][nextY]])){
                    ctrlX += D[i][0];
                }

                while(D[i][1]!=0&&ctrlY>=0&&(nextX!=x2||ctrlY!=y2)&&ctrlY<=3&&(BOARD[nextX][ctrlY]==0||visited[BOARD[nextX][ctrlY]])){
                    ctrlY += D[i][1];
                }
                if(ctrlX<0||ctrlX>3) ctrlX -= D[i][0];
                if(ctrlY<0||ctrlY>3) ctrlY -= D[i][1];


                if(!vis[ctrlX][ctrlY]){
                    vis[ctrlX][ctrlY] = true;
                    queue.add(new Node(ctrlX,ctrlY,dis+1));
                }
                if(!vis[ctrlX][ctrlY]){
                    vis[ctrlX][ctrlY] = true;
                    queue.add(new Node(ctrlX,ctrlY,dis+1));
                }

            }
        }

        return -1;
    }
}