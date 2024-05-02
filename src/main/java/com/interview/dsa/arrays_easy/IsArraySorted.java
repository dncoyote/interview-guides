package com.interview.dsa.arrays_easy;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        boolean result = isArraySorted(arr);
        System.out.println("Is Array sorted: " + result);

        int[] arr1 = { 1, 2, 3, 4, 5 };
        boolean result1 = isArraySorted(arr1);
        System.out.println("Is Array sorted: " + result1);
    }

    private static boolean isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
