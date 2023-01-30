package org.book;

import java.util.function.Consumer;

public class MethodReferenceDemo implements MyFunctionalInterface {

    public static void staticMethod(){
        System.out.println("staticMethod");
    }

    public void instanceMethod(){
        System.out.println("instanceMethod");
    }

    public void instanceMethod(String param){
        System.out.println("instanceMethod " + param);
    }

    @Override
    public MethodReferenceDemo call() {

        return null;
    }

    public static void main(String[] args){

        Consumer<String> exe = Printer::printSomething;
        exe.accept("dd");
    }

    public static class Printer{
        static void printSomething(String text){
            System.out.println(text);
        }
    }
}
