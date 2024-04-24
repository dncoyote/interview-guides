# **Sorting**

# Sorting I

## **Selection Sort** 
> Time Complexity - O(n<sup>2</sup>)
- Selection Sort is a simple sorting algorithm that works by repeatedly selecting the smallest (or largest, depending on the sorting order) element from the unsorted part of the array and swapping it with the element at the current position.
- The algorithm maintains two subarrays within the array being sorted: the sorted subarray and the unsorted subarray.

#### Algorithm
- Initial State: The algorithm considers the entire array as the unsorted subarray initially. The sorted subarray is empty.
- Iteration: In each iteration, the algorithm finds the smallest element in the unsorted subarray and swaps it with the element at the beginning of the unsorted subarray.
- Expansion of Sorted Subarray: After each iteration, the sorted subarray expands by one element, and the unsorted subarray shrinks by one element.
- Termination: The algorithm terminates when the entire array becomes sorted (i.e., the unsorted subarray becomes empty).

```java
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        System.out.println("Before sorting");
        for (int num : arr) {
            System.out.println(num);
        }
        int result[] = selectionSort(arr);
        System.out.println("After sorting");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] selectionSort(int arr[]) {
        int n = arr.length;
        //iterates through the unsorted array
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            //picks the value
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
```
#### Working
Initial array: { 13, 46, 24, 52, 20, 9 }

- Iteration 1: Find the smallest element in the unsorted subarray { 13, 46, 24, 52, 20, 9 }, which is 9, and swap it with the element at the beginning of the unsorted subarray.
Array after Iteration 1: { 9, 46, 24, 52, 20, 13 }
- Iteration 2: Find the smallest element in the remaining unsorted subarray { 46, 24, 52, 20, 13 }, which is 13, and swap it with the element at the beginning of the unsorted subarray.
Array after Iteration 2: { 9, 13, 24, 52, 20, 46 }
- Iteration 3: Find the smallest element in the remaining unsorted subarray { 24, 52, 20, 46 }, which is 20, and swap it with the element at the beginning of the unsorted subarray.
Array after Iteration 3: { 9, 13, 20, 52, 24, 46 }
- Iteration 4: Find the smallest element in the remaining unsorted subarray { 52, 24, 46 }, which is 24, and swap it with the element at the beginning of the unsorted subarray.
Array after Iteration 4: { 9, 13, 20, 24, 52, 46 }
- Iteration 5: Find the smallest element in the remaining unsorted subarray { 52, 46 }, which is 46, and swap it with the element at the beginning of the unsorted subarray.

Array after Iteration 5: { 9, 13, 20, 24, 46, 52 }

#### Time Complexity

## **Bubble Sort**
- Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. 
- The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.

#### Algorithm
- Passes through the List: The algorithm starts at the beginning of the list and compares adjacent elements.
- Swapping Elements: If the elements are in the wrong order (i.e., the current element is greater than the next element in ascending order), they are swapped.
- Repeating Passes: The algorithm repeats this process for each pair of adjacent elements in the list until no more swaps are needed.
- Termination: The list is considered sorted when no swaps are made during a pass through the list.
```java
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 54, 20, 9 };
        System.out.println("Before sorting");
        for (int n : arr) {
            System.out.println(n);
        }
        int[] result = bubbleSort(arr);
        System.out.println("After Bubble sorting");
        for (int m : result) {
            System.out.println(m);
        }
    }

    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
```
#### Working
Initial array: { 13, 46, 24, 52, 20, 9 }
- Pass 1: Compare 13 and 46 (no swap), compare 46 and 24, swap them, compare 46 and 52 (no swap), compare 52 and 20, swap them, compare 52 and 9, swap them.
Array after Pass 1: { 13, 24, 46, 20, 9, 52 }
- Pass 2: Compare 13 and 24 (no swap), compare 24 and 46 (no swap), compare 46 and 20, swap them, compare 46 and 9, swap them, compare 46 and 52 (no swap).
Array after Pass 2: { 13, 24, 20, 9, 46, 52 }
- Pass 3: Compare 13 and 24 (no swap), compare 24 and 20, swap them, compare 24 and 9, swap them, compare 24 and 46 (no swap), compare 46 and 52 (no swap).
Array after Pass 3: { 13, 20, 9, 24, 46, 52 }
- Pass 4: Compare 13 and 20 (no swap), compare 20 and 9, swap them, compare 20 and 24 (no swap), compare 24 and 46 (no swap), compare 46 and 52 (no swap).
Array after Pass 4: { 13, 9, 20, 24, 46, 52 }
- Pass 5: Compare 13 and 9, swap them, compare 13 and 20 (no swap), compare 20 and 24 (no swap), compare 24 and 46 (no swap), compare 46 and 52 (no swap).
Array after Pass 5: { 9, 13, 20, 24, 46, 52 }