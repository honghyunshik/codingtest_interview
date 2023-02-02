package org.example.baekjoon16235;

import java.util.Arrays;
import java.util.HashMap;

public class test {

    public static void main(String[] args){

        int[] arr = new int[]{1,2,3,4,5};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void change(int[] arr){
        arr[2] = 144;
    }
}

