public class LongestPalindromicSubstring {

  public static String longestPalindromicSubstring(String str) {
    String longestPalindrome = null;
    int leftIdx = 0;
    int rightIdx = str.length() - 1;
    while (leftIdx < rightIdx) {
      while (str.charAt(leftIdx) != str.charAt(rightIdx) && leftIdx != rightIdx) {
        rightIdx--;
      }
      String possiblePalindrome = str.substring(leftIdx, rightIdx);
      if (isPalindrome(possiblePalindrome) && possiblePalindrome.length() > longestPalindrome.length()) {
        longestPalindrome = possiblePalindrome;
      }
      leftIdx = rightIdx++;
    }

    return longestPalindrome;
  }

  private static boolean isPalindrome(String str) { // from PalindromeCheck
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
