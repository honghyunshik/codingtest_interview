package org.sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        int[] input = {1,46,24,0,1234,2};
        //BubbleSort bubbleSort = new BubbleSort();
        //bubbleSort.bubble_sort(input);
        //SelectionSort selectionSort = new SelectionSort();
        //selectionSort.selection_sort(input);
        //InsertionSort insertionSort = new InsertionSort();
        //insertionSort.insertionSort(input);
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(input);
        System.out.println(Arrays.toString(input));
    }

}
