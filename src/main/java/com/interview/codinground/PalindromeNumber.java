package com.interview.codinground;

public class PalindromeNumber {

    public static void main(String[] args) {
        int num = 12321;
        if (isPalindrome(num)) {
            System.out.println(num + "is palindrome.");

        } else {
            System.out.println(num + "is not palindrome.");
        }
    }

    public static boolean isPalindrome(int num) {

        int n = num;
        int revNum = 0;

        while (num > 0) {
            int val = num % 10;
            revNum = revNum * 10 + val;
            num = num / 10;
        }
        if (revNum == n) {
            return true;
        } else {
            return false;
        }
    }
}
