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

  // 1 more solution: using double for loop: the least optimal || O(n^2) time | O(1) space

  /* O(nlog(n)) | O(1) space || using pointers
  public static int[] twoNumberSum(int[] array, int targetSum) {
    Arrays.sort(array);
    int left = 0;
    int right = array.length-1;
    while (left < right) {
      if (array[left] + array[right] == targetSum) {
        return new int[] {array[left], array[right]};
      } else if (array[left] + array[right] < targetSum) {
        left++;
      } else {
        right--;
      }
    }
    return new int[0];
  }
   */

  /* Best: O(n) time | O(n) space
  public static int[] twoNumberSum(int[] array, int targetSum) {
    Set<Integer> nums = new HashSet<>();
    for (int num: array) {
      int match = targetSum - num;
      if (nums.contains(match)) {
        return new int[] {match, num};
      }
      nums.add(num);
    }
    return new int[0];
  }
   */
}

