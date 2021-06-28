/*
  Given a non-empty string of lowercase letters and a non-negative integer representing a key,
  write a function that returns a new string obtained by shifting every letter in the input string
  by k positions in the alphabet, where k is the key.

  Note that letters should "wrap" around the alphabet; in other words, the letter "z" shifted by
  one returns the letter "a".
*/
public class CaesarCipherEncryptor {

  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  private static final int TOTAL_LETTERS = 26;

  /**
   * Constructs a new string from the input string with each character shifted according to the
   * input key.
   * Complexity: O(n) time | O(n) space.
   * Assumption: only lowercase letters and non-negative integer key.
   *
   * @param str - the input String.
   * @param key - the position in the alphabet to be shifted, an integer.
   * @return the new constructed String.
   */
  public static String caesarCypherEncryptor(String str, int key) {
    char[] encryptedStr = new char[str.length()];
    int shiftKey = key % TOTAL_LETTERS;
    for (int i = 0; i < encryptedStr.length; i++) {
      encryptedStr[i] = getNewCharacter(str.charAt(i), shiftKey);
    }
    return String.valueOf(encryptedStr);
  }

  /**
   * Helper method to get a new character from the input key.
   *
   * @param character - the current Character.
   * @param shiftKey  - the new position in the alphabet to be shifted, an integer.
   * @return the new shifted Character.
   */
  private static char getNewCharacter(char character, int shiftKey) {
    int newCharIndex = ALPHABET.indexOf(character) + shiftKey;
    return ALPHABET.charAt(newCharIndex % TOTAL_LETTERS);
  }

}
