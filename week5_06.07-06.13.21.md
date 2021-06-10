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

> Leetcode problems only for this week

---

# Recursion

## [Leetcode #70 - Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
* Python

#### Level: Easy 📗

```python
def climbStairs(n) {
    if n == 1:
        return 1
    elif n == 2:
        return 2
    return climbStairs(n - 1) + climbStairs(n - 2)
}
```

### O(n) time | O(n) space
* Could make this O(1) space using Fibonacci Number approach

---

# Linked List

## [Leetcode #2 - Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
* Python

```python
def addTwoNumbers(self, l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
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

---

# Strings

## [Leetcode #3 - Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
* Redo problem using Python

#### Level: Medium 📘

```python
def lengthOfLongestSubstring(self, s):
    """
    :type s: str
    :rtype: int
    """
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


