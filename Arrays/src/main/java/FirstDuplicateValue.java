import java.util.ArrayList;
import java.util.List;

public class FirstDuplicateValue {

  /*

  Given an array of integers between 1 and n, inclusive, where n is the length of the array, write
  a function that returns the first integer that appears more than once (when the array is read
  from left to right).

  In other words, out of all the integers that might occur more than once in the input array, your
  function should return the one whose first duplicate value has the minimum index.

  If no integer appears more than once, your function should return -1.

  Note that you're allowed to mutate the input array.
   */

  // O(n) time | O(1) space - pay attention closely to the question
  public int firstDuplicateValue(int[] array) {
    for (int num : array) {
      int absValue = Math.abs(num);
      if (array[absValue - 1] < 0) return absValue;
      array[absValue - 1] *= -1;
    }
    return -1;
  }


  /* O(n) time | O(n) space

  public int firstDuplicateValue(int[] array) {
    List<Integer> tempArr = new ArrayList<>();
    for (int num : array) {
      if (tempArr.contains(num)) {
        return num;
      }
      tempArr.add(num);
    }
    return -1;
  }
   */

  // O(n^2) | O(1) space is also possible with double for loops
}
