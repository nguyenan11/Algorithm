public class LLConstruction {

  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
      if (head == null) {
        head = node;
        tail = node;
        return;
      }
      insertBefore(head, node);
    }

    public void setTail(Node node) {
      if (head == null) {
        head = node;
        tail = node;
        return;
      }
      insertAfter(tail, node);
    }

    public void insertBefore(Node node, Node nodeToInsert) {
      if (node == head) {
        head = nodeToInsert;
        head.next = node;
      } else {
        nodeToInsert.prev = node.prev;
        nodeToInsert.next = node;
        node.prev = nodeToInsert;
      }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
      if (node == tail) {
        tail = nodeToInsert;
        tail.prev = node;
      } else {
        nodeToInsert.next = node.next;
        nodeToInsert.prev = node;
        node.next = nodeToInsert;
      }
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
      Node currNode = head;
      while (position > 1) {
        currNode = currNode.next;
        position--;
      }
      insertBefore(currNode, nodeToInsert);
    }

    public void removeNodesWithValue(int value) {
      Node currNode = head;
      while (currNode != null) {
        Node nodeToRemove = currNode;
        currNode = currNode.next;
        if (nodeToRemove.value == value) remove(nodeToRemove);
      }
    }

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
