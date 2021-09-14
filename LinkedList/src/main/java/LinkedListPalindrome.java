import java.util.Stack;

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

}
