/*
  You're given two positive integers representing the height of a staircase and the maximum number
  of steps that you can advance up the staircase at a time. Write a function that returns the
  number of ways in which you can climb the staircase.

  For example, if you were given a staircase of `height = 3` and `maxSteps = 2` you could climb the
  staircase in 3 ways. You could take **1 step, 1 step, then 1 step**, you could also take **1
  step, then 2 steps**, and you could take **2 steps, then 1 step**.

  Note that `maxSteps <= height` will always be true.
*/
public class StaircaseTraversal {

  // O(n * k) time | O(n) space - n is height of staircases and k is number of allowed steps
  public int staircaseTraversal(int height, int maxSteps) {
    int[] waysToTop = new int[height + 1];
    waysToTop[0] = 1;
    waysToTop[1] = 1;
    for (int currHeight = 2; currHeight < height + 1; currHeight++) {
      int step = 1;
      while (step <= maxSteps && step <= currHeight) {
        waysToTop[currHeight] += waysToTop[currHeight - step];
        step += 1;
      }
    }
    return waysToTop[height];
  }

  /*
  // O(k^n) time | O(n) space - n is height of staircases and k is number of allowed steps
  public int staircaseTraversal(int height, int maxSteps) {
    return numWaysToTop(height, maxSteps);
  }

	public int numWaysToTop(int height, int maxSteps) {
		if (height <= 1) {
			return 1;
		}
		int numWays = 0;
		for (int step =1; step < Math.min(maxSteps, height) + 1; step++) {
			numWays += numWaysToTop(height - step, maxSteps);
		}
		return numWays;
	}
  */

}
