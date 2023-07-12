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

## [Leetcode #90 - Subsets II](https://leetcode.com/problems/subsets-ii/)

#### Level: Medium 📘

```python
def subsetsWithDup(self, nums):
  """
  :type nums: List[int]
  :rtype: List[List[int]]
  """
  result, subset = [], []
  nums.sort()

  def dfs(i):
    if i == len(nums): # done iterating
      result.append(subset[::]) # copy to get the global variable, other subset is just []
      return
    
    # decision to include nums[i] - left side
    subset.append(nums[i])
    dfs(i + 1)

    # decision NOT to include nums[i] - right side
    subset.pop()
    while i + 1 < len(nums) and nums[i] == nums[i + 1]:
      i += 1
    dfs(i + 1)

  dfs(0)
  return result
```

### O(n * 2^n) time | O(2^n) space
