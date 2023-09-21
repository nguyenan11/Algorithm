# Algorithm practice

# Week 09/18 - 09/24/2023

# Category for this week:
**[2D Dynamic Programming](#2d-dynamic-programming)**<br>

---

# 2D Dynamic Programming

## [Leetcode #1143 - Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)

#### Level: Medium 📘

![LC1143](../2023_images/LC1143.png)

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

## [Leetcode #309 - Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

#### Level: Medium 📘

![LC309](../2023_images/LC309.png)

```python
def maxProfit(self, prices):
  """
  :type prices: List[int]
  :rtype: int

  instead of doing the whole recursion tree, use Caching/ dp
  """
  # State: Buying or Selling?
  # If Buy -> i + 1
  # If Sell -> i + 2

  dp = {}  # key=(i, canBuy) val=maxProfit

  def dfs(i, canBuy):
    if i >= len(prices):
      return 0
    if (i, canBuy) in dp:
      return dp[(i, canBuy)] # already at max value

    if canBuy:
      buy = dfs(i + 1, not canBuy) - prices[i]
      cooldown = dfs(i + 1, canBuy)
      dp[(i, canBuy)] = max(buy, cooldown) # caching
    else:
      sell = dfs(i + 2, not canBuy) + prices[i]
      cooldown = dfs(i + 1, canBuy)
      dp[(i, canBuy)] = max(sell, cooldown) # caching
    return dp[(i, canBuy)]

  return dfs(0, True)
```

#### O(2n) ~ O(n) time | O(2n) ~ O(n) space

## [Leetcode #518 - Coin Change II](https://leetcode.com/problems/coin-change-ii/)

#### Level: Medium 📘

```python
def change(self, amount, coins):
  """
  :type amount: int
  :type coins: List[int]
  :rtype: int
  """
  cache = {}

  def dfs(i, a):
    if a == amount:
      return 1
    if a > amount or i == len(coins):
      return 0
    if (i, a) in cache:
      return cache[(i, a)]
    
    cache[(i, a)] = dfs(i, a + coins[i]) + dfs(i + 1, a)
    return cache[(i, a)]
  
  return dfs(0, 0)
```

#### O(n * amount) time | O(n * amount) space