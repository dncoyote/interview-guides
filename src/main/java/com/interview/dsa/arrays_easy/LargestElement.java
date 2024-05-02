package com.interview.dsa.arrays_easy;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        int largest = findLargestElement(arr);
        System.out.println("Largest Element: " + largest);
    }

    private static int findLargestElement(int[] arr) {
        int largest = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
}
