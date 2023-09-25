# Algorithm practice

# Week 09/25 - 10/01/2023

# Category for this week:
**[Randon](#random)**<br>

---

# Random

## [Leetcode #1929 - Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/)

#### Level: Easy 📗

> Approach 1

```python
def getConcatenation(self, nums):
  """
  :type nums: List[int]
  :rtype: List[int]
  """
  return nums + nums
```

> Approach 2

```python
def getConcatenation(self, nums):
  """
  :type nums: List[int]
  :rtype: List[int]
  """
  result = []
  for i in range(2):
    for num in nums:
      result.append(num)
  return result
```

#### O(2n) ~ O(n) time | O(n) space if extra memory counts if not then O(1) space
