package com.interview.codinground;

import java.util.HashMap;
import java.util.Map;

public class CountCharOccurences {
    public static void main(String[] args) {
        String input = "JavaJavaEE";
        countCharacterRepetitions(input);
    }

    public static void countCharacterRepetitions(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Convert the string to lowercase for case-insensitive counting
        str = str.toLowerCase();

        // Iterate through the string and count character repetitions
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        }

        // Print the character frequencies
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
/**
 * Output
 * -------
 * a-4
 * e-2
 * v-2
 * j-2
 */