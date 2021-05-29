# Algorithm practice

* Documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 3: 05/24 - 05/30/2021

# Category for this week: 
**[Array](#array)**<br>
**[Strings](#strings)**<br>
**[Sorting](#sorting)**<br>


---

# Array

## [Four Number Sum](Arrays/src/main/java/FourNumSum.java)

#### Level: Hard 📕

> Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all quadruplets in the array that sum up to the target sum and return a two-dimensional array of all these quadruplets in no particular order.
>
> If no four numbers sum up to the target sum, the function should return an empty array.

```java
public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    List<Integer[]> quadruplets = new ArrayList<Integer[]>();
    Map<Integer, List<Integer[]>> allPairsSum = new HashMap<>();
    int size = array.length;
    for (int i = 1; i < size - 1; i++) { // starts with 1, skip through 1st iteration
      for (int j = i + 1; j < size; j++) {
        int currSum = array[i] + array[j];
        int match = targetSum - currSum;
        if (allPairsSum.containsKey(match)) {
          for (Integer[] pair : allPairsSum.get(match)) {
            Integer[] newQuadruplets = {pair[0], pair[1], array[i], array[j]};
            quadruplets.add(newQuadruplets);
          }
        }
      }
      for (int k = 0; k < i; k++) { // anything before i -> building Map steps
        int currSum = array[i] + array[k];
        Integer[] pair = {array[k], array[i]};
        if (!allPairsSum.containsKey(currSum)) {
          List<Integer[]> pairGroup = new ArrayList<>();
          pairGroup.add(pair);
          allPairsSum.put(currSum, pairGroup);
        } else {
          allPairsSum.get(currSum).add(pair);
        }
      }
    }
    return quadruplets;
}
```
### Average: O(n^2) time | O(n^2) space
* Worst: O(n^3) time (pair group has multiple/ all elements) | O(n^2) space
* The idea behind this is not to add from first iteration. For Ex: [7, 6], the
target number is 13, when pointer is at 7, don't add to Map; add when pointer is
at 6.

## [Leetcode #1 - Two Number Sum](https://leetcode.com/problems/two-sum/)
* Redo problem using Python

#### Level: Easy 📗

```python
def twoSum(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    targetDictionary = {}
    
    for index, num in enumerate(nums):
        missingPiece = target - num
        if missingPiece in targetDictionary:
            return [index, targetDictionary[missingPiece]]
        else:
            targetDictionary[num] = index
```

### O(n) time | O(n) space

---

# Strings

## [Reverse Words In String](Strings/src/main/java/ReverseWordsInString.java)

#### Level: Medium 📘

## [Leetcode #387 - First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)
* Redo problem using Python

#### Level: Easy 📗

```python
dic = {}
        
for character in s:
        if character in dic:
            count = dic[character]
            dic[character] = count + 1
        else:
            dic[character] = 1
            
    for index,character in enumerate(s):
        if dic[character] == 1:
            return index
    
    return -1
```

### O(n) time | O(1) space - n is the length of the input string
* See notes in week 2 for explanation of constant space

---

# Sorting

## [Bubble Sort](Sortings/src/main/java/BubbleSort.java)

#### Level: Easy 📗

> Write a function that takes in an array of integers and returns a sorted version of that array. Use the Bubble Sort algorithm to sort the array.

```java
public static int[] bubbleSort(int[] array) {
    boolean isSorted = false;
    int counter = 0; // not reducing complexity but made algorithm more efficient
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < array.length - 1 - counter; i++) {
        if (array[i] > array[i + 1]) {
          swap(i, i + 1, array);
          isSorted = false;
        }
      }
      counter++;
    }
    return array;
}

private static void swap(int i, int j, int[] array) {
    int tempValue = array[i];
    array[i] = array[j];
    array[j] = tempValue;
}
```

### O(n^2) time | O(1) space
* Best: O(n) time | O(1) space - when array is already sorted