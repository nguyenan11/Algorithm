import java.util.List;

/*
  You're given an array of integers and an integer. Write a function that moves all instances of
  that integer in the array to the end of the array and returns the array.

  The function should perform this in place (i.e., it should mutate the input array) and doesn't
  need to maintain the order of the other integers.
 */
public class MoveEleToEnd {

  /**
   * Takes in an array of integers and a target number, move to target number to the end of the
   * array.
   * Complexity: O(n) time | O(1) space - n is length of array.
   * Edge case: target numbers could initially be at the end of array already.
   *
   * @param array - the array of integers to loop through.
   * @param toMove - the number (target) to be moved to the end of array.
   * @return a mutated version of array that has target moved to the end.
   */
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
