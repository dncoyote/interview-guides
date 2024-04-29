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
> Time Complexity - O(n log n)
> Space Complexity - 
- Merge Sort is a divide-and-conquer sorting algorithm that works by recursively dividing the unsorted array into smaller subarrays until each subarray consists of only one element (which is inherently sorted). 
- It then merges these smaller sorted subarrays back together in a sorted manner until the entire array is sorted.
```java
public class MergeSort {
    public static void main(String args[]) {
        int arr[] = { 3, 1, 2, 4, 1, 5, 2, 6, 4 };
        System.out.println("Before sorting array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
```
#### Algorithm
- Divide
- Merge

#### Working
- Merge Sort Function:
    - `mergeSort(int[] arr, int low, int high)` function is called with the array, starting index `low`, and ending index `high`.
    - This function implements the Merge Sort algorithm.
- Merge Sort Algorithm:
    - Base Case: If `low >= high`, return. This condition is reached when a subarray has only one element or is empty.
    - Calculate the middle index as `mid = (low + high) / 2`.
    - Recursively call `mergeSort` for the left half `mergeSort(arr, low, mid)` and the right half `mergeSort(arr, mid + 1, high)`.
    - After the left and right halves are sorted, merge them using the `merge` method.
- Merge Method:
    - `merge(int[] arr, int low, int mid, int high)` method merges two sorted halves of the array.
    - Create a temporary array `ArrayList<Integer> temp` to store the merged elements temporarily.
    - Initialize `left` as the starting index of the left half and `right` as the starting index of the right half.
    - Compare elements from the left and right halves, adding the smaller element to `temp`.
    - Continue this process until one of the halves is exhausted.
    - If elements are left in the left or right half after the comparison, add them to `temp`.
    - Finally, transfer the sorted elements from temp back to the original array `arr`.
- Printing the Sorted Array:
    - After the Merge Sort algorithm completes, the code prints the sorted array.

##### Step-by-step breakdown 
- Initial Array: `[3, 1, 2, 4, 1, 5, 2, 6, 4]`
- Merge Sort Steps:
    - Splitting into subarrays: `[3, 1, 2, 4, 1, 5, 2, 6, 4]` -> `[3, 1, 2, 4]` `[1, 5, 2, 6, 4]`
    - Sorting subarrays: `[3, 1, 2, 4]` `[1, 5, 2, 6, 4]`-> `[1, 2, 3, 4]` `[1, 2, 4, 5, 6]`
    - Merging sorted subarrays: `[1, 2, 3, 4]` `[1, 2, 4, 5, 6]` -> `[1, 1, 2, 2, 3, 4, 4, 5, 6]`
- After Sorting Output: `1 1 2 2 3 4 4 5 6`

#### Complexities
##### Time 

##### Space

## **Quick Sort**
> Time Complexity - O(n log n)
> Space Complexity - O(1)
- Quick Sort is a highly efficient sorting algorithm that falls under the category of divide-and-conquer algorithms. 
- It works by selecting a "pivot" element from the array and partitioning the other elements into two sub-arrays according to whether they are less than or greater than the pivot. 
- The sub-arrays are then recursively sorted.

```java
public class QuickSort {
    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[] {4, 6, 2, 5, 7, 9, 1, 3});
        int n = arr.size();
        System.out.println("Before Using Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " "); 
        }
        System.out.println();
        arr = quickSort(arr);
        System.out.println("After Quick sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        qs(arr, 0, arr.size() - 1);
        return arr;
    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }

    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }

            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    } 
}
```
#### Algorithm
- Pick a pivot.
- Smaller on the left and larger on the right.

#### Working
- Quick Sort Function:
    - `quickSort(List<Integer> arr)` function is called with the array as the argument.
    - Inside quickSort, the qs function (Quick Sort) is invoked with the array, starting index (low), and ending index (high).
- Quick Sort (qs) Function:
    - `qs` function implements the Quick Sort algorithm recursively.
    - It checks if `low < high`, which is the base case for recursion. If true, it proceeds with partitioning and sorting.
- Partitioning Function:
    - `partition(List<Integer> arr, int low, int high)` partitions the array based on a pivot element.
    - It selects the pivot as the element at index low initially.
    - Initializes two pointers `i` and `j` pointing to low and high respectively.
    - Enters a loop where `i` moves forward until it finds an element greater than the pivot, and `j` moves backward until it finds an element less than or equal to the pivot.
    - Swaps elements at `i` and `j` if `i` is less than `j`, ensuring elements less than the pivot are on the left side and elements greater are on the right side.
    - Finally, swaps the pivot element with the element at index `j`, placing the pivot in its correct sorted position.
    - Returns the index `j`, which is the partitioning index.
- Recursive Calls:
    - After partitioning, the Quick Sort function `qs` is recursively called for the left sub-array `qs(arr, low, pIndex - 1)` and the right sub-array `qs(arr, pIndex + 1, high)`.
- Printing the Sorted Array:
    - Once the Quick Sort algorithm completes, the code prints the sorted array.
 
#### Complexities
##### Time 

##### Space