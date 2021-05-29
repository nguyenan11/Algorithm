/*
  Write a function that takes in an array of integers and returns a sorted version of that array.
  Use the Bubble Sort algorithm to sort the array.
 */
public class BubbleSort {

  // Average: O(n^2) time | O(1) space
  // Best: O(n) time | O(1) space - array is already sorted
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
      counter++;
    }
    return array;
  }

  private static void swap(int i, int j, int[] array) {
    int tempValue = array[i];
    array[i] = array[j];
    array[j] = tempValue;
  }

}
