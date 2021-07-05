/*
  Write a `BST` class for a Binary Search Tree. The class should support:
  + Inserting values with the `insert` method.
  + Removing values with the `remove` method; this method should only remove the first instance of
  a given value.
  + Searching for values with the `contains` method.

  Note that you can't remove values from a single-node tree. In other words, calling the `remove`
  method on a single-node tree should simply not do anything.

  Each `BST` node has an integer `value`, a `left` child node, and a `right` child node. A node is
  said to be a valid `BST` node if and only if it satisfies the BST property: its `value` is
  strictly greater than the values of every node to its left; its `value` is less than or equal to
  the values of every node to its right; and its children nodes are either valid `BST` nodes
  themselves or `None` / `null`.
*/
public class BSTConstruction {

  // Average: O(log n) time | O(log n) space
  // Worst: O(n) time | O(n) space
  // Assumption: this BST allows duplications and duplications goes to right
  static class BST {

    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      if (value < this.value) {
        if (this.left == null) {
          BST newNode = new BST(value);
          this.left = newNode;
        } else {
          this.left = this.left.insert(value);
        }
      } else { // value >= this.value
        if (this.right == null) {
          BST newNode = new BST(value);
          this.right = newNode;
        } else {
          this.right = this.right.insert(value);
        }
      }
      return this;
    }

    public boolean contains(int value) {
      if (value < this.value) {
        if (this.left == null) {
          return false;
        }
        return this.left.contains(value);
      } else if (value > this.value) {
        if (this.right == null) {
          return false;
        }
        return this.right.contains(value);
      } else {
        return true;
      }
    }

    public BST remove(int value) {
      this.removeHelper(this, value);
      return this;
    }

    private BST removeHelper(BST root, int value) {
      // base case
      if (root == null) {
        return root;
      }

      // searching
      if (value < root.value) {
        root.left = removeHelper(root.left, value);
      } else if (value > root.value) {
        root.right = removeHelper(root.right, value);
      } else { // found a match
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
        } else { // node has both children
          root.value = findMin(root.right);
          root.right = removeHelper(root.right, root.value);
        }
      }
      return root;
    }

    private int findMin(BST root) {
      BST currNode = root;
      while (currNode.left != null) {
        currNode = currNode.left;
      }
      return currNode.value;
    }

  }

}
