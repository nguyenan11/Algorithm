import java.util.HashMap;
import java.util.Map;

public class MinCharactersForWords {

  public String[] minimumCharactersForWords(String[] words) {
    Map<Character, Integer> allWordsFrequencies = new HashMap<>();
    for (String word : words) {
      Map<Character, Integer> characterFrequencies = new HashMap<>();
      for (int i = 0; i < word.length(); i++) {
        char currCharacter = word.charAt(i);
        characterFrequencies.put(currCharacter, characterFrequencies.getOrDefault(currCharacter, 1) + 1);
      }
      //allWordsFrequencies.
    }
    return new String[] {};
  }
}
