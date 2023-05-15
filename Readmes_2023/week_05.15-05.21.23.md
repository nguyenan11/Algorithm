# Algorithm practice

# Week 05/15 - 05/21/2023


# Category for this week:
**[Two Pointers](#two~pointers)**<br>

---

# Two Pointers

## [Leetcode #125 - Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

#### Level: Easy 📗

```python
def isPalindrome(self, s):
  """
  :type s: str
  :rtype: bool
  """
  leftPtr = 0
  rightPtr = len(s) - 1
  if leftPtr >= rightPtr:
    return True

  while leftPtr < rightPtr:
    leftChar = s[leftPtr].lower()
    rightChar = s[rightPtr].lower() 
    if not leftChar.isalnum():
      leftPtr += 1
    elif not rightChar.isalnum():
      rightPtr -= 1
    else:
      if leftChar != rightChar:
        return False
      leftPtr += 1
      rightPtr -= 1
  return True
```

### O(n) time | O(1) space

## [Leetcode #167 - Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

#### Level: Medium 📘

```python
def twoSum(self, numbers, target):
  """
  :type numbers: List[int]
  :type target: int
  :rtype: List[int]
  """
  leftPtr, rightPtr = 0, len(numbers) - 1
  while leftPtr < rightPtr:
    val = numbers[leftPtr], numbers[rightPtr]
    if val > target:
      rightPtr -= 1
    elif val < target:
      leftPtr += 1
    else:
      return [leftPtr + 1, rightPtr + 1]
```

### O(n) time | O(1) space
