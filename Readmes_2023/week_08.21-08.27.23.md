# Algorithm practice

# Week 08/21 - 08/27/2023

# Category for this week:
**[Microsoft focused questions](#microsoft)**<br>

---


# Microsoft

### Follow this list: https://github.com/hxu296/leetcode-company-wise-problems-2022#microsoft

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

## [Leetcode #151 - Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

#### Level: Medium 📘

> Attempt - FAILED

```python
def reverseWords(self, s):
  """
  :type s: str
  :rtype: str
  """
  s = s.strip()
  reverseList = []
  startIdx = 0
  for i in range(len(s)):
    if (
      s[i] == " " and s[startIdx] != " " or
      s[i] != " " and s[startIdx] == " "
    ):
      word = s[startIdx:i]
      reverseList.insert(0, word)
      startIdx = i
  word = s[startIdx:i + 1]
  reverseList.insert(0, word)
  return "".join(reverseList)
```

> Success

```python
def reverseWords(self, s):
  """
  :type s: str
  :rtype: str
  """
  s = s.strip()
  reverseList = []
  startIdx, endIdx = 0, 0
  while endIdx < len(s):
    if s[endIdx] == " ":
      word = s[startIdx:endIdx]
      reverseList.insert(0, word)
      startIdx = endIdx
      reverseList.insert(0, " ")
      while s[endIdx] == " ":
        endIdx += 1
        startIdx += 1
      endIdx += 1
  word = s[startIdx:endIdx + 1]
  reverseList.insert(0, word)
  return "".join(reverseList)
```

### Complexity: Time: would be O(n) WITHOUT the consideration of string concatenation, and strip(), and calling string[start:end] | Need to be careful with space: modified s, using list

## [Leetcode #54 - Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)

#### Level: Medium 📘

```python
def spiralOrder(self, matrix):
  """
  :type matrix: List[List[int]]
  :rtype: List[int]
  """
  result = []
  top, bot = 0, len(matrix)
  left, right = 0, len(matrix[0])
  # right and bot boundaries are actually outside of matrix/ not equal len - 1

  # while iterating thru the loop, important to include -1 sometimes to avoid duplication (already visited node)
  while top < bot and left < right:
    # all num in top row
    # range in Python right input is non-inclusive | go from left to right - 1
    for i in range(left, right):
      result.append(matrix[top][i])
    top += 1
    # all num on outer right col
    for i in range(top, bot):
      result.append(matrix[i][right - 1])
    right -= 1
    # crossed pointers | single row, or single column matrix
    if not (top < bot and left < right):
      break
    # all num on bottom row
    for i in range(right - 1, left - 1, -1):
      result.append(matrix[bot -1][i])
    bot -= 1
    # all num on outer left col
    for i in range(bot - 1, top - 1, -1):
      result.append(matrix[i][left])
    left += 1

  return result
```

### O(row * col) time | O(1) runtime space | O(row * col) result space

## [Leetcode #1304 - Find N Unique Integers Sum up to Zero](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/)

#### Level: Easy 📗

```python
def sumZero(self, n):
  """
  :type n: int
  :rtype: List[int]
  """
  result = []
  if n % 2 != 0:
    result.append(0)
    n -= 1
  uniqueInt = 1
  while n > 0:
    result.append(uniqueInt)
    result.append(-1 * uniqueInt)
    uniqueInt += 1
    n -= 2
  return result
```

#### O(n / 2) time ~~ O(n) time | O(n) space

## [Leetcode #17 - Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

#### Level: Medium 📘

```python
def letterCombinations(self, digits):
  """
  :type digits: str
  :rtype: List[str]
  """
  res = []
  digitToChar = {
    "2": "abc",
    "3": "def",
    "4": "ghi",
    "5": "jkl",
    "6": "mno",
    "7": "qprs",
    "8": "tuv",
    "9": "wxyz",
  }

  def backtracking(i, currStr):
    if len(currStr) == len(digits):
      res.append(currStr)
      return
    for char in digitToChar[digits[i]]:
      backtracking(i + 1, currStr + char)

  if digits: # in case digits is null
    backtracking(0, "")
  
  return res
```

#### O(n * 4^n) time | O(4^n) space worst / O(3^n) space average

## [Leetcode #297 - Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

#### Level: Hard 📕

```python
def serialize(self, root):
  """Encodes a tree to a single string.
  
  :type root: TreeNode
  :rtype: str
  """
  tempList = [] # check function below for global characteristics

  def dfs(node):
    if not node:
      tempList.append("N")
      return
    tempList.append(str(node.val))
    dfs(node.left)
    dfs(node.right)

  dfs(root)
  return ".".join(tempList)
  

def deserialize(self, data):
  """Decodes your encoded data to tree.
  
  :type data: str
  :rtype: TreeNode
  """
  valsList = data.split(".")
  self.level = 0 # MAKE SURE to include self. - int var different from list [], look at above function, don't need self.

  def dfs():
    if valsList[self.level] == "N":
      self.level += 1
      return None
    node = TreeNode(int(valsList[self.level]))
    self.level += 1
    node.left = dfs()
    node.right = dfs()
    return node

  return dfs()
```

#### O(n) time | ~ O(2n) ~~ O(n) space

## [Leetcode #5 - Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

#### Level: Medium 📘

```python
def longestPalindrome(self, s):
  """
  :type s: str
  :rtype: str
  """
  longest = [0, 1]
  for i in range(1, len(s)):
    odd = self.findLongestPalindrome(s, i - 1, i + 1)
    even = self.findLongestPalindrome(s, i - 1, i)
    currLongest = odd if odd[1] - odd[0] > even[1] - even[0] else even
    longest = longest if longest[1] - longest[0] > currLongest[1] - currLongest[0] else currLongest
  
  return s[longest[0]:longest[1]]

def findLongestPalindrome(self, s, left, right):
  while left >= 0 and right < len(s):
    if s[left] != s[right]:
      break
    left -= 1
    right += 1
  return [left + 1, right] # +1 is important so you can exclude the unmatched | right] already excludes right
```

#### O(n^2) time - but be considerable of string slice operation at the end (which is believed to cost linear time) | O(1) space

## [Leetcode #2 - Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

#### Level: Medium 📘

```python
def addTwoNumbers(self, l1, l2):
  """
  :type l1: ListNode
  :type l2: ListNode
  :rtype: ListNode
  """
  dummy = currNode = ListNode()
  needAddOne = 0
  while l1 or l2 or needAddOne:
    val1 = val2 = 0
    if l1:
      val1 = l1.val
      l1 = l1.next
    if l2:
      val2 = l2.val
      l2 = l2.next
    currSum = val1 + val2 + needAddOne
    val = currSum % 10
    needAddOne = currSum // 10
    currNode.next = ListNode(val)
    currNode = currNode.next
  
  return dummy.next
```

### O(max(m, n)) time | O(max(m, n)) space - where m is length of linked list 1 and n is length of linked list 2
