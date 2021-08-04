import java.util.ArrayList;
import java.util.List;

/*
  You're given a `Node` class that has a `name` and an array of optional `children` nodes. When put
  together, nodes form an acyclic tree-like structure.

  Implement the `depthFirstSearch` method on the `Node` class, which takes in an empty array,
  traverses the tree using the Depth-first Search approach (specifically navigating the tree from
  left to right), stores all of the nodes' names in the input array, and returns it.
*/
public class DepthFirstSearch {

  static class Node {

    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }

    // O(v + e) time | O(v) space - v is number of vertices, e is number of edges
    public List<String> depthFirstSearch(List<String> array) {
      array.add(this.name);
      for (Node child : children) {
        child.depthFirstSearch(array);
      }
      return array;
    }

  }

}
