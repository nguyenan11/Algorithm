import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  Write a function that takes in a non-empty array of distinct integers and an integer representing
  a target sum. The function should find all quadruplets in the array that sum up to the target sum
  and return a two-dimensional array of all these quadruplets in no particular order.

  If no four numbers sum up to the target sum, the function should return an empty array.
 */
public class FourNumSum {

  // Average: O(n^2) time | O(n^2) space
  // Worst: O(n^3) time | O(n^2) space
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    List<Integer[]> quadruplets = new ArrayList<Integer[]>();
    Map<Integer, List<Integer[]>> allPairsSum = new HashMap<>();
    int size = array.length;
    for (int i = 1; i < size - 1; i++) {
      for (int j = i + 1; j < size; j++) {
        int currSum = array[i] + array[j];
        int match = targetSum - currSum;
        if (allPairsSum.containsKey(match)) {
          for (Integer[] pair : allPairsSum.get(match)) {
            Integer[] newQuadruplets = {pair[0], pair[1], array[i], array[j]};
            quadruplets.add(newQuadruplets);
          }
        }
      }
      for (int k = 0; k < i; k++) {
        int currSum = array[i] + array[k];
        Integer[] pair = {array[k], array[i]};
        if (!allPairsSum.containsKey(currSum)) {
          List<Integer[]> pairGroup = new ArrayList<>();
          pairGroup.add(pair);
          allPairsSum.put(currSum, pairGroup);
        } else {
          allPairsSum.get(currSum).add(pair);
        }
      }
    }
    return quadruplets;
  }

  public static void main(String[] args) {
    int[] array = new int[]{7, 6, 4, -1, 1, 2};
    List<Integer[]> result = fourNumberSum(array, 16);
    List<Integer[]> expected = Arrays.asList(new Integer[]{7, 6, 4, -1}, new Integer[]{7, 6, 1, 2});
  }
}
