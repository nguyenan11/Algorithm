import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Write a function that takes in a string made up of brackets (, [, {, ), ], and } and other
  optional characters. The function should return a boolean representing whether the string is
  balanced with regards to brackets.

  A string is said to be balanced if it has as many opening brackets of a certain type as it has
  closing brackets of that type and if no bracket is unmatched. Note that an opening bracket can't
  match a corresponding closing bracket that comes before it, and similarly, a closing bracket
  can't match a corresponding opening bracket that comes after it. Also, brackets can't overlap
  each other as in ([)].
*/
public class BalancedBrackets {

  /**
   * Checks if a given string is made up of balanced brackets. () [] {}
   * Complexity: O(n) time | O(n) space.
   * Edge case: string might contain letter, and also end with open bracket(s). Brackets can
   * also not be overlap.
   *
   * @param str - the given String.
   * @return true if string is made up of balanced brackets, false otherwise.
   */
  public static boolean balancedBrackets(String str) {
    List<Character> OPEN_BRACKETS = Arrays.asList('[', '(', '{');
    List<Character> CLOSE_BRACKETS = Arrays.asList(']', ')', '}');
    List<Character> stack = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      Character currChar = str.charAt(i);
      int targetIdx = CLOSE_BRACKETS.indexOf(currChar); // return -1 if not found
      if (targetIdx != -1) {
        if (stack.size() == 0 || (stack.get(stack.size() - 1) != OPEN_BRACKETS.get(targetIdx))) {
          return false;
        } else {
          stack.remove(stack.size() - 1);
        }
      } else {
        if (OPEN_BRACKETS.contains(currChar)) {
          stack.add(currChar);
        }
      }
    }
    return stack.size() == 0;
  }
}