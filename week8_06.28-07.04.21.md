# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 8: 06/28 - 07/04/2021

# Category for this week:
**[Binary Search](#binary-search)**<br>
**[Sorting](#sorting)**<br>
**[Linked List](#linked-list)**<br>

---

# Binary Search

## [Leetcode #278 - First Bad Version](https://leetcode.com/problems/first-bad-version/)
* *Python*

#### Level: Easy 📗

```python
def firstBadVersion(self, n):
  """
  :type n: int
  :rtype: int
  """
  left = 1
  right = n
  while left < right:
    mid = left + (right - left) / 2
    if isBadVersion(mid):
      right = mid
    else:
      left = mid + 1
  return left
```

### Complexity???

## [Find Closet Value in BST](Binary Search Trees/src/main/java/FindClosetValue.java)

#### Level: Easy 📗

> Write a function that takes in a Binary Search Tree (BST) and a target integer value and returns the closest value to that target value contained in the BST.
>
> You can assume that there will only be one closest value.
>
> Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is strictly greater than the values of every node to its left; its `value` is less than or equal to the values of every node to its right; and its children nodes are either valid `BST` nodes themselves or `None` / `null`.

```java
public static int findClosestValueInBst(BST tree, int target) {
  return findClosestValue(tree, target, tree.value);
}


public static int findClosestValue(BST node, int target, int closest) {
  if (node == null) {
    return closest; // case base
  }

  closest = Math.abs(closest - target) > Math.abs(node.value - target) ? node.value : closest;

  if (target < node.value) {
    return findClosestValue(node.left, target, closest);
  } else if (target > node.value) {
    return findClosestValue(node.right, target, closest);
  } else {
    return node.value;
  }
}
```

### Average: O(log n) time | O(log n) space. 
* Worst: O(n) time | O(n) space when tree has 1 branch.
* Could use O(1) space by solving iteratively; still 2 functions, use currNode and get rid of base case.

## [BST Construction](Binary Search Trees/src/main/java/BSTConstruction.java)

#### Level: Medium 📘

```java

```

---

# Sorting

## [Heap Sort](Sortings/src/main/java/HeapSort.java)

#### Level: Hard 📕

---

# Linked List

## [Remove Duplicates From Linked List](LinkedList/src/main/java/RemoveDuplicateFromLL.java)

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