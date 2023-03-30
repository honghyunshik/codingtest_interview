package org.dump;

public class Test9 {


    public static void main(String[] args){


        A a = new A();
        A a1 = new C();
        A a2 = new B();
        A a3 = new C();
        a1 = a3;
        System.out.println(a1.getClass());
        System.out.println(a1.a);
        A a4 = a3;
        System.out.println(a4.getClass());
        System.out.println(a4.a);
        ;
        a4.test();
    }



}

class A{
    int a = 10;
    public void test(){
        System.out.println("A");
    }
}

class B extends A{

    int b= 20;
    public void test1(){
        System.out.println("B");
    }
}

class C extends B{

    int c = 30;
    public void test2(){
        System.out.println("C");
    }
}
