/*
  You're given two Linked Lists of potentially unequal length. Each Linked List represents a
  non-negative integer, where each node in the Linked List is a digit of that integer, and the
  first node in each Linked List always represents the least significant digit of the integer.
  Write a function that returns the head of a new Linked List that represents the sum of the
  integers represented by the two input Linked Lists.

  Each `LinkedList` node has an integer `value` as well as a `next` node pointing to the next node
  in the list or to `None` / `null` if it's the tail of the list. The `value` of each `LinkedList`
  node is always in the range of `0 - 9`.

  Note: your function must create and return a new Linked List, and you're not allowed to modify
  either of the input Linked Lists.
*/
public class SumOfLinkedList {

  // This is an input class. Do not edit.
  public static class LinkedList {

    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  // O(max(n1,n2)) time | O(max(n1,n2)) space
  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    LinkedList newHead = new LinkedList(0), currNode = newHead;
    int needAdd1 = 0;
    while (linkedListOne != null || linkedListTwo != null || needAdd1 != 0) {
      int val1 = 0, val2 = 0;
      if (linkedListOne != null) {
        val1 = linkedListOne.value;
        linkedListOne = linkedListOne.next;
      }
      if (linkedListTwo != null) {
        val2 = linkedListTwo.value;
        linkedListTwo = linkedListTwo.next;
      }
      int currSum = val1 + val2 + needAdd1;
      int newValue = currSum % 10; // divmod in python would save 2 lines
      needAdd1 = currSum / 10;
      currNode.next = new LinkedList(newValue);
      currNode = currNode.next;
    }
    return newHead.next;
  }

}
