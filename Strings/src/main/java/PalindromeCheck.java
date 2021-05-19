/*
  Write a function that takes in a non-empty string and that returns a boolean
  representing whether the string is a palindrome.

  A palindrome is defined as a string that's written the same forward and
  backward. Note that single-character strings are palindromes.
 */
public class PalindromeCheck {

  /* O(n) time | O(n) space
  public static boolean isPalindrome(String str) {
    return new StringBuilder(str).reverse().toString().equals(str);
  }
   */

  // O(n) time | O(1) space
  public static boolean isPalindrome(String str) {
    int leftIdx = 0;
    int rightIdx= str.length();
    while (leftIdx <= rightIdx) {
      if (str.charAt(leftIdx) != str.charAt(rightIdx)) return false;
      leftIdx++;
      rightIdx--;
    }
    return true;
  }
}