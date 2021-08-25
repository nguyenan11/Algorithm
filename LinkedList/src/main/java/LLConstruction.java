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
      if (tail == null) {
        setHead(node);
        return;
      }
      insertAfter(tail, node);
    }

    public void insertBefore(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == null) return;
      remove(nodeToInsert);
      nodeToInsert.prev = node.prev;
      nodeToInsert.next = node;
      if (node.prev == null) {
        head = nodeToInsert;
      } else {
        node.prev.next = nodeToInsert;
      }
      node.prev = nodeToInsert;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
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
