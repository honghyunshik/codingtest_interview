package org.dump;

public class Test11 {

    public static void main(String[] args){

        String opt = "true";
        switch (opt){
            case "true": System.out.println("true");
                break;
            case "false": System.out.println("false");

            default: System.out.println("aaa");
        }
    }

    public static boolean avail(int x){
        return x-- >0?true:false;
    }
}
