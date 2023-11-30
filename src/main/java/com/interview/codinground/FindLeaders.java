package com.interview.codinground;

import java.util.ArrayList;
import java.util.List;

class FindLeaders {
    public static void main(String[] args) {
        int[] array = { 5, 6, 7, 0, 1, 3, 5, 5 };
        List<Integer> leaderVal = findLeaders(array);
        System.out.println(leaderVal);
    }

    public static List<Integer> findLeaders(int[] array) {
        int n = array.length;
        int max = array[n - 1];
        List<Integer> leaders = new ArrayList<>();
        leaders.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if (array[i] > max) {
                max = array[i];
                leaders.add(array[i]);
            }
        }
        return leaders;
    }
}
