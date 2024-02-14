package com.interview.codinground;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindPrimeNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.forEach(number -> {
            boolean isPrime = isPrime(number);
            if (isPrime) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        });
    }

    public static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number)
                .noneMatch(i -> number % i == 0);
    }
}
