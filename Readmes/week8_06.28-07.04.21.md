# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
  * Alternative (less optimal) solutions might also be available within each 
  file

# Week 8: 06/28 - 07/04/2021

# Category for this week:
**[Binary Search](#binary-search)**<br>
**[Binary Search Tree](#binary-search-tree)**<br>

---

# Binary Search

## [Leetcode #278 - First Bad Version](https://leetcode.com/problems/first-bad-version/)
* *Python*

#### Level: Easy 📗

```python
def firstBadVersion(self, n):
  '''
  Function -- firstBadVersion
    Finds the first bad version in array of versions, because version are built
    from its previous version.

    Note: function bool isBadVersion(version) is given.
  Parameter:
    n - array of int, starting from 1 to n, ascending.
  Return:
    First bad version, an int.
  '''
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

### O(log n) time | O(1) space

---

# Binary Search Tree

## [Find Closet Value in BST](../Binary%20Search%20Trees/src/main/java/FindClosetValue.java)

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

## [BST Construction](../Binary%20Search%20Trees/src/main/java/BSTConstruction.java)

#### Level: Medium 📘

> Write a `BST` class for a Binary Search Tree. The class should support:
>  + Inserting values with the `insert` method.
>  + Removing values with the `remove` method; this method should only remove the first instance of a given value.
>  + Searching for values with the `contains` method.
>
> Note that you can't remove values from a single-node tree. In other words, calling the `remove` method on a single-node tree should simply not do anything.
>
> Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is strictly greater than the values of every node to its left; its `value` is less than or equal to the values of every node to its right; and its children nodes are either valid `BST` nodes themselves or `None` / `null`.

```java
// Major assumption: this BST allows duplications and duplications goes to right
static class BST {

  public int value;
  public BST left;
  public BST right;

  public BST(int value) {
    this.value = value;
  }

  public BST insert(int value) {
    if (value < this.value) {
      if (this.left == null) {
        BST newNode = new BST(value);
        this.left = newNode;
      } else {
        this.left = this.left.insert(value);
      }
    } else { // value >= this.value
      if (this.right == null) {
        BST newNode = new BST(value);
        this.right = newNode;
      } else {
        this.right = this.right.insert(value);
      }
    }
    return this;
  }

  public boolean contains(int value) {
    if (value < this.value) {
      if (this.left == null) {
        return false;
      }
      return this.left.contains(value);
    } else if (value > this.value) {
      if (this.right == null) {
        return false;
      }
      return this.right.contains(value);
    } else {
      return true;
    }
  }

  public BST remove(int value) {
    this.removeHelper(this, value);
    return this;
  }

  private BST removeHelper(BST root, int value) {
    // base case
    if (root == null) {
      return root;
    }

    // searching
    if (value < root.value) {
      root.left = removeHelper(root.left, value);
    } else if (value > root.value) {
      root.right = removeHelper(root.right, value);
    } else { // found a match
      if (root.left == null && root.right == null) {
        return null;
      }
      if (root.left == null) {
        root.value = root.right.value;
        root.left = root.right.left;
        root.right = root.right.right;
      } else if (root.right == null) {
        root.value = root.left.value;
        root.right = root.left.right;
        root.left = root.left.left;
      } else { // node has both children
        root.value = findMin(root.right);
        root.right = removeHelper(root.right, root.value);
      }
    }
    return root;
  }

  private int findMin(BST root) {
    BST currNode = root;
    while (currNode.left != null) {
      currNode = currNode.left;
    }
    return currNode.value;
  }

}
```

### Average: O(log n) time | O(log n) space. 
* Worst: O(n) time | O(n) space when tree has 1 branch.
* Same idea as above problem to make it O(1) space.

## [Validate BST](../Binary%20Search%20Trees/src/main/java/ValidateBST.java)

#### Level: Medium 📘

> Write a function that takes in a potentially invalid Binary Search Tree (BST) and returns a boolean representing whether the BST is valid.
>
> Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is strictly greater than the values of every node to its left; its `value` is less than or equal to the values of every node to its right; and its children nodes are either valid `BST` nodes themselves or `None` / `null`.
>
> A BST is valid if and only if all of its nodes are valid `BST` nodes.

```java
public static boolean validateBst(BST tree) {
  return validate(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public static boolean validate(BST root, int minValue, int maxValue) {
  if (root.value < minValue || root.value >= maxValue) {
    return false;
  }
  if (root.left != null && !validate(root.left, minValue, root.value)) {
    return false;
  }
  return root.right == null || validate(root.right, root.value, maxValue);
}

static class BST {

  public int value;
  public BST left;
  public BST right;

  public BST(int value) {
    this.value = value;
  }
}
```

### O(n) time | O(h) space - n is number of nodes in tree, h is the height of tree (or length of the longest branch).
* O(h) space due to using space on call stack.
