import java.util.ArrayList;
import java.util.List;

/*
  Write a function that takes in a Binary Search Tree (BST) and a positive integer `k` and returns
  the kth largest integer contained in the BST.

  You can assume that there will only be integer values in the BST and that `k` is less than or
  equal to the number of nodes in the tree.

  Also, for the purpose of this question, duplicate integers will be treated as distinct values.
  In other words, the second largest value in a BST containing values `{5, 7, 7}` will be `7`—not
  `5`.
  
  Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is
  said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is
  strictly greater than the values of every node to its left; its `value` is less than or equal to
  the values of every node to its right; and its children nodes are either valid `BST` nodes
  themselves or `None` / `null`.
*/
public class FindKthLargestValue {

  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  // O(n) time | O(n) space
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

}
