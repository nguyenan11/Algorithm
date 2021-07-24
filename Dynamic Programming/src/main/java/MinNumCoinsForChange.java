import java.util.Arrays;

public class MinNumCoinsForChange {

  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    int[] numCoins = new int[n + 1];
    Arrays.fill(numCoins, Integer.MAX_VALUE);
    numCoins[0] = 0;
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
