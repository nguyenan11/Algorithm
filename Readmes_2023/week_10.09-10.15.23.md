# Algorithm practice

# Week 10/09 - 10/15/2023

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
