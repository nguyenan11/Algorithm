# Algorithm practice

# Week 05/15 - 05/21/2023


# Category for this week:
**[Two Pointers](#two~pointers)**<br>

---

# Two Pointers

## [Leetcode #125 - Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

#### Level: Easy 📗

```python
def isPalindrome(self, s):
  """
  :type s: str
  :rtype: bool
  """
  leftPtr = 0
  rightPtr = len(s) - 1
  if leftPtr >= rightPtr:
    return True

  while leftPtr < rightPtr:
    leftChar = s[leftPtr].lower()
    rightChar = s[rightPtr].lower() 
    if not leftChar.isalnum():
      leftPtr += 1
    elif not rightChar.isalnum():
      rightPtr -= 1
    else:
      if leftChar != rightChar:
        return False
      leftPtr += 1
      rightPtr -= 1
  return True
```

### O(n) time | O(1) space

## [Leetcode #167 - Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

#### Level: Medium 📘

```python
def twoSum(self, numbers, target):
  """
  :type numbers: List[int]
  :type target: int
  :rtype: List[int]
  """
  leftPtr, rightPtr = 0, len(numbers) - 1
  while leftPtr < rightPtr:
    val = numbers[leftPtr], numbers[rightPtr]
    if val > target:
      rightPtr -= 1
    elif val < target:
      leftPtr += 1
    else:
      return [leftPtr + 1, rightPtr + 1]
```

### O(n) time | O(1) space


## [Leetcode #15 - 3Sum](https://leetcode.com/problems/3sum/)

#### Level: Medium 📘

```python
def threeSum(self, nums):
  """
  :type nums: List[int]
  :rtype: List[List[int]]
  """
  TARGET = 0

  result = []
  nums.sort()

  for i, num in enumerate(nums):
    # only count the FIRST appearance of repeated number
    # the rest repetition will be ignored
    if i > 0 and num == nums[i - 1]:
      continue

    leftPtr, rightPtr = i + 1, len(nums) - 1
    while leftPtr < rightPtr:
      threeSum = num + nums[leftPtr] + nums[rightPtr]
      if threeSum > TARGET:
        rightPtr -= 1
      elif threeSum < TARGET:
        leftPtr += 1
      else:
        result.append([num, nums[leftPtr], nums[rightPtr]])
        leftPtr += 1
        while nums[leftPtr] == nums[leftPtr - 1] and leftPtr < rightPtr:
          leftPtr += 1
              
  return result
```

### O(n^2) time - from O(nlogn) + O(n^2) | O(1) space - in some libraries, sorting might store additional memory, which could result in O(n) space due to sort()

## [Leetcode #11 - Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

#### Level: Medium 📘

```python
def maxArea(self, height):
  """
  :type height: List[int]
  :rtype: int
  """
  maxArea = 0
  leftWall, rightWall = 0, len(height) - 1
  while leftWall != rightWall:
    currArea = min(height[leftWall], height[rightWall]) * (rightWall - leftWall)
    maxArea = max(maxArea, currArea)
    if height[leftWall] < height[rightWall]:
      leftWall += 1
    else:
      rightWall -= 1
  return maxArea
```

### O(n) time | O(1) space - n is number of elements in the list (height)

## [Leetcode #42 - Trapping Rain Water](https://leetcode.com/problems/container-with-most-water/)

#### Level: Hard 📕

> O(n) memory allocation
> IMPORTANT: The formula is min(L, R) - height[i] to get trapped water at i

![LC42](../2023_images/LC42.png)

```python
def trap(self, height):
  """
  :type height: List[int]
  :rtype: int
  """
  size = len(height)

  leftMax = [0 for i in range(size)]
  rightMax = [0 for i in range(size)]
  runningLeftMax, runningRightMax = 0, 0

  for i, num in enumerate(height):
    leftMax[i] = runningLeftMax
    runningLeftMax = max(runningLeftMax, num)

  for i in range(size - 1, -1, -1):
    rightMax[i] = runningRightMax
    runningRightMax = max(runningRightMax, height[i])

  result = 0
  for i, num in enumerate(height):
    trappedWater = min(leftMax[i], rightMax[i]) - num
    if trappedWater > 0:
      result += trappedWater

  return result
```

### O(n) time | O(n) space

```python
def trap(self, height):
  """
  :type height: List[int]
  :rtype: int
  """
  if not height:
    return 0

  l, r = 0, len(height) - 1
  leftMax, rightMax = height[l], height[r]
  res = 0
  while l < r:
    if leftMax < rightMax:
      l += 1
      leftMax = max(leftMax, height[l])
      res += leftMax - height[l]
    else:
      r -= 1
      rightMax = max(rightMax, height[r])
      res += rightMax - height[r]
  return res
```

### O(n) time | O(1) space

## [Leetcode #20 - Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

#### Level: Easy 📗

```python
def isValid(self, s):
  """
  :type s: str
  :rtype: bool
  """
  OPEN_BRACKETS = ['(', '{', '[']
  CLOSE_BRACKETS = [')', '}', ']']
  stack = []

  for bracket in s:
    if bracket in OPEN_BRACKETS:
      stack.append(bracket)
    else:
      if not stack:
        return False

      topOfStack = stack.pop()
      index = OPEN_BRACKETS.index(topOfStack)
      if CLOSE_BRACKETS[index] != bracket:
        return False
  
  return len(stack) == 0
```

### O(n) time | O(n) space

## [Leetcode #155 - Min Stack](https://leetcode.com/problems/min-stack/)

#### Level: Medium 📘

> The idea for O(1) time is that to actually have 2 stacks - 1 for all regular stack (FILO) operations and 1 for keeping track of current minimum value

```python
class MinStack(object):
  def __init__(self):
    self.stack = []
    self.minStack = []

  def push(self, val):
    """
    :type val: int
    :rtype: None
    """
    self.stack.append(val)
    val = min(val, self.minStack[-1] if self.minStack else val)
    self.minStack.append(val)
      

  def pop(self):
    """
    :rtype: None
    """
    self.stack.pop()
    self.minStack.pop()
      

  def top(self):
    """
    :rtype: int
    """
    return self.stack[-1]

  def getMin(self):
    """
    :rtype: int
    """
    return self.minStack[-1]
```

### O(1) time as required

## [Leetcode #150 - Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

#### Level: Medium 📘

> This below implementation won't work due to negative int check, but logic should be that way

```python
def evalRPN(self, tokens):
  """
  :type tokens: List[str]
  :rtype: int
  """
  stack = []
  for token in tokens:
    # this won't work because of this lstrip function here
    if token.lstrip('-').isnumeric():
      stack.append(int(token))
    else:
      topOfStack = stack.pop()
      secondTopOfStack = stack.pop()
      num = self.doOperation(token, secondTopOfStack, topOfStack)
      stack.append(num)
  return stack.pop()

def doOperation(self, operator, num1, num2):
  if operator == "+":
    return num1 + num2
  elif operator == '-':
    return num1 - num2
  elif operator == '*':
    return num1 * num2
  else:
    return int(num1 / num2)
```

> This version will work - ONLY in Python3, not Python -> Above should work in Python3 as well

```python
def evalRPN(self, tokens):
  """
  :type tokens: List[str]
  :rtype: int
  """
  stack = []
  for c in tokens:
    if c == "+":
      stack.append(stack.pop() + stack.pop())
    elif c == "-":
      a, b = stack.pop(), stack.pop()
      stack.append(b - a)
    elif c == "*":
      stack.append(stack.pop() * stack.pop())
    elif c == "/":
      a, b = stack.pop(), stack.pop()
      stack.append(int(b / a))
    else:
      stack.append(int(c))
  return stack[0]
```

### O(n) time | O(n) space 
