package com.interview.dsa.arrays_easy;

public class SecondLargestElementBetter {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        int secondLargest = findSecondLargestElement(arr);
        System.out.println("Second Largest Element: " + secondLargest);
    }

    private static int findSecondLargestElement(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] > secondLargest && arr[j] != largest) {
                secondLargest = arr[j];
            }
        }
        return secondLargest;
    }
}