package org.example.date20221204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Floodfill {

    static final int MAX_N = 10;
    static int[][] D = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};      //점의 이동을 위한 배열
    static int N;
    static boolean[][] VISITED = new boolean[MAX_N][MAX_N];
    static int[][] Board = new int[MAX_N][MAX_N];
    static class Point{
        int row,col;
        Point(int row,int col){
            this.row = row;
            this.col = col;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String[] line = br.readLine().split(" ");
            Board[i] = Arrays.stream(line)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        String[] line = br.readLine().split(" ");
        int Row = Integer.parseInt(line[0]);
        int Col = Integer.parseInt(line[1]);
        int color = Integer.parseInt(line[2]);
        //dfs_stack(Row,Col,color);
        dfs_recursion(Row,Col,color);

        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(Board[i]));
        }

    }


    public static void dfs_recursion(int Row, int Col, int color){

        VISITED[Row][Col] = true;
        Board[Row][Col] = color;

        for(int i=0;i<4;i++){
            int tRow = Row + D[i][0], tCol = Col + D[i][1];
            if(tRow<0||tRow>N-1||tCol<0||tCol>N-1) continue;
            if(!VISITED[tRow][tCol]&&Board[tRow][tCol]!=1){
                dfs_recursion(tRow,tCol,color);
            }
        }

    }


    public static void dfs_stack(int Row, int Col, int color){

        boolean visited[][] = new boolean[MAX_N][MAX_N];
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(Row,Col));

        while(!stack.isEmpty()){

            Point curr = stack.pop();
            if(visited[curr.row][curr.col]) continue;
            System.out.println("Col : "  + curr.col + " Row : " + curr.row);

            visited[curr.row][curr.col] = true;
            Board[curr.row][curr.col] = color;

            for(int i=0;i<4;++i){
                int tRow = curr.row+D[i][1], tCol = curr.col+D[i][0];
                if(tCol<0||tCol>N-1||tRow<0||tRow>N-1) continue;
                if(visited[tRow][tCol]) continue;
                if(Board[tRow][tCol]==1) continue;
                stack.push(new Point(tRow,tCol));

            }

        }

    }
}
