public class ShiftLinkedList {

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

  static class LinkedList {

    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }

}
