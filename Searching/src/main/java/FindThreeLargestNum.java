/*
  Write a function that takes in an array of at least three integers and, without sorting the input
  array, returns a sorted array of the three largest integers in the input array.

  The function should return duplicate integers if necessary; for example, it should return
  `[10, 10, 12]` for an input array of `[10, 5, 9, 10, 12]`.
*/
public class FindThreeLargestNum {

  public static int[] findThreeLargestNumbers(int[] array) {
    int[] sortedThreeLargestNum = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    for (int num : array) {
      updateLargest(sortedThreeLargestNum, num);
    }
    return sortedThreeLargestNum;
  }

  public static void updateLargest(int[] threeLargest, int num) {
    if (num > threeLargest[2]) {
      shiftAndUpdate(threeLargest, num, 2);
    } else if (num > threeLargest[1]) {
      shiftAndUpdate(threeLargest, num, 1);
    } else if (num > threeLargest[0]) {
      shiftAndUpdate(threeLargest, num, 0);
    }
  }

  public static void shiftAndUpdate(int[] threeLargest, int num, int position) {
    for (int i = 0; i <= position; i++) {
      if (i == position) {
        threeLargest[i] = num;
      } else {
        threeLargest[i] = threeLargest[i + 1];
      }
    }
  }
}
