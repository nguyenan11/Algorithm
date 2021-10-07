import java.util.ArrayList;
import java.util.List;

/*
  The pre-order traversal of a Binary Tree is a traversal technique that starts at the tree's root
  node and visits nodes in the following order:
  * Current node
  * Left subtree
  * Right subtree

  Given a non-empty array of integers representing the pre-order traversal of a Binary Search Tree
  (BST), write a function that creates the relevant BST and returns its root node.

  The input array will contain the values of BST nodes in the order in which these nodes would be
  visited with a pre-order traversal.
*/
public class ReconstructBST {

  // This is an input class. Do not edit.
  static class BST {

    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  /**
   * Helper class. Important to have this class, to keep track of current index.
   */
  class Index {

    int index;

    public Index(int index) {
      this.index = index;
    }
  }

  /**
   * Reconstruct a BST from an unsorted array of Integers.
   * Complexity: O(n) time | O(n) space.
   *
   * @param pre - unsorted array of Integers.
   * @return a valid BST.
   */
  public BST reconstructBst(ArrayList<Integer> pre) {
    return constructBst(pre, Integer.MIN_VALUE, Integer.MAX_VALUE, new Index(0));
  }

  /**
   * Helper method but also main method to actually perform all the reconstruction of BST.
   *
   * @param pre        - unsorted array of Integers.
   * @param lowerBound - the lower bound of current BST node, an int.
   * @param upperBound - the upper bound of current BST node, an int.
   * @param index      - current index corresponding to index of element in 'pre', an Index object.
   * @return the valid constructed BST node.
   */
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

}
