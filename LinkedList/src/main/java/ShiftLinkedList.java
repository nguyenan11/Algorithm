public class ShiftLinkedList {

  public static LinkedList shiftLinkedList(LinkedList head, int k) {
    if (k == 0) return head;
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
    head = newHead;
    return head;
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
