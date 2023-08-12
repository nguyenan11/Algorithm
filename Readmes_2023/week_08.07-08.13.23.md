# Algorithm practice

# Week 08/07 - 08/13/2023

# Category for this week:
**[TikTok focused questions](#tiktok)**<br>

---

# TikTok

### Follow this list: https://github.com/hxu296/leetcode-company-wise-problems-2022#bytedance

## 23 https://leetcode.com/problems/merge-k-sorted-lists/description/

```python
def mergeKLists(self, lists):
  """
  :type lists: List[ListNode]
  :rtype: ListNode
  """
  # lists can be null
  # list can contain null list [[]], [non-null, []]
  # happy case [nn1, nn2]
  # are we allowed to modify the lists
  if lists == None or len(lists) == 0:
      return None
  if len(lists) == 1:
      return lists[0]
  while len(lists) > 1:
      mergedList = []
      for i in range(0, len(lists), 2):
          list1 = lists[i]
          list2 = lists[i + 1] if (i + 1) < len(lists) else None
          mergedList.append(self.merge2Lists(list1, list2))
      lists = mergedList
  return lists[0]


def merge2Lists(self, list1, list2):
  head = currNode = ListNode()
  while list1 and list2:
      if list1.val < list2.val:
          currNode.next = list1
          list1 = list1.next
      else:
          currNode.next = list2
          list2 = list2.next
      currNode = currNode.next
  currNode.next = list1 or list2
  return head.next
```

## 200 https://leetcode.com/problems/number-of-islands/description/

```python
def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        islandNum = 0
        visited = [[False for col in row] for row in grid]
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if visited[row][col]:
                    continue
                hasLand = self.traverseNode(row, col, grid, visited)
                if hasLand:
                    islandNum += 1
        return islandNum

    
    def traverseNode(self, row, col, grid, visited):
        hasLand = False
        nodeToExplore = [[row, col]] # stack
        while nodeToExplore:
            node = nodeToExplore.pop()
            tempRow = node[0]
            tempCol = node[1]
            if visited[tempRow][tempCol]:
                continue
            visited[tempRow][tempCol] = True
            if grid[tempRow][tempCol] == "0":
                continue
            hasLand = True
            neighborNodes = self.findAllPossibleNeighbor(tempRow, tempCol, visited, grid)
            for neighbor in neighborNodes:
                nodeToExplore.append(neighbor)
        return hasLand

    
    def findAllPossibleNeighbor(self, row, col, visited, grid):
        neighborNodes = []
        if row > 0 and not visited[row - 1][col]:
            neighborNodes.append([row - 1, col])
        if row + 1 < len(grid) and not visited[row + 1][col]:
            neighborNodes.append([row + 1, col])
        if col > 0 and not visited[row][col -1]:
            neighborNodes.append([row, col -1])
        if col + 1 < len(grid[0]) and not visited[row][col + 1]:
            neighborNodes.append([row, col + 1])
        return neighborNodes
```

## 33 https://leetcode.com/problems/search-in-rotated-sorted-array/description/

> Make sure to include = sign

```python
def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # [1, 2, 3, 4, 5, 6, 7]
        # target = 1 and later 6
        # [5, 6, 7, 1, 2, 3, 4]
        # target = 6 and later 3
        if not nums or len(nums) == 0:
            return -1
        if len(nums) == 1:
            return 0 if target in nums else -1

        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) / 2

            if nums[mid] == target:
                return mid

            # sorted left
            if nums[left] <= nums[mid]:
                if nums[left] <= target and target <= nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            
            # sorted right
            else:
                if nums[mid] <= target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1
```

## 124 https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

```python
def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.maxSum = root.val

        def dfs(node):
            if not node:
                return 0

            leftMax, rightMax = dfs(node.left), dfs(node.right)
            leftMax, rightMax = max(leftMax, 0), max(rightMax, 0)

            # check for max at each split
            self.maxSum = max(self.maxSum, node.val + leftMax + rightMax)
            return node.val + max(leftMax, rightMax)
        
        dfs(root)
        return self.maxSum
```

## 146 https://leetcode.com/problems/lru-cache/

Approach

```python
class Node():
    def __init__(self, key, value):
        self.key, self.value = key, value
        self.prev = self.next = None


class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.cap = capacity
        self.cache = {} # IMPORTANT: key as key, value as Node(k, v)

        self.left, self.right = Node(0, 0), Node(0, 0)
        self.left.next, self.right.prev = self.right, self.left


        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.cache:
            # insert
            # remove
            return self.cache[key].value
        return -1
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.cache:
            # remove
            # insert

        # then remove if exceeded capacity
        if len(self.cache) > self.cap:
            lru = self.left.next
            # remove lru
            del self.cache[lru.key]
```

Solution

```python
class Node():
    def __init__(self, key, value):
        self.key, self.value = key, value
        self.prev = self.next = None


class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.cap = capacity
        self.cache = {} # IMPORTANT: key as key, value as Node(k, v)

        self.left, self.right = Node(0, 0), Node(0, 0) # left and right are unchangable
        self.left.next, self.right.prev = self.right, self.left

    # remove from left - LRU
    def remove(self, node):
        prev, nxt = node.prev, node.next
        prev.next, nxt.prev = nxt, prev

    # insert to right - MRU
    def insert(self, node):
        prev, nxt = self.right.prev, self.right # getting outmost right
        prev.next = nxt.prev = node # link Right to node
        node.prev, node.next = prev, nxt # link node to Right

        
    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.cache:
            self.remove(self.cache[key])
            self.insert(self.cache[key])
            return self.cache[key].value
        return -1
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.cache:
            self.remove(self.cache[key])
        node = Node(key, value)
        self.cache[key] = node
        self.insert(node)

        # then remove if exceeded capacity
        if len(self.cache) > self.cap:
            lru = self.left.next
            self.remove(lru)
            del self.cache[lru.key]
```

## 227 https://leetcode.com/problems/basic-calculator-ii/description/

```python
 def calculate(self, s):
  """
  :type s: str
  :rtype: int
  """
  if not s or len(s) == 0:
      return 0

  stack = []
  num = 0
  sign = '+'
  for i in range(len(s)):
      if s[i].isnumeric():
          # important keeping track of number here
          num = num * 10 + int(s[i])
      if not s[i].isnumeric() and ' ' != s[i] or i == len(s) - 1:
          # i == len(s) - 1 to check when string is ended
          if sign == '+':
              stack.append(num)
          elif sign == '-':
              stack.append(-num)
          elif sign == '/':
              tempNum = stack.pop()
              if tempNum < 0:
                  tempNum = -1 * tempNum / num
                  stack.append(-1 * tempNum)
              else:   
                  stack.append(tempNum / num)
          else:
              stack.append(stack.pop() * num)
          sign = s[i]
          num = 0
  result = 0
  while stack:
      result += stack.pop()
  return result
```

## 239 https://leetcode.com/problems/sliding-window-maximum/description/

Attempt - failed due to time running out

```python
def maxSlidingWindow(self, nums, k):
  """
  :type nums: List[int]
  :type k: int
  :rtype: List[int]
  """
  result = []
  left = 0
  while left + k <= len(nums):
      right = left + k
      maxNum = max(nums[left:right])
      result.append(maxNum)
      left += 1
  return result
```

Solution
Monotonically Decreasing Queue

```python
def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        # storing max value on the left
        # <-> keep popping if value on outter less than current value
        # <-> less value than max will be appended to right

        result = []
        q = deque() # storing indexes / IMPORTANT
        left = right = 0
        while right < len(nums):
            # check outter right
            while q and nums[q[-1]] < nums[right]:
                q.pop()
            q.append(right)

            # if left is out of bound - remove left value from window
            if left > q[0]:
                q.popleft()
            
            # make sure window is at least size k
            if (right + 1) >= k:
                result.append(nums[q[0]])
                # only increment left when k is reached
                left += 1
            right += 1
        
        return result
```

### O(n) time | O(n) space

## 1996 https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/description/

Time Limit Exceeded

```python
def numberOfWeakCharacters(self, properties):
        """
        :type properties: List[List[int]]
        :rtype: int
        """
        weakCount = [0] * len(properties)
        for i in range(len(properties)):
            j = i + 1
            while j < len(properties):
                prop1, prop2 = properties[i], properties[j]
                check = (prop1[0] - prop2[0]) * (prop1[1] - prop2[1])
                # 0 mean there's equal, -1 mean not both increasing or decreasing
                if check >= 1:
                    if prop1[0] < prop2[0]:
                        weakCount[i] = 1
                    else:
                        weakCount[j] = 1
                j += 1
        return sum(weakCount)
```

Solution

```python
def numberOfWeakCharacters(self, properties):
        """
        :type properties: List[List[int]]
        :rtype: int
        """
        # sort ascending by 1st property, if 1st props are same, sort descending by 2nd property
        properties.sort(key=lambda x: (x[0], -x[1]))
        
        stack = []
        ans = 0
        
        for a, d in properties:
            while stack and stack[-1] < d:
                stack.pop()
                ans += 1
            stack.append(d)
        return ans
```

## 122 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

```python
def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # IMPORTANT: you can buy it then immediately sell it on the same day
        maxProfit = 0
        for i in range(len(prices)):
            if i + 1 < len(prices) and prices[i + 1] > prices[i]:
                maxProfit += prices[i + 1] - prices[i]
        return maxProfit
```

## 207 https://leetcode.com/problems/course-schedule/

```python
def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # dfs
        preMap = [[] for i in range(numCourses)]

        # map each course to : prereq list
        for crs, pre in prerequisites:
            preMap[crs].append(pre)

        visiting = set()

        def dfs(crs):
            # already visited
            if crs in visiting:
                return False
            # no prereq
            if preMap[crs] == []:
                return True

            visiting.add(crs)
            for pre in preMap[crs]:
                if not dfs(pre):
                    return False
            visiting.remove(crs)
            preMap[crs] = []
            return True

        for c in range(numCourses):
            if not dfs(c):
                return False
        return True
```

## 32 https://leetcode.com/problems/longest-valid-parentheses/description/

```python
def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = [0]
        maxCount = 0
        for c in s:
            if c == ")":
                if len(stack) > 1:
                    val = stack.pop()
                    stack[-1] += val + 2
                    maxCount = max(maxCount, stack[-1])
                else:
                    stack = [0]
            else:
                stack.append(0)
        return maxCount
```

## 39 https://leetcode.com/problems/combination-sum/submissions/

```python
def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []

        def dfs(subset):
            sumSubset = sum(subset)
            if sumSubset == target:
                subset.sort()
                if subset not in result:
                    result.append(subset)
                return
            if sumSubset > target:
                return
            else:
                for num in candidates:
                    dfs(subset + [num])
        
        for num in candidates:
            dfs([num])

        return result
```

## 53 https://leetcode.com/problems/maximum-subarray/description/

```python
def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxSum = nums[0]
        currSum = 0
        for num in nums:
            if currSum < 0:
                currSum = 0
            currSum += num
            maxSum = max(maxSum, currSum)
        return maxSum
```

### 121 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

```python
def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxProfit, minPrice = 0, prices[0]
        for p in prices:
            minPrice = min(p, minPrice)
            profit = p - minPrice
            maxProfit = max(maxProfit, profit)
        return maxProfit
```

## 148 https://leetcode.com/problems/sort-list/description/

```python
def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        fastPtr, slowPtr = head.next, head
        while fastPtr and fastPtr.next:
            fastPtr = fastPtr.next.next
            slowPtr = slowPtr.next
        mid = slowPtr.next
        slowPtr.next = None # break it in half
        l1, l2 = self.sortList(head), self.sortList(mid)
        return self.merge(l1, l2)


    def merge(self, l1, l2):
        if not l1 or not l2:
            return l1 or l2
        dummy = currNode = ListNode()
        while l1 and l2:
            if l1.val < l2.val:
                currNode.next = l1
                l1 = l1.next
            else:
                currNode.next = l2
                l2 = l2.next
            currNode = currNode.next
        currNode.next = l1 or l2
        return dummy.next
```

## 1774 https://leetcode.com/problems/closest-dessert-cost/description/

Unsolved problem

```python
def closestCost(self, baseCosts, toppingCosts, target):
        """
        :type baseCosts: List[int]
        :type toppingCosts: List[int]
        :type target: int
        :rtype: int
        """
        self.closest = baseCosts[0]        

        def dfs(cost, index):
            if (
                abs(cost - target) < abs(self.closest - target) or
                abs(cost - target) < abs(self.closest - target) and 
                cost == self.closest
            ):
                self.closest = cost
            if index == len(toppingCosts) or cost >= target:
                return
            dfs(cost, index + 1)
            dfs(cost + toppingCosts[index], index + 1)
            dfs(cost + toppingCosts[index] * 2, index + 1)
            
    
        
        for cost in baseCosts:
            dfs(cost, 0)
        
        return self.closest
```

## 15 https://leetcode.com/problems/3sum/description/

```python
def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        TARGET = 0
        result = []

        nums.sort()

        for i, num in enumerate(nums):
            if i > 0 and num == nums[i - 1]:
                continue

            match = TARGET - num
            leftPtr, rightPtr = i + 1, len(nums) - 1
            while leftPtr < rightPtr:
                twoSum = nums[leftPtr] + nums[rightPtr]
                if twoSum == match:
                    result.append([num, nums[leftPtr], nums[rightPtr]])
                    leftPtr += 1
                    rightPtr -= 1
                    while nums[leftPtr] == nums[leftPtr - 1] and leftPtr < rightPtr:
                        leftPtr += 1
                elif twoSum < match:
                    leftPtr += 1
                else:
                    rightPtr -= 1

        return result
```