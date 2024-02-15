package com.interview.codinground;

public class PermuteString {
    public static void main(String[] args) {
        String s = "ABC";
        int n = s.length();
        PermuteString permute = new PermuteString();

        permute.permute(s, 0, n - 1);
    }

    private void permute(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        } else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                permute(s, l + 1, r);
                s = swap(s, l, i);
            }
        }
    }

    private String swap(String s, int i, int j) {
        char temp;
        char[] c = s.toCharArray();
        temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return String.valueOf(c);
    }
}
