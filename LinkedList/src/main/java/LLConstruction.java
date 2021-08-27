/*
  Write a `DoublyLinkedList` class that has a `head` and a `tail`, both of which point to either a
  linked list `Node` or `None` / `null`. The class should support:
  * Setting the head and tail of the linked list.
  * Inserting nodes before and after other nodes as well as at given positions (the position of the
  head node is `1`).
  * Removing given nodes and removing nodes with given values.
  * Searching for nodes with given values.

  Note that the `setHead`, `setTail`, `insertBefore`, `insertAfter`, `insertAtPosition`, and
  `remove` methods all take in actual `Node`s as input parameters—not integers (except for
  `insertAtPosition`, which also takes in an integer representing the position); this means that
  you don't need to create any new `Node`s in these methods. The input nodes can be either
  stand-alone nodes or nodes that are already in the linked list. If they're nodes that are already
  in the linked list, the methods will effectively be *moving* the nodes within the linked list.
  You won't be told if the input nodes are already in the linked list, so your code will have to
  defensively handle this scenario.

  Each `Node` has an integer `value` as well as a `prev` node and a `next` node, both of which can
  point to either another node or `None` / `null`.
*/

public class LLConstruction {

  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    // O(1) time | O(1) space
    public void setHead(Node node) {
      if (head == null) {
        head = node;
        tail = node;
        return;
      }
      insertBefore(head, node);
    }

    // O(1) time | O(1) space
    public void setTail(Node node) {
      if (tail == null) {
        setHead(node);
        return;
      }
      insertAfter(tail, node);
    }

    // O(1) time | O(1) space
    public void insertBefore(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == null) return; // node before itself so do nothing
      remove(nodeToInsert); // break the binding, then reconnect them
      nodeToInsert.prev = node.prev;
      nodeToInsert.next = node;
      if (node.prev == null) {
        head = nodeToInsert;
      } else {
        node.prev.next = nodeToInsert;
      }
      node.prev = nodeToInsert; // line 30 has to be there for this to work
    }

    // O(1) time | O(1) space
    public void insertAfter(Node node, Node nodeToInsert) { // opposite of insertBefore
      if (nodeToInsert == head && nodeToInsert == tail) return;
      remove(nodeToInsert);
      nodeToInsert.prev = node;
      nodeToInsert.next = node.next;
      if (node.next == null) {
        tail = nodeToInsert;
      } else {
        node.next.prev = nodeToInsert;
      }
      node.next = nodeToInsert;
    }

    // O(p) time | O(1) space
    public void insertAtPosition(int position, Node nodeToInsert) {
      if (position == 1) {
        setHead(nodeToInsert);
        return;
      }
      Node currNode = head;
      int currPosition = 1;
      while (currNode != null && currPosition++ != position) currNode = currNode.next;
      if (currNode != null) {
        insertBefore(currNode, nodeToInsert);
      } else {
        setTail(nodeToInsert);
      }
    }

    // O(n) time | O(1) space
    public void removeNodesWithValue(int value) {
      Node currNode = head;
      while (currNode != null) {
        Node nodeToRemove = currNode;
        // if we don't do this the binding will be broken later and currNode.next will be null
        currNode = currNode.next;
        if (nodeToRemove.value == value) remove(nodeToRemove);
      }
    }

    // O(1) time | O(1) space
    public void remove(Node node) {
      if (node == head) {
        head = node.next;
      }
      if (node == tail) {
        tail = node.prev;
      }
      removeNodeBinding(node);
    }

    public void removeNodeBinding(Node node) {
      if (node.prev != null) node.prev.next = node.next;
      if (node.next != null) node.next.prev = node.prev;
      node.prev = null;
      node.next = null;
    }

    // O(n) time | O(1) space
    public boolean containsNodeWithValue(int value) {
      Node currNode = head;
      while (currNode != null && currNode.value != value) currNode = currNode.next;
      return currNode != null;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }

}
