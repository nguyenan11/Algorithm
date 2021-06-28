import java.util.*;

/*
  Write a function that takes in an array of strings and groups anagrams together.

  Anagrams are strings made up of exactly the same letters, where order doesn't matter. For example,
  "cinema" and "iceman" are anagrams; similarly, "foo" and "ofo" are anagrams.

  Your function should return a list of anagram groups in no particular order.
*/
public class GroupAnagrams {

  /**
   * Makes a list of anagram lists (groups) from a single list of words.
   * Complexity: O(w * n * log(n)) time | O(wn) space - where w is the number of words and n is
   * length of the longest word.
   *
   * @param words - list of words (Strings).
   * @return list of list of anagrams.
   */
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

  /**
   * Helper method to sort a string.
   *
   * @param word - the input String.
   * @return a new sorted version of the input String.
   */
  private static String sortStr(String word) {
    char[] arr = word.toCharArray();
    Arrays.sort(arr);
    return String.valueOf(arr); // same as new String(arr); || don't use toString
  }

}
