public class ThreeNumSort {

  public int[] threeNumberSort(int[] array, int[] order) {
    int firstNum = order[0];
    int lastNum = order[2];

    int leftPtr = 0;
    int rightPtr = leftPtr + 1;
    while (rightPtr < array.length) {
      if (array[leftPtr] == firstNum) {
        leftPtr++;
        rightPtr++;
      } else {
        if (array[rightPtr] == firstNum) {
          swap(leftPtr, rightPtr, array);
          leftPtr++;
          rightPtr++;
        } else {
          rightPtr++;
        }
      }
    }

    rightPtr = array.length - 1;
    leftPtr = rightPtr - 1;
    while (leftPtr >= 0) {
      if (array[rightPtr] == lastNum) {
        rightPtr--;
        leftPtr--;
      } else {
        if (array[leftPtr] == lastNum) {
          swap(leftPtr, rightPtr, array);
          rightPtr--;
          leftPtr--;
        } else {
          leftPtr--;
        }
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
