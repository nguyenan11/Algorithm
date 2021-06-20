import java.util.Stack;

public class NextGreaterElement {

  public int[] nextGreaterElement(int[] array) {
    Stack<Integer> stack = new Stack<>();
    int currLargest = array[0];
    stack.add(currLargest);
    for (int i = 1; i < array.length; i++) {
      if (array[i] > currLargest) {
        currLargest = array[i];
        stack.add(currLargest);
      }
    }
    return null;
  }

}
