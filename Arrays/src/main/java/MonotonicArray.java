public class MonotonicArray {

  /*

  Write a function that takes in an array of integers and returns a boolean
  representing whether the array is monotonic.

  An array is said to be monotonic if its elements, from left to right, are
  entirely non-increasing or entirely non-decreasing.

  Non-increasing elements aren't necessarily exclusively decreasing; they simply
  don't increase. Similarly, non-decreasing elements aren't necessarily
  exclusively increasing; they simply don't decrease.

  Note that empty arrays and arrays of one element are monotonic.
   */


  // O(n) time | O(1) space
  // Fail 2 test cases; need to double check
  public static boolean isMonotonic(int[] array) {
    int length = array.length;
    if (length <= 2) {
      return true;
    }
    int initialCondition = Integer.compare(array[0], array[1]);
    for (int i = 1; i < length - 1; i++) {
      int currCondition = Integer.compare(array[i], array[i + 1]);
      if (currCondition != initialCondition && currCondition != 0) {
        return false;
      }
    }
    return true;
  }
}
