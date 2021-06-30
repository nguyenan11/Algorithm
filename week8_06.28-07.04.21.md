# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 8: 06/28 - 07/04/2021

# Category for this week:
**[Binary Search](#binary-search)**<br>

---

# Binary Search

## [Leetcode #278 - First Bad Version](https://leetcode.com/problems/first-bad-version/)

#### Level: Easy 📗

```python
def firstBadVersion(self, n):
  """
  :type n: int
  :rtype: int
  """
  left = 1
  right = n
  while left < right:
    mid = left + (right - left) / 2
    if isBadVersion(mid):
      right = mid
    else:
      left = mid + 1
  return left
```