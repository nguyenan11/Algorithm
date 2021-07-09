# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 9: 07/05 - 07/11/2021

# Category for this week:
**[Binary Search Tree](#binary-search-tree)**<br>
**[Sorting](#sorting)**<br>

---

# Binary Search Tree

## [BST Traversal](Binary%20Search%20Trees/src/main/java/BSTTraversal.java)
* **Important**: Check the pattern where the array.add/append is placed within each function

#### Level: Medium 📘

> Write three functions that take in a Binary Search Tree (BST) and an empty array, traverse the BST, add its nodes' values to the input array, and return that array. The three functions should traverse the BST using the in-order, pre-order, and post-order tree-traversal techniques, respectively.
>
> Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is strictly greater than the values of every node to its left; its `value` is less than or equal to the values of every node to its right; and its children nodes are either valid `BST` nodes themselves or `None` / `null`.

```java
public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
    // left, root, right
    if (tree != null) {
      inOrderTraverse(tree.left, array);
      array.add(tree.value);
      inOrderTraverse(tree.right, array);
    }
    return array;
}

public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
    if (tree != null) {
      array.add(tree.value);
      preOrderTraverse(tree.left, array);
      preOrderTraverse(tree.right, array);
    }
    return array;
}

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

## [Min Height BST]()



---

# Sorting

## [Heap Sort](Sortings/src/main/java/HeapSort.java)

#### Level: Hard 📕