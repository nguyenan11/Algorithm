import java.util.ArrayList;
import java.util.List;

/*
Write a function that takes in an n x m two-dimensional array (that can be square-shaped when
n == m) and returns a one-dimensional array of all the array's elements in spiral order.

Spiral order starts at the top left corner of the two-dimensional array, goes to the right, and
proceeds in a spiral pattern all the way until every element has been visited.
 */
public class SpiralTraverse {

  // O(n) time | O(n) space - n is total number of elements in the array
  public static List<Integer> spiralTraverse(int[][] array) {
    if (array.length == 0) {
      return new ArrayList<Integer>();
    }

    List<Integer> result = new ArrayList<>();
    int startRow = 0;
    int startCol = 0;
    int endRow = array.length - 1;
    int endCol = array[0].length - 1;

    while (startRow <= endRow && startCol <= endCol) {
      for (int col = startCol; col <= endCol; col++) {
        result.add(array[startRow][col]);
      }

      for (int row = startRow + 1; row <= endRow; row++) {
        result.add(array[row][endCol]);
      }

      /*
      Handle the edge case when there's a single row in the middle of the matrix. In this case, we
      don't want to double-count the values in this row, which we've already counted in the first
      for loop above.
       */
      for (int col = endCol - 1; col >= startCol; col--) {
        if (startRow == endRow) {
          break;
        }
        result.add(array[endRow][col]);
      }

      /*
      Handle the edge case when there's a single column in the middle of the matrix. In this case,
      we don't want to double-count the values in this column, which we've already counted in the
      second for loop above.
       */
      for (int row = endRow - 1; row >= startRow + 1; row--) {
        if (startCol == endCol) {
          break;
        }
        result.add(array[row][startCol]);
      }

      startRow++;
      startCol++;
      endRow--;
      endCol--;
    }

    return result;
  }


}
