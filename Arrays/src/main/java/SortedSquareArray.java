import java.util.Arrays;

public class SortedSquareArray {

  /**
   * Write a function that takes in a non-empty array of integers that are sorted in ascending order
   * and returns a new array of the same length with the squares of the original integers also
   * sorted in ascending order.
   */

  // Not optimal || O(nlog(n) || O(n) space
  /*
  public int[] sortedSquaredArray(int[] array) {
    int[] newArr = new int[array.length];
    for (int index = 0; index < array.length; index++) {
      newArr[index] = (int) Math.pow(array[index], 2);
    }
    Arrays.sort(newArr);
    return newArr;
  }*/

  // O(n) time | O(n) space
  public int[] sortedSquaredArray(int[] array) {
    int[] newArr = new int[array.length];
    int smallerValueIndex = 0;
    int largerValueIndex = array.length - 1;
    for (int i = array.length; i >= 0; i--) {
      int smallerValue = array[smallerValueIndex];
      int largerValue = array[largerValueIndex];
      if (Math.abs(smallerValue) > Math.abs(largerValue)) {
        newArr[i] = smallerValue * smallerValue;
        smallerValueIndex++;
      } else {
        newArr[i] = largerValue * largerValue;
        largerValueIndex--;
      }
    }
    return newArr;
  }
}
