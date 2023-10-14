package com.interview.corejava;

import java.util.Arrays;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] arg) {
        List<Integer> num = Arrays.asList(4, 5, 7, 8, 9);
        num.forEach(n -> System.out.println(n));
    }
}
