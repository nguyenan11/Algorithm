/*
  Write a function that takes in a potentially invalid Binary Search Tree (BST) and returns a
  boolean representing whether the BST is valid.

  Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is
  said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is
  strictly greater than the values of every node to its left; its `value` is less than or equal to
  the values of every node to its right; and its children nodes are either valid `BST` nodes
  themselves or `None` / `null`.

  A BST is valid if and only if all of its nodes are valid `BST` nodes.
*/
public class ValidateBST {

  // O(n) time | O(h) space - n is number of nodes in tree, h is the height of tree.
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

}
