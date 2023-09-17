# Algorithm practice

# Week 09/11 - 09/17/2023


# Category for this week:
**[Bit Manipulation](#bit-manipulation)**<br>
**[Math And Geometry](#math-and-geometry)**<br>
**[Greedy](#greedy)**<br>

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
    for i in range(r - l): # range (l, r - 1) | Num rotations are less than r
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

## [Leetcode #202 - Happy Number](https://leetcode.com/problems/happy-number/)

#### Level: Easy 📗

> Failed approach due to repeated nest loop

```python
def isHappy(self, n):
  """
  :type n: int
  :rtype: bool
  """
  if n // 10 == 0:
    return n == 1
  newNum = 0
  while n:
    newNum += (n % 10) ** 2 # get last number on right
    n = n // 10 # shift to the left
  return self.isHappy(newNum)
```

#### complexity?

> Another approach is to use hash set to store - LinkedList cycle

```python
def isHappy(self, n):
  """
  :type n: int
  :rtype: bool
  """
  # loops endlessly FROM the prompt - important piece
  loop = set()
  while n not in loop:
    loop.add(n)
    n = self.sumOfSquares(n)
    if n == 1:
      return True
  return False


def sumOfSquares(self, n):
  result = 0
  while n:
    result += (n % 10) ** 2
    n = n // 10 # shift left
  return result
```

#### O(n) time | O(n) space - n is the number of unique numbers

> Optimized

```python
def isHappy(self, n):
  """
  :type n: int
  :rtype: bool
  """
  # loops endlessly FROM the prompt - important piece
  slow, fast = n, self.sumOfSquares(n)
  while slow != fast:
    fast = self.sumOfSquares(fast)
    fast = self.sumOfSquares(fast)
    slow = self.sumOfSquares(slow)
  
  return True if fast == 1 else False

def sumOfSquares(self, n):
  result = 0
  while n:
    result += (n % 10) ** 2
    n = n // 10 # shift left
  return result 
```

#### O(1) space

## [Leetcode #66 - Plus One](https://leetcode.com/problems/plus-one/)

#### Level: Easy 📗

```python
def plusOne(self, digits):
  """
  :type digits: List[int]
  :rtype: List[int]
  """
  result = []
  addOne = 1
  for i in range(len(digits) - 1, -1, -1):
    num = addOne + digits[i]
    if num == 10:
      addOne = 1
      num = 0
    else:
      addOne = 0
    result.insert(0, num)
  if addOne:
    result.insert(0, addOne)
  return result
```

#### O(n) time | O(1) space

## [Leetcode #50 - Pow(x, n)](https://leetcode.com/problems/powx-n/)

#### Level: Medium 📘

> First attempt - failed with time limit exceeded

```python
def myPow(self, x, n):
  """
  :type x: float
  :type n: int
  :rtype: float
  """
  if x == 0:
    return 0
  if n == 0:
    return 1
  if n < 0:
    x = 1 / x
    n *= -1
  result = 1
  while n > 0:
    result *= x
    n -= 1
  return result
```

#### O(n) time | O(1) space

> Divide and Conquer

```python
def myPow(self, x, n):
  """
  :type x: float
  :type n: int
  :rtype: float
  """
  def divideAndConquer(x, n):
    if x == 0: return 0
    if n == 0: return 1
    res = divideAndConquer(x, n // 2)
    res = res * res

    # Ex: n = 5 | x * x^2 * x^2 = x^5
    return x * res if n % 2 else res
      
  result = divideAndConquer(x, abs(n))
  return result if n >= 0 else 1 / result
```

#### O(log n) time | O(log n) space

## [Leetcode #43 - Multiply Strings](https://leetcode.com/problems/multiply-strings/)

#### Level: Medium 📘

```python
def multiply(self, num1, num2):
  """
  :type num1: str
  :type num2: str
  :rtype: str

  Note: 
  - max length of multiplication is the sum of 2 num
  - make sure to know how to do multiplication, the carry
  - the shift to left when multiply next digit in 2nd num
  - use array, go backward
  - 81 % 10 = 1 | 81 / 10 = 8
  """
  if "0" in [num1, num2]:
    return "0"

  # max length of multiplication
  res = [0] * (len(num1) + len(num2))
  num1, num2 = num1[::-1], num2[::-1]

  for i1 in range(len(num1)):
    for i2 in range(len(num2)):
      digit = int(num1[i1]) * int(num2[i2])

      # these next 3 lines are extremely important

      # i1 + i2 is brilliant | add with the carry first
      res[i1 + i2] += digit
      # save carry directly into the next position
      res[i1 + i2 + 1] += res[i1 + i2] // 10
      # make sure no tenth in the current iteration
      res[i1 + i2] = res[i1 + i2] % 10

  res, start = res[::-1], 0
  while start < len(res) and res[start] == 0:
    start += 1
  
  res = map(str, res[start:])
  return "".join(res)
```

#### O(num1 * num2) time | O(num1 + num2) space

## [Leetcode #2013 - Detect Squares](https://leetcode.com/problems/detect-squares/)

#### Level: Medium 📘

```python
class DetectSquares(object):

  def __init__(self):
    # better than {} | if key is not there, value will just be 0
    self.pointCount = defaultdict(int)
    self.points = [] # not necessary need this - can just use keys from map    

  def add(self, point):
    """
    :type point: List[int]
    :rtype: None
    """
    # list can't be key in Python
    self.pointCount[tuple(point)] += 1
    self.points.append(point)
      
  def count(self, point):
    """
    :type point: List[int]
    :rtype: int
    """
    count = 0
    px, py = point
    for x, y in self.points:
      # not equal length, or SAME points
      if abs(x - px) != abs(y - py) or x == px or y == py:
        continue
      count += self.pointCount[(x, py)] * self.pointCount[(px, y)]
    return count
```

#### O(n) time | O(n) space

---

# Greedy

## [Leetcode #55 - Jump Game](https://leetcode.com/problems/jump-game/)

#### Level: Medium 📘

```python
def canJump(self, nums):
  """
  :type nums: List[int]
  :rtype: bool
  """
  goal = len(nums) - 1 # goal is index, last value doesn't really matter
  for i in range(len(nums) - 2, -1, -1):
    if i + nums[i] >= goal:
      goal = i
  return goal == 0
```

#### O(n) time | O(1) space

## [Leetcode #45 - Jump Game II](https://leetcode.com/problems/jump-game-ii/)

#### Level: Medium 📘

```python
def jump(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  jumps = 0
  l, r = 0, 0
  while r < len(nums) - 1: # this will exit once last num reached
    maxJump = 0
    for i in range(l, r + 1):
      maxJump = max(maxJump, i + nums[i])
    l = r + 1
    r = maxJump
    jumps += 1
  return jumps
```

#### O(n) time | O(1) space
