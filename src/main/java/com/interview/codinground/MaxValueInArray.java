package com.interview.codinground;

public class MaxValueInArray {
    public static void main(String[] args) {
        int[] arr={1,45,6,33,2,99};

        int result = maxValueInArray(arr);
        System.out.println(result);
    }

    private static int maxValueInArray(int[] arr) {
        int max =arr[0];
        int length = arr.length-1;

        for(int i=1;i<=length;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    
}
