public class BSTConstruction {

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      BST current = this;
      while (true) {
        if (value < current.value) {
          if (current.left != null) {
            current = current.left;
          } else {
            current.left = new BST(value);
            break;
          }
        } else {
          if (current.right != null) {
            current = current.right;
          } else {
            current.right = new BST(value);
            break;
          }
        }
      }
      return this;
    }

    public boolean contains(int value) {
      BST current = this;
      while (current != null) {
        if (value < current.value) {
          current = current.left;
        } else if (value > current.value) {
          current = current.right;
        } else {
          return true;
        }
      }
      return false;
    }

    public BST remove(int value) {
      removeHelper(this, value);
      return this;
    }

    public BST removeHelper(BST root, int value) {
      // base case
      if (root == null) return root;
      // searching for the node to delete
      if (value < root.value) {
        root.left = removeHelper(root.left, value);
      } else if (value > root.value) {
        root.right = removeHelper(root.right, value);
      } else {
        // node with no child or 1 child
        if (root.left == null && root.right == null) {
          return null;
        }
        if (root.left == null) {
          root.value = root.right.value;
          root.left = root.right.left;
          root.right = root.right.right;
        } else if (root.right == null) {
          root.value = root.left.value;
          root.right = root.left.right;
          root.left = root.left.left;
        } else {
          // root with 2 children
          root.value = minValue(root.right);
          root.right = removeHelper(root.right, root.value);
        }
      }
      return root;
    }

    public int minValue(BST root) {
      int minValue = root.value;
      while (root.left != null) {
        minValue = root.left.value;
        root = root.left;
      }
      return minValue;
    }
  }

}
