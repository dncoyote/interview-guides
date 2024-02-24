package com.interview.codinground;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindRepeatingValueInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 5);

        Map<Integer, Long> result = findRepeatingNumbers(numbers);
        result.forEach((value, count) -> {

            if (count > 1) {
                System.out.println(value);
            }
        });

    }

    public static Map<Integer, Long> findRepeatingNumbers(List<Integer> numbers) {

        Map<Integer, Long> result = numbers.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        return result;
    }

}