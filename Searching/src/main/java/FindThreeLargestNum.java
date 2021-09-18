/*

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
