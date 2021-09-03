/*
  Need add prompt and check complexity
*/
public class RemoveDuplicateFromLL {

  /**
   * This is an input class. Do not edit.
   */
  public static class LinkedList {

    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  /**
   * Loops through a Linked List, and remove any node(s) with duplicated value.
   * Complexity: O(n) time | O(1) space.
   * Edge case: There might more than 1 node with duplicated value.
   *
   * @param linkedList - a LinkedList object, where each node contains a value and a next node.
   * @return the result LinkedList with any duplication(s) removed.
   */
  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    LinkedList currNode = linkedList;
    while (currNode != null) {
      LinkedList nextNode = currNode.next;
      while (nextNode != null && nextNode.value == currNode.value) {
        nextNode = nextNode.next;
      }

      currNode.next = nextNode;
      currNode = nextNode;
    }
    return linkedList;
  }

}
