import java.util.Arrays;

public class LargestRange {

  public static int[] largestRange(int[] array) { // Need to deal with duplicate
    Arrays.sort(array);
    int startOfRange = array[0];
    int[] rangeArr = new int[2];
    int largestRange = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i + 1] - array[i] == 1) {
        int currRange = array[i + 1] - startOfRange;
        if (currRange > largestRange) {
          rangeArr = new int[]{startOfRange, array[i + 1]};
          largestRange = currRange;
        }
      } else {
        startOfRange = array[i + 1];
      }
    }
    return rangeArr;
  }

}
