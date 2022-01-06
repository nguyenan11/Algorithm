import java.util.ArrayList;
import java.util.List;

/*
  Write a function that takes in an array of unique integers and returns an array of all
  permutations of those integers in no particular order.

  If the input array is empty, the function should return an empty array.
*/
public class Permutations {

  // O(n * n!) time | O(n * n!) space
  public static List<List<Integer>> getPermutations(List<Integer> array) {
    List<List<Integer>> permutations = new ArrayList<List<Integer>>();
    getPermutations(0, array, permutations);
    return permutations;
  }

  public static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
    if (i == array.size() - 1) {
      permutations.add(new ArrayList<Integer>(array));
    } else {
      for (int j = i; j < array.size(); j++) {
        swap(array, i, j);
        getPermutations(i + 1, array, permutations);
        swap(array, i, j);
      }
    }
  }

  public static void swap(List<Integer> array, int i, int j) {
    Integer temp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, temp);
  }

  /* Longer run time sln: O(n^2 * n!) time | O(n * n!) space
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
   */

}
