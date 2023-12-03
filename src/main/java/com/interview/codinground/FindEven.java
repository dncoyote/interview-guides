package com.interview.codinground;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FindEven {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = num -> num % 2 == 0;
        // numList.stream().filter(isEven).forEach(num -> System.out.println(num));

        numList.stream().filter(isEven).forEach(System.out::println);
    }
}
