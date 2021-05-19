public class FindClosetValue {

  public static int findClosestValueInBst(BST tree, int target) {
    int closetValue = tree.value;
    if (closetValue - target == 0) return closetValue; // case base

    if (target < tree.value && tree.left != null) {
      return Math.min(closetValue, findClosestValueInBst(tree.left, target));
    } else if (target > tree.value && tree.right != null) {
      return Math.min(closetValue, findClosestValueInBst(tree.right, target));
    } else {
      return closetValue;
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
