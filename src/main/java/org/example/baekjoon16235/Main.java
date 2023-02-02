package org.example.baekjoon16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());       //땅 크기
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());       //k년 지난 후 살아남은 나무 수 출력

        int[][] arr = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] tree = new int[m][3];
        for(int i=0;i<m;i++){
             st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            tree[i] = new int[]{x,y,z};
        }

        Solution sol = new Solution();
        int ans = sol.getTree(n,k,tree,arr);
        System.out.println(ans);


    }
}

class Solution{

    static HashMap<String, PriorityQueue<Integer>> map;
    static int[][] BOARD;
    int getTree(int n, int k, int[][] tree, int[][] array){

        //map에다가 땅에 대한 나무 정보 저장
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String now = i + "," + j;
                map.put(now,new PriorityQueue<>((a,b)->a-b));
            }
        }

        //영양 정보 저장
        BOARD = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                BOARD[i][j] = 5;
            }
        }


        //초기 나무 심기
        for(int[] arr:tree){
            int x = arr[0];
            int y = arr[1];
            int z = arr[2];
            String key = x + "," + y;
            map.get(key).add(z);
        }

        //k년도 동안 봄 - 여름 - 가을 - 겨울 반복
        for(int i=0;i<k;i++){

            spring(n);
            autumn(n);
            winter(n,array);

        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String key = i + "," + j;
                ans += map.get(key).size();
            }
        }
        return ans;
    }

    //봄
    //영양분을 나이만큼 먹고 나이 + 1
    void spring(int n){

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String key = i + "," + j;
                PriorityQueue<Integer> newPQ = new PriorityQueue<>((a,b)->a-b);
                PriorityQueue<Integer> oldPQ = map.get(key);
                int die = 0;
                while(!oldPQ.isEmpty()){
                    int now = oldPQ.poll();
                    if(BOARD[i][j]>=now){
                        newPQ.add(now+1);
                        BOARD[i][j] = Math.max(0,BOARD[i][j]-now);
                    }else{
                        die += now/2;
                    }
                }
                map.put(key,newPQ);
                BOARD[i][j] += die;
            }
        }
    }

    //가을
    //나무가 번식함
    void autumn(int n){

        int[][] D = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,+1},{1,-1},{1,0},{1,1}};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String key = i + "," + j;
                PriorityQueue<Integer> newPQ = new PriorityQueue<>((a,b)->a-b);
                while(!map.get(key).isEmpty()){
                    int now = map.get(key).poll();
                    newPQ.add(now);
                    //5의 배수이면 주변에 나무를 심음
                    if(now%5==0){
                        for(int k=0;k<D.length;k++){
                            int nextI = i + D[i][0];
                            int nextJ = j + D[i][1];
                            if(nextI>n-1||nextI<0||nextJ>n-1||nextJ<0) continue;
                            map.get(nextI+","+nextJ).add(1);
                        }
                    }
                }
                map.put(key,newPQ);
            }
        }
    }

    void winter(int n, int[][] array){


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                BOARD[i][j] += array[i][j];
            }
        }

        for(int i=0;i<BOARD.length;i++){
            System.out.println(Arrays.toString(BOARD[i]));
        }
        System.out.println();
        System.out.println();

    }







}
