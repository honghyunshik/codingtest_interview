package org.example.taja;

import org.example.programmers2.FindK;

import java.util.ArrayList;

public class Test extends FindK {

    public static void main(String[] args){

        /*
        String a = "123";
        change(a);
        System.out.println(a);

        Student<Integer> student = new Student<>(100000,15);
        System.out.println(student.age);
        System.out.println(student.money);
        student.<Integer>getMoney(150);
        String a1 = "1234";
        String b1 = "1234";
        System.out.println(a1.hashCode());
        System.out.println(b1.hashCode());
        System.out.println(a1.hashCode()==b1.hashCode());
        */

    }

    public static void change(String s){
        s = s.concat("123");

    }
}

class Student<T>{

    T money;
    T age;
    Student(T money, T age){
        this.money = money;
        this.age = age;
    }

    <V> V getMoney(V money){
        return money;
    }
}
