import java.util.List;

/*
  Write three functions that take in a Binary Search Tree (BST) and an empty array, traverse the
  BST, add its nodes' values to the input array, and return that array. The three functions should
  traverse the BST using the in-order, pre-order, and post-order tree-traversal techniques,
  respectively.

  Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is
  said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is
  strictly greater than the values of every node to its left; its `value` is less than or equal to
  the values of every node to its right; and its children nodes are either valid `BST` nodes
  themselves or `None` / `null`.
*/
public class BSTTraversal {

  /**
   * Traverses BST using in-order.
   * Complexity: O(n) time | O(n) space
   *
   * @param tree  - a BST object.
   * @param array - result array containing tree's values, Integer array.
   * @return array of Integers.
   */
  public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
    // left, root, right
    if (tree != null) {
      inOrderTraverse(tree.left, array);
      array.add(tree.value);
      inOrderTraverse(tree.right, array);
    }
    return array;
  }

  /**
   * Traverses BST using pre-order.
   * Complexity: O(n) time | O(n) space
   *
   * @param tree  - a BST object.
   * @param array - result array containing tree's values, Integer array.
   * @return array of Integers.
   */
  public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
    // root, left, right
    if (tree != null) {
      array.add(tree.value);
      preOrderTraverse(tree.left, array);
      preOrderTraverse(tree.right, array);
    }
    return array;
  }

  /**
   * Traverses BST using post-order.
   * Complexity: O(n) time | O(n) space
   *
   * @param tree  - a BST object.
   * @param array - result array containing tree's values, Integer array.
   * @return array of Integers.
   */
  public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
    // left, right, root
    if (tree != null) {
      postOrderTraverse(tree.left, array);
      postOrderTraverse(tree.right, array);
      array.add(tree.value);
    }
    return array;
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
