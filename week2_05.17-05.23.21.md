# Algorithm practice

- Documentations and extra notes are in each file.
    * Alternative (less optimal) solutions might also be available

# Week 2: 05/17 - 05/23/2021

### Category: Array

## [Longest Peak](Arrays/src/main/java/LongestPeak.java)

#### Level: Medium

> Write a function that takes in an array of integers and returns the length of the longest peak in the array.
>
> A peak is defined as adjacent integers in the array that are **strictly** increasing until they reach a tip (the highest value in the peak), at which point they become **strictly** decreasing. At least three integers are required to form a peak.
>
> For example, the integers `[1, 4, 10, 2]` form a peak, but the integers `[4, 0, 10]` don't and neither do the integers `[1, 2, 2, 0]`. Similarly, the integers `[1, 2, 3]`  don't form a peak because there aren't any strictly decreasing integers after the `3`.

```java
public static int longestPeak(int[] array) {
    int longestPeakLength = 0;
    int i = 1;
    while (i < array.length - 1) {
      boolean tipDetected = array[i - 1] < array[i] && array[i] > array[i + 1];
      if (!tipDetected) {
        i++;
        continue;
      }

      int leftIdx = i - 2;
      while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
        leftIdx--;
      }

      int rightIdx = i + 2;
      while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
        rightIdx++;
      }

      longestPeakLength = updateLongestPeak(longestPeakLength, leftIdx, rightIdx);
      i = rightIdx;

    }
    return longestPeakLength;
  }


  private static int updateLongestPeak(int longestPeakLength, int leftIdx, int rightIdx) {
    int currPeakLength = rightIdx - leftIdx - 1;
    return Math.max(currPeakLength, longestPeakLength);
  }
```

### O(n) time | O(n) space - n is length of input array
* Limitation about assumption: peak as if it points up; pointing down was not
considered.
* We traverse thru each number once, at most 2 - 3 times (when peak found and 
traverse to the left) -> still O(n)

## [Array Of Products](Arrays/src/main/java/ArrayOfProducts.java)

#### Level: Medium

> Write a function that takes in a non-empty array of integers and returns an array of the same length, where each element in the output array is equal to the product of every other number in the input array.
>
> In other words, the value at `output[i]` is equal to the product of every number in the input array other than `input[i]`.
>
> Note that you're expected to solve this problem without using division.

```java
public static int[] arrayOfProducts(int[] array) {
    int[] productArr = new int[array.length];

    int productFromLeft = 1;
    for (int i = 0; i < array.length; i++) {
      productArr[i] = productFromLeft;
      productFromLeft *= array[i];
    }

    int productFromRight = 1;
    for (int i = array.length - 1; i >= 0; i--) {
      productArr[i] *= productFromRight;
      productFromRight *= array[i];
    }
    return productArr;
  }
```

### O(n) time | O(n) space - n is length of input array

## [First Duplicate Value](Arrays/src/main/java/FirstDuplicateValue.java)

> Given an array of integers between `1` and `n`, inclusive, where `n` is the length of the array, write a function that returns the first integer that appears more than once (when the array is read from left to right).
>
> In other words, out of all the integers that might occur more than once in the input array, your function should return the one whose first duplicate value has the minimum index.
>
> If no integer appears more than once, your function should return `-1`.
>
> Note that you're allowed to mutate the input array.

```java
public int firstDuplicateValue(int[] array) {
    for (int num : array) {
      int absValue = Math.abs(num);
      if (array[absValue - 1] < 0) return absValue;
      array[absValue - 1] *= -1;
    }
    return -1;
  }
```

### O(n) time | O(1) space - most optimal
* O(n) time | O(n) is made with single for-loop and a Set/ List
* O(n^2) | O(1) space is made with double for-loops