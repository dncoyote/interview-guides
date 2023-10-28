package com.interview.codinground;

//Reverse a String
public class ReverseString {

    public static String reverseString(String string) {
        int size = string.length() - 1;
        StringBuilder rev = new StringBuilder();

        for (int i = size; i >= 0; i--) {
            rev.append(string.charAt(i));

        }

        return rev.toString();
    }

    public static void main(String[] args) {
        String string = "Kerala is known as God's own country.";
        String reverse = reverseString(string);
        System.out.println(reverse);
    }
}
/**
 * Output
 * .yrtnuoc nwo s'doG sa nwonk si alareK
 */
