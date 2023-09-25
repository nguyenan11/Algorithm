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

## [Leetcode #1299 - Replace Elements with Greatest Element on Right Side](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/)

#### Level: Easy 📗

```python
def replaceElements(self, arr):
  """
  :type arr: List[int]
  :rtype: List[int]
  """
  rightMax = -1 
  
  for i in range(len(arr) - 1, -1, -1):
    newMax = max(rightMax, arr[i])
    arr[i] = rightMax
    rightMax = newMax
  return arr
```

#### O(n) time | O(1) space
