# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 5: 06/07 - 06/13/2021

# Category for this week:
**[Recursion](#recursion)**<br>
**[Linked List](#linked-list)**<br>
**[Strings](#strings)**<br>
**[Array](#array)**<br>

---

# Recursion

## [Leetcode #70 - Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
* *Python*

#### Level: Easy 📗

```python
def climbStairs(n):
    '''
    Function -- climbStairs
        Finds total number of distinct ways to climb to the top, given each 
        time you can either climb 1 or 2 steps.
    Parameter:
        n - number of stairs to reach a top, an int.
    Return:
        An int represents total number of distinct ways to climb the stairs.
    '''
    if n == 1:
        return 1
    elif n == 2:
        return 2
    return climbStairs(n - 1) + climbStairs(n - 2)
```

### O(n) time | O(n) space
* Could make this O(1) space using Fibonacci Number approach

---

# Linked List

## [Leetcode #2 - Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
* *Python*

```python
def addTwoNumbers(self, l1, l2):
    '''
    Function -- addTwoNumbers
        Given 2 non-empty Linked Lists, each represents an int in reverse order 
        (for ex, [1, 2, 3] means number 321). Calculates the sum of those 2 
        numbers and return the result in format of Linked List.
        Ex: [1, 2, 3] + [1, 2, 2, 3]  = [2, 4, 5, 3]
        Because 321 + 3221 = 3542
    Parameter:
        l1 - 1st Linked List of digits (integers)
        l2 - 2nd Linked List of digits (integers)
    Return:
        A Linked List of digits, which represents an int in reverse order.
    '''
    needAddOne = 0
    root = n = ListNode(0)
    while l1 or l2 or needAddOne:
        val1 = val2 = 0
        if l1:
            val1 = l1.val
            l1 = l1.next
        if l2:
            val2 = l2.val
            l2 = l2.next
        needAddOne, val = divmod(val1+val2+needAddOne, 10)
        n.next = ListNode(val)
        n = n.next
    return root.next
```

### O(max(m, n)) time | O(max(m, n)) space - where m is length of linked list 1 and n is length of linked list 2

## [Remove Duplicates From Linked List](../LinkedList/src/main/java/RemoveDuplicateFromLL.java)

#### Level: Easy 📗

> You're given the head of a Singly Linked List whose nodes are in sorted order with respect to their values. Write a function that returns a modified version of the Linked List that doesn't contain any nodes with duplicate values. The Linked List should be modified in place (i.e., you shouldn't create a brand new list), and the modified Linked List should still have its nodes sorted with respect to their values.
>
> Each `LinkedList` node has an integer `value` as well as a `next` node pointing to the next node in the list or to `None` / `null` if it's the tail of the list.

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

### O(n) time | O(1) space

---

# Strings

## [Leetcode #3 - Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
* Redo problem using Python

#### Level: Medium 📘

```python
def lengthOfLongestSubstring(self, s):
    '''
    Function -- lengthOfLongestSubstring
        Finds the longest substring without repeating character.
    Parameter:
        s - input String
    Return:
        Longest substring without repeating. 
        Assumption: There's only 1 longest substring.
    '''
    lastSeen = {}
    startIdx, longest = 0, 0
    for idx, char in enumerate(s):
        if char in lastSeen:
            startIdx = max(startIdx, lastSeen[char] + 1)
        longest = max(longest, idx + 1 - startIdx)
        lastSeen[char] = idx
    return longest
```

### O(n) time | O(min(n, a)) - n is the length of input string and a is the length of the character alphabet represented in the input string

---

# Array

## [Leetcode #1004 - Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)

#### Level: Medium 📘

```python
def longestOnes(self, nums, k):
    '''
    Function -- longestOnes
        Finds the maximum number of consecutive 1's in the array if you can 
        flip at most k 0's.
    Parameter:
        nums - binary array of integers (1 and 0 only)
        k - maximum number (an int) of 0's can be flipped into 1's
    Return:
        Maximum number of consecutive 1's after the operation was done, an int.
    '''
    i = 0
    for j in range(len(nums)):
        k -= 1 - nums[j]
        if k < 0:
            k += 1 - nums[i]
            i += 1
    return j - i + 1
```

### O(n) time | O(1) space - n is the number of elements in nums array

## [Leetcode #74 - Search a 2d Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

#### Level: Medium 📘

```python
def searchMatrix(self, matrix, target):
    '''
    Function -- searchMatrix
        Searches whether a value is in an m x n matrix.
    Parameter:
        matrix - array of arrays of integers, which has the following 
        properties:
            * Integers in each row are sorted from left to right.
            * The first integer of each row is greater than the last integer 
            of the previous row.
        target - a number to be searched, an int
    Return:
        True if target was found in the matrix, false otherwise.
    '''
    if not matrix or target is None:
        return False

    rows, cols = len(matrix), len(matrix[0])
    low, high = 0, rows * cols - 1
    
    while low <= high:
        mid = (low + high) / 2
        num = matrix[mid / cols][mid % cols]

        if num == target:
            return True
        elif num < target:
            low = mid + 1
        else:
            high = mid - 1
    
    return False
```

### O(log(mn)) time | O(1) space

## [Leetcode #84 - Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

#### Level: Hard 📕

```python
def largestRectangleArea(self, height):
    '''
    Function -- largestRectangleArea
        Placeholder
    Parameter:
        n - some
    Return:
        Placeholder
    '''
    n = len(height)

    # left[i], right[i] represent how many bars are >= than the current bar

    left = [1] * n
    right = [1] * n
    max_rect = 0

    # calculate left
    for i in range(0, n):
        j = i - 1
        while j >= 0:
            if height[j] >= height[i]:
                left[i] += left[j]
                j -= left[j]
            else: break

    # calculate right
    for i in range(n - 1, -1, -1):
        j = i + 1
        while j < n:
            if height[j] >= height[i]:
                right[i] += right[j]
                j += right[j]
            else: break

    for i in range(0, n):
        max_rect = max(max_rect, height[i] * (left[i] + right[i] - 1))

    return max_rect
```

### Complexity???

## [Leetcode #340 - Longest Substring with At Most K Distinct Characters]()

```python
def lengthOfLongestSubstringKDistinct(s: str, k: int) -> int:
    '''
    Function -- climbStairs
        Placeholder
    Parameter:
        n - some
    Return:
        Placeholder
    '''
    d = {}
    j, longest = 0, 0
    for i in range(len(s)):
        # default 0 otherwise d.get(s[i]) then add 1
        d[s[i]] = d.get(s[i], 0) + 1
        while len(d) > k:  # keep incrementing j until duplicate count goes down
            d[s[j]] -= 1
            if d[s[j]] == 0:  # duplicate removed
                d.pop(s[j])
            j += 1
        longest = max(longest, i - j + 1)
    return longest
```

### Complexity???