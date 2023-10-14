package com.interview.datastructures;

import java.util.ArrayList;
import java.util.List;

public class ListsDemo {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<String>();
        colors.add("blue");
        colors.add("purple");
        System.out.println(colors.size());
        System.out.println(colors.contains("purple"));
        System.out.println(colors.contains("pink"));
        System.out.println(colors);

        for (String col : colors) {
            System.out.println(col);
        }
        colors.forEach(System.out::println);
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
    }
}
