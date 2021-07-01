public class FindClosetValue {

  public static int findClosestValueInBst(BST tree, int target) {
    return findClosestValue(tree, target, tree.value);
  }


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
