import java.util.List;

/*
  Write a function that takes in a non-empty sorted array of distinct integers, constructs a BST
  from the integers, and returns the root of the BST.

  The function should minimize the height of the BST.

  You've been provided with a `BST` class that you'll have to use to construct the BST.

  Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is
  said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is
  strictly greater than the values of every node to its left; its `value` is less than or equal to
  the values of every node to its right; and its children nodes are either valid `BST` nodes
  themselves or `None` / `null`.>

  A BST is valid if and only if all of its nodes are valid `BST` nodes.

  Note that the `BST` class already has an `insert` method which you can use if you want.
*/
public class MinHeightBST {

  /**
   * Initializes the reconstruction of BST.
   * Complexity: O(n) time | O(n) space.
   * Important: array is sorted.
   *
   * @param array - non-empty sorted array of Integers.
   * @return a valid BST with the minimum height possible.
   */
  public static BST minHeightBst(List<Integer> array) {
    return reconstructBST(array, null, 0, array.size() - 1);
  }

  /**
   * Helper method to recursively reconstruct the BST.
   *
   * @param array    - input array of Integers.
   * @param bst      - current BST node.
   * @param startIdx - the start index on array, an int.
   * @param endIdx   - the end index on array, an int.
   * @return the BST node after it's been reconstructed.
   */
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

  /*
  Complexity: O(nlog(n)) time | O(n) space because using insert function take log(n) time ->
  n elements will take nlog(n).

  public static BST reconstructBST(List<Integer> array, BST bst, int startIdx, int endIdx) {
    if (endIdx < startIdx) return null;
    int midIdx = (startIdx + endIdx) / 2;
    int valueAdded = array.get(midIdx);
    if (bst == null) {
      bst = new BST(valueAdded);
    } else {
      bst.insert(valueAdded); // log(n) time
    }
    reconstructBST(array, bst, startIdx, midIdx - 1);
    reconstructBST(array, bst, midIdx + 1, endIdx);
    return bst;
  }
  */

  static class BST {

    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }

}
