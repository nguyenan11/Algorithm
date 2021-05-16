# Algorithm practice

- Alternative solutions might be available in each question.

# Week 1: 05/10 - 05/16/2021

### Topic: Array

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

> Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of the first one. A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the SAME ORDER as they appear in the array. For instance, the numbers `[1, 3, 4]` from a subsequence of the array `[1, 2, 3, 4]`, and so do the number `[2, 4]`. Note that a single number in an array and the array itself are both valid subsequences of the arrays.

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
> Given an array of pairs representing the teams that have competed against each other and an array containing the results of each competition, write a function that returns the winner of the tournament. The input arrays are named "competitions" and "results", respectively. The `competitions` array has elements in the form of `[homeTeam, awayTeam]`, where each team is a string of at most 30 characters representing the name of the team. The `results` array contains information about the winner of each corresponding competition in the `competitions` array. Specifically, `results[i]` denotes the winner of `competitions[i]`, where `1` in the `results` array means that the home team in the corresponding competition won and a `0` means that the away team won.
>
> It's guaranteed that exactly one team will win the tournament and that each team will compete against all other teams exactly once. It's also guaranteed that the tournament will always have at least two teams.

```java
private static final int AWAY_TEAM_WON = 0, POINTS_PER_WIN = 3;

public String tournamentWinner(ArrayList<ArrayList<String>> competitions,
      ArrayList<Integer> results) {
    Hashtable<String, Integer> tracking = new Hashtable<>();
    String winner = null;
    String roundWinner;
    int highestPoints = 0;
    for (int index = 0; index < competitions.size(); index++) {
      roundWinner = getRoundWinner(index, competitions, results);
      updateScores(tracking, roundWinner);

      if (tracking.get(roundWinner) > highestPoints) {
        highestPoints = tracking.get(roundWinner);
        winner = roundWinner;
      }

    }
    return winner;
  }

  private String getRoundWinner(int index, ArrayList<ArrayList<String>> competitions,
      ArrayList<Integer> results) {
    if (results.get(index) == AWAY_TEAM_WON) {
      return competitions.get(index).get(1);
    } else {
      return competitions.get(index).get(0);
    }
  }

  private void updateScores(Hashtable<String, Integer> tracking, String roundWinner) {
    if (tracking.containsKey(roundWinner)) {
      tracking.put(roundWinner, tracking.get(roundWinner) + POINTS_PER_WIN);
    } else {
      tracking.put(roundWinner, POINTS_PER_WIN);
    }
  }
```

### O(n) time | O(k) space - n is number of competitions, k is number of teams

## [Non-Constructible Change](Arrays/src/main/java/NonConstructibleChange.java)

### Level: Easy

> Given an array of positive integers representing the values of coins in your possession, write a function that returns the minimum amount of change (the minimum sum of money) that you cannot create. The given coins can have any positive integer value and aren't necessarily unique (i.e., you can have multiple coins of the same value).
>
> For example, if you are given coins = [1, 2, 5], the minimum amount of change that you can't create is 4. If you're given no coins, the minimum amount of change that you can't create is 1.

```java
public int nonConstructibleChange(int[] coins) {
    int impossibleChange = 1;
    Arrays.sort(coins);
    for (int coin : coins) {
      if (coin > impossibleChange) {
        return impossibleChange;
      } else if (coin <= impossibleChange + 1) {
        impossibleChange += coin;
      }
    }
    return impossibleChange;
  }
```

### O(nlog(n)) time | O(1) space - n is number of coins

## [Three Numbers Sum](Arrays/src/main/java/ThreeNumSum.java)

### Level: Medium

> Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all triplets in the array that sum up to the target sum and return a two-dimensional array of all these triplets. The numbers in each triplet should be ordered in ascending order, and the triplets themselves should be ordered in ascending order with respect to the numbers they hold.
>
>If no three numbers sum up to the target sum, the function should return an empty array.

```java
public static List<int[]> threeNumberSum(int[] array, int targetSum) {
    List<int[]> targetList = new ArrayList<int[]>();
    Arrays.sort(array);
    int size = array.length - 1;
    for (int i = 0; i < size; i++) {
      int match = targetSum - array[i];

      int leftPointer = i + 1;
      int rightPointer = size;
      while (leftPointer < rightPointer) {
        int sumOfTwo = array[leftPointer] + array[rightPointer];
        if (sumOfTwo == match) {
          targetList.add(new int[]{array[i], array[leftPointer], array[rightPointer]});
          leftPointer++;
          rightPointer--;
        } else if (sumOfTwo < match) {
          leftPointer++;
        } else {
          rightPointer--;
        }
      }
    }
    return targetList;
  }
```

### O(n^2) time | O(n) space - n is length of input array
* O(nlog(n)) from sorting is less than O(n^2)

## [Smallest Difference](Arrays/src/main/java/SmallestDifference.java)

### Level: Medium

> Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array) whose absolute difference is closest to zero, and returns an array containing these two numbers, with the number from the first array in the first position.
>
> Note that the absolute difference of two integers is the distance between them on the real number line. For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.
>
>You can assume that there will only be one pair of numbers with the smallest difference.

```java
public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);
    int arrOneIdx = 0, arrTwoIdx = 0; // index starts at 0
    int smallestValueOne = 0, smallestValueTwo = 0; // declaration
    int smallestDiff = Integer.MAX_VALUE;

    while (arrOneIdx < arrayOne.length && arrTwoIdx < arrayTwo.length) {
      int twoCurrValue = arrayTwo[arrTwoIdx];
      int oneCurrValue = arrayOne[arrOneIdx];
      int currDifference = Math.abs(twoCurrValue - oneCurrValue);
        if (oneCurrValue < twoCurrValue) {
          arrOneIdx++;
        } else if (oneCurrValue > twoCurrValue) {
          arrTwoIdx++;
        } else {
          return new int[]{oneCurrValue, twoCurrValue};
        }
        if (smallestDiff > currDifference) {
          smallestDiff = currDifference;
          smallestValueOne = oneCurrValue;
          smallestValueTwo = twoCurrValue;
      }
    }
    return new int[]{smallestValueOne, smallestValueTwo};
  }
```

### O(nlog(n) + mlog(m)) time | O(1) space
* Roughly O(n + m) time
* n and m because 2 arrays might not have the same length

## [Move Element To End](Arrays/src/main/java/MoveEleToEnd.java)

### Level: Medium

>You're given an array of integers and an integer. Write a function that moves all instances of that integer in the array to the end of the array and returns the array.
>
>The function should perform this in place (i.e., it should mutate the input array) and doesn't need to maintain the order of the other integers.

```java
public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int start = 0;
    int end = array.size() - 1;
    while (start < end) {
      if (array.get(start) == toMove) {
        while (array.get(end) == toMove && end > start) {
          end--;
        }
        array.set(start, array.get(end));
        array.set(end, toMove);
      }
      start++;
    }
    return array;
  }
```

### O(n) time | O(1) space - n is length of array
* Seems like n^2 square for time because of 2 while loops, but the iterations
stop when two pointers cross-path


