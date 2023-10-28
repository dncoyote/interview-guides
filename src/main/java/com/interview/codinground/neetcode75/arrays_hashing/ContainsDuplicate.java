package com.interview.codinground.neetcode75.arrays_hashing;

import java.util.HashSet;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * 
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * 
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 **/
public class ContainsDuplicate {

    public Boolean checkDuplicate(int[] numArr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : numArr) {
            if (set.contains(num)) {
                return false;
            } else {
                set.add(num);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 1 };
        int[] arr2 = { 1, 2, 3, 4 };
        int[] arr3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.checkDuplicate(arr1));
        System.out.println(cd.checkDuplicate(arr2));
        System.out.println(cd.checkDuplicate(arr3));
    }
}
/**
 * Output
 * ------
 * false
 * true
 * false
 */