import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

  /**
   *
   Given two non-empty arrays of integers, write a function that determines
   whether the second array is a subsequence of the first one.
   A subsequence of an array is a set of numbers that aren't necessarily adjacent
   in the array but that are in the SAME ORDER as they appear in the array. For
   instance, the numbers [1, 3, 4] from a subsequence of the array [1, 2, 3, 4], and so do the
   number [2, 4]. Note that a single number in an array and the array itself are both valid
   subsequences of the arrays.
   */

  // O(n) time | O(1) space
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int seqIndex = 0;
    for (int num: array) {
      if (seqIndex < sequence.size() && num == sequence.get(seqIndex)) {
        seqIndex++;
      }
    }
    return seqIndex == sequence.size();
  }

  // Alternative: Same idea, using arrIndex and seqIndex, using while loop, keep ++, same complexity

  public static void main(String[] args) {
    List<Integer> array = Arrays.asList(1, 1 , 6 , 1);
    List<Integer> sequence = Arrays.asList(1, 1, 1, 6);
  boolean expected = ValidateSubsequence.isValidSubsequence(array, sequence);
  System.out.println(expected);
  }
}
