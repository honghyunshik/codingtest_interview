package org.sort;

import org.sort2.sort.MergeSort;

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
        //HeapSort heapSort = new HeapSort();
        //heapSort.heapSort(input);
        //QuickSort quickSort = new QuickSort();
        //quickSort.quickSort(input);
        //System.out.println(Arrays.toString(input));
        //Fibonacci fibonacci = new Fibonacci();
        //Factorial factorial = new Factorial();
        //int answer = factorial.forFactorial(4);
        //Uclid uclid = new Uclid();
        //int answer = uclid.getGCD(new int[]{8, 12,4,5});
        //MergeSort mergeSort = new MergeSort();
        //mergeSort.merge_sort(input);
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge_sort(input);
        System.out.println(Arrays.toString(input));
    }

}
