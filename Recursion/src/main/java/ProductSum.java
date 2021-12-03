import java.util.ArrayList;
import java.util.List;

/*
  Write a function that takes in a "special" array and returns its product sum.

  A "special" array is a non-empty array that contains either integers or other "special" arrays.
  The product sum of a "special" array is the sum of its elements, where "special" arrays inside
  it are summed themselves and then multiplied by their level of depth.

  The depth of a "special" array is how far nested it is. For instance, the depth of `[]` is `1`;
  the depth of the inner array in `[[]]` is `2`; the depth of the innermost array in `[[[]]]` is
  `3`.

  Therefore, the product sum of `[x, y]` is `x + y`; the product sum of `[x, [y, z]]` is `x + 2 *
  (y + z)`; the product sum of `[x, [y, [z]]]` is `x + 2 * (y + 3z)`.
*/
public class ProductSum {

  // O(n) time | O(d) space - where n is the total number of elements in the array, including
  // sub-elements, and d is the greatest depth of "special" arrays in the array
  public static int productSum(List<Object> array) {
    return productSumRecursion(array, 1);
  }

  public static int productSumRecursion(List<Object> array, int multiplier) {
    int sum = 0;
    for (Object element : array) {
      if (element instanceof ArrayList) { // check if an element is a list
        @SuppressWarnings("unchecked")
        ArrayList<Object> innerList = (ArrayList<Object>) element;
        sum += productSumRecursion(innerList, multiplier + 1);
      } else {
        sum += (int) element;
      }
    }
    return sum * multiplier;
  }

}
