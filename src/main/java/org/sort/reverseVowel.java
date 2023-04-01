package org.sort;

import java.util.Arrays;
import java.util.HashSet;

public class reverseVowel {

    public static void main(String[] args){
        reverseVowel reverseVowel= new reverseVowel();
        System.out.println(reverseVowel.getReverse("bacedufivo"));
    }
    HashSet<Character> vowel = new HashSet<>();
    reverseVowel(){
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
    }

    String getReverse(String str){

        int l=0, r=str.length()-1;
        char[] arr = new char[str.length()];
        while(l<r){
            while(l<r&&!vowel.contains(str.charAt(l))){
                System.out.println(l);
                arr[l] = str.charAt(l);
                l++;
            }
            while(l<r&&!vowel.contains(str.charAt(r))){
                arr[r] = str.charAt(r);
                r--;
            }
            arr[l] = str.charAt(r);
            arr[r] = str.charAt(l);
            l++;
            r--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
