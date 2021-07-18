/*
  Given an array of distinct positive integers representing coin denominations and a single
  non-negative integer `n` representing a target amount of money, write a function that returns the
  number of ways to make change for that target amount using the given coin denominations.

  Note that an unlimited amount of coins is at your disposal.
*/
public class NumWaysToMakeChange {

  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    int[] ways = new int[n + 1];
    ways[0] = 1;
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
