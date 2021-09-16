/*
  Write a function that takes in the head of a Singly Linked List and returns a boolean representing
  whether the linked list's nodes form a palindrome. Your function shouldn't make use of any
  auxiliary data structure.

  A palindrome is usually defined as a string that's written the same forward and backward. For a
  linked list's nodes to form a palindrome, their values must be the same when read from left to
  right and from right to left. Note that single-character strings are palindromes, which means
  that single-node linked lists form palindromes.
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
    LinkedList slowNode = head;
    LinkedList fastNode = head;
    while (fastNode != null && fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }
    LinkedList reversedSecondHalfNode = reverseLinkedList(slowNode);
    LinkedList firstHalfNode = head;
    while (reversedSecondHalfNode != null) {
      if (reversedSecondHalfNode.value != firstHalfNode.value) return false;
      reversedSecondHalfNode = reversedSecondHalfNode.next;
      firstHalfNode = firstHalfNode.next;
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

  /* Alternative | When we cannot modify the LL
  O(n) time | O(n) space | Implement Recursive using left node, right node for same complexity

  public boolean linkedListPalindrome(LinkedList head) {
    Stack<Integer> stack = new Stack<>();
    LinkedList currNode = head;
    while (currNode != null) {
      stack.add(currNode.value);
      currNode = currNode.next;
    }

		currNode = head;
		while (currNode != null) {
			if (stack.peek() != currNode.value) return false;
			stack.pop();
			currNode = currNode.next;
		}
    return true;
  }
  */


  /*
  This approach fails only 1 test case on LL 3 -> 1 -> 2 -> 3
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
  */

}
