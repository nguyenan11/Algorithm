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
