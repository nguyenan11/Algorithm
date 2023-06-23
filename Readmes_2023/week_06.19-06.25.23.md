# Algorithm practice

# Week 06/19 - 06/25/2023


# Category for this week:
**[Binary Search](#binary-search)**<br>
**[Trees](#trees)**<br>

---

# Binary Search

## [Leetcode #33 - Search In Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

#### Level: Medium 📘

```python
def search(self, nums, target):
  """
  :type nums: List[int]
  :type target: int
  :rtype: int
  """
  if not nums or len(nums) == 0:
    return -1
  if len(nums) == 1:
    return 0 if target in nums else -1
  left, right = 0, len(nums) - 1
  while left <= right:
    mid = left + (right - left) / 2
    if nums[mid] == target:
      return mid

    # sorted left portion
    if nums[left] <= nums[mid]:
      if target > nums[mid] or target < nums[left]:
        left = mid + 1
      else:
        right = mid - 1
    # sorted right portion
    else:
      if target < nums[mid] or target > nums[right]:
        right = mid - 1
      else:
        left = mid + 1
  return -1
```

### O(log n) time | O(1) space

## [Leetcode #981 - Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/)

#### Level: Medium 📘

> Important details: All the timestamps of set are strictly increasing.

```python
class TimeMap(object):

  def __init__(self):
    self.keyValues = {} 
    # map where key is key and value is list of [value, timestamp]
      

  def set(self, key, value, timestamp):
    """
    :type key: str
    :type value: str
    :type timestamp: int
    :rtype: None
    """
    if key not in self.keyValues:
      self.keyValues[key] = []
    self.keyValues[key].append([value, timestamp])

  def get(self, key, timestamp):
    """
    :type key: str
    :type timestamp: int
    :rtype: str
    """
    result, values = "", self.keyValues.get(key, [])
    left, right = 0, len(values) - 1
    while left <= right:
      mid = left + (right - left) / 2
      if values[mid][1] <= timestamp: # [1] is timestamp
        result = values[mid][0] # [0] is value
        left = mid + 1
      else:
        right = mid - 1
    return result
```

## [Leetcode #4 - Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)

#### Level: Hard 📕

> Brute force

```python
def findMedianSortedArrays(self, nums1, nums2):
  """
  :type nums1: List[int]
  :type nums2: List[int]
  :rtype: float
  """
  nums = nums1 + nums2
  nums = sorted(nums)
  mid = len(nums) / 2
  if len(nums) % 2 == 0:
    return (nums[mid] + nums[mid -1]) / 2.0
  return nums[mid]
```

### O(log(n + m)) time | O(n + m) space

---

# Trees

## [Leetcode #226 - Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)

#### Level: Easy 📗

> DFS recursive

```python
def invertTree(self, root):
  """
  :type root: TreeNode
  :rtype: TreeNode
  """
  if not root:
    return
  root.left, root.right = root.right, root.left
  root.left = self.invertTree(root.left)
  root.right = self.invertTree(root.right)
  return root
```

### O(n) time | O(1) space

## [Leetcode #104 - Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

#### Level: Easy 📗

> DFS recursive

```python
def maxDepth(self, root):
  """
  :type root: TreeNode
  :rtype: int
  """
  if not root:
    return 0
  return self.dfs(root)

def dfs(self, root):
  count, left, right = 1, 0, 0
  if root.left:
    left = self.dfs(root.left)
  if root.right:
    right = self.dfs(root.right)
  count += max(left, right)
  return count
```

### O(n) time | O(1) space

> DFS iterative - go through all the nodes at each level before going down

```python
def maxDepth(self, root):
  stack = [[root, 1]]
  result = 0
  while stack:
    node, depth = stack.pop() # depth is level
    if node:
      result = max(result, depth)
      stack.append([node.left, depth + 1])
      stack.append([node.right, depth + 1])
  return result
```

### O(n) time | O(n) space

> BFS iterative

```python
def maxDepth(self, root):
  if not root:
    return 0
      
  depth = 0
  q = deque([root])
  while q:
    for i in range(len(q)): # this is important for queue to work
      node = q.popleft() # using stack won't work because pop on right
      if node.left:
        q.append(node.left)
      if node.right:
        q.append(node.right)
    depth += 1
  return depth
```

### O(n) time | O(n) space
