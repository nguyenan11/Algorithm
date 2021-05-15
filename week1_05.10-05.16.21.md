# Algorithm practice
* Alternative solutions might be available in each question.

# Week 1: 05/10 - 05/16/2021
## [Two Numbers Sum](Arrays/src/main/java/TwoNumSum.java)
#### Level: Easy
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

## [Validate Subsequence](Arrays/src/main/java/ValidateSubsequence.java)
#### Level: Easy
> Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of the first one. A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the SAME ORDER as they appear in the array. For instance, the numbers ```[1, 3, 4]``` from a subsequence of the array ```[1, 2, 3, 4]```, and so do the number ```[2, 4]```. Note that a single number in an array and the array itself are both valid subsequences of the arrays.
```java
public boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int seqIndex = 0;
    for (int num: array) {
      if (seqIndex < sequence.size() && num == sequence.get(seqIndex)) {
        seqIndex++;
      }
    }
    return seqIndex == sequence.size();
  }
```
### O(n) time | O(1) space
### Alternative: Same idea, using arrIndex and seqIndex, using while loop, keep ++, same complexity.

## [Sorted Squared Array](Arrays/src/main/java/SortedSquareArray.java)
#### Level: Easy
> Write a function that takes in a non-empty array of integers that are sorted in ascending order and returns a new array of the same length with the squares of the original integers also sorted in ascending order.
```java
public int[] sortedSquaredArray(int[] array) {
    int[] newArr = new int[array.length];
    int smallerValueIndex = 0;
    int largerValueIndex = array.length - 1;
    for (int i = array.length; i >= 0; i--) {
      int smallerValue = array[smallerValueIndex];
      int largerValue = array[largerValueIndex];
      if (Math.abs(smallerValue) > Math.abs(largerValue)) {
        newArr[i] = smallerValue * smallerValue;
        smallerValueIndex++;
      } else {
        newArr[i] = largerValue * largerValue;
        largerValueIndex--;
      }
    }
    return newArr;
  }
```
### O(n) time | O(n) space

## [Tournament Winner](Arrays/src/main/java/TournamentWinner.java)
#### Level: Easy
> There's an algorithms tournament taking place in which teams of programmers compete against each other to solve algorithmic problems as fast as possible. Teams compete in a round robin, where each team faces off against all other teams. Only two teams compete against each other at a time, and for each competition, one team is designated the home team, while the other team is the away team. In each competition there's always one winner and one loser; there are no ties. A team receives 3 points if it wins and 0 points if it loses. The winner of the tournament is the team that receives the most amount of points.
>
> Given an array of pairs representing the teams that have competed against each other and an array containing the results of each competition, write a function that returns the winner of the tournament. The input arrays are named "competitions" and "results", respectively. The ```competitions``` array has elements in the form of ```[homeTeam, awayTeam]```, where each team is a string of at most 30 characters representing the name of the team. The ```results``` array contains information about the winner of each corresponding competition in the ```competitions``` array. Specifically, ```results[i]``` denotes the winner of ```competitions[i]```, where ```1``` in the ```results``` array means that the home team in the corresponding competition won and a ```0``` means that the away team won.
>
> It's guaranteed that exactly one team will win the tournament and that each team will compete against all other teams exactly once. It's also guaranteed that the tournament will always have at least two teams.
```java
public static String tournamentWinner(ArrayList<ArrayList<String>> competitions,
      ArrayList<Integer> results) {
    Hashtable<String, Integer> tracking = new Hashtable<>();
    String winner = null;
    String roundWinner;
    int highestPoints = 0;
    for (int index = 0; index < competitions.size(); index++) {
      if (results.get(index) == 0) {
        roundWinner = competitions.get(index).get(1);
      } else {
        roundWinner = competitions.get(index).get(0);
      }

      if (tracking.containsKey(roundWinner)) {
        tracking.put(roundWinner, tracking.get(roundWinner) + 3);
      } else {
        tracking.put(roundWinner, 3);
      }

      if (tracking.get(roundWinner) > highestPoints) {
        highestPoints = tracking.get(roundWinner);
        winner = roundWinner;
      }

    }
    return winner;
  }
```
### O(n) time | O(k) space - n is number of competitions, k is number of teams

## [Non-Constructible Change](Arrays/src/main/java/NonConstructibleChange.java)
### Level: Easy
> Given an array of positive integers representing the values of coins in your possession, write a function that returns the minimum amount of change (the minimum sum of money) that you cannot  create. The given coins can have any positive integer value and aren't necessarily unique (i.e., you can have multiple coins of the same value).
>
> For example, if you are given coins = [1, 2, 5], the minimum amount of change that you can't create is 4. If you're given no coins, the minimum amount of change that you can't create is 1.
```java
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
```