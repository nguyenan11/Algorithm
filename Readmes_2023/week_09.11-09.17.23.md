# Algorithm practice

# Week 09/11 - 09/17/2023


# Category for this week:
**[Bit Manipulation](#bit-manipulation)**<br>

---

# Bit Manipulation

## [Leetcode #191 - Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)

#### Level: Easy 📗

```python
def hammingWeight(self, n):
  """
  :type n: int
  :rtype: int
  100 % 2 = 0
  101 % 2 = 1
  1101 % 2 = 0
  1100 % 2 = 0
  """
  count = 0
  while n: # n not equal 0
    count += n % 2
    # shift to right by 1
    # 1101 -> 110, 110 -> 11, 11 -> 1
    n = n >> 1
  return count
```

#### O(len) time - len is binary string length of 32  | O(1) space
