package com.interview.codinground;

public class DoubleEqualsAndEquals {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";

        // true
        System.out.println(s1 == s2);

        String s3 = new String("Hello");
        // false
        System.out.println(s1 == s3);

        String s4 = new String("Hello");
        // false
        System.out.println(s3 == s4);
    }
}
