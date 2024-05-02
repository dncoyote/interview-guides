# **Arrays**

# Introduction
## **Arrays**
- Array is a data structure that allows you to store multiple values of the same type under a single variable name.
- Arrays are used to store elements of a specific type in contiguous memory locations. 
- Each element in an array can be accessed using an index, starting from 0 for the first element to n-1.
```java
// Declaration and initialization of an array of integers
int[] numbers = {1, 2, 3, 4, 5};

// Declaration and initialization of an empty array of strings
String[] names = new String[3]; // Creates an array of size 3
names[0] = "Alice";
names[1] = "Bob";
names[2] = "Charlie";
```
---
# Easy

## **Find the largest element in Array** 
#### Brute
- Quick Sort

#### Optimal
>Time Complexity - O(N)
```java
public class LargestElement {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        int largest = findLargestElement(arr);
        System.out.println("Largest Element: " + largest);
    }

    private static int findLargestElement(int[] arr) {
        int largest = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
}
```
## **Find the smallest element in Array** 

## **Find the second largest element in Array** 
#### Brute
- Quick Sort
- Find `arr[n-2]`, check whether its equal to `arr[n-1]`(largest), if its not equal then `arr[n-2]` is second largest, if its equal then find `arr[n-3]` and repeat comparison.

#### Better
>Time Complexity - O(2N)
- Find largest
- `if`
```java
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        int secondLargest = findSecondLargestElement(arr);
        System.out.println("Second Largest Element: " + secondLargest);
    }

    private static int findSecondLargestElement(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] > secondLargest && arr[j] != largest) {
                secondLargest = arr[j];
            }
        }
        return secondLargest;
    }
}
```

#### Optimal
>Time Complexity - 
```java
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        int secondLargest = findSecondLargestElement(arr);
        System.out.println("Second Largest Element: " + secondLargest);
    }

    private static int findSecondLargestElement(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && secondLargest != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
```

## **Find the second smallest element in Array** 

## **Check if Array is sorted** 
#### Optimal
>Time Complexity - O(N)
-  `for (int i = 1; i < arr.length; i++)` No need to check for the first element.
```java
public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        boolean result = isArraySorted(arr);
        System.out.println("Is Array sorted: " + result);

        int[] arr1 = { 1, 2, 3, 4, 5 };
        boolean result1 = isArraySorted(arr1);
        System.out.println("Is Array sorted: " + result1);
    }

    private static boolean isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
```

## **Remove duplicates from a sorted array** 
#### Brute
>Time Complexity 
- use Set.

#### Optimal
>Time Complexity - O(N)
>Space Complexity - O(1)

```java
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = { 5, 9, 9, 9, 10, 10, 16 };
        int length = removingDuplicates(arr);
        System.out.println("Unique Array:");
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int removingDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
```
