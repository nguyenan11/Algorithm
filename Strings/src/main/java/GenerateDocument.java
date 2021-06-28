import java.util.HashMap;
import java.util.Map;

/*
  You're given a string of available characters and a string representing a document that you need
  to generate. Write a function that determines if you can generate the document using the available
  characters. If you can generate the document, your function should return "true"; otherwise, it
  should return "false".

  You're only able to generate the document if the frequency of unique characters in the characters
  string is greater than or equal to the frequency of unique characters in the document string. For
  example, if you're given characters = "abcabc" and document = "aabbccc" you cannot generate the
  document because you're missing one c.

  The document that you need to create may contain any characters, including special characters,
  capital letters, numbers, and spaces.

  Note: you can always generate the empty string ("").
*/
public class GenerateDocument {

  private static final int ONE_APPEARANCE = 1;

  /**
   * Checks if a Document string can be generated from the characters in the Characters string.
   * Complexity: O(n+ m) time | O(c) space - n is number of characters, m is the length of the
   * document, c is number of unique characters in characters string.
   * Assumption: each character is distinctly used once.
   *
   * @param characters - the Characters String contains characters to build a new String.
   * @param document   - the Document String, the target String.
   * @return true if Characters supply enough characters for Document, false otherwise.
   */
  public boolean generateDocument(String characters, String document) {
    Map<Character, Integer> mapChar = new HashMap<>();
    for (int i = 0; i < characters.length(); i++) {
      char currChar = characters.charAt(i);
      updateMapChar(mapChar, currChar);
    }

    for (int i = 0; i < document.length(); i++) {
      char currChar = document.charAt(i);
      if (!mapChar.containsKey(currChar) || mapChar.get(currChar) == 0) {
        return false;
      }
      mapChar.replace(currChar, mapChar.get(currChar) - ONE_APPEARANCE);
    }
    return true;
  }

  /**
   * Helper method to update the map of characters.
   *
   * @param mapChar - the map of characters.
   * @param aChar   - a character to be added/ updated within the map.
   */
  private void updateMapChar(Map<Character, Integer> mapChar, char aChar) {
    if (mapChar.containsKey(aChar)) {
      mapChar.replace(aChar, mapChar.get(aChar) + ONE_APPEARANCE);
    } else {
      mapChar.put(aChar, ONE_APPEARANCE);
    }
  }

}
