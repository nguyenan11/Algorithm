import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. The function should find all quadruplets in
  the array that sum up to the target sum and return a two-dimensional array of
  all these quadruplets in no particular order.

  If no four numbers sum up to the target sum, the function should return an
  empty array.
 */
public class FourNumSum {

  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    List<Integer[]> sumList = new ArrayList<Integer[]>();
    Map<Integer, Integer[]> pairMap = new HashMap<>();
    int size = array.length;
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        int currSum = array[i] + array[j];
        int match = targetSum - currSum;
        if (pairMap.containsKey(match)) {
          if (!sumList.containsAll(Arrays.asList(pairMap.get(match)[0], pairMap.get(match)[1], array[i], array[j]))) {
            sumList.add(
                new Integer[]{pairMap.get(match)[0], pairMap.get(match)[1], array[i], array[j]});
          }
        } else {
          pairMap.put(currSum, new Integer[]{array[i], array[j]});
        }
      }
    }
    return sumList;
  }

  public static void main(String[] args) {
    int[] array = new int[]{7, 6, 4, -1, 1, 2};
    List<Integer[]> expected = fourNumberSum(array, 16);
    // System.out.println(expected);
  }
}
