package com.interview.codinground;

import java.util.HashMap;

public class RemoveDuplicateOccurenceFromString {
    public static void main(String[] args) {
        String str = "red blue green black blue white black";

        String result = removeDuplicate(str);

        System.out.println(result);
    }

    private static String removeDuplicate(String str) {
        String[] words = str.split("");

        HashMap<String, Integer> uniqueWords = new HashMap<>();
        for (String word : words) {
            uniqueWords.put(word, uniqueWords.getOrDefault(uniqueWords, 0) + 1);
        }

        return uniqueWords.entrySet().stream().filter(entry -> entry.getValue() == 1).toString();
    }
}