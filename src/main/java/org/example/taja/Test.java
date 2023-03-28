package org.example.taja;

public class Test {

    public static void main(String[] args){

        /*
        String a = "123";
        change(a);
        System.out.println(a);
        */
        Student<Integer,Integer> student = new Student<>(100000,15);
        System.out.println(student.age);
        System.out.println(student.money);

    }

    public static void change(String s){
        s = s.concat("123");

    }
}

class Student<S,T>{

    S money;
    T age;
    Student(S money, T age){
        this.money = money;
        this.age = age;
    }
}
