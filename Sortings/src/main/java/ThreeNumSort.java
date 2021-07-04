/*
  You're given an array of integers and another array of three distinct integers. The first array
  is guaranteed to only contain integers that are in the second array, and the second array
  represents a desired order for the integers in the first array. For example, a second array of
  [x, y, z] represents a desired order of [x, x, ..., x, y, y, ..., y, z, z, ..., z] in the first
  array.

  Write a function that sorts the first array according to the desired order in the second array.
  The function should perform this in place (i.e., it should mutate the input array), and it
  shouldn't use any auxiliary space (i.e., it should run with constant space: O(1) space).

  Note that the desired order won't necessarily be ascending or descending and that the first array
  won't necessarily contain all three integers found in the second array—it might only contain one
  or two.
*/
public class ThreeNumSort {

  /**
   * Sorts the first array based on the order given in the second array.
   * Complexity: O(n) time | O(1) space - n is length of array.
   * Assumption: There are maximum of 3 distinct integers.
   *
   * @param array - the array of integers to be sorted.
   * @param order - the array contains desired order of integers, size of 1 - 3.
   * @return sorted array of integers.
   */
  public int[] threeNumberSort(int[] array, int[] order) {
    int firstNum = order[0];
    int lastNum = order[2];

    int leftPtr = 0;
    int rightPtr = leftPtr + 1;

    // first pass
    while (rightPtr < array.length) {
      if (array[leftPtr] == firstNum) {
        leftPtr++;
      } else {
        if (array[rightPtr] == firstNum) {
          swap(leftPtr, rightPtr, array);
          leftPtr++;
        }
      }
      rightPtr++;
    }

    rightPtr = array.length - 1;
    leftPtr = rightPtr - 1;

    // second pass
    while (leftPtr >= 0) {
      if (array[rightPtr] == lastNum) {
        rightPtr--;
      } else {
        if (array[leftPtr] == lastNum) {
          swap(leftPtr, rightPtr, array);
          rightPtr--;
        }
      }
      leftPtr--;
    }

    return array;
  }

  /**
   * Helper method to swap 2 values of the array.
   *
   * @param i     - index of first value, an integer.
   * @param j     - index of second value, an integer.
   * @param array - the array of integers.
   */
  private static void swap(int i, int j, int[] array) {
    int tempValue = array[i];
    array[i] = array[j];
    array[j] = tempValue;
  }

}
