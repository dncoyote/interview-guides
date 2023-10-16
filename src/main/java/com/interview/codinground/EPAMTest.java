package com.interview.codinground;

import java.util.HashSet;

/*write a fucntion solution given an array A of N integeres returns the largest K>0 such that 
both values K and -K exist in array A. If there is no such integer, the fucntion should return 0
 */
class EPAMTest {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int largest = 0;
        for (int n : A) {
            if (set.contains(-n)) {
                largest = Math.max(largest, Math.abs(n));
            }
            set.add(n);
        }
        return largest;
    }

    public static void main() {
        EPAMTest s = new EPAMTest();
        int[] A = { 3, 2, -2, 5, -3 };
        int largest = s.solution(A);
        System.out.println(largest);
    }
}