/*
  Write a function that takes in an array of integers and returns the length of the longest peak in
  the array.

  A peak is defined as adjacent integers in the array that are strictly increasing until they reach
  a tip (the highest value in the peak), at which point they become strictly decreasing. At least
  three integers are required to form a peak.

  For example, the integers [1, 4, 10, 2] form a peak, but the integers [4, 0, 10] don't and neither
  do the integers [1, 2, 2, 0]. Similarly, the integers [1, 2, 3]  don't form a peak because there
  aren't any strictly decreasing integers after the 3.
 */
public class LongestPeak {

  /**
   * Finds the length of the longest peak from the given array.
   * Complexity: O(n) time | O(1) space. We traverse thru each number once, at most 2 - 3 times
   * (when peak found and traverse to the left) -> still O(n).
   * Assumption: at least 3 integers required to form a peak. Peak only point up and have to
   * shape like ^.
   *
   * @param array - the array of integers.
   * @return an integer represents the length of the longest peak, 0 if no peak found.
   */
  public static int longestPeak(int[] array) {
    int longestPeakLength = 0;
    int i = 1;
    while (i < array.length - 1) {
      boolean tipDetected = array[i - 1] < array[i] && array[i] > array[i + 1];
      if (!tipDetected) {
        i++;
        continue;
      }

      int leftIdx = i - 2;
      while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
        leftIdx--;
      }

      int rightIdx = i + 2;
      while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
        rightIdx++;
      }

      longestPeakLength = updateLongestPeak(longestPeakLength, leftIdx, rightIdx);
      i = rightIdx;

    }
    return longestPeakLength;
  }

  /**
   * Helper method to find to longest peak at current iteration.
   *
   * @param longestPeakLength - the current longest peak length, an integer.
   * @param leftIdx           - the left-most index of the new peak, an integer.
   * @param rightIdx          - the right-most index of the new peak, an integer.
   * @return the longer peak between the current longest peak and the new peak, an integer.
   */
  private static int updateLongestPeak(int longestPeakLength, int leftIdx, int rightIdx) {
    int currPeakLength = rightIdx - leftIdx - 1;
    return Math.max(currPeakLength, longestPeakLength);
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 3, 2};
    System.out.println(longestPeak(array));
  }

}
