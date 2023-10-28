package com.interview.codinground;

// Find non repeated chars in a string
//Kerala is known as God's own country.
public class NonRepeatedCharsInString {

    public static String findNonRepeated(String string) {

        int size = string.length() - 1;
        StringBuilder rev = new StringBuilder();
        Boolean flag = false;
        for (int i = 0; i <= size; i++) {
            char a = string.charAt(i);
            for (int j = 0; j <= size; j++) {
                if (i != j &&
                        string.charAt(j) == a) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                rev.append(string.charAt(i));
            }

        }

        return rev.toString();
    }

    public static void main(String[] args) {
        String string = "Kerala is known as God's own country.";
        String reverse = findNonRepeated(string);
        System.out.println(reverse);
    }
}
/**
 * output
 * -------
 * KelikGd'cuty.
 */