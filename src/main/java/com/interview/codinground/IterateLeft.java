package com.interview.codinground;

import java.util.stream.IntStream;

public class IterateLeft {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        // Integer sum = findSumFromLeft(arr);
        Integer sum = findSumFromLeftLambda(arr);
        System.out.println(sum);
    }

    public static Integer findSumFromLeft(int[] arr) {
        int length = arr.length;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static Integer findSumFromLeftLambda(int[] arr) {
        // IntStream.range(0, arr.length)
        // .map(index -> IntStream.range(0, index + 1).map(i -> arr[i]).sum())
        // .forEach(System.out::println);
        int[] sum = { 0 };
        IntStream.range(0, arr.length)
                .map(index -> sum[0] += arr[index]) 
                .toArray();

        return sum[0];
    }
}
