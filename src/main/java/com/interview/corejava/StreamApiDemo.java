package com.interview.corejava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.interview.corejava.model.Product;

public class StreamApiDemo {
    public static void main(String[] arg) {
        List<Integer> num = Arrays.asList(4, 5, 7, 8, 9);

        // saves list into a stream
        Stream<Integer> data = num.stream();
        data.forEach(n -> System.out.println(n));

        // filter odd numbers only
        num.stream()
                .filter(n -> n % 2 == 1)
                .sorted()
                .map(n -> n * 2)
                .forEach(n -> System.out.println(n));
        // stream can only be used once
        // data.forEach(n -> System.out.println(n));

        Predicate<Integer> predicate = n -> n % 2 == 1;

        num.stream()
                .filter(predicate)
                .sorted()
                .map(n -> n * 2)
                .forEach(n -> System.out.println(n));

        // Filtering data
        System.out.println("\n Filtering Data:");
        List<String> names = Arrays.asList("Alice", "Jabbar", "Bob", "Anna");
        List<String> filtered = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        filtered.forEach(value -> System.out.println(value));
        System.out.println("\n Filtering Data");

        // Transforming data
        System.out.println("\n Transforming Data:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> transformed = numbers.stream().map(number -> number * 2).collect(Collectors.toList());
        for (Integer no : transformed)
            System.out.println(no);
        System.out.println("\n Transforming Data");

        // Transforming data
        System.out.println("\n Transforming Data:");
        List<Product> products = Arrays.asList(new Product("Apple", 2.5), new Product("Orange", 9.5));
        Integer sumprice = products.stream().mapToInt(Product::getPrice).sum();
        System.out.println(sumprice);
        System.out.println("\n Transforming Data");
    }
}
