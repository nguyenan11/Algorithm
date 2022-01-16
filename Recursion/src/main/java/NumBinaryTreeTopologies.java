import java.util.ArrayList;
import java.util.List;

/*
  Write a function that takes in a non-negative integer `n` and returns the number of possible
  Binary Tree topologies that can be created with exactly n nodes.

  A Binary Tree topology is defined as any Binary Tree configuration, irrespective of node values.
  For instance, there exist only two Binary Tree topologies when `n` is equal to `2`: a root node
  with a left node, and a root node with a right node.

  Note that when `n` is equal to `0`, there's one topology that can be created: the `None` / `null`
  node.
*/
public class NumBinaryTreeTopologies {

  // O(n^2) time | O(n) space
  public static int numberOfBinaryTreeTopologies(int n) {
    List<Integer> cache = new ArrayList<Integer>();
    cache.add(1);
    for (int m = 1; m < n + 1; m++) {
      int numTrees = 0;
      for (int leftTreeSize = 0; leftTreeSize < m; leftTreeSize++) {
        int rightTreeSize = m - 1 - leftTreeSize;
        int numLeftTrees = cache.get(leftTreeSize);
        int numRightTrees = cache.get(rightTreeSize);
        numTrees += numLeftTrees * numRightTrees;
      }
      cache.add(numTrees);
    }
    return cache.get(n);
  }

  /*
  Brute force. Complexity: Upper Bound: O((n*(2n)!)/(n!(n+1)!)) time | O(n) space
  public static int numberOfBinaryTreeTopologies(int n) {
    if (n == 0) return 1;
    int numTrees = 0;
    for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
      int rightTreeSize = n - 1 - leftTreeSize;
      int numLeftTrees = numberOfBinaryTreeTopologies(leftTreeSize);
      int numRightTrees = numberOfBinaryTreeTopologies(rightTreeSize);
      numTrees += numLeftTrees * numRightTrees;
    }
    return numTrees;
  }
  */

}
