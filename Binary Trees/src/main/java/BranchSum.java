import java.util.ArrayList;
import java.util.List;

public class BranchSum {

  /**
   * Write a function that takes in a Binary Tree and returns a list of its branch sums ordered from
   * leftmost branch sum to rightmost branch sum.
   *
   *
   * A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree branch is a path
   * of nodes in a tree that starts at the root node and ends at any leaf node.
   *
   * Each BinaryTree nodes has an integer value, a left child node, and a right child node. Children
   * nodes can either be BinaryTree nodes themselves or None/ Null.
   */

  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {

    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
    return new ArrayList<Integer>();
  }
}

