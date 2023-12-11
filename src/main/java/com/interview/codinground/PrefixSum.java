package com.interview.codinground;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] sumArr = computePrefixSum(arr);
        System.out.println(Arrays.toString(sumArr));
    }

    private static int[] computePrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }
}
