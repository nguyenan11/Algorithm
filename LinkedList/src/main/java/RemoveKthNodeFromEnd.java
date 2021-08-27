public class RemoveKthNodeFromEnd {

  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    LinkedList iteratingPtr = head;
    LinkedList KthPtr = head;
    for (int i = 1; i <= k; i++) {
      iteratingPtr = iteratingPtr.next;
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
