import java.util.Arrays;

public class NonConstructibleChange {

  /*

  Given an array of positive integers representing the values of coins in your
  possession, write a function that returns the minimum amount of change (the
  minimum sum of money) that you cannot  create. The given coins can have
  any positive integer value and aren't necessarily unique (i.e., you can have
  multiple coins of the same value).

  For example, if you are given coins = [1, 2, 5], the minimum amount of change that you can't
  create is 4. If you're given no coins, the minimum amount of change that you can't create is 1
   */

  public int nonConstructibleChange(int[] coins) {
    int impossibleChange = 1;
    Arrays.sort(coins);
    for (int index = 0; index < coins.length; index++) {
      if (coins[index] > impossibleChange) {
        return impossibleChange;
      } else if (coins[index] <= impossibleChange + 1) {
        impossibleChange += coins[index];
      }
    }
    return impossibleChange;
  }
}
