/*
  Given an array of distinct positive integers representing coin denominations and a single
  non-negative integer `n` representing a target amount of money, write a function that returns the
  number of ways to make change for that target amount using the given coin denominations.

  Note that an unlimited amount of coins is at your disposal.
*/
public class NumWaysToMakeChange {

  /**
   * Find the number of distinct ways to make a certain value from available changes. Complexity:
   * O(nd) time | O(n) space - n is input n, d is number of elements in denoms
   * Assumption: unlimited amount of availble changes.
   *
   * @param n      - a target value, an int.
   * @param denoms - array of integers representing availble changes/ coins.
   * @return an int representing number of ways to make change, 0 if change cannot be made from
   * available coins.
   */
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    int[] ways = new int[n + 1];
    ways[0] = 1; // important here
    for (int denom : denoms) {
      for (int amount = 1; amount < n + 1; amount++) {
        if (denom <= amount) {
          ways[amount] += ways[amount - denom];
        }
      }
    }
    return ways[n];
  }

}
