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