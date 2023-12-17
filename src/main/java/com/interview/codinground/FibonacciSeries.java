package com.interview.codinground;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10;

        generateFibonacciSeries(n);
    }

    private static void generateFibonacciSeries(int n) {

        int first = 0;
        int second = 1;

        for (int i = 0; i < n; i++) {
            System.out.println(first + ", ");
            int next = first + second;
            first=second;
            second = next;
        }
    }
}
