/*
  Write a function that takes in an array of integers and returns a sorted version of that array.
  Use the Insertion Sort algorithm to sort the array.
 */
public class InsertionSort {

  // Average: O(n^2) time | O(1) space
  // Best: O(n) time | O(1) space - array is already sorted
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

  private static void swap(int i, int j, int[] array) {
    int tempValue = array[i];
    array[i] = array[j];
    array[j] = tempValue;
  }

}
