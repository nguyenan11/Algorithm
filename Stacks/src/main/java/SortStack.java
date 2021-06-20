import java.util.ArrayList;

public class SortStack {

  // O(n^2) time | O(n) space
  public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
    if (stack.size() == 0) return stack;

    int top = stack.remove(stack.size() - 1);
    sortStack(stack);
    insertInSortOrder(stack, top);
    return stack;
  }

  public void insertInSortOrder(ArrayList<Integer> stack, int value) {
    if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
      stack.add(value);
      return;
    }
    int top = stack.remove(stack.size() - 1);
    insertInSortOrder(stack, value);
    stack.add(top);
  }

}
