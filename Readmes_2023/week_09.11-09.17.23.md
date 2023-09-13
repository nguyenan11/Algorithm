# Algorithm practice

# Week 09/11 - 09/17/2023


# Category for this week:
**[Bit Manipulation](#bit-manipulation)**<br>
**[Math And Geometry](#math-and-geometry)**<br>

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

## [Leetcode #338 - Counting Bits](https://leetcode.com/problems/counting-bits/)

#### Level: Easy 📗

```python
def countBits(self, n):
  """
  :type n: int
  :rtype: List[int]
  """
  dp = [0] * (n + 1)
  offset = 1 # power of 2 - 2^0, 2^1, 2^2,...

  for i in range(1, n + 1): # exclude n + 1 actually
    if offset * 2 == i: # check if we have new offset
      offset = i
    dp[i] = 1 + dp[i - offset]
  
  return dp
```

#### O(n) time | O(n + 1) space

---

# Math And Geometry

## [Leetcode #48 - Rotate Image](https://leetcode.com/problems/rotate-image/)

#### Level: Medium 📘

```python
def rotate(self, matrix):
  """
  :type matrix: List[List[int]]
  :rtype: None Do not return anything, modify matrix in-place instead.
  """
  # important to note: n x n matrix
  l, r = 0, len(matrix) - 1
  while l < r:
    for i in range(r - l):
      top, bot = l, r

      # save top left
      topLeft = matrix[top][l + i]

      # move bot left to top left
      matrix[top][l + i] = matrix[bot - i][l]

      # move bot right to bot left
      matrix[bot - i][l] = matrix[bot][r - i]

      # move top right to bot right
      matrix[bot][r - i] = matrix[top + i][r]

      # move top left to top right
      matrix[top + i][r] = topLeft

    l += 1
    r -= 1
```

#### O(n x n) time | O(1) space

## [Leetcode #73 - Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

#### Level: Medium 📘

> Brute force

```python
def setZeroes(self, matrix):
  """
  :type matrix: List[List[int]]
  :rtype: None Do not return anything, modify matrix in-place instead.
  """
  colsZero, rowsZero = set(), set()
  
  for r in range(len(matrix)):
    for c in range(len(matrix[0])):
      if matrix[r][c] == 0:
        colsZero.add(c)
        rowsZero.add(r)

  for r in range(len(matrix)):
    for c in range(len(matrix[0])):
      if matrix[r][c] == 0:
        continue
      if r in rowsZero or c in colsZero:
        matrix[r][c] = 0
```

#### O(m x n) time | O(m + n) space
