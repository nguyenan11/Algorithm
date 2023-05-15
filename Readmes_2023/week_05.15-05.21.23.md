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
