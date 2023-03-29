package org.example.taja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        Stream<?> stream = list.stream();
        stream.forEach(System.out::println);
    }
}
