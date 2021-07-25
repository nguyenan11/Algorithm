import java.util.Arrays;

/*
  Given an array of positive integers representing coin denominations and a single non-negative
  integer `n` representing a target amount of money, write a function that returns the smallest
  number of coins needed to make change for (to sum up to) that target amount using the given coin
  denominations.

  Note that you have access to an unlimited amount of coins. In other words, if the denominations
  are `[1, 5, 10]`, you have access to an unlimited amount of `1`s, `5`s, and `10`s.

  If it's impossible to make change for the target amount, return `-1`.
*/
public class MinNumCoinsForChange {

  // O(nd) time | O(n) space - d is how many denoms we have
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    int[] numCoins = new int[n + 1];
    Arrays.fill(numCoins, Integer.MAX_VALUE); // kind of like the base case
    numCoins[0] = 0; // zero dollar
    int toCompare = 0;
    for (int denom : denoms) {
      for (int amount = 0; amount < numCoins.length; amount++) {
        if (denom <= amount) {
          if (numCoins[amount - denom] == Integer.MAX_VALUE) {
            toCompare = numCoins[amount - denom];
          } else {
            toCompare = numCoins[amount - denom] + 1;
          }
          numCoins[amount] = Math.min(numCoins[amount], toCompare);
        }
      }
    }
    return numCoins[n] != Integer.MAX_VALUE ? numCoins[n] : -1;
  }

}
