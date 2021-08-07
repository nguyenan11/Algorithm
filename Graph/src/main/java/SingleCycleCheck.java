public class SingleCycleCheck {

  public static boolean hasSingleCycle(int[] array) {
    int counter = 0;
    int idx = 0;
    while (counter < array.length) {
      int numMoves = array[idx];
      if (numMoves == 0) return false;
      idx = validateMove(numMoves, idx, array.length - 1);
      counter++;
    }
    return idx == 0;
  }

  public static int validateMove(int numMoves, int idx, int arrayLength) {
    int newIdx = idx + numMoves;
    if (newIdx > arrayLength) {
      newIdx = (newIdx % arrayLength) - 1;
    }
    if (newIdx < 0) {
      newIdx = arrayLength + 1 + newIdx;
    }
    return newIdx;
  }

  public static void main(String args[]) {
    int[] arr = new int[]{2, 3, 1, -4, -4, 2};
    int[] secondArr= new int[]{2, 2, 2};
    int[] edgeCase = new int[]{10, 11, -6, -23, -2, 3, 88, 908, -26};
    boolean result = hasSingleCycle(arr);
    System.out.println(result);
  }

}
