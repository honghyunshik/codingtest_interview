package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {

    static int target;
    static boolean[] check;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        check = new boolean[target*2+1];


        System.out.println(bfs(N));

    }

    public static int bfs(int num){

        class Move{
            int num, count;
            Move(int num, int count){
                this.num = num;
                this.count = count;
            }
        }

        if(target<=num){
            return num-target;
        }
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(num,0));
        check[num] = true;





        while(!queue.isEmpty()){

            Move now = queue.remove();
            if(now.num==target){
                return now.count;
            }

            if(now.num+1>0&&now.num+1<check.length&&!check[now.num+1]){
                queue.add(new Move(now.num+1,now.count+1));
                check[now.num+1] = true;
            }
            if(now.num-1>0&&now.num-1<check.length&&!check[now.num-1]) {
                queue.add(new Move(now.num-1,now.count+1));
                check[now.num-1] = true;
            }
            if(now.num*2>0&&now.num*2<check.length&&!check[now.num*2]) {
                queue.add(new Move(now.num*2,now.count+1));
            }
        }

        return -1;
    }
}
