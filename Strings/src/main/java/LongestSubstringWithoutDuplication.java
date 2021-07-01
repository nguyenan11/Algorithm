import java.util.HashMap;
import java.util.Map;

/*
  Write a function that takes in a string and returns its longest substring without duplicate
  characters.

  You can assume that there will only be one longest substring without duplication.
*/
public class LongestSubstringWithoutDuplication {

  // O(n) time | O(min(n, a)) space - where n is the length of the input string and a is the
  // length of the character alphabet represented in the input string

  /**
   * 
   * @param str
   * @return
   */
  public static String longestSubstringWithoutDuplication(String str) {
    Map<Character, Integer> lastSeen = new HashMap<>();
    int[] longest = {0, 1};
    int startIdx = 0;
    for (int i = 0; i < str.length(); i++) {
      char currChar = str.charAt(i);
      if (lastSeen.containsKey(currChar)) {
        startIdx = Math.max(startIdx, lastSeen.get(currChar) + 1); // important here
      }
      if (longest[1] - longest[0] < i + 1 - startIdx) {
        longest = new int[]{startIdx, i + 1};
      }
      lastSeen.put(currChar, i);
    }
    return str.substring(longest[0], longest[1]);
  }

  public static void main(String[] args) {
    String expected = longestSubstringWithoutDuplication("clementisacap");
    System.out.println(expected);
  }

}
