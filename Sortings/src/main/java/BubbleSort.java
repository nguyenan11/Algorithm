/*
  Write a function that takes in an array of integers and returns a sorted version of that array.
  Use the Bubble Sort algorithm to sort the array.
*/
public class BubbleSort {

  /**
   * Bubble sorting an array.
   * Complexity: Average: O(n^2) time | O(1) space. Best: O(n) time | O(1) space - array is already
   * sorted.
   *
   * @param array - the array of integers to be sorted.
   * @return sorted array of integers.
   */
  public static int[] bubbleSort(int[] array) {
    boolean isSorted = false;
    int counter = 0; // not reducing complexity but made algorithm more efficient
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < array.length - 1 - counter; i++) {
        if (array[i] > array[i + 1]) {
          swap(i, i + 1, array);
          isSorted = false;
        }
      }
      counter++; // more efficient here
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
