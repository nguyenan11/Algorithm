# Algorithm practice

# Week 07/10 - 07/16/2023


# Category for this week:
**[Backtracking](#backtracking)**<br>

---

# Backtracking

## [Leetcode #40 - Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)

#### Level: Medium 📘

```python
def combinationSum2(self, candidates, target):
  """
  :type candidates: List[int]
  :type target: int
  :rtype: List[List[int]]
  """
  result = []
  candidates.sort()

  def dfs(idx, path, currTotal):
    if currTotal > target: return
    if currTotal == target:
      result.append(path)
      return
    for i in range(idx, len(candidates)):
      if i > idx and candidates[i] == candidates[i - 1]: # key to understand algo here
        continue
      dfs(i + 1, path + [candidates[i]], currTotal + candidates[i])
  
  dfs(0, [], 0)
  return result
```

### ?????