package com.interview.codinground;

public class FindPrimeNumberInRange {
    public static void main(String[] args) {
        int start = 3;
        int end = 11;

        findPrimeInRange(start, end);
    }

    private static void findPrimeInRange(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }

}
