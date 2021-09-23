import java.util.Arrays;
import java.util.Stack;

/*
  Write a function that takes in an array of integers and returns a new array containing, at each
  index, the next element in the input array that's greater than the element at that index in the
  input array.
  In other words, your function should return a new array where `outputArray[i]` is the next
  element in the input array that's greater than `inputArray[i]`. If there's no such next greater
  element for a particular index, the value at that index in the output array should be `-1`. For
  example, given `array = [1, 2]` your function should return `[2, -1]`.

  Additionally, your function should treat the input array as a `circular` array. A circular array
  wraps around itself as if it were connected end-to-end. So the next index after the last index
  in a circular array is the first index. This means that, for our problem, given
  `array = [0, 0, 5, 0, 0, 3, 0 0]`, the next greater element after `3` is `5`, since the array is
  circular.
*/
public class NextGreaterElement {

  /**
   * Iterates thru entire input array and return new array where the value at each index represents
   * the next greater element from input array (from left to right).
   * Complexity: O(n) time | O(n) space.
   * Edge case: Accounts for negative number.
   *
   * @param array - input array of integers.
   * @return new array of integers.
   */
  public int[] nextGreaterElement(int[] array) {
    int[] result = new int[array.length];
    Arrays.fill(result, -1);

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < array.length * 2; i++) {
      int circularIdx = i % array.length;

      while (stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
        int top = stack.pop();
        result[top] = array[circularIdx];
      }
      stack.push(circularIdx);
    }
    return result;
  }

}
