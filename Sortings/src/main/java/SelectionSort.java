/*
  Write a function that takes in an array of integers and returns a sorted version of that array.
  Use the Selection Sort algorithm to sort the array.
*/
public class SelectionSort {

  /**
   * Selection sorting an array.
   * Complexity: Average: O(n^2) time | O(1) space. Best: O(n) time | O(1) space - array is already
   * sorted.
   *
   * @param array - the array of integers to be sorted.
   * @return sorted array of integers.
   */
  public static int[] selectionSort(int[] array) {
    int currIdx = 0;
    while (currIdx < array.length - 1) {
      int smallestIdx = currIdx;
      for (int i = currIdx + 1; i < array.length; i++) {
        if (array[smallestIdx] > array[i]) {
          smallestIdx = i;
        }
      }
      swap(currIdx, smallestIdx, array);
      currIdx++;
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
