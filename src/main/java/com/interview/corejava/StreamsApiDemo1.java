package com.interview.corejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsApiDemo1 {

    public static void main(String[] args) {

        List<String> fruitList = Arrays.asList("apple", "banana", "cherry", "date", "apricot");

        // create a stream from the list
        Stream<String> stream = fruitList.stream();

        // filter the stream to only include elements starting with "a"
        Stream<String> filteredStream = stream.filter(s -> s.startsWith("a"));
        filteredStream.forEach(System.out::println);
        // find element using filter
        String firstLongFruit = fruitList.stream()
                .filter(fruit -> fruit.length() > 6)
                .findFirst()
                .orElse("No long fruit found");
        System.out.println(firstLongFruit);

        // map the filtered stream to uppercase strings
        Stream<String> mappedStream = fruitList.stream().map(String::toUpperCase);
        // print the mapped stream to the console
        mappedStream.forEach(System.out::println);
        // Map elements
        List<Integer> fruitLengths = fruitList.stream()
                .map(String::length)
                .toList();
        System.out.println("Fruit lengths: " + fruitLengths); // Output: [5, 6, 6, 4, 7]

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        // Using reduce to calculate the product of numbers
        int product = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Reduce: "+product);

        // Reduce elements
        int sum = fruitList.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total length: " + sum); // Output: 31

    }
}
