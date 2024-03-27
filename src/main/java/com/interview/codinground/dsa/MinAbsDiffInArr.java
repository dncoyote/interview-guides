package com.interview.codinground.dsa;

import java.util.Collections;
import java.util.List;

public class MinAbsDiffInArr {

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 9, 12, 15 };
        int minAbsDiff = findMinAbsDiff(array);
        System.out.println("Minimum absolute difference: " + minAbsDiff);
    }

    public static int findMinAbsDiff(int[] numbers) {
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.length; i++) {
            int diff = numbers[i] - numbers[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static int findMinAbsDiff(List<Integer> numbers) {
        // int minAbsDiff = numbers.stream()
        // .sorted()
        // .reduce((a, b) -> Math.min(Math.abs(a - b), Integer.MAX_VALUE))
        // .orElseThrow(() -> new IllegalArgumentException("List is empty"));

        Collections.sort(numbers);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.size(); i++) {
            int diff = Math.abs(numbers.get(i) - numbers.get(i - 1));
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}
