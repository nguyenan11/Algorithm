/*
  Write a function that takes in an array of integers and returns a sorted version of that array.
  Use the Quick Sort algorithm to sort the array.
 */
public class QuickSort {

  // Best and average: O(nlog(n)) time | O(log(n)) space
  // Worst: O(n^2) time | O(log(n)) space
  public static int[] quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
    return array;
  }

  private static void quickSort(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivotIdx = partition(array, start, end);
    quickSort(array, start, pivotIdx - 1);
    quickSort(array, pivotIdx + 1, end);
  }

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

  private static void swap(int i, int j, int[] array) {
    int tempValue = array[i];
    array[i] = array[j];
    array[j] = tempValue;
  }

}
