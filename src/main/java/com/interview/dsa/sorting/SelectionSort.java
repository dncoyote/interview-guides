package com.interview.dsa.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        System.out.println("Before selection sorting");
        for (int num : arr) {
            System.out.println(num);
        }
        int result[] = selectionSort(arr);
        System.out.println("After selection sorting");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] selectionSort(int arr[]) {
        int n = arr.length;
        int i = 0;
        for (i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            System.out.println("After sorting " + i + " value");
            for (int m : arr) {
                System.out.println(m);
            }
        }
        return arr;
    }
}
