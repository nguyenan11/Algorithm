import java.util.*;

public class ReverseWordsInString {

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
