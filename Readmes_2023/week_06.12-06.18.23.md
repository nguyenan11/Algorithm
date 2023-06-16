# Algorithm practice

# Week 06/12 - 06/18/2023


# Category for this week:
**[Binary Search](#binary-search)**<br>

---

# Binary Search

## [Leetcode #121 - Best Time To Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

#### Level: Easy 📗

```python
def search(self, nums, target):
  """
  :type nums: List[int]
  :type target: int
  :rtype: int
  """
  left, right = 0, len(nums) - 1
  while left <= right:
    mid = left + ((right - left) // 2)
    if nums[mid] < target:
      left = mid + 1
    elif nums[mid] > target:
      right = mid - 1
    else:
      return mid
  return -1
```

Notes on finding mid: If you are setting mid = *(left + right) / 2*, you have to be very careful. Unless you are using a language that does not support overflow such as Python, left + right could overflow. 1 way to fix this is *left + ((right - left) // 2)* instead

### O(log n) time | O(1) space

## [Leetcode #74 - Search a 2d Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

#### Level: Medium 📘

```python
def searchMatrix(self, matrix, target):
  """
  :type matrix: List[List[int]]
  :type target: int
  :rtype: bool
  """
  if not matrix or target is None:
      return False

  rows, cols = len(matrix), len(matrix[0])
  low, high = 0, rows * cols - 1
  while low <= high:
    mid = low + ((high - low) // 2)
    num = matrix[mid / cols][mid % cols]
    if num < target:
      low = mid + 1
    elif num > target:
      high = mid - 1
    else:
      return True
  return False
```

### O(log(mn)) time | O(1) space

## [Leetcode #153 - Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

#### Level: Medium 📘

```python
def findMin(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  left, right = 0, len(nums) - 1
  currMin = nums[0]
  while left <= right:
    if nums[left] <= nums[right]:
      currMin = min(currMin, nums[left])
      break
    else:
      mid = left + (right - left) / 2
      currMin = min(currMin, nums[mid])
      if nums[mid] >= nums[left]:
        left = mid + 1
      else:
        right = mid - 1
  return currMin
```

### O(log n) time | O(1) space
