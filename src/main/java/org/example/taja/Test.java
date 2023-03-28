package org.example.taja;

public class Test {

    public static void main(String[] args){

        String a = "123";
        change(a);
        System.out.println(a);

    }

    public static void change(String s){
        s = s.concat("123");

    }
}
