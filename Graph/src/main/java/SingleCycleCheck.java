public class SingleCycleCheck {

  // O(n) time | O(1) space
  public static boolean hasSingleCycle(int[] array) {
    int counter = 0;
    int idx = 0;
    while (counter < array.length) {
      if (counter > 0 && idx == 0) {
        return false;
      }
      int numMoves = array[idx];
      idx = validateMove(numMoves, idx, array.length);
      counter++;
    }
    return idx == 0;
  }

  public static int validateMove(int numMoves, int idx, int arrayLength) {
    int newIdx = (idx + numMoves) % arrayLength;
    return newIdx >= 0 ? newIdx : newIdx + arrayLength;
  }

  public static void main(String args[]) {
    int[] arr = new int[]{2, 3, 1, -4, -4, 2};
    int[] secondArr = new int[]{2, 2, 2};
    int[] thirdArr = new int[]{0, 1, 1, 1, 1, 1};
    int[] edgeCase = new int[]{10, 11, -6, -23, -2, 3, 88, 908, -26};
    boolean result = hasSingleCycle(arr);
    System.out.println(result);
  }

}
