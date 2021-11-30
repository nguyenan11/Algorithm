import java.util.ArrayList;
import java.util.List;

/*
  Write a function that takes in two strings and returns their longest common subsequence.

  A subsequence of a string is a set of characters that aren't necessarily adjacent in the string
  but that are in the same order as they appear in the string. For instance, the characters
  `["a", "c", "d"]` form a subsequence of the string `"abcd"`, and so do the characters
  `["b", "d"]`. Note that a single character in a string and the string itself are both valid
  subsequences of the string.

  You can assume that there will only be one longest common subsequence.
*/
public class LongestCommonSubsequence {

  /**
   * Finds and builds a longest common subsequence between 2 strings.
   * Complexity: O(nm) time | O(nm) space - n and m is length of str1 and str2 respectively.
   * Assumption: only 1 longest common subsequence.
   *
   * @param str1 - input String number 1.
   * @param str2 - input String number 2.
   * @return a longest common subsequence, a String.
   */
  public static List<Character> longestCommonSubsequence(String str1, String str2) {

    // +1 b/c empty string at the beginning (first row, first col)
    int[][] lengths = new int[str2.length() + 1][str1.length() + 1];
    for (int i = 1; i < str2.length() + 1; i++) {
      for (int j = 1; j < str1.length() + 1; j++) {

        // Check if is the last letter of current substring of str2 equals to last letter at current substring of str1
        if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
          lengths[i][j] = lengths[i - 1][j - 1] + 1; // LCS located diagonally upward
          // Constant time and space
        } else {
          // [i - 1][j]: lcs immediately above it
          // [i][j - 1]: lcs immediately to the left of it
          lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
        }
      }
    }
    return buildSequence(lengths, str1);
  }

  /**
   * Helper method acting as a String builder to build the longest common subsequence.
   *
   * @param lengths - list of 2 integers representing final position of character in lcs table.
   * @param str     - input String.
   * @return the longest common subsequence built from input str, a String.
   */
  public static List<Character> buildSequence(int[][] lengths, String str) {
    List<Character> sequence = new ArrayList<Character>();
    int i = lengths.length - 1; // final row of lcs
    int j = lengths[0].length - 1; // final column at lcs

    // starts at bottom right corner of lcs
    while (i != 0 && j != 0) {
      if (lengths[i][j] == lengths[i - 1][j]) {
        i--;
      } else if (lengths[i][j] == lengths[i][j - 1]) {
        j--;
      } else {
        sequence.add(0, str.charAt(j - 1));
        i--;
        j--;
      }
    }
    return sequence;
  }

  /*
  Bruteforce solution
  O(nm * min(n, m)) time | O(nm * min(n, m)) time space
  min(n, m) because of concatenation

  public static List<Character> longestCommonSubsequence(String str1, String str2) {
    List<List<List<Character>>> lcs = new ArrayList<List<List<Character>>>();
    for (int i = 0; i < str2.length() + 1; i++) {
      lcs.add(new ArrayList<List<Character>>());
      for (int j = 0; j < str1.length() + 1; j++) {
        lcs.get(i).add(new ArrayList<Character>());
      }
    }

    for (int i = 1; i < str2.length() + 1; i++) {
      for (int j = 1; j < str1.length() + 1; j ++) {
        if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
          List<Character> copy = new ArrayList<Character>(lcs.get(i - 1).get(j - 1));
          lcs.get(i).set(j, copy);
          lcs.get(i).get(j).add(str2.charAt(i - 1));
        } else {
          if (lcs.get(i - 1).get(j).size() > lcs.get(i).get(j - 1).size()) {
            lcs.get(i).set(j, lcs.get(i - 1).get(j));
          } else {
            lcs.get(i).set(j, lcs.get(i).get(j - 1));
          }
        }
      }
    }
    return lcs.get(str2.length()).get(str1.length());
  }

   */

}
