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
