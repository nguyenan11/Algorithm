/*

 */
public class LinkedListPalindrome {

  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public boolean linkedListPalindrome(LinkedList head) {
    LinkedList reversedLLHead = reverseLinkedList(head);
    LinkedList currNode = head;
    LinkedList currReverseNode = reversedLLHead;
    while (currNode != null) {
      if (currNode.value != currReverseNode.value) return false;
      currNode = currNode.next;
      currReverseNode = currReverseNode.next;
    }
    return true;
  }

  public static LinkedList reverseLinkedList(LinkedList head) {
    LinkedList currNode = head;
    LinkedList prevNode = null;
    while (currNode != null) {
      LinkedList nextNode = currNode.next;
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = nextNode;
    }
    return prevNode;
  }

  /*
  This approach will work if the case where odd number of nodes is taken care, which requires more
  steps
  public boolean linkedListPalindrome(LinkedList head) {
    Stack<Integer> stack = new Stack<>();
    LinkedList currNode = head;
    while (currNode != null) {
      if (stack.isEmpty()) {
        stack.add(currNode.value);
      } else {
        if (stack.peek() == currNode.value) {
          stack.pop();
        } else {
          stack.add(currNode.value);
        }
      }
      currNode = currNode.next;
    }
    return stack.isEmpty() || stack.size() == 1 ;
  }
  */

}
