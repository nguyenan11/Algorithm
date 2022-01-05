import java.util.ArrayList;
import java.util.List;

/*
  Write a function that takes in an array of unique integers and returns an array of all
  permutations of those integers in no particular order.

  If the input array is empty, the function should return an empty array.
*/
public class Permutations {

  // O(n^2 * n!) time | O(n * n!) space
  public static List<List<Integer>> getPermutations(List<Integer> array) {
    List<List<Integer>> permutations = new ArrayList<List<Integer>>();
    getPermutations(array, new ArrayList<Integer>(), permutations);
    return permutations;
  }

  public static void getPermutations(List<Integer> array, List<Integer> currPermutation, List<List<Integer>> permutations) {
    if (array.size() == 0 && currPermutation.size() > 0) {
      permutations.add(currPermutation);
    } else {
      for (int i = 0; i < array.size(); i ++) {
        List<Integer> newArray = new ArrayList<Integer>(array);
        newArray.remove(i);
        List<Integer> newPermutation = new ArrayList<Integer>(currPermutation);
        newPermutation.add(array.get(i));
        getPermutations(newArray, newPermutation, permutations);
      }
    }
  }

}
