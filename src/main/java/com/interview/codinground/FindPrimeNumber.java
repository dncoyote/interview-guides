package com.interview.codinground;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FindPrimeNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Predicate to check if a number is prime
        Predicate<Integer> isPrime = num -> num > 1 && isDivisibleOnlyByOneAndItself(num);

        // Filtering and printing prime numbers
        numbers.stream()
               .filter(isPrime)
               .forEach(System.out::println);
    }

    // Helper method to check if a number is divisible only by 1 and itself
    private static boolean isDivisibleOnlyByOneAndItself(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
