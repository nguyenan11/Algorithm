import java.util.Arrays;

/*
  You're given a two-dimensional array (a matrix) of distinct integers and a target integer. Each
  row in the matrix is sorted, and each column is also sorted; the matrix doesn't necessarily have
  the same height and width.

  Write a function that returns an array of the row and column indices of the target integer if
  it's contained in the matrix, otherwise `[-1, -1]`.
*/
public class SearchInSortedMatrix {

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

}
