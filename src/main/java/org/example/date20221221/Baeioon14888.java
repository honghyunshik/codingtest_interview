package org.example.date20221221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baeioon14888 {

    static ArrayList<int[]> bruteForceArray;
    static ArrayList<Integer> operatorList;
    static int operatorCount = 0;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numArray = new int[n];
        int[] operator = new int[4];
        for(int i=0;i<n;i++){
            numArray[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        operatorList = new ArrayList<>();
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
            for(int j=0;j<i;j++){
                operatorList.add(i);
                operatorCount++;
            }
        }
        System.out.println(getMinMax(numArray,operator).toString());

    }

    public static StringBuilder getMinMax(int[] numArray, int[] operator){

        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        makeList(operator);
        for(int[] arr:bruteForceArray){
            int temp = numArray[0];
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0){
                    temp += numArray[i+1];
                }else if(arr[i]==1){
                    temp -= numArray[i+1];
                }else if(arr[i]==2){
                    temp *= numArray[i+1];
                }else if(arr[i]==3){
                    if(temp<0){
                        temp = (-temp)/numArray[i+1];
                        temp = -temp;
                    }else temp = temp/numArray[i+1];
                }
            }
            min = Math.min(temp,min);
            max = Math.max(temp,max);
        }
        sb.append(max + "\n" + min);

        return sb;
    }

    public static void makeList(int[] operator){

        bruteForceArray  = new ArrayList<>();
        for(int i=0;i<4;i++){

            if(operator[i]==0) continue;
            String temp = "";
            for(int j=0;j<4;j++){

                if(i==0&&j==0||i==1&&j==1||i==2&&j==2||i==3&&j==3) temp += operator[j]-1;
                else temp += operator[j];
            }

            bruteForce(temp,i + " ");
        }



    }

    public static void bruteForce(String count, String word){

        if(count.equals("0000")){
            String[] list = word.split(" ");
            int[] temp = new int[list.length];
            for(int i=0;i<list.length;i++){
                temp[i] = Integer.parseInt(list[i]);
            }
            bruteForceArray.add(temp);
            return;
        }
        for(int i=0;i<4;i++){

            if(count.charAt(i)-48>0) {
                String temp = "";
                for(int j=0;j<count.length();j++){
                    if(i==0&&j==0||i==1&&j==1||i==2&&j==2||i==3&&j==3){
                        temp += count.charAt(j)-49;
                    }else temp += count.charAt(j);
                }
                //System.out.println(temp);
                bruteForce(temp, word + i + " ");
            }
        }


    }

}
