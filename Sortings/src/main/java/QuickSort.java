/*
  Write a function that takes in an array of integers and returns a sorted version of that array.
  Use the Quick Sort algorithm to sort the array.
*/
public class QuickSort {

  /**
   * Quick sorting an array.
   * Complexity: Best and average: O(nlog(n)) time | O(log(n)) space.
   * Worst: O(n^2) time | O(log(n)) space
   *
   * @param array - the array of integers to be sorted.
   * @return sorted array of integers.
   */
  public static int[] quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
    return array;
  }

  /**
   * Overloading method of quickSort.
   *
   * @param array - the array of integers to be sorted.
   * @param start - starting position (index), an int.
   * @param end   - ending position (index), an int.
   */
  private static void quickSort(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivotIdx = partition(array, start, end);
    quickSort(array, start, pivotIdx - 1);
    quickSort(array, pivotIdx + 1, end);
  }

  /**
   * Partition function using last element in array as pivot.
   *
   * @param array - the array of integers to be sorted.
   * @param start - starting position (index), an int.
   * @param end   - ending position (index), an int.
   * @return the index of a wall, where element(s) on left of wall is less than wall's value,
   * element(s) on right of wall is more than wall's value.
   */
  private static int partition(int[] array, int start, int end) {
    int pivotIdx = end;
    int pivot = array[pivotIdx];
    int currIdx = start - 1;
    for (int i = start; i < end; i++) {
      if (array[i] <= pivot) {
        currIdx++;
        swap(currIdx, i, array);
      }
    }
    swap(pivotIdx, currIdx + 1, array);
    return currIdx + 1;
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
