public class ThreeNumSort {

  public int[] threeNumberSort(int[] array, int[] order) {
    int currIdx = 0;
    for (int i = 0; i < order.length - 1; i++) {
      int currOrder = order[i];
      int leftPtr = currIdx;
      while (leftPtr < array.length - 1) {
        int rightPtr = leftPtr + 1;
        if (array[leftPtr] != currOrder) {
          while (array[rightPtr] != currOrder) {
            rightPtr++;
          }
          swap(leftPtr, rightPtr, array);
          currIdx = leftPtr;
        }
        leftPtr++;
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
