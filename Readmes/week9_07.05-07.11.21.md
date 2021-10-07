# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
  * Alternative (less optimal) solutions might also be available within each 
  file

# Week 9: 07/05 - 07/11/2021

# Category for this week:
**[Binary Search Tree](#binary-search-tree)**<br>

---

# Binary Search Tree

## [BST Traversal](../Binary%20Search%20Trees/src/main/java/BSTTraversal.java)
* **Important**: Check the pattern *where* the array.add/append is placed within each function

#### Level: Medium 📘

> Write three functions that take in a Binary Search Tree (BST) and an empty array, traverse the BST, add its nodes' values to the input array, and return that array. The three functions should traverse the BST using the in-order, pre-order, and post-order tree-traversal techniques, respectively.
>
> Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is strictly greater than the values of every node to its left; its `value` is less than or equal to the values of every node to its right; and its children nodes are either valid `BST` nodes themselves or `None` / `null`.

```java
// left, root, right
public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
  if (tree != null) {
    inOrderTraverse(tree.left, array);
    array.add(tree.value);
    inOrderTraverse(tree.right, array);
  }
  return array;
}

// root, left, right
public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
  if (tree != null) {
    array.add(tree.value);
    preOrderTraverse(tree.left, array);
    preOrderTraverse(tree.right, array);
  }
  return array;
}

// left, right, root
public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
  if (tree != null) {
    postOrderTraverse(tree.left, array);
    postOrderTraverse(tree.right, array);
    array.add(tree.value);
  }
  return array;
}
```

### O(n) time | O(n) space

## [Min Height BST](../Binary%20Search%20Trees/src/main/java/MinHeightBST.java)

#### Level: Medium 📘

> Write a function that takes in a non-empty sorted array of distinct integers, constructs a BST from the integers, and returns the root of the BST.
> The function should minimize the height of the BST.
> You've been provided with a `BST` class that you'll have to use to construct the BST.
>
> Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is strictly greater than the values of every node to its left; its `value` is less than or equal to the values of every node to its right; and its children nodes are either valid `BST` nodes themselves or `None` / `null`.
>
> A BST is valid if and only if all of its nodes are valid `BST` nodes.
> Note that the `BST` class already has an `insert` method which you can use if you want.

```java
public static BST reconstructBST(List<Integer> array, BST bst, int startIdx, int endIdx) {
  if (endIdx < startIdx) {
    return null;
  }
  int midIdx = (startIdx + endIdx) / 2;
  BST newNode = new BST(array.get(midIdx));
  if (bst == null) {
    bst = newNode;
  } else {
    if (array.get(midIdx) < bst.value) {
      bst.left = newNode;
      bst = bst.left;
    } else {
      bst.right = newNode;
      bst = bst.right;
    }
  }
  reconstructBST(array, bst, startIdx, midIdx - 1);
  reconstructBST(array, bst, midIdx + 1, endIdx);
  return bst;
}
```

### O(n) time | O(n) space

## [Find Kth Largest Value in BST](../Binary%20Search%20Trees/src/main/java/FindKthLargestValue.java)

#### Level: Medium 📘

> Write a function that takes in a Binary Search Tree (BST) and a positive integer `k` and returns the kth largest integer contained in the BST.
>
> You can assume that there will only be integer values in the BST and that `k` is less than or equal to the number of nodes in the tree.
> Also, for the purpose of this question, duplicate integers will be treated as distinct values. In other words, the second largest value in a BST containing values `{5, 7, 7}` will be `7`—not `5`.
>
> Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is strictly greater than the values of every node to its left; its `value` is less than or equal to the values of every node to its right; and its children nodes are either valid `BST` nodes themselves or `None` / `null`.

```java
public int findKthLargestValueInBst(BST tree, int k) {
  List<Integer> inOrderArr = new ArrayList<>();
  inOrderBST(tree, inOrderArr);
  int idx = inOrderArr.size() - k;
  return inOrderArr.get(idx);
}

public void inOrderBST(BST tree, List<Integer> array) {
  if (tree != null) {
    inOrderBST(tree.left, array);
    array.add(tree.value);
    inOrderBST(tree.right, array);
  }
}
```

### O(n) time | O(n) space

## [Reconstruct BST](../Binary%20Search%20Trees/src/main/java/ReconstructBST.java)

#### Level: Medium 📘

> The pre-order traversal of a Binary Tree is a traversal technique that starts at the tree's root node and visits nodes in the following order:
> * Current node
> * Left subtree
> * Right subtree
> Given a non-empty array of integers representing the pre-order traversal of a Binary Search Tree (BST), write a function that creates the relevant BST and returns its root node.
> The input array will contain the values of BST nodes in the order in which these nodes would be visited with a pre-order traversal.

```java
class Index {
  int index;
  public Index(int index) {
    this.index = index;
  }
}

public BST reconstructBst(ArrayList<Integer> pre) {
  return constructBst(pre, Integer.MIN_VALUE, Integer.MAX_VALUE, new Index(0));
}

public BST constructBst(List<Integer> pre, int lowerBound, int upperBound, Index index) {
  // base case
  if (index.index == pre.size()) {
    return null;
  }

  int value = pre.get(index.index);
  if (value < lowerBound || value >= upperBound) {
    return null;
  }
  index.index += 1;
  BST leftSubtree = constructBst(pre, lowerBound, value, index);
  BST rightSubtree = constructBst(pre, value, upperBound, index);
  BST currNode = new BST(value);
  currNode.left = leftSubtree;
  currNode.right = rightSubtree;
  return currNode;
}
```

### O(n) time | O(n) space

## [Leetcode #783 - Minimum Distance Between BST Nodes](https://leetcode.com/problems/minimum-distance-between-bst-nodes/)
* *Python*

#### Level: Easy 📗

```python
class Solution(object):
  previous = -float('inf')
  result = float('inf')

  def minDiffInBST(self, root):
    '''
    Function -- minDiffInBST
      Finds the minimum difference between the values of any two different nodes
      in the tree.
    Parameter:
      root - the root of a BST.
    Return:
      The minimum different, an int.
    '''
    if root.left:
      self.minDiffInBST(root.left)
    self.result = min(self.result, root.val - self.previous)
    self.previous = root.val
    if root.right:
      self.minDiffInBST(root.right)
    return self.result
```

### O(n) time | O(h) space - n is number of elements, h is the height of BST
