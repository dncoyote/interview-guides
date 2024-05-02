package com.interview.dsa.arrays_easy;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = { 5, 9, 9, 9, 10, 10, 16 };
        int length = removingDuplicates(arr);
        System.out.println("Unique Array:");
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int removingDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
