import java.util.*;

public class GroupAnagrams {

  public static List<List<String>> groupAnagrams(List<String> words) {
    Map<String, List<String>> anagramsMap = new HashMap<>();

    for (String word : words) {
      String currKey = sortStr(word);
      if (anagramsMap.containsKey(currKey)) {
        anagramsMap.get(currKey).add(word);
      } else {
        anagramsMap.put(currKey, new ArrayList<>(Arrays.asList(word)));
      }
    }

    return new ArrayList<>(anagramsMap.values());
  }

  private static String sortStr(String word) {
    char[] arr = word.toCharArray();
    Arrays.sort(arr);
    return String.valueOf(arr); // same as new String(arr); || don't use toString
  }

}
