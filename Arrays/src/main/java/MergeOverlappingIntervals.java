import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
  Write a function that takes in a non-empty array of arbitrary intervals, merges any overlapping
  intervals, and returns the new intervals in no particular order.

  Each interval `interval` is an array of two integers, with `interval[0]`  as the start of the
  interval and `interval[1]`  as the end of the interval.

  Note that back-to-back intervals aren't considered to be overlapping. For example, [1, 5] and
  [6, 7] aren't overlapping; however, [1, 6] and [6, 7] are indeed overlapping.

  Also note that the start of any particular interval will always be less than or equal to the end
  of that interval.
*/
public class MergeOverlappingIntervals {

  /**
   * Merges any overlapping intervals in the given array.
   * Complexity: O(nlog(n)) time | O(n) space
   * Assumption: each interval inside the array of intervals will be size of 2
   *
   * @param intervals - the given array of intervals, where each interval consists of 2 integers.
   * @return new array of intervals with any overlapping intervals merged.
   */
  public static int[][] mergeOverlappingIntervals(int[][] intervals) {
    Arrays.sort(intervals, new IntCompare());
    List<int[]> mergedInterval = new ArrayList<int[]>();
    int[] currInterval = intervals[0];
    mergedInterval.add(currInterval);

    for (int[] nextInterval : intervals) {
      int currIntervalEnd = currInterval[1];
      int nextIntervalStart = nextInterval[0];
      int nextIntervalEnd = nextInterval[1];

      if (currIntervalEnd >= nextIntervalStart) {
        currInterval[1] = nextIntervalEnd;
      } else {
        currInterval = nextInterval;
        mergedInterval.add(currInterval);
      }
    }
    return mergedInterval.toArray(new int[mergedInterval.size()][]);
  }

  /**
   * Comparator to compare/ sort 2 intervals based their first integer.
   */
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

