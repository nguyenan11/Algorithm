/*
  Write a function that takes in a non-empty array of integers and returns an array of the same
  length, where each element in the output array is equal to the product of every other number in
  the input array.

  In other words, the value at output[i] is equal to the product of every number in the input
  array other than input[i].

  Note that you're expected to solve this problem without using division.
*/
public class ArrayOfProducts {

  /**
   * Creates a new array from the given array where each element in the new array is equal to the
   * product of every other number in given array.
   * Complexity: O(n) time | O(n) space - O(2n) = O(n).
   * Assumption: No division allowed.
   *
   * @param array - the array of integers.
   * @return a new array of integers computed from the input array.
   */
  public static int[] arrayOfProducts(int[] array) {
    int[] productArr = new int[array.length];

    int productFromLeft = 1;
    for (int i = 0; i < array.length; i++) {
      productArr[i] = productFromLeft;
      productFromLeft *= array[i];
    }

    int productFromRight = 1;
    for (int i = array.length - 1; i >= 0; i--) {
      productArr[i] *= productFromRight;
      productFromRight *= array[i];
    }
    return productArr;
  }

  // Alternative solution is O(3n), use 3 int[] - productArr = leftArr * rightArr

  /*
  Brute force approach
  O(n^2) time | O(n) space
  public static int[] arrayOfProducts(int[] array) {
    int[] newArr = new int[array.length];
    int leftIdx = 0;
    int rightIdx = array.length - 1;
    int currIdx = 0;
    while (currIdx < array.length) {
      int currProduct = 1;

      while (leftIdx < currIdx) {
        currProduct *= array[leftIdx];
        leftIdx++;
      }

      while (rightIdx > currIdx) {
        currProduct *= array[rightIdx];
        rightIdx--;
      }

      leftIdx = 0;
      rightIdx = array.length - 1;
      newArr[currIdx] = currProduct;
      currIdx++;
    }
    return newArr;
  }
  */

  public static void main(String[] args) {
    int[] array = new int[]{5, 1, 4, 2};
    int[] result = arrayOfProducts(array);
    for (int num : result) {
      System.out.println(num);
    }
  }

}
