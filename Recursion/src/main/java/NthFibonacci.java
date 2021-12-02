/*
  The Fibonacci sequence is defined as follows: the first number of the sequence is `0`, the second
  number is `1`, and the nth number is the sum of the (n - 1)th and (n - 2)th numbers. Write a
  function that takes in an integer `n` and returns the nth Fibonacci number.

  Important note: the Fibonacci sequence is often defined with its first two numbers as `F0 = 0`
  and `F1 = 1`. For the purpose of this question, the first Fibonacci number is `F0`; therefore,
  `getNthFib(1)` is equal to `F0`, `getNthFib(2)` is equal to `F1`, etc..
 */
public class NthFibonacci {

  // O(n) time | O(1) space
  public static int getNthFib(int n) {
    int[] lastTwo = {0, 1};
    int counter = 3;
    while (counter <= n) {
      int nextFib = lastTwo[0] + lastTwo[1];
      lastTwo[0] = lastTwo[1];
      lastTwo[1] = nextFib;
      counter++;
    }
    return n > 1 ? lastTwo[1] : lastTwo[0]; // handle edge case where n == 1
  }

  /* O(n) time | O(n) space
  public static int getNthFib(int n) {
    Map<Integer, Integer> memory = new HashMap<Integer, Integer>();
    memory.put(1, 0);
    memory.put(2, 1);
    return getNthFib(n, memory);
  }

  public static int getNthFib(int n, Map<Integer, Integer> memory) {
    if (memory.containsKey(n)) {
      return memory.get(n);
    }
    memory.put(n, getNthFib(n - 1, memory) + getNthFib(n - 2, memory));
    return memory.get(n);
  }
  */

  /* Brute force: O(2^n) time | O(n) space
  public static int getNthFib(int n) {
    if (n == 2) {
      return 1;
    } else if (n == 1) {
      return 0;
    }
    return getNthFib(n - 1) + getNthFib(n - 2);
  }
  */

}
