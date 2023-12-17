package com.interview.codinground;

public class Palindrome {
    public static void main(String[] args) {
        String str = "ABRBA";

        boolean result = checkPalindrome(str);
        if (result) {
            System.out.println(str + " is palidrome.");
        } else {
            System.out.println(str + " is not palidrome.");
        }
    }

    private static boolean checkPalindrome(String str) {
        str = str.toLowerCase();
        String original = str;
        String reverse = "";
        int length = str.length() - 1;
        for (int i = length; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        if (original.equals(reverse)) {
            return true;
        } else {
            return false;
        }

    }
}
