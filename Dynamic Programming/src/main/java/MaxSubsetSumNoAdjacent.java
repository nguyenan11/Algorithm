/*
  Write a function that takes in an array of positive integers and returns the maximum sum of
  non-adjacent elements in the array.

  If the input array is empty, the function should return `0`.
*/
public class MaxSubsetSumNoAdjacent {

  /**
   * Calculates the maximum sum of non adjacent elements in the array.
   * Complexity: O(n) time | O(1) space
   * Assumption: positive integers only.
   *
   * @param array - input array of positive integers.
   * @return an int representing sum of non adjacent numbers from array, 0 if array is empty.
   */
  public static int maxSubsetSumNoAdjacent(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    if (array.length == 1) {
      return array[0];
    }
    int second = array[0];
    int first = Math.max(array[0], array[1]);
    for (int i = 2; i < array.length; i++) {
      int currMax = Math.max(array[i] + second, first);
      second = first;
      first = currMax;
    }
    return first;
  }

  /*
  Brute force
  O(n) time | O(n) space

  public static int maxSubsetSumNoAdjacent(int[] array) {
    if (array.length == 0) return 0;
    if (array.length == 1) return array[0];

    int[] maxSum = new int[array.length];
    maxSum[0] = array[0];
    maxSum[1] = Math.max(maxSum[0], array[1]);
    for (int i = 2; i < array.length; i++) {
      maxSum[i] = Math.max(array[i] + maxSum[i - 2], maxSum[i - 1]);
    }
    return maxSum[maxSum.length - 1];
  }
   */

  public static void main(String[] args) {
    int[] array = new int[]{7, 10, 12, 7, 9, 14};
    // 7 + 12 + 14
    int expected = maxSubsetSumNoAdjacent(array);
    System.out.println(expected);
  }
}
