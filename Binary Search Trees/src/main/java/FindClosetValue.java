/*
  Write a function that takes in a Binary Search Tree (BST) and a target integer value and returns
  the closest value to that target value contained in the BST.

  You can assume that there will only be one closest value.

  Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is
  said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is
  strictly greater than the values of every node to its left; its `value` is less than or equal to
  the values of every node to its right; and its children nodes are either valid `BST` nodes
  themselves or `None` / `null`.
*/
public class FindClosetValue {

  /**
   * Finds a closet value to the target in a Binary Search Tree (recursive approach).
   * Complexity: Average: O(log n) time | O(log n) space - Worst: O(n) time | O(n) space.
   * Assumption: node's value is strictly greater than all values on left, and less or equal to
   * values on right.
   *
   * @param tree   - the root node, an BST object.
   * @param target - the given target, an int.
   * @return the int in BST that's closet to the target.
   */
  public static int findClosestValueInBst(BST tree, int target) {
    return findClosestValue(tree, target, tree.value);
  }


  /**
   * Helper method to find closet value recursively.
   *
   * @param node    - current node, an BST object.
   * @param target  - the given target, an int.
   * @param closest - the current closet value, an int.
   * @return the int that's closet the target.
   */
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

  static class BST {

    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }

}
