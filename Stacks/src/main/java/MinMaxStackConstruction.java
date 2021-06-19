import java.util.*;

/*
  Write a MinMaxStack class for a Min Max Stack. The class should support:
  - Pushing and popping values on and off the stack.
  - Peeking at the value at the top of the stack.
  - Getting both the minimum and the maximum values in the stack at any given point in time.

  All class methods, when considered independently, should run in constant time and with constant
  space.
*/
public class MinMaxStackConstruction {

  static class MinMaxStack {

    List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();
    List<Integer> stack = new ArrayList<Integer>();

    // O(1) time | O(n) space
    public int peek() {
      return stack.get(stack.size() - 1);
    }


    // O(1) time | O(n) space
    public int pop() {
      minMaxStack.remove(minMaxStack.size() - 1);
      return stack.remove(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public void push(Integer number) {
      Map<String, Integer> newMinMax = new HashMap<String, Integer>();
      newMinMax.put("min", number);
      newMinMax.put("max", number);
      if (minMaxStack.size() > 0) {
        Map<String, Integer> lastMinMax = new HashMap<String, Integer>(
            minMaxStack.get(minMaxStack.size() - 1));
        newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
        newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
      }
      minMaxStack.add(newMinMax);
      stack.add(number);
    }

    // O(1) time | O(1) space
    public int getMin() {
      return minMaxStack.get(minMaxStack.size() - 1).get("min");
    }

    // O(1) time | O(1) space
    public int getMax() {
      return minMaxStack.get(minMaxStack.size() - 1).get("max");
    }
  }

}
