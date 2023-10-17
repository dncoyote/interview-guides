package com.interview.codinground.neetcode75.arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        // int[] arr = { 2, 7, 11, 15 };
        // int target = 9;
        // int[] result = ts.findIndices(arr, target);
        // System.out.println(Arrays.toString(result));
        int[] arr1 = { 2, 1, 11, 3 };
        int target = 4;
        int[] result = ts.findIndices(arr1, target);
        System.out.println(Arrays.toString(result));
    }

    private int[] findIndices(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = target - arr[i];
            if (map.containsKey(val)) {
                return new int[] { map.get(val), i };
            }
            map.put(arr[i], i);
        }
        throw new IllegalArgumentException("Does not exist.");
    }
}
