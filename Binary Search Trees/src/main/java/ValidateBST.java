public class ValidateBST {

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
