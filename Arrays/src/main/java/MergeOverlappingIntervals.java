import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

  public static int[][] mergeOverlappingIntervals(int[][] intervals) {
    int[][] newIntervals = new int[intervals.length][2];
    Arrays.sort(intervals, new IntCompare());
    int leftIdx = 0;
    while (leftIdx < intervals.length - 1) {
      int rightIdx = leftIdx + 1;
      while (intervals[leftIdx][1] >= intervals[rightIdx][0]) {
        intervals[leftIdx][1] = intervals[rightIdx][1];
        rightIdx++;
      }
      newIntervals[leftIdx] = intervals[leftIdx];
      leftIdx = rightIdx;
    }

    return newIntervals;
  }

  static class IntCompare implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
      return Integer.compare(o1[0], o2[0]);
    }
  }

  public static void main(String[] args) {
    int[][] intervals = new int[][]{{2, 8}, {1, 3}, {9, 10}};
    Arrays.sort(intervals, new IntCompare());
  }
}

