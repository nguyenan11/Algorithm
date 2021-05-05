import java.util.Arrays;
import java.util.*;

public class TwoNumSum {

  /**
   * Write a function that takes in a non-empty array of distinct integers and an integer
   * representing a target sum. If any two numbers in the input array sum up to the target sum, the
   * function should return them in an array, in any order. If no two numbers sum up to the target
   * sum, the function should return an empty array.
   */

  public static int[] twoNumberSum(int[] array, int targetSum) {
    if (array.length == 1)
      return new int[0]; // cannot compare to itself
    for (int i = 1; i < array.length; i++) {
      if (array[i] + array[0] == targetSum) {
        return new int[]{array[0], array[i]};
      }
    }
    return twoNumberSum(Arrays.copyOfRange(array, 1, array.length), targetSum);
  }

}

