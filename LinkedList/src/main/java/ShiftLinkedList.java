/*
  Write a function that takes in the head of a Singly Linked List and an integer `k`, shifts the
  list in place (i.e., doesn't create a brand new list) by k positions, and returns its new head.

  Shifting a Linked List means moving its nodes forward or backward and wrapping them around the
  list where appropriate. For example, shifting a Linked List forward by one position would make
  its tail become the new head of the linked list.

  Whether nodes are moved forward or backward is determined by whether `k` is positive or negative.

  Each `LinkedList` node has an integer `value` as well as a `next` node pointing to the next node
  in the list or to `None` / `null` if it's the tail of the list.

  You can assume that the input Linked List will always have at least one node; in other words, the
  head will never be `None` / `null`.
*/
public class ShiftLinkedList {

  // O(n) time | O(1) space
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
    int length = 1;
    LinkedList tail = head;
    while (tail.next != null) {
      tail = tail.next;
      length++;
    }

    int offset = Math.abs(k) % length;
    if (offset == 0) return head;
    int newTailPosition = k > 0 ? length - offset : offset; // logic for +/-
    LinkedList newTail = head;
    for (int i = 1; i < newTailPosition; i++) {
      newTail = newTail.next;
    }

    LinkedList newHead = newTail.next;
    newTail.next = null;
    tail.next = head;
    return newHead;
  }

  /*
  Brute force: O(k) time | O(1) space

  public static LinkedList shiftLinkedList(LinkedList head, int k) {
    if (k == 0) return head;
    if (k > 0) return positiveShift(head, k);
    return negativeShift(head, k);
  }

  public static LinkedList negativeShift(LinkedList head, int k) {
    LinkedList PtrOne = head;
    int newK = Math.abs(k);
    for (int i = 1; i < newK; i++) {
      if (PtrOne == null) PtrOne = head;
      PtrOne = PtrOne.next;
    }
    LinkedList newHead = PtrOne.next;
    if (newHead == null) return head;
    LinkedList currNode = PtrOne;
    while (currNode.next != null) {
      currNode = currNode.next;
    }
    currNode.next = head;
    PtrOne.next = null;
    return newHead;
  }

  public static LinkedList positiveShift(LinkedList head, int k) {
    LinkedList PtrOne = head;
    for (int i = 1; i <= k; i++) {
      if (PtrOne == null) PtrOne = head;
      PtrOne = PtrOne.next;
    }

    if (PtrOne == null) return head;
    LinkedList PtrTwo = head;
    while (PtrOne.next != null) {
      PtrOne = PtrOne.next;
      PtrTwo = PtrTwo.next;
    }
    LinkedList newHead = PtrTwo.next;
    PtrTwo.next = null;
    PtrOne.next = head;
    return newHead;
  }
  */

  static class LinkedList {

    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }

}
