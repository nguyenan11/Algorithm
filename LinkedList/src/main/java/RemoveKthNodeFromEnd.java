/*
  Write a function that takes in the head of a Singly Linked List and an integer `k` and removes
  the kth node from the end of the list.

  The removal should be done in place, meaning that the original data structure should be mutated
  (no new structure should be created).

  Furthermore, the input head of the linked list should remain the head of the linked list after
  the removal is done, even if the head is the node that's supposed to be removed. In other words,
  if the head is the node that's supposed to be removed, your function should simply mutate its
  `value` and `next` pointer

  Note that your function doesn't need to return anything.
  You can assume that the input Linked List will always have at least two nodes and, more
  specifically, at least k nodes.

  Each `LinkedList` node has an integer `value` as well as a `next` node pointing to the next node
  in the list or to `None` / `null` if it's the tail of the list.
*/
public class RemoveKthNodeFromEnd {

  // O(n) time | O(1) space
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    LinkedList iteratingPtr = head;
    LinkedList KthPtr = head;
    for (int i = 1; i <= k; i++) {
      iteratingPtr = iteratingPtr.next;
    }

    // edge case when head is supposed to be removed
    if (iteratingPtr == null) {
      head.value = head.next.value;
      head.next = head.next.next;
      return;
    }

    while (iteratingPtr.next != null) {
      iteratingPtr = iteratingPtr.next;
      KthPtr = KthPtr.next;
    }
    KthPtr.next = KthPtr.next.next;
  }

  static class LinkedList {

    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }

}
