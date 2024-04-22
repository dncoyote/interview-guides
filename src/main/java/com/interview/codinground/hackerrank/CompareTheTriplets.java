package com.interview.codinground.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareTheTriplets {
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int aSum = 0;
        int bSum = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aSum += 1;
            } else if (a.get(i) < b.get(i)) {
                bSum += 1;
            }
        }
        result.add(aSum);
        result.add(bSum);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(17, 28, 30);
        List<Integer> b = Arrays.asList(99, 16, 8);
        List<Integer> result = compareTriplets(a, b);
        System.out.println(result.toString());
    }

}
