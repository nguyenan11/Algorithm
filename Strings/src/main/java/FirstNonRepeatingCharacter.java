import java.util.HashMap;
import java.util.Map;

/*
  Write a function that takes in a string of lowercase English-alphabet letters and returns the
  index of the string's first non-repeating character.

  The first non-repeating character is the first character in a string that occurs only once.

  If the input string doesn't have any non-repeating characters, your function should return "-1".
*/
public class FirstNonRepeatingCharacter {

  /**
   * Finds the index where first non-repeating character appear in the string.
   * Complexity: O(n) time | O(1) space - n is the length of the input string.
   * Assumption: String might not contain any repeating characters.
   *
   * @param string - the input String.
   * @return the index of first non-repeating character, -1 if no repeating was found.
   */
  public int firstNonRepeatingCharacter(String string) {
    Map<Character, Integer> charFrequencies = new HashMap<>();

    for (int i = 0; i < string.length(); i++) {
      char currChar = string.charAt(i);
      charFrequencies.put(currChar, charFrequencies.getOrDefault(currChar, 0) + 1);
    }

    for (int i = 0; i < string.length(); i++) {
      char currChar = string.charAt(i);
      if (charFrequencies.get(currChar) == 1) {
        return i;
      }
    }
    return -1;
  }

}
