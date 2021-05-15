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

  // O(nlog(n) + mlog(m)) time | O(1) space
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);
    int arrOneIdx = 0, arrTwoIdx = 0; // index starts at 0
    int smallestValueOne = 0, smallestValueTwo = 0; // declaration
    int smallestDiff = Integer.MAX_VALUE;

    while (arrOneIdx < arrayOne.length && arrTwoIdx < arrayTwo.length) {
      int twoCurrValue = arrayTwo[arrTwoIdx];
      int oneCurrValue = arrayOne[arrOneIdx];
      int currDifference = Math.abs(twoCurrValue - oneCurrValue);
        if (oneCurrValue < twoCurrValue) {
          arrOneIdx++;
        } else if (oneCurrValue > twoCurrValue) {
          arrTwoIdx++;
        } else {
          return new int[]{oneCurrValue, twoCurrValue};
        }
        if (smallestDiff > currDifference) {
          smallestDiff = currDifference;
          smallestValueOne = oneCurrValue;
          smallestValueTwo = twoCurrValue;
      }
    }
    return new int[]{smallestValueOne, smallestValueTwo};
  }

  /* Alternative
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
   	Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int idxOne = 0;
		int idxTwo = 0;
		int smallest = Integer.MAX_VALUE;
		int current = Integer.MAX_VALUE;
		int[] smallestPair = new int[2];
		while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
			int firstNum = arrayOne[first];
			int secondNum = arrayTwo[second];
			current = Math.abs(firstNum - secondNum);
			if (firstNum < secondNum) {
				idxOne++;
			} else if (firstNum > secondNum) {
				idxTwo++;
			} else {
				return new int[] {firstNum, secondNum};
			}
			if (smallest > current) {
				smallest = current;
				smallestPair = new int[] {firstNum, secondNum};
			}
		}
		return smallestPair;
  }
   */
}
