/*
  Write a function that takes in an array of integers and returns a sorted version of that array.
  Use the Heap Sort algorithm to sort the array.
 */
public class HeapSort {

  public static int[] heapSort(int[] array) {
    buildMaxHeap(array);
    for (int endIdx = array.length - 1; endIdx > 0; endIdx--) {
      swap(0, endIdx, array);
      siftDown(0, endIdx - 1, array);
    }
    return array;
  }

  public static void buildMaxHeap(int[] array) {
    int firstParentIdx = (array.length - 2) / 2;
    for (int currIdx = firstParentIdx; currIdx >= 0; currIdx--) {
      siftDown(currIdx, array.length - 1, array);
    }
  }

  public static void siftDown(int currIdx, int endIdx, int[] heap) {
    int childOneIdx = currIdx * 2 + 1;
    while (childOneIdx <= endIdx) {
      int childTwoIdx = currIdx * 2 + 2 <= endIdx ? currIdx * 2 + 2 : -1;
      int idxToSwap;
      if (childTwoIdx != -1 && heap[childTwoIdx] > heap[childOneIdx]) {
        idxToSwap = childTwoIdx;
      } else {
        idxToSwap = childOneIdx;
      }
      if (heap[idxToSwap] > heap[currIdx]) {
        swap(currIdx, idxToSwap, heap);
        currIdx = idxToSwap;
        childOneIdx = currIdx * 2 + 1;
      } else {
        return;
      }
    }
  }

  private static void swap(int i, int j, int[] array) {
    int tempValue = array[i];
    array[i] = array[j];
    array[j] = tempValue;
  }

}
