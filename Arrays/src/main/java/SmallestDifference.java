import java.util.Arrays;

public class SmallestDifference {

  /*

  Write a function that takes in two non-empty arrays of integers, finds the
  pair of numbers (one from each array) whose absolute difference is closest to
  zero, and returns an array containing these two numbers, with the number from
  the first array in the first position.


  Note that the absolute difference of two integers is the distance between
  them on the real number line. For example, the absolute difference of -5 and 5
  is 10, and the absolute difference of -5 and -4 is 1.


  You can assume that there will only be one pair of numbers with the smallest
  difference.
   */

  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);
    int arrOnePointer = arrayOne[0];
    int arrTwoPointer = arrayTwo[0];
    int currDifference;
    int currSmallestDiff = Integer.MAX_VALUE;
    for (int num : arrayOne) {
      currDifference = Math.abs(arrTwoPointer - num);
      if (currDifference < currSmallestDiff) {
        currSmallestDiff = currDifference;
        arrOnePointer = num;
      }
    }

    for (int num : arrayTwo) {
      currDifference = Math.abs(num - arrOnePointer);
      if (currDifference < currSmallestDiff) {
        currSmallestDiff = currDifference;
        arrTwoPointer = num;
      }
    }
    return new int[]{arrOnePointer, arrTwoPointer};
  }

}
