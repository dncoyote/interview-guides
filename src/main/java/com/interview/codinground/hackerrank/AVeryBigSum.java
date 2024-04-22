package com.interview.codinground.hackerrank;

import java.util.Arrays;
import java.util.List;

public class AVeryBigSum {
    public static long aVeryBigSum(List<Long> ar) {
        long sum = 0L;
        for (long value : ar) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Long> ar = Arrays.asList(5L, 1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);
        Long sum = aVeryBigSum(ar);
        System.out.println(sum);
    }
}
