package org.example.baekjoon3109;

import org.example.kakao3.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

    static Character[][] pipe;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        pipe = new Character[r][c];
        for(int i=0;i<r;i++){
            String input = br.readLine();
            for(int j=0;j<c;j++){
                pipe[i][j] = input.charAt(j);
            }
        }
        visited = new boolean[r][c];
        Main main = new Main();
        for(int i=0;i<r;i++){
            main.maxPipe(i,0);
        }
        System.out.println(answer);

    }

    public boolean maxPipe(int row, int col){

        if(col==visited[0].length-1) {
            answer ++;
            return true;
        }

        int[][] D = {{-1,1},{0,1},{1,1}};
        for(int i=0;i<D.length;i++){
            int nextRow = row + D[i][0];
            int nextCol = col + D[i][1];
            if(nextRow<0||nextRow>visited.length-1||nextCol<0||nextCol>visited[0].length-1) continue;
            if(pipe[nextRow][nextCol]=='x') continue;
            if(visited[nextRow][nextCol]) continue;
            visited[nextRow][nextCol] = true;
            boolean check = maxPipe(nextRow,nextCol);
            if(check) return true;
        }

        return false;
    }
}
