/*
  Write a function that takes in a sorted array of integers as well as a target integer. The
  function should use the Binary Search algorithm to determine if the target integer is contained
  in the array and should return its index if it is, otherwise `-1`.
*/
public class BinarySearch {

  // O(log(n)) time | O(1) space
  public static int binarySearch(int[] array, int target) {
    int start = 0, end = array.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (array[mid] == target) return mid;
      if (target < array[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  // Can also use Recursive approach with complexity of O(log(n)) time | O(log(n)) space

}
