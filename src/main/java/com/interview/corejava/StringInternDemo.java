package com.interview.corejava;

public class StringInternDemo {
    public static void main(String[] args) {

        String s1 = new String("Hello");
        String s2 = "Hello";

        System.out.println(s1 == s2);

        s1 = s1.intern();

        System.out.println(s1 == s2);
    }

}
