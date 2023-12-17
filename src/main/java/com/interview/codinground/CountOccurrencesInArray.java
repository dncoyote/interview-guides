package com.interview.codinground;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesInArray {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 7, 2, 99, 2, 0 };

        Map<Integer, Integer> occurrenceMap = countOccurrences(arr);
        printOccurrencesMap(occurrenceMap);

    }

    private static void printOccurrencesMap(Map<Integer, Integer> occurrenceMap) {
        for(Map.Entry<Integer,Integer>entry:occurrenceMap.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

    private static Map<Integer, Integer> countOccurrences(int[] arr) {
        Map<Integer, Integer> occurrencesMap = new HashMap<>();
        for (int element : arr) {
            occurrencesMap.put(element, occurrencesMap.getOrDefault(element, 0) + 1);
        }
        return occurrencesMap;
    }
}

/**
 * occurrencesMap: This is a HashMap that stores the occurrences of each element in the array. The keys are elements, and the values are their corresponding frequencies.

.getOrDefault(element, 0): This method is used to retrieve the value associated with the specified key (element) from the map. If the key is present, it returns the associated value; otherwise, it returns the default value (0 in this case).

+ 1: After retrieving the current frequency of the element from the map (or 0 if the element is not present), we add 1 to it. This is because we are counting the occurrence of the element in the array.

In summary, the expression occurrencesMap.getOrDefault(element, 0) + 1 effectively increments the count of occurrences for a specific element in the map. If the element is already present in the map, it retrieves the current count and increments it by 1. If the element is not present, it assumes the count is 0 and increments it to 1
 */
