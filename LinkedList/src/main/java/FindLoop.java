/*
  Write a function that takes in the head of a Singly Linked List that contains a loop (in other
  words, the list's tail node points to some node in the list instead of `None` / `null`). The
  function should return the node (the actual node--not just its value) from which the loop
  originates in constant space.

  Each `LinkedList` node has an integer `value` as well as a `next` node pointing to the next node
  in the list.
*/
public class FindLoop {

  // O(n) time | O(1) space
  public static LinkedList findLoop(LinkedList head) {
    LinkedList slowPtr = head.next;
    LinkedList fastPtr = head.next.next;
    while (slowPtr != fastPtr) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }
    slowPtr = head;
    while (slowPtr != fastPtr) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next;
    }
    return slowPtr;
  }

  // Brute force: Traverse the LL, store value in a HashTable or Set
  // -> when repeated value found -> start of loop

  static class LinkedList {

    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }

}
