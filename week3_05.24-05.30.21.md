# Algorithm practice

* Documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 2: 05/24 - 05/30/2021

# Category for this week: 
**[Array](#array)**<br>
**[Strings](#strings)**<br>

---

# Array

## [Four Number Sum](Arrays/src/main/java/FourNumSum.java)

#### Level: Hard 📕

> Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all quadruplets in the array that sum up to the target sum and return a two-dimensional array of all these quadruplets in no particular order.
>
> If no four numbers sum up to the target sum, the function should return an empty array.
```java
comeback for this
```

## [Problem 1 - Two Number Sum](https://leetcode.com/problems/two-sum/)
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

---

# Strings

## [Reverse Words In String](Strings/src/main/java/ReverseWordsInString.java)

#### Level: Medium 📘

## [Prob 387 - First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)
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
* See notes in week 2 for constant space
