package com.interview.codinground;

public class IterateRight {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        Integer sum = findSumFromLeftLambda(arr);
        System.out.println(sum);
    }

    private static Integer findSumFromLeftLambda(int[] arr) {
        int length = arr.length;
        int sum = 0;
        for (int i = length - 1; i >= 0; i--) {
            // System.out.println(arr[i]);
            sum += arr[i];
        }
        return sum;
    }
}
