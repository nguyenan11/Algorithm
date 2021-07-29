# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 4: 05/31 - 06/06/2021

# Category for this week: 
**[Array](#array)**<br>
**[Strings](#strings)**<br>
**[Sorting](#sorting)**<br>

---

# Array

## [Leetcode #1099 - Two Sum Less Than K](https://leetcode.com/problems/two-sum-less-than-k/)
* *Python*

#### Level: Easy 📗

```python
def twoSumLessThanK(self, nums, k):
  '''
  Function -- twoSumLessThanK
    Finds the sum (of 2 number in a list) that is less or equal than a target 
    number, and that sum is the closet number comparing to target.
  Parameter:
    nums - the list of integers
    k - the target int
  Return: 
    An int represents the closet number. If no sums are less than equal to
    target, -1 will be returned.
  '''
  sorted_nums = sorted(filter(lambda x: x < k, nums))
  lo, hi, closet = 0, len(sorted_nums) - 1, -1
  while lo < hi:
    two_sum = sorted_nums[lo] + sorted_nums[hi]
    if two_sum < k:
      closet = max(two_sum, closet)
      lo += 1
    else:
      hi -= 1
  return closet
```

### O(nlog(n)) time | O(n) space - n is number of elements in the list
* Definitely could make it O(1) space by storing sorted_nums into nums

## [Leetcode #11 - Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
* *Python*

#### Level: Medium 📘

```python
def maxArea(self, height):
  '''
  Function -- maxArea
    Finds the container (rectangle shaped) that can hold the most water -
    biggest area can be formed. Width can be calculated by subtraction between
    each height.
  Parameter:
    height - the list of integers, where each int represents a height
  Return:
    The biggest area to hold water (without spilling) that can be formed, an 
    int.
  '''
  currMax = 0;
  leftWall = 0;
  rightWall = len(height) - 1
  while leftWall != rightWall:
    currArea = min(height[leftWall], height[rightWall]) * (rightWall - leftWall)
    currMax = max(currMax, currArea)
    if height[leftWall] < height[rightWall]:
      leftWall += 1
    else:
      rightWall -= 1
  return currMax
```

### O(n) time | O(1) space - n is number of elements in the list (height)

## [Leetcode #35 - Search Insert Position](https://leetcode.com/problems/search-insert-position/)
* *Python*

#### Level: Easy 📗

```python
def searchInsert(self, nums, target):
  '''
  Function -- searchInsert
    Given a sorted list of integers, finds where a new target int can be
    inserted.
  Parameter:
    nums - SORTED list of integers
    target - the target int
  Return:
    The position (index) where the target number can be inserted, an int.
  '''
  left = 0
  right = len(nums) - 1
  while left <= right:
    mid = (left + right) // 2
    if nums[mid] == target:
      return mid
    elif nums[mid] > target:
      right = mid - 1
    else:
      left = mid + 1
  return left
```

### O(log n) time | O(1) space - n is number of elements in the list (nums)
* O(log n) time because only considering half the array at each iteration.

---

# Strings

## [Longest Palindromic Substring](../Strings/src/main/java/LongestPalindromicSubstring.java)

#### Level: Medium 📘

> Write a function that, given a string, returns its longest palindromic substring.
>
> A palindrome is defined as a string that's written the same forward and backward. Note that single-character strings are palindromes.
>
> You can assume that there will only be one longest palindromic substring.

```java
public static String longestPalindromicSubstring(String str) {
  int[] currLongest = new int[]{0, 1};
  for (int i = 1; i < str.length(); i++) {
    int[] odd = getLongestPalindrome(i - 1, i + 1, str);
    int[] even = getLongestPalindrome(i - 1, i, str);
    int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
    currLongest = currLongest[1] - currLongest[0] > longest[1] - longest[0] ? currLongest : longest;
  }
  return str.substring(currLongest[0], currLongest[1]);
}

private static int[] getLongestPalindrome(int leftIdx, int rightIdx, String str) {
  while (leftIdx >= 0 && rightIdx < str.length()) {
    if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
      break;
    }
    leftIdx--;
    rightIdx++;
  }
  return new int[] {leftIdx + 1, rightIdx};
}
```

### O(n^2) time | O(n) space

## [Longest Substring Without Duplication](../Strings/src/main/java/LongestSubstringWithoutDuplication.java)

#### Level: Hard 📕

> Write a function that takes in a string and returns its longest substring without duplicate characters.
>
> You can assume that there will only be one longest substring without duplication.

```java
public static String longestSubstringWithoutDuplication(String str) {
  Map<Character, Integer> lastSeen = new HashMap<>();
  int[] longest = {0, 1};
  int startIdx = 0;
  for (int i = 0; i < str.length(); i++) {
    char currChar = str.charAt(i);
    if (lastSeen.containsKey(currChar)) {
      startIdx = Math.max(startIdx, lastSeen.get(currChar) + 1);
    }
    if (longest[1] - longest[0] < i + 1 - startIdx) {
      longest = new int[]{startIdx, i + 1};
    }
    lastSeen.put(currChar, i);
  }
  return str.substring(longest[0], longest[1]);
}
```

### O(n) time | O(min(n, a)) space - where n is the length of the input string and a is the length of the character alphabet represented in the input string (because of duplications)

---

# Sorting

## [Three Numbers Sort](../Sortings/src/main/java/ThreeNumSort.java)

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

### O(n) time | O(1) space - n is length of array
* O(2n) because 2 loops -> O(n) time
* Could refactor to use for-loops instead of while loops and use 1 pointer for
each loop instead of 2 pointers, but I'd like to see the logic clearer this way.

## [Leetcode #75 - Sort Colors](https://leetcode.com/problems/sort-colors/)
* *Python*
* This is the same problem as above, but this is a less extensible version

#### Level: Medium 📘 

```python
def sortColors(self, nums):
  '''
  Function -- sortColors
    Sorts the array of int (nums) following the order [0, 1, 2].
  Parameter:
    nums - unsorted array of integers ranged from 0 - 2
  Return:
    Sorted array of integers.
  '''
  
  l = -1
  r = len(nums)
  i = 0
  while i < r:
    if nums[i] == 0:
      nums[l + 1], nums[i] = nums[i], nums[l + 1]
      l += 1
      i += 1
    elif nums[i] == 1:
      i += 1
    else:
      nums[r - 1], nums[i] = nums[i], nums[r -1]
      r -= 1
```

### O(n) time | O(1) space - n is length of array

## [Quick Sort](../Sortings/src/main/java/QuickSort.java)

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