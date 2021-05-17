public class LongestPeak {

  public static int longestPeak(int[] array) {
    int longestPeakLength = 0;
    int i = 1;
    while (i < array.length - 1) {
      boolean tipDetected = array[i - 1] < array[i] && array[i] > array[i + 1];
      if (!tipDetected) {
        i++;
        continue;
      }

      int leftIdx = i - 2;
      while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
        leftIdx--;
      }

      int rightIdx = i + 2;
      while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
        rightIdx++;
      }

      longestPeakLength = updateLongestPeak(longestPeakLength, leftIdx, rightIdx);
      i = rightIdx;

    }
    return longestPeakLength;
  }


  private static int updateLongestPeak(int longestPeakLength, int leftIdx, int rightIdx) {
    int currPeakLength = rightIdx - leftIdx - 1;
    return Math.max(currPeakLength, longestPeakLength);
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 3, 2};
    System.out.println(longestPeak(array));
  }

}
