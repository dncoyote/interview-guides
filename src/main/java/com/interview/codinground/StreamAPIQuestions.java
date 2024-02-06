package com.interview.codinground;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIQuestions {
    public static void main(String[] args) {
        /**
         * Filter Strings Starting with 'A':
         * Input: List of strings
         * Output: List of strings starting with 'A'
         */
        List<String> stringList = Arrays.asList("Ajax", "Odysseus", "Agammemnon");
        List<String> resultList = stringList.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());

        System.out.println(resultList);

        /**
         * Square of Integers:
         * Input: List of integers
         * Output: List of squares of integers
         */

        List<Integer> intList = Arrays.asList(2, 3, 4);
        List<Integer> resultList1 = intList.stream().map(num -> num * num).collect(Collectors.toList());

        System.out.println(resultList1);

        /**
         * Count Strings with Length > 5:
         * Input: List of strings
         * Output: Count of strings with length greater than 5
         */

        List<String> stringList1 = Arrays.asList("Ajax", "Odysseus", "Agammemnon");
        List<String> resultList2 = stringList1.stream().filter(name -> name.length() > 5).collect(Collectors.toList());

        System.out.println(resultList2);

        /**
         * Uppercase Conversion:
         * Input: List of strings
         * Output: List of strings converted to uppercase
         */
        List<String> stringList2 = Arrays.asList("Ajax", "Odysseus", "Agammemnon");
        List<String> resultList3 = stringList2.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(resultList3);

        /**
         * Sum of Integers:
         * Input: List of integers
         * Output: Sum of all integers
         */
        List<Integer> intList1 = Arrays.asList(2, 3, 4);
        int sum = intList1.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum);

        /**
         * Maximum Integer:
         * Input: List of integers
         * Output: Maximum intege
         */
        List<Integer> intList2 = Arrays.asList(2, 11, 3, 1, 4);
        int max = intList2.stream().mapToInt(Integer::intValue).max().orElse(0);

        System.out.println(max);

        /**
         * Check for 'e' in Strings:
         * Input: List of strings
         * Output: Boolean (true if all strings contain 'e', false otherwise)
         */
        List<String> stringList3 = Arrays.asList("Ajax", "Odysseus", "Agammemnon");
        List<String> resultList4 = stringList3.stream().filter(name -> name.contains("e")).collect(Collectors.toList());

        System.out.println(resultList4);

        List<String> stringList4 = Arrays.asList("Ajaxey", "Odysseus", "Agammemnon");
        boolean containsVal = stringList4.stream().allMatch(name -> name.contains("e"));

        System.out.println(containsVal);

        /**
         * Remove Duplicates:
         * Input: List of strings
         * Output: List of strings with duplicates removed
         */
        List<String> stringList5 = Arrays.asList("Ajax", "Odysseus", "Agammemnon", "Ajax", "Arkantos");
        List<String> resultList5 = stringList5.stream().distinct().collect(Collectors.toList());

        System.out.println(resultList5);

        /**
         * Sort Strings Alphabetically:
         * Input: List of strings
         * Output: List of strings sorted alphabetically
         */
        List<String> stringList6 = Arrays.asList("Ajax", "Odysseus", "Agammemnon", "Arkantos");
        List<String> resultList7 = stringList6.stream().sorted().toList();

        System.out.println(resultList7);

        /**
         * Group Strings by Length:
         * Input: List of strings
         * Output: Map where keys are string lengths and values are lists of strings
         * with that length
         */
        List<String> stringList7 = Arrays.asList("Ajax", "Odysseus", "Agammemnon", "Arkantos");
        Map<Integer, List<String>> resultList8 = stringList7.stream().collect(Collectors.groupingBy(String::length));

        System.out.println(resultList8);
    }

}
