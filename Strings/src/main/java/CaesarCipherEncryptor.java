public class CaesarCipherEncryptor {

  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  private static final int TOTAL_LETTERS = 26;

  public static String caesarCypherEncryptor(String str, int key) {
    char[] encryptedStr = new char[str.length()];
    int shiftKey = key % TOTAL_LETTERS;
    for (int i = 0; i < encryptedStr.length; i++) {
      encryptedStr[i] = getNewCharacter(str.charAt(i), shiftKey);
    }
    return String.valueOf(encryptedStr);
  }

  private static char getNewCharacter(char character, int shiftKey) {
    int newCharIndex = ALPHABET.indexOf(character) + shiftKey;
    return ALPHABET.charAt(newCharIndex % TOTAL_LETTERS);
  }

}
