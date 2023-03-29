package org.example.taja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args){

        //ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,31,4,89));
        //List<Integer> list2 = list.stream().map(num->num+100).filter(num->num>2).sorted((a, b)->b-a).collect(Collectors.toList());
        //int a = (int) stream.count();
        //System.out.println(a);
        Hi hi = new Hi(20);
        System.out.println(hi.a);
    }
}

class Hi{
    Hi(int a){
        this.a = a;
    }

    int a = 10;
}