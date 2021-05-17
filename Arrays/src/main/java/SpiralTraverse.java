import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

  /*

  Write a function that takes in an n x m two-dimensional array (that can be
  square-shaped when n == m) and returns a one-dimensional array of all the
  array's elements in spiral order.


  Spiral order starts at the top left corner of the two-dimensional array, goes
  to the right, and proceeds in a spiral pattern all the way until every element
  has been visited.
   */

  private static final int MIN = 0;

  public static List<Integer> spiralTraverse(int[][] array) {
    List<Integer> newArr = new ArrayList<>();
    int MAX = array.length - 1;
    newArr.add(array[0][0]);
    int currRow = 0, currCol = 1;
    int totalTraversal = array.length * array.length;
    int traversalCount = 1;
    while (traversalCount < totalTraversal) {
      newArr.add(array[currRow][currCol]);
      if (currRow < MAX && currCol != MIN) {
        if (currCol < MAX) {
          currCol++;
        } else {
          currRow++;
        }
      } else {
        if (currCol > MIN) {
          currCol--;
        } else {
          currRow--;
        }
      }
      traversalCount++;
    }
    return newArr;
  }


}
