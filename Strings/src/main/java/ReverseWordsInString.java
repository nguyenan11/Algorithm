import java.util.*;

/*
  Write a function that takes in a string of words separated by one or more whitespaces and returns
  a string that has these words in reverse order. For example, given the string "tim is great",
  your function should return "great is tim".

  For this problem, a word can contain special characters, punctuation, and numbers. The words in
  the string will be separated by one or more whitespaces, and the reversed string must contain the
  same whitespaces as the original string. For example, given the string "whitespace    4" you
  would be expected to return "4    whitespace".

  Note that you're not allowed to to use any built-in "spilt" or "reverse" methods/functions.
  However, you are allowed to use a built-in "join" method/function.

  Also note that the input string isn't guaranteed to always contain words.
*/
public class ReverseWordsInString {

  /**
   * Reverses the words in the input string.
   * Complexity: O(n) time | O(1) space - n is the length of the input string.
   * Assumption: no using String methods "spilt" or "reverse".
   * Edge case: White space(s) is reversed. Might contain special characters, not just words.
   *
   * @param string - the input String.
   * @return the reversed version of input String.
   */
  public String reverseWordsInString(String string) {
    List<String> reverseString = new ArrayList<>();
    int wordStarting = 0;

    for (int i = 0; i < string.length(); i++) {

      char currChar = string.charAt(i);

      if (currChar == ' ') {
        reverseString.add(string.substring(wordStarting, i));
        wordStarting = i;
      } else if (string.charAt(wordStarting) == ' ') {
        reverseString.add(" ");
        wordStarting = i;
      }
    }

    reverseString.add(string.substring(wordStarting));

    Collections.reverse(reverseString);
    return String.join("", reverseString);
  }

}
