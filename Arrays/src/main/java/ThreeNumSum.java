import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {

  /*
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. The function should find all triplets in
  the array that sum up to the target sum and return a two-dimensional array of
  all these triplets. The numbers in each triplet should be ordered in ascending
  order, and the triplets themselves should be ordered in ascending order with
  respect to the numbers they hold.

  If no three numbers sum up to the target sum, the function should return an
  empty array.
   */

  // O(n^2) -- O(n^2log(n)) time | O(n) space - n is length of input array
  public static List<int[]> threeNumberSum(int[] array, int targetSum) {
    List<int[]> targetList = new ArrayList<int[]>();
    Arrays.sort(array);
    int size = array.length - 1;
    for (int i = 0; i < size; i++) {
      int match = targetSum - array[i];

      int leftPointer = i + 1;
      int rightPointer = size;
      while (leftPointer < rightPointer) {
        int sumOfTwo = array[leftPointer] + array[rightPointer];
        if (sumOfTwo == match) {
          targetList.add(new int[]{array[i], array[leftPointer], array[rightPointer]});
          leftPointer++;
          rightPointer--;
        } else if (sumOfTwo < match) {
          leftPointer++;
        } else {
          rightPointer--;
        }
      }
    }
    return targetList;
  }

  public static void main(String[] args) {
    int[] array = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
    int target = 0;
    List<int[]> expected = threeNumberSum(array, target);
    for (int[] list: expected) {
      System.out.println(Arrays.toString(list));
    }
  }
}
