package org.sort2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        int[] arr = {1,24,274,1111,28,0,8,33};

        //BubbleSort bubbleSort = new BubbleSort();
        //bubbleSort.bubble_sort(arr);
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selection_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}