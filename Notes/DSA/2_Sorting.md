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

## **Selection Sort** 
- Insertion Sort is a simple sorting algorithm that builds the final sorted array (or list) one element at a time. 
- It works by repeatedly taking an unsorted element from the input list and inserting it into its correct position in the sorted part of the list.

#### Algorithm
- Initial State: The first element in the list is considered as the sorted part (since a single element is always considered sorted initially). The rest of the elements are unsorted.
- Iterative Insertion: Starting from the second element, the algorithm iteratively takes an element from the unsorted part and inserts it into its correct position in the sorted part.
    - The algorithm compares the element with the elements in the sorted part, moving larger elements one position to the right to make space for the new element.
    - It continues this process until all elements are sorted.
- Termination: The list is fully sorted when all elements have been processed and inserted into the correct positions.

```java
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 14, 9, 15, 12, 6, 8, 13 };
        System.out.println("Before sorting");
        for (int n : arr) {
            System.out.println(n);
        }
        int[] result = insertionSort(arr);
        System.out.println("After sorting");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }
}
```

#### Working
Initial array: { 14, 9, 15, 12, 6, 8, 13 }

- Iteration 1: Start with the sorted part [14] and the unsorted part [9, 15, 12, 6, 8, 13]. Take 9 from the unsorted part and insert it into its correct position in the sorted part.
Array after Iteration 1: [9, 14, 15, 12, 6, 8, 13]
- Iteration 2: Continue with the sorted part [9, 14] and the unsorted part [15, 12, 6, 8, 13]. Take 15 from the unsorted part and insert it into its correct position in the sorted part.
Array after Iteration 2: [9, 14, 15, 12, 6, 8, 13] (no change as 15 is already in its correct position)
- Iteration 3: Continue with the sorted part [9, 14, 15] and the unsorted part [12, 6, 8, 13]. Take 12 from the unsorted part and insert it into its correct position in the sorted part.
Array after Iteration 3: [9, 12, 14, 15, 6, 8, 13]
- Iteration 4: Continue with the sorted part [9, 12, 14, 15] and the unsorted part [6, 8, 13]. Take 6 from the unsorted part and insert it into its correct position in the sorted part.
Array after Iteration 4: [6, 9, 12, 14, 15, 8, 13]
- Iteration 5: Continue with the sorted part [6, 9, 12, 14, 15] and the unsorted part [8, 13]. Take 8 from the unsorted part and insert it into its correct position in the sorted part.
Array after Iteration 5: [6, 8, 9, 12, 14, 15, 13]
- Iteration 6: Continue with the sorted part [6, 8, 9, 12, 14, 15] and the unsorted part [13]. Take 13 from the unsorted part and insert it into its correct position in the sorted part.
Array after Iteration 6: [6, 8, 9, 12, 13, 14, 15]

# Sorting II
## **Merge Sort**

## **Quick Sort**

```java
```

#### Algorithm

#### Working