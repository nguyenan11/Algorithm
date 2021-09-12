import java.util.ArrayList;

/*
  Write a function that takes in an array of integers representing a stack, recursively sorts the
  stack in place (i.e., doesn't create a brand new array), and returns it.

  The array must be treated as a stack, with the end of the array as the top of the stack.
  Therefore, you're only allowed to
  * Pop elements from the top of the stack by removing elements from the end of the array using
  the built-in `.pop()` method in your programming language of choice.
  * Push elements to the top of the stack by appending elements to the end of the array using the
  built-in `.append()` method in your programming language of choice.
  * Peek at the element on top of the stack by accessing the last element in the array.

  You're not allowed to perform any other operations on the input array, including accessing
  elements (except for the last element), moving elements, etc.. You're also not allowed to use
  any other data structures, and your solution must be recursive.
*/
public class SortStack {

  /**
   * Sorts a stack without creating a new stack, with the largest value on top.
   * Complexity: O(n^2) time | O(n) space.
   *
   * @param stack - an array of integers representing a stack; the end of the array as top of
   *              stack.
   * @return a sorted stack.
   */
  public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
    if (stack.size() == 0) {
      return stack;
    }

    int top = stack.remove(stack.size() - 1);
    sortStack(stack);
    insertInSortOrder(stack, top);
    return stack;
  }

  /**
   * Helper method to insert value in sort order using recursion. This is where the sorting
   * happens.
   *
   * @param stack - the input stack, an array of integers.
   * @param value - the new value to be added to the stack, an int.
   */
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
