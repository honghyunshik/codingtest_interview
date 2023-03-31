package org.sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        int[] input = {1,46,24,0,1234,2};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubble_sort(input);
        System.out.println(Arrays.toString(input));
    }

}
