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
