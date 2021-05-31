# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 4: 05/31 - 06/06/2021

# Category for this week: 
**[Strings](#strings)**<br>
**[Sorting](#sorting)**<br>


---

# Sorting

## [Three Numbers Sort](Sortings/src/main/java/ThreeNumSort.java)

#### Level: Medium 📘

> You're given an array of integers and another array of three distinct integers. The first array is guaranteed to only contain integers that are in the second array, and the second array represents a desired order for the integers in the first array. For example, a second array of `[x, y, z]` represents a desired order of `[x, x, ..., x, y, y, ..., y, z, z, ..., z]` in the first array.
>
> Write a function that sorts the first array according to the desired order in the second array.
> The function should perform this in place (i.e., it should mutate the input array), and it shouldn't use any auxiliary space (i.e., it should run with constant space: `O(1)` space).
>
> Note that the desired order won't necessarily be ascending or descending and that the first array won't necessarily contain all three integers found in the second array—it might only contain one or two.

```java
public int[] threeNumberSort(int[] array, int[] order) {
  int firstNum = order[0];
  int lastNum = order[2];

  int leftPtr = 0;
  int rightPtr = leftPtr + 1;

  // first pass
  while (rightPtr < array.length) {
    if (array[leftPtr] == firstNum) {
      leftPtr++;
    } else {
      if (array[rightPtr] == firstNum) {
        swap(leftPtr, rightPtr, array);
        leftPtr++;
      }
    }
    rightPtr++;
  }

  rightPtr = array.length - 1;
  leftPtr = rightPtr - 1;

  // second pass
  while (leftPtr >= 0) {
    if (array[rightPtr] == lastNum) {
      rightPtr--;
    } else {
      if (array[leftPtr] == lastNum) {
        swap(leftPtr, rightPtr, array);
        rightPtr--;
      }
    }
    leftPtr--;
  }

  return array;
}

private static void swap(int i, int j, int[] array) {
  int tempValue = array[i];
  array[i] = array[j];
  array[j] = tempValue;
}
```

### O(n) time | O(n) space - n is length of array
* O(2n) because 2 loops -> O(n)
* Could refactor to use for-loops instead of while loops and use 1 pointer for
each loop instead of 2 pointers, but I'd like to see the logic clearer this way.

## [Quick Sort](Sortings/src/main/java/QuickSort.java)

#### Level: Hard 📕

> Write a function that takes in an array of integers and returns a sorted version of that array. Use the Quick Sort algorithm to sort the array.

```java
public static int[] quickSort(int[] array) {
  quickSort(array, 0, array.length - 1);
  return array;
}

private static void quickSort(int[] array, int start, int end) {
  if (start >= end) {
    return;
  }
  int pivotIdx = partition(array, start, end);
  quickSort(array, start, pivotIdx - 1);
  quickSort(array, pivotIdx + 1, end);
}

private static int partition(int[] array, int start, int end) {
  int pivotIdx = end;
  int pivot = array[pivotIdx];
  int currIdx = start - 1;
  for (int i = start; i < end; i++) {
    if (array[i] <= pivot) {
      currIdx++;
      swap(currIdx, i, array);
    }
  }
  swap(pivotIdx, currIdx + 1, array);
  return currIdx + 1;
}

private static void swap(int i, int j, int[] array) {
  int tempValue = array[i];
  array[i] = array[j];
  array[j] = tempValue;
}
```

### Best and average: O(nlog(n)) time | O(log(n)) space
* Worst: O(n^2) time | O(log(n)) space