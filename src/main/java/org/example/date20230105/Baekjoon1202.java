package org.example.date20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewelry implements Comparable<Jewelry>{
    int weight, price;
    Jewelry(int weight, int price){
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewelry o) {
        if(o.weight==this.weight){
            return o.price-this.price;
        }
        return this.weight-o.weight;
    }
}
public class Baekjoon1202 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            pq.add(new Jewelry(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Integer[] bag = new Integer[K];

        for(int i=0;i<K;i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);

        long ans = 0;

        PriorityQueue<Integer> price = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<bag.length;i++){
            while(!pq.isEmpty()&&pq.peek().weight<=bag[i]){
                price.add(pq.poll().price);
            }
            if(!price.isEmpty()){
                ans+= price.poll();
            }

        }
        System.out.println(ans);

    }

    public static int binarySearch(Integer[] arr, int target){

        int l = 0, r = arr.length-1;

        while(l<r){
            int mid = (l+r)/2;
            if(mid>=target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
