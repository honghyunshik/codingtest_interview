package org.example.date20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Parcel implements Comparable<Parcel>{
    int from, to, amount;
    Parcel(int from, int to, int amount){
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public int compareTo(Parcel o) {
        if(this.to==o.to){
            return this.from-o.from;
        }
        return this.to-o.to;
    }
}
public class Baekjoon8980 {

    public static void main(String[] args) throws IOException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());       //마을 수
        int K = Integer.parseInt(st.nextToken());       //택배 용량
        int M = Integer.parseInt(br.readLine());        //택배 수
        Parcel[] parcel = new Parcel[M];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            parcel[i] = new Parcel(from,to,amount);
        }
        Arrays.sort(parcel);
        int[] total = new int[M+1];
        for(int i=0;i<N;i++){
            total[i] = K;
        }
        int ans = 0;
        for(int j=0;j<parcel.length;j++){
            Parcel curr = parcel[j];
            int min = Integer.MAX_VALUE;
            for(int i=curr.from;i<curr.to;i++){
                min = Math.min(min, total[i]);
            }

            if(min>curr.amount){
                for(int i=curr.from;i<curr.to;i++){
                    total[i] -= curr.amount;
                }
                ans+=curr.amount;
            }else{
                for(int i=curr.from;i<curr.to;i++){
                    total[i] -= min;
                }
                ans+=min;
            }
        }
        System.out.println(ans);
        br.close();

    }
}
