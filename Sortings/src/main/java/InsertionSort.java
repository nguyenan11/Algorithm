/*
  Write a function that takes in an array of integers and returns a sorted version of that array.
  Use the Insertion Sort algorithm to sort the array.
 */
public class InsertionSort {

  /**
   * Insertion sorting an array.
   * Complexity: Average: O(n^2) time | O(1) space. Best: O(n) time | O(1) space - array is already
   * sorted.
   *
   * @param array - the array of integers to be sorted.
   * @return sorted array of integers.
   */
  public static int[] insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = i;
      while (j > 0 && array[j] < array[j - 1]) {
        swap(j, j - 1, array);
        j--;
      }
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
