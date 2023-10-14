package com.interview.datastructures;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        String[] colors = new String[5];
        colors[0] = "purple";
        colors[1] = "blue";

        System.out.println("Array printing: ");
        System.out.println(Arrays.toString(colors));

        int[] numbers = { 100, 200 };

        System.out.println("Array printing using enhanced for loop: ");
        for (String col : colors) {
            System.out.println(col);
        }
        System.out.println("Array printing using streams: ");
        Arrays.stream(colors).forEach(System.out::println);

        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }
    }

}
