public class RemoveDuplicateFromLL {

  public static class LinkedList {

    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    LinkedList currNode = linkedList;
    while (currNode != null) {
      LinkedList nextNode = currNode.next;
      while (nextNode != null && nextNode.value == currNode.value) {
        nextNode = nextNode.next;
      }

      currNode.next = nextNode;
      currNode = nextNode;
    }
    return linkedList;
  }

}
