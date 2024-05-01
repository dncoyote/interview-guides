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

# Easy

## **Find the largest element in Array** 
#### Brute
- Quick Sort

#### Optimal
>Time Complexity - O(N)
```java
```

## **Find the second largest element in Array** 
#### Brute
- Quick Sort
- Find `arr[n-2]`, check whether its equal to `arr[n-1]`(largest), if its not equal then `arr[n-2]` is second largest, if its equal then find `arr[n-3]` and repeat comparison.

#### Better
>Time Complexity - O(2N)
- Find largest
- `if`

#### Optimal