# Algorithm practice

# Week 09/18 - 09/24/2023


# Category for this week:
**[2D Dynamic Programming](#2d-dynamic-programming)**<br>

---

# 2D Dynamic Programming

## [Leetcode #1143 - Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)

#### Level: Medium 📘

![LC1143](../2023_images/LC1143)

If go diagonally: +1
 
> Bottom up solution

```python
 def longestCommonSubsequence(self, text1, text2):
  """
  :type text1: str
  :type text2: str
  :rtype: int

  if go diagnosely: +1
  """
  dp = [[0 for col in range(len(text2) + 1)] for row in range(len(text1) + 1)]

  # 2 conditions while iterating
  for r in range(len(text1) - 1, -1, -1):
    for c in range(len(text2) - 1, -1, -1):
      if text1[r] == text2[c]:
        dp[r][c] = 1 + dp[r + 1][c + 1]
      else:
        # value to the right and bot
        dp[r][c] = max(dp[r][c + 1], dp[r + 1][c])

  return dp[0][0]
```

#### O(text1 * text2) time | O(text1 * text2) space
