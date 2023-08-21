# Algorithm practice

# Week 08/21 - 08/27/2023

# Category for this week:
**[Microsoft focused questions](#microsoft)**<br>

---

# Microsoft

## [Leetcode #1822 - Sign of the Product of an Array](https://leetcode.com/problems/sign-of-the-product-of-an-array/)

#### Level: Easy 📗

```python
def arraySign(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  count = 1
  for num in nums:
    if num == 0:
      return 0
    if num < 1:
      count *= -1
  return count
```

#### O(n) time | O(1) space
