package com.interview.codinground;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;

        int result = findFactorial(number);
        System.out.println(result);

    }

    private static int findFactorial(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
