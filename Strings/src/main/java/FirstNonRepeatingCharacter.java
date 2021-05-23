import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

  public int firstNonRepeatingCharacter(String string) {
    Map<Character, Integer> charFrequencies = new HashMap<>();

    for (int i = 0; i < string.length(); i++) {
      char currChar = string.charAt(i);
      charFrequencies.put(currChar, charFrequencies.getOrDefault(currChar, 0) + 1);
    }

    for (int i = 0; i < string.length(); i++) {
      char currChar = string.charAt(i);
      if (charFrequencies.get(currChar) == 1) {
        return i;
      }
    }
    return -1;
  }

}
