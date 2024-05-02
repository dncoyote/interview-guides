package com.interview.dsa.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 54, 20, 9 };
        System.out.println("Before sorting");
        for (int n : arr) {
            System.out.println(n);
        }
        int[] result = bubbleSort(arr);
        System.out.println("After Bubble sorting");
        for (int m : result) {
            System.out.println(m);
        }
    }

    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
