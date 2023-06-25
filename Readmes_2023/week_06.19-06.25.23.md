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

## [Leetcode #543 - Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)

#### Level: Easy 📗

```python
def diameterOfBinaryTree(self, root):
  """
  :type root: TreeNode
  :rtype: int
  """
  self.diameter = 0

  def dfs(root):

    if not root:
      return 0
    left = dfs(root.left)
    right = dfs(root.right)
    self.diameter = max(self.diameter, left + right)

    return 1 + max(left, right)

  dfs(root)
  return self.diameter
```

### O(n) time | O(1) space

## [Leetcode #110 - Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

#### Level: Easy 📗

```python
def isBalanced(self, root):
  """
  :type root: TreeNode
  :rtype: bool
  """
  return self.dfs(root) != -1

# recursive 
def dfs(self, root):
  if not root:
    return 0
  left = self.dfs(root.left)
  right = self.dfs(root.right)
  # -1 imposes imbalance |  abs(left - right) to calculate imbalance
  if left == -1 or right == -1 or abs(left - right) > 1:
    return -1
  return 1 + max(left, right)
```

### O(n) time | O(1) space

## [Leetcode #100 - Same Tree](https://leetcode.com/problems/same-tree/)

#### Level: Easy 📗

```python
def isSameTree(self, p, q):
  """
  :type p: TreeNode
  :type q: TreeNode
  :rtype: bool
  """
  if not p and not q:
    return True
  if p and q and p.val == q.val:
    return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
  return False
```

### O(p + q) time | O(1) space

## [Leetcode #572 - Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)

#### Level: Easy 📗

```python
def isSubtree(self, root, subRoot):
  """
  :type root: TreeNode
  :type subRoot: TreeNode
  :rtype: bool
  """
  if not subRoot:
    return True
  if not root:
    return False
  if self.sameTree(root, subRoot):
    return True
  return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)        


def sameTree(self, root, subRoot):
  if not root and not subRoot:
    return True
  if root and subRoot and root.val == subRoot.val:
    return self.sameTree(root.left, subRoot.left) and self.sameTree(root.right, subRoot.right)
  return False
```

### O(root + subRoot) time | O(1) space

### [Leetcode #235 - Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

#### Level: Easy 📗

> Important assumption:
> * All values are unique
> * Follow the character of Binary Search Tree, left < right

```python
def lowestCommonAncestor(self, root, p, q):
  """
  :type root: TreeNode
  :type p: TreeNode
  :type q: TreeNode
  :rtype: TreeNode
  """
  while root:
    if max(p.val, q.val) < root.val:
      root = root.left
    elif min(p.val, q.val) > root.val:
      root = root.right
    else:
      return root
  return None # edge case when root is None
```

### O(log root) time | O(1) space

## [Leetcode #102 - Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

#### Level: Medium 📘

```python
def levelOrder(self, root):
  """
  :type root: TreeNode
  :rtype: List[List[int]]
  """
  result = []

  if not root:
    return result
  
  q = deque([root])
  while q:
    sameLevelNodes = []
    for i in range(len(q)):
      node = q.popleft()
      sameLevelNodes.append(node.val)
      if node.left:
        q.append(node.left)
      if node.right:
        q.append(node.right)
    result.append(sameLevelNodes)
  return result
```

### O(n) time | O(n) space

## [Leetcode #199 - Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

#### Level: Medium 📘

```python
def rightSideView(self, root):
  """
  :type root: TreeNode
  :rtype: List[int]
  """
  rightView = []
  if not root:
    return rightView
  
  q = deque([root])
  while q:
    tempLength = len(q) - 1
    for i in range(len(q)):
      node = q.popleft()
      if i == tempLength:
        rightView.append(node.val)
      if node.left:
        q.append(node.left)
      if node.right:
        q.append(node.right)

  return rightView
```

### O(n) time | O(n) space

## [Leetcode #1448 - Count Good Nodes in Binary Tree](https://leetcode.com/problems/count-good-nodes-in-binary-tree/)

#### Level: Medium 📘

```python
def goodNodes(self, root):
  """
  :type root: TreeNode
  :rtype: int
  """
  return self.dfs(root, root.val)

def dfs(self, node, maxValue):
  if not node:
    return 0
  result = 1 if node.val >= maxValue else 0
  maxValue = max(node.val, maxValue)
  result += self.dfs(node.left, maxValue)
  result += self.dfs(node.right, maxValue)
  return result
```

### O(n) time | O(1) space
