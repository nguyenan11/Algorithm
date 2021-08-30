/*
  Write a function that takes in the head of a Singly Linked List, reverses the list in place
  (i.e., doesn't create a brand new list), and returns its new head.

  Each `LinkedList` node has an integer `value` as well as a `next` node pointing to the next node
  in the list or to `None` / `null` if it's the tail of the list.

  You can assume that the input Linked List will always have at least one node; in other words, the
  head will never be `None` / `null`.
*/
public class ReverseLinkedList {

  // O(n) time | O(1) space
  public static LinkedList reverseLinkedList(LinkedList head) {
    LinkedList currNode = head;
    LinkedList prevNode = null;
    while (currNode != null) {
      LinkedList nextNode = currNode.next; // temp node
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = nextNode;
    }
    return prevNode;
  }

  /* Brute force: O(2n) -> O(n) time | O(n) space
  public static LinkedList reverseLinkedList(LinkedList head) {
    Stack<Integer> stack = new Stack<Integer>();
    LinkedList currNode = head;
    while (currNode != null) {
      stack.push(currNode.value);
      currNode = currNode.next;
    }
    currNode = head;
    while (!stack.empty()) {
      currNode.value = stack.pop();
      currNode = currNode.next;
    }
    return head;
  }
   */


  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }

}
