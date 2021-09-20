/*
  You're given a two-dimensional array (a matrix) of distinct integers and a target integer. Each
  row in the matrix is sorted, and each column is also sorted; the matrix doesn't necessarily have
  the same height and width.

  Write a function that returns an array of the row and column indices of the target integer if
  it's contained in the matrix, otherwise `[-1, -1]`.
*/
public class SearchInSortedMatrix {

  // O(m + n) time | O(1) space
  // Important assumption: Each row in the matrix is sorted, and each column is also sorted.
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    int row = 0;
    int col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] > target) {
        col--;
      } else if (matrix[row][col] < target) {
        row++;
      } else {
        return new int[] {row, col};
      }
    }
    return new int[] {-1, -1};
  }

  /* Brute force
  O(mlog(n)) time | O(1) space
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    int[] notFound = new int[] {-1, -1};
    for (int i = 0; i < matrix.length; i++) {
      int[] rowResult = binarySearch(matrix[i], i, target);
      if (!Arrays.equals(rowResult, notFound)) return rowResult;
    }
    return notFound;
  }

  public static int[] binarySearch(int[] rowArr, int rowPos, int target) {
    int start = 0, end = rowArr.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (rowArr[mid] == target) return new int[] {rowPos, mid};
      if (target < rowArr[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return new int[] {-1, -1};
  }
  */

}
