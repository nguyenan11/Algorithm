# Algorithm practice

- Documentations and extra notes are in each file.
    * Alternative (less optimal) solutions might also be available

# Week 2: 05/17 - 05/23/2021

### Category: Array

## [Longest Peak](Arrays/src/main/java/LongestPeak.java)

#### Level: Medium 📘

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

#### Level: Medium 📘

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

#### Level: Medium 📘

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

## [Merge Overlapping Intervals](Arrays/src/main/java/MergeOverlappingIntervals.java)

#### Level: Medium 📘

> Write a function that takes in a non-empty array of arbitrary intervals merges any overlapping intervals, and returns the new intervals in no particular order.
>
> Each interval `interval` is an array of two integers, with `interval[0]`  as the start of the interval and `interval[1]`  as the end of the interval.
>
> Note that back-to-back intervals aren't considered to be overlapping. For example, `[1, 5]` and `[6, 7]` aren't overlapping; however, `[1, 6]` and `[6, 7]` *are* indeed overlapping.
>
> Also note that the start of any particular interval will always be less than or equal to the end of that interval.

```java
public static int[][] mergeOverlappingIntervals(int[][] intervals) {
    Arrays.sort(intervals, new IntCompare());
    List<int[]> mergedInterval = new ArrayList<int[]>();
    int[] currInterval = intervals[0];
    mergedInterval.add(currInterval);

    for (int[] nextInterval : intervals) {
      int currIntervalEnd = currInterval[1];
      int nextIntervalStart = nextInterval[0];
      int nextIntervalEnd = nextInterval[1];

      if (currIntervalEnd >= nextIntervalStart) {
        currInterval[1] = nextIntervalEnd;
      } else {
        currInterval = nextInterval;
        mergedInterval.add(currInterval);
      }
    }
    return mergedInterval.toArray(new int[mergedInterval.size()][]);
  }

  static class IntCompare implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
      return Integer.compare(o1[0], o2[0]);
    }
  }
```

### O(nlog(n)) time | O(n) space

## [Four Number Sum](Arrays/src/main/java/FourNumSum.java)

#### Level: Hard 📕

> Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all quadruplets in the array that sum up to the target sum and return a two-dimensional array of all these quadruplets in no particular order.
>
> If no four numbers sum up to the target sum, the function should return an empty array.
```java
comeback for this
```

---

### Category: String

## [Palindrome Check](Strings/src/main/java/PalindromeCheck.java)

#### Level: Easy 📗

> Write a function that takes in a non-empty string and that returns a boolean representing whether the string is a palindrome.
>
> A palindrome is defined as a string that's written the same forward and backward. Note that single-character strings are palindromes.

```java
public static boolean isPalindrome(String str) {
    int leftIdx = 0;
    int rightIdx= str.length();
    while (leftIdx <= rightIdx) {
      if (str.charAt(leftIdx) != str.charAt(rightIdx)) return false;
      leftIdx++;
      rightIdx--;
    }
    return true;
  }
```

### O(n) time | O(1) space
