import java.util.HashMap;
import java.util.Map;

public class MinCharactersForWords {

  public String[] minimumCharactersForWords(String[] words) {
    Map<String, Integer> characterFrequencies = new HashMap<>();
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        char currCharacter = word.charAt(i);
      }
    }
    return new String[] {};
  }
}
