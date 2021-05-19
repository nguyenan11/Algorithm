import java.util.Arrays;

public class SubarraySort {

  public static int[] subarraySort(int[] array) {
    int currMinToSort = Integer.MAX_VALUE;
    int currMaxToSort = Integer.MIN_VALUE;
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        currMinToSort = Math.min(currMinToSort, array[i]);
        currMaxToSort = Math.max(currMaxToSort, array[i - 1]);
      }
    }

    Arrays.sort(array);
    int minIdx = -1;
    int maxIdx = -1;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == currMinToSort && minIdx == -1) {
        minIdx = i;
      } else if (array[i] == currMaxToSort && maxIdx == -1) {
        maxIdx = i;
      }
    }
    return new int[]{minIdx, maxIdx};
  }

}
