/*
  Write a function that takes in a non-empty string and that returns a boolean representing whether
  the string is a palindrome.

  A palindrome is defined as a string that's written the same forward and backward. Note that
  single-character strings are palindromes.
 */
public class PalindromeCheck {

  /* If manually reverse String using for-loop and index; be careful with the immutability of
  String (O(n)) -> String concatenation is O(n), could use StringBuilder or List<Char> then append
  to make it O(1) -> Checkout RunLengthEncoding for better illustration */


  /* Alternative: O(n) time | O(n) space - using built-in reverse.

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