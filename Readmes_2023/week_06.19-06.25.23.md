# Algorithm practice

# Week 06/19 - 06/25/2023


# Category for this week:
**[Binary Search](#binary-search)**<br>

---

# Binary Search

## [Leetcode #33 - Search In Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

#### Level: Medium 📘

```python
def search(self, nums, target):
  """
  :type nums: List[int]
  :type target: int
  :rtype: int
  """
  if not nums or len(nums) == 0:
    return -1
  if len(nums) == 1:
    return 0 if target in nums else -1
  left, right = 0, len(nums) - 1
  while left <= right:
    mid = left + (right - left) / 2
    if nums[mid] == target:
      return mid

    # sorted left portion
    if nums[left] <= nums[mid]:
      if target > nums[mid] or target < nums[left]:
        left = mid + 1
      else:
        right = mid - 1
    # sorted right portion
    else:
      if target < nums[mid] or target > nums[right]:
        right = mid - 1
      else:
        left = mid + 1
  return -1
```

### O(log n) time | O(1) space

## [Leetcode #981 - Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/)

#### Level: Medium 📘

> Important details: All the timestamps of set are strictly increasing.

```python
class TimeMap(object):

  def __init__(self):
    self.keyValues = {} 
    # map where key is key and value is list of [value, timestamp]
      

  def set(self, key, value, timestamp):
    """
    :type key: str
    :type value: str
    :type timestamp: int
    :rtype: None
    """
    if key not in self.keyValues:
      self.keyValues[key] = []
    self.keyValues[key].append([value, timestamp])

  def get(self, key, timestamp):
    """
    :type key: str
    :type timestamp: int
    :rtype: str
    """
    result, values = "", self.keyValues.get(key, [])
    left, right = 0, len(values) - 1
    while left <= right:
      mid = left + (right - left) / 2
      if values[mid][1] <= timestamp:
        result = values[mid][0]
        left = mid + 1
      else:
        right = mid - 1
    return result
```

