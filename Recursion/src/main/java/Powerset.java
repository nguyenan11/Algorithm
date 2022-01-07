import java.util.ArrayList;
import java.util.List;

/*
  Write a function that takes in an array of unique integers and returns its powerset.

  The powerset `P(X)` of a set `X` is the set of all subsets of `X`. For example, the powerset of
  `[1,2]` is `[[], [1], [2], [1,2]]`.

  Note that the sets in the powerset do not need to be in any particular order.
*/
public class Powerset {

  // O(n * 2^n) time | O(n * 2^n) space
  public static List<List<Integer>> powerset(List<Integer> array) {
    return powerset(array, array.size() - 1);
  }

  // recursion step
  public static List<List<Integer>> powerset(List<Integer> array, int idx) {
    if (idx < 0) {
      List<List<Integer>> emptySet = new ArrayList<List<Integer>>();
      emptySet.add(new ArrayList<Integer>());
      return emptySet;
    }
    int num = array.get(idx);
    List<List<Integer>> subsets = powerset(array, idx - 1);
    int length = subsets.size();
    for (int i = 0; i < length; i++) {
      List<Integer> currSubset = new ArrayList<Integer>(subsets.get(i));
      currSubset.add(num);
      subsets.add(currSubset);
    }
    return subsets;
  }

  /* Non-recursive solution. Same complexity: O(n * 2^n) time | O(n * 2^n) space
  public static List<List<Integer>> powerset(List<Integer> array) {
    List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    subsets.add(new ArrayList<Integer>());
    for (Integer num : array) {
      int length = subsets.size();
      for (int i = 0; i < length; i++) {
        List<Integer> currSubset = new ArrayList<Integer>(subsets.get(i));
        currSubset.add(num);
        subsets.add(currSubset);
      }
    }
    return subsets;
  }
  */

}
