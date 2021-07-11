import java.util.ArrayList;
import java.util.List;

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

  class Index {

    int index;

    public Index(int index) {
      this.index = index;
    }
  }

  public BST reconstructBst(ArrayList<Integer> pre) {
    return constructBst(pre, Integer.MIN_VALUE, Integer.MAX_VALUE, new Index(0));
  }

  public BST constructBst(List<Integer> pre, int minValue, int maxValue, Index index) {
    // base case
    if (index.index >= pre.size()) {
      return null;
    }

    BST node = null;
    int value = pre.get(index.index);
    // if the current element of pre is in range
    if (value >= minValue && value < maxValue) {
      node = new BST(value);
      index.index += 1;

      if (index.index < pre.size()) {
        // Construct the subtree under root
        node.left = constructBst(pre, minValue, value, index);
      }

      if (index.index < pre.size()) {
        // Construct the right subtree
        node.right = constructBst(pre, value, maxValue, index);
      }
    }
    return node;
  }

}
