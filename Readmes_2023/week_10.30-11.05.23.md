# Algorithm practice

# Week 10/30 - 11/05/2023

# Category for this week:
**[Array And Hashing](#array-and-hashing)**<br>

---

# Array And Hashing

## [Leetcode #14 - Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)

#### Level: Easy 📗

```python
def longestCommonPrefix(self, strs):
  """
  :type strs: List[str]
  :rtype: str
  """
  comPrefix = ""
  for i in range(len(strs[0])):
    for s in strs:
      if i == len(s) or s[i] != strs[0][i]:
        return comPrefix
    comPrefix += strs[0][i]
  return comPrefix
```

#### O(n^s) time | O(n) space - n is length of 1 string, s is total number of strings

## [Leetcode #118 - Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)

#### Level: Easy 📗

```python
def generate(self, numRows):
  """
  :type numRows: int
  :rtype: List[List[int]]
  """
  result = [[1]]
  for i in range(numRows - 1): # 1st row already there
    # 0 @ start and end, using 2 pointers. 1s will always be outside
    temp = [0] + result[-1] + [0] 
    newRow =  []
    for j in range(len(result[-1]) + 1):
      newRow.append(temp[j] + temp[j + 1])
    result.append(newRow)
  return result
```

#### O(numRows!) time | O(numRows!) space

## [Leetcode #27 - Remove Element](https://leetcode.com/problems/remove-element/)

#### Level: Easy 📗

```python
def removeElement(self, nums, val):
  """
  :type nums: List[int]
  :type val: int
  :rtype: int
  """
  # Follow merge sort logic when partition
  k = 0
  for i in range(len(nums)):
    if nums[i] != val:
      nums[k] = nums[i]
      k += 1
  return k
```

#### O(n) time | O(1) space

## [Leetcode #929 - Unique Email Addresses](https://leetcode.com/problems/unique-email-addresses/)

#### Level: Easy 📗

```python
def numUniqueEmails(self, emails):
  """
  :type emails: List[str]
  :rtype: int
  """
  receiveMails = set()
  for mail in emails:
    local, domain = mail.split("@")
    validLocal = local.split("+")[0]
    receiveLocal = "".join(validLocal.split("."))
    receiveMail = receiveLocal + "@" + domain
    receiveMails.add(receiveMail)
  return len(receiveMails)
```

#### O(emails) time | O(unique emails) space

## [Leetcode #205 - Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)

#### Level: Easy 📗

```python
def isIsomorphic(self, s, t):
  """
  :type s: str
  :type t: str
  :rtype: bool
  """
  if len(s) != len(t):
      return False
  sToT, tToS = {}, {}
  for i in range(len(s)):
      if (
          s[i] in sToT and sToT[s[i]] != t[i] or
          t[i] in tToS and tToS[t[i]] != s[i]
      ):
          return False
      sToT[s[i]] = t[i]
      tToS[t[i]] = s[i]
  return True
```

#### O(n) time | O(2n) ~ O(n) space

## [Leetcode #605 - Can Place Flowers](https://leetcode.com/problems/can-place-flowers/)

#### Level: Easy 📗

> Failed attempt

```python
def canPlaceFlowers(self, flowerbed, n):
  prevNonEmpty = -1
  for idx, plot in enumerate(flowerbed):
    if plot == 1:
      gap = idx - prevNonEmpty - 1
      if gap >= 3:
        n -= gap // 2
      prevNonEmpty = idx
  
  if prevNonEmpty == -1:
    length = len(flowerbed)
    if length % 2 == 0:
      return len(flowerbed) // 2 >= n
    return len(flowerbed) // 2 + 1 >= n
  return n <= 0
```

> Success

```python
def canPlaceFlowers(self, flowerbed, n):
  """
  :type flowerbed: List[int]
  :type n: int
  :rtype: bool
  """
  fb = [0] + flowerbed + [0] # avoid out of bound error when parsing
  for i in range(1, len(fb) - 1):
    if fb[i - 1] == 0 and fb[i] == 0 and fb[i + 1] == 0:
      fb[i] = 1
      n -= 1
  return n <= 0
```

#### O(n) time | O(n) space
