package org.example.baekjoon2110;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        array = new int[num];

        for(int i=0;i<num;i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        Main main = new Main();

        System.out.println(main.binarySearch(count));
    }

    public long binarySearch(int target){

        long l = 1;
        long r = array[array.length-1]-array[0];


        while(l<=r){
            long mid = (l+r)/2;
            long cnt = gonu(mid);

            //거리를 늘여야 한다
            if(cnt>=target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return r;
    }

    public long gonu(long dist){

        long cnt = 1;
        int lastLocate = 0;
        for(int i=1;i<array.length;i++){
            if(array[i]-array[lastLocate]>=dist){
                cnt++;
                lastLocate = i;
            }
        }
        return cnt;
    }

}
