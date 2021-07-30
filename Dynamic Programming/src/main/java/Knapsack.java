import java.util.ArrayList;
import java.util.List;

public class Knapsack {

  // O(nc) time | O(nc) space - n is how many array of items, c is allowance capacity
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
    int[][] knapsackValues = new int[items.length + 1][capacity + 1];
    for (int row = 1; row < items.length + 1; row++) {
      int currWeight = items[row - 1][1];
      int currValue = items[row - 1][0];
      for (int col = 0; col < capacity + 1; col++) {
        if (currWeight > col) {
          knapsackValues[row][col] = knapsackValues[row - 1][col]; // take values from above row
        } else {
          knapsackValues[row][col] =
              Math.max(
                  knapsackValues[row - 1][col],
                  knapsackValues[row - 1][col - currWeight] + currValue);
        }
      }
    }
    return buildKnapsack(knapsackValues, items, knapsackValues[items.length][capacity]);
    // traverse from bottom right and supposedly up-left
  }

  public static List<List<Integer>> buildKnapsack(int[][] knapsackValues, int[][] items,
      int weight) {
    List<List<Integer>> sequence = new ArrayList<List<Integer>>();
    List<Integer> totalWeight = new ArrayList<Integer>();
    totalWeight.add(weight); // always included
    sequence.add(totalWeight);
    sequence.add(new ArrayList<Integer>());
    int row = knapsackValues.length - 1;
    int col = knapsackValues[0].length - 1;
    while (row > 0) {
      // above value is the same (no changes made), movement was straight down -> traverse up
      if (knapsackValues[row][col] == knapsackValues[row - 1][col]) { //
        row--;
      } else { // changes were made (add to sequence) -> traverse up and leftward to the exact spot
        sequence.get(1).add(0, row - 1);
        col -= items[row - 1][1];
        row--;
      }
      if (col == 0) {
        break;
      }
    }
    return sequence;
  }

}
