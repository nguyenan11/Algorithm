import java.util.ArrayList;
import java.util.List;

public class MoveEleToEnd {

  /*

  You're given an array of integers and an integer. Write a function that moves
  all instances of that integer in the array to the end of the array and returns
  the array.

  The function should perform this in place (i.e., it should mutate the input
  array) and doesn't need to maintain the order of the other integers.
   */

  // O(n) time | O(1) space - n is length of array
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int start = 0;
    int end = array.size() - 1;
    while (start < end) {
      if (array.get(start) == toMove) {
        while (array.get(end) == toMove && end > start) {
          end--;
        }
        array.set(start, array.get(end));
        array.set(end, toMove);
      }
      start++;
    }
    return array;
  }
}
