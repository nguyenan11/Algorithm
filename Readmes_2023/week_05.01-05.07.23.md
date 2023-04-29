# Algorithm practice

# Week 05/01 - 05/07/2023


# Category for this week:
**[Array](#array)**<br>

---

# Array

## [Leetcode #217 - Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

#### Level: Easy 📗

```python
def containsDuplicate(self, nums):
  """
  :type nums: List[int]
  :rtype: bool
  """
  hashset = set()
  for num in nums:
    if num in hashset:
      return True
    hashset.add(num)
  return False
```

### O(n) time | O(n) space


