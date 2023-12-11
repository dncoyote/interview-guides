package com.interview.codinground;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 2, 5, 6, 1, 7, 8, 9, 7 };
        int[] uniqueArr = removeDuplicates(arr);
        System.out.println(Arrays.toString(uniqueArr));
    }

    private static int[] removeDuplicates(int[] arr) {
        Arrays.sort(arr);
        int uniqueCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqueCount++;
            }
        }
        int[] uniqueArr = new int[uniqueCount];
        uniqueArr[0] = arr[0];
        int currentIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqueArr[currentIndex] = arr[i];
                currentIndex++;
            }
        }

        return uniqueArr;

        //java 8
        // return IntStream.of(arr)
        //         .distinct()
        //         .toArray();
    }
}
