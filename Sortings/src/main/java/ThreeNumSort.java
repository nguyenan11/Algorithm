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

  public int[] threeNumberSort(int[] array, int[] order) {
    int firstNum = order[0];
    int lastNum = order[2];

    int leftPtr = 0;
    int rightPtr = leftPtr + 1;
    while (rightPtr < array.length) {
      if (array[leftPtr] == firstNum) {
        leftPtr++;
        rightPtr++;
      } else {
        if (array[rightPtr] == firstNum) {
          swap(leftPtr, rightPtr, array);
          leftPtr++;
          rightPtr++;
        } else {
          rightPtr++;
        }
      }
    }

    rightPtr = array.length - 1;
    leftPtr = rightPtr - 1;
    while (leftPtr >= 0) {
      if (array[rightPtr] == lastNum) {
        rightPtr--;
        leftPtr--;
      } else {
        if (array[leftPtr] == lastNum) {
          swap(leftPtr, rightPtr, array);
          rightPtr--;
          leftPtr--;
        } else {
          leftPtr--;
        }
      }
    }

    return array;
  }

  private static void swap(int i, int j, int[] array) {
    int tempValue = array[i];
    array[i] = array[j];
    array[j] = tempValue;
  }

}
