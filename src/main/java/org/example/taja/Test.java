package org.example.taja;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args){

        String a = "123";
        //change(a);
        ArrayList<Integer> ab = new ArrayList<>();
        change(ab);
        System.out.println(ab);
    }

    public static void change(ArrayList<Integer> ab){
        ab.add(1);
    }
}
