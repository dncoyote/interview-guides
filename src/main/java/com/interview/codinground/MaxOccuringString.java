package com.interview.codinground;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxOccuringString {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aa", "bb", "cc", "aa", "bb", "aa");

        String maxOccuringString = findMaxOccuringString(strings);
        System.out.println(maxOccuringString);
        // Map<String, Long> resultMap = findMaxOccuringString(strings);

        // resultMap.forEach((string, frequesncy) -> System.out.println(string + " " +
        // frequesncy));
    }

    private static String findMaxOccuringString(List<String> strings) {
        Map<String, Long> stringMap = strings.stream()
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        // Optional<Entry<String, Long>> maxEntry =
        // stringMap.entrySet().stream().max(Map.Entry.comparingByValue());

        String maxString = null;
        long maxFrequency = 0;
        for (Map.Entry<String, Long> entry : stringMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxString = entry.getKey();
                maxFrequency = entry.getValue();
            }

        }
        return maxString;
    }
}
