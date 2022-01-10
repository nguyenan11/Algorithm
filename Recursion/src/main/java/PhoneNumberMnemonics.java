import java.util.*;

public class PhoneNumberMnemonics {

  public static Map<Character, String[]> DIGIT_LETTERS = new HashMap<Character, String[]>();

  static {
    DIGIT_LETTERS.put('0', new String[] {"0"});
    DIGIT_LETTERS.put('1', new String[] {"1"});
    DIGIT_LETTERS.put('2', new String[] {"a", "b", "c"});
    DIGIT_LETTERS.put('3', new String[] {"d", "e", "f"});
    DIGIT_LETTERS.put('4', new String[] {"g", "h", "i"});
    DIGIT_LETTERS.put('5', new String[] {"j", "k", "l"});
    DIGIT_LETTERS.put('6', new String[] {"m", "n", "o"});
    DIGIT_LETTERS.put('7', new String[] {"p", "q", "r", "s"});
    DIGIT_LETTERS.put('8', new String[] {"t", "u", "v"});
    DIGIT_LETTERS.put('9', new String[] {"w", "x", "y", "z"});
  }

  // O(4^n * n) time | O(4^n * n) space - n is the length of phone number
  public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
    String[] currMnemonic = new String[phoneNumber.length()];
    Arrays.fill(currMnemonic, "0");
    ArrayList<String> mnemonicsFound = new ArrayList<String>();
    mnemonicsHelper(0, phoneNumber, currMnemonic, mnemonicsFound);
    return mnemonicsFound;
  }

  public void mnemonicsHelper(int idx, String phoneNumber, String[] currMnemonic, ArrayList<String> mnemonicsFound) {
    if (idx == phoneNumber.length()) {
      String mnemonic = String.join("", currMnemonic);
      mnemonicsFound.add(mnemonic);
    } else {
      char digit = phoneNumber.charAt(idx);
      String[] letters = DIGIT_LETTERS.get(digit);
      for (String letter : letters) {
        currMnemonic[idx] = letter;
        mnemonicsHelper(idx + 1, phoneNumber, currMnemonic, mnemonicsFound);
      }
    }
  }

}
