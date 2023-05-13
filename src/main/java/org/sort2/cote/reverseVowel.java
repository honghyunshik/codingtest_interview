package org.sort2.cote;

import java.util.HashSet;

public class reverseVowel {

    public static void main(String[] args){

        String input = "aeiou";
        reverseVowel reverseVowel = new reverseVowel();
        System.out.println(input);
        System.out.println(reverseVowel.reverse(input));
    }

    private String reverse(String input){

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        StringBuilder sb = new StringBuilder(input);

        int l = 0, r = sb.length()-1;

        while(l<r){

            if(!set.contains(sb.charAt(l))) l++;
            else if(!set.contains(sb.charAt(r))) r--;
            else{
                char temp = sb.charAt(l);
                sb.setCharAt(l,sb.charAt(r));
                sb.setCharAt(r,temp);
                l++;
                r--;
            }

        }
        return sb.toString();
    }
}
