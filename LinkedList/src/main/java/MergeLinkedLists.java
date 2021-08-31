/*
  Write a function that takes in the heads of two Singly Linked Lists that are in sorted order,
  respectively. The function should merge the lists in place (i.e., it shouldn't create a brand
  new list) and return the head of the merged list; the merged list should be in sorted order.

  Each `LinkedList` node has an integer `value` as well as a `next` node pointing to the next node
  in the list or to `None` / `null` if it's the tail of the list.

  You can assume that the input Linked List will always have at least one node; in other words, the
  head will never be `None` / `null`.
*/
public class MergeLinkedLists {

  // This is an input class. Do not edit.
  public static class LinkedList {

    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  // O(n1 + n2) time | O(1) space
  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
    LinkedList p1 = headOne, p2 = headTwo, p1Prev = null;
    while (p1 != null && p2 != null) {
      if (p1.value < p2.value) {
        p1Prev = p1;
        p1 = p1.next;
      } else {
        if (p1Prev != null) {
          p1Prev.next = p2;
        }
        p1Prev = p2;
        p2 = p2.next;
        p1Prev.next = p1;
      }
    }
    if (p1 == null) {
      p1Prev.next = p2;
    }
    return headOne.value < headTwo.value ? headOne : headTwo;
  }

}
