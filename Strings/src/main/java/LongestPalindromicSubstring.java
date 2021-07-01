/*
  Write a function that, given a string, returns its longest palindromic substring.

  A palindrome is defined as a string that's written the same forward and backward. Note that
  single-character strings are palindromes.

  You can assume that there will only be one longest palindromic substring.
*/
public class LongestPalindromicSubstring {

  /**
   * Finds the longest palindromic substring within the input string.
   * Complexity: O(n^2) time | O(n) space.
   * Assumption: only 1 longest palindromic substring.
   * Edge case: Palindrome can be in even or odd length.
   *
   * @param str - the input String.
   * @return the longest palindromic subtring, a String.
   */
  public static String longestPalindromicSubstring(String str) {
    int[] currLongest = new int[]{0, 1};
    for (int i = 1; i < str.length(); i++) {
      int[] odd = getLongestPalindrome(i - 1, i + 1, str);
      int[] even = getLongestPalindrome(i - 1, i, str);
      int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
      currLongest =
          currLongest[1] - currLongest[0] > longest[1] - longest[0] ? currLongest : longest;
    }
    return str.substring(currLongest[0], currLongest[1]);
  }

  /**
   * Helper method to find the indexes of the current longest palindrome.
   *
   * @param leftIdx  - the left index/ pointer, an int.
   * @param rightIdx - the right index/ pointer, an int.
   * @param str      - the input String.
   * @return an array contains 2 integers, where first int is starting position and second int is
   * ending position for palindrome.
   */
  private static int[] getLongestPalindrome(int leftIdx, int rightIdx, String str) {
    while (leftIdx >= 0 && rightIdx < str.length()) {
      if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
        break;
      }
      leftIdx--;
      rightIdx++;
    }
    return new int[]{leftIdx + 1, rightIdx};
  }

}
