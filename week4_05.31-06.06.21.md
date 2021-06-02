# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 4: 05/31 - 06/06/2021

# Category for this week: 
**[Strings](#strings)**<br>
**[Sorting](#sorting)**<br>
**[Linked List](#linked-list)**<br>


---

# Strings

## [Longest Palindromic Substring](Strings/src/main/java/LongestPalindromicSubstring.java)

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

## [Longest Substring Without Duplication](Strings/src/main/java/LongestSubstringWithoutDuplication.java)

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

---

# Linked List

## [Remove Duplicates From Linked List](Linked List/src/main/java/RemoveDuplicateFromLL.java)

#### Level: Easy 📗

```java
public static class LinkedList {
  public int value;
  public LinkedList next;

  public LinkedList(int value) {
    this.value = value;
    this.next = null;
  }
}

public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
  LinkedList currNode = linkedList;
  while (currNode != null) {
    LinkedList nextNode = currNode.next;
    while (nextNode != null && nextNode.value == currNode.value) {
      nextNode = nextNode.next;
    }

    currNode.next = nextNode;
    currNode = nextNode;
  }
  return linkedList;
}
```