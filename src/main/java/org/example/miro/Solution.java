package org.example.miro;

import java.util.*;
class Solution {

    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};

    public int solution(String[] maps) {
        int answer = 0;

        int[][] SL = new int[2][2];
        int xLen = maps[0].length();
        int yLen = maps.length;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){

                if(maps[i].charAt(j)==('S')) {
                    SL[0][0] = i;
                    SL[0][1] = j;
                }
                else if(maps[i].charAt(j)==('L')){
                    SL[1][0] = i;
                    SL[1][1] = j;
                }
            }
        }
        int x = bfs(maps, SL[0][0],SL[0][1], xLen, yLen, 'L');
        int y = bfs(maps, SL[1][0],SL[1][1], xLen, yLen, 'E');
        if(x==-1||y==-1) answer = -1;
        else answer = x + y;
        return answer;
    }


    public int bfs(String[] maps, int x, int y, int xLen, int yLen, char find){
        boolean[][] visited = new boolean[yLen][xLen];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,0));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowDis = now.dis;

            if(maps[nowX].charAt(nowY)==find) return nowDis;
            for(int i=0;i<D.length;i++){
                int nextX = nowX + D[i][0];
                int nextY = nowY + D[i][1];
                if(nextX<0||nextX>xLen-1||nextY<0||nextY>yLen-1) continue;
                if(maps[nextX].charAt(nextY)==('X')) continue;
                if(visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                queue.add(new Node(nextX,nextY,nowDis+1));
            }
        }
        return -1;
    }

}

class Node{
    int x,y,dis;
    Node(int x,int y,int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}