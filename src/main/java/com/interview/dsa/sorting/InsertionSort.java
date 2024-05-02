package com.interview.dsa.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 14, 9, 15, 12, 6, 8, 13 };
        System.out.println("Before sorting");
        for (int n : arr) {
            System.out.println(n);
        }
        int[] result = insertionSort(arr);
        System.out.println("After sorting");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
                System.out.println("After sorting at "+i);
                for (int m : arr) {
                    System.out.println(m);
                }
            }
        }
        return arr;
    }
}
