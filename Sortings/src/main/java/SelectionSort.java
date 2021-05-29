/*
  Write a function that takes in an array of integers and returns a sorted version of that array.
  Use the Selection Sort algorithm to sort the array.
 */
public class SelectionSort {

  // Average: O(n^2) time | O(1) space
  // Best: O(n) time | O(1) space - array is already sorted
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

  private static void swap(int i, int j, int[] array) {
    int tempValue = array[i];
    array[i] = array[j];
    array[j] = tempValue;
  }

}
