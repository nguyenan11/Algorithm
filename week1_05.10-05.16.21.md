# Algorithm practice

# Week 1: 05/10 - 05/16/2021
## [Two num sums](Arrays/src/main/java/TwoNumSum.java)
> Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. If any two numbers in the input array sum up to the target sum, the function should return them in an array, in any order. If no two numbers sum up to the target sum, the function should return an empty array.
```java
public int[] twoNumberSum(int[] array, int targetSum) {
    Set<Integer> nums = new HashSet<>();
    for (int num: array) {
      int match = targetSum - num;
      if (nums.contains(match)) {
        return new int[] {match, num};
      }
      nums.add(num);
    }
    return new int[0];
  }
```
### O(n) time | O(n) space
### Check out alternatives in folder

