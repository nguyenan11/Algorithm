# Algorithm practice

# Week 08/28 - 09/03/2023


# Category for this week:
**[Heap](#heap)**<br>
**[Intervals](#intervals)**<br>
**[Backtracking](#backtracking)**<br>
**[Graphs](#graphs)**<br>
**[Dynamic Programming](#dynamic-programming)**<br>

---

# Heap
> and/or Priority Queue

## [Leetcode #703 - Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)

#### Level: Easy 📗

> Failed attempt - but right logic
> Failed b/c self.heap might be initialized empty

```python
import heapq

class KthLargest(object):

  def __init__(self, k, nums):
    """
    :type k: int
    :type nums: List[int]
    """
    self.heap = []
    for num in nums:
      if len(self.heap) == k:
        heapq.heappushpop(self.heap, num)
      else:
        heapq.heappush(self.heap, num)
      

  def add(self, val):
    """
    :type val: int
    :rtype: int
    """
    heapq.heappushpop(self.heap, val)
    return self.heap[0]
```

> Success

```python
import heapq

class KthLargest(object):

  def __init__(self, k, nums):
    """
    :type k: int
    :type nums: List[int]
    """
    self.minHeap, self.k = nums, k
    heapq.heapify(self.minHeap)
    while len(self.minHeap) > k:
      heapq.heappop(self.minHeap) # pop smallest element        

  def add(self, val):
    """
    :type val: int
    :rtype: int
    """
    heapq.heappush(self.minHeap, val)
    while len(self.minHeap) > self.k:
      heapq.heappop(self.minHeap)
    return self.minHeap[0]
```

#### O(log n) time | O(n) - n is total number of elements in nums (because of the heap initialization based on nums, even though heap is reduced to k size later)

> heappush(), heappop(), and heappushpop() from Python has O(log n) time complexity

## [Leetcode #1046 - Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)

#### Level: Easy 📗

```python
import heapq

class Solution(object):
  def lastStoneWeight(self, stones):
    """
    :type stones: List[int]
    :rtype: int
    """
    maxHeap = [-s for s in stones]
    heapq.heapify(maxHeap)
    while len(maxHeap) > 1:
      stone1, stone2 = -1 * heapq.heappop(maxHeap), -1 * heapq.heappop(maxHeap)
      if stone1 != stone2:
        # stone1 is guaranteed to be bigger than stone2 if they're different due to maxHeap
        newWeight = stone1 - stone2
        heapq.heappush(maxHeap, -1 * newWeight)
    maxHeap.append(0) # edge case when stones is [2, 2]
    return -1 * maxHeap[0]
```

#### O(nlog n) time (I'm not fully convinced) | O(n) space

> heapify() take O(n)

## [Leetcode #973 - K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)

#### Level: Medium 📘

```python
def kClosest(self, points, k):
  """
  :type points: List[List[int]]
  :type k: int
  :rtype: List[List[int]]
  """
  minHeap = []

  for (x, y) in points:
    dist = x*x + y*y
    minHeap.append([dist, x, y])
  
  heapq.heapify(minHeap) # this is possible because Python library heapq only sort base on first element
      
  result = []
  while k > 0:
    dist, x, y = heapq.heappop(minHeap)
    result.append([x, y])
    k -= 1

  return result
```

#### O(n) time | O(n) space

## [Leetcode #215 - Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

#### Level: Medium 📘

```python
def findKthLargest(self, nums, k):
  """
  :type nums: List[int]
  :type k: int
  :rtype: int
  """
  minHeap = []
  for num in nums:
    if len(minHeap) == k:
      heapq.heappushpop(minHeap, num)
    else:
      heapq.heappush(minHeap, num)
  return minHeap[0]
```

#### O(n log k) time | O(k) space

> Optimized solution - nice concept

```python
def findKthLargest(self, nums, k):
  """
  :type nums: List[int]
  :type k: int
  :rtype: int
  """
  # find the right index in respect to array - help with moving Pointer
  k = len(nums) - k
  left, right = 0, len(nums) - 1
  while left < right:
    pivot = self.partition(nums, left, right)
    
    # move left
    if pivot > k:
      right = pivot - 1
    
    # move right
    elif pivot < k:
      left = pivot + 1

    else:
      break
  
  return nums[k]

# Quickselect (similar to QuickSort)
def partition(self, nums, left, right): 
  pivot, movingPointer = nums[right], left
  for i in range(left, right):
    if nums[i] <= pivot:
      # all less/equal num to left of pivot, bigger to right of pivot
      nums[i], nums[movingPointer] = nums[movingPointer], nums[i]
      movingPointer += 1
  # final swap to ensure values left are smaller and right are bigger
  nums[movingPointer], nums[right] = nums[right], nums[movingPointer]
  return movingPointer
```

#### O(n) + O(n/2) + O(n/4) + ... = O(2n) = O(n) time | O(1) space

## [Leetcode #621 - Task Scheduler](https://leetcode.com/problems/task-scheduler/)

#### Level: Medium 📘

```python
def leastInterval(self, tasks, n):
  """
  :type tasks: List[str]
  :type n: int
  :rtype: int
  """
  freq = Counter(tasks)
  # freq = {}
  # for task in tasks:
  #     freq[task] = freq.get(task, 0) + 1
  
  maxHeap = [-count for count in freq.values()]
  heapq.heapify(maxHeap)

  time = 0

  # pairs of [-count, idleTime] - this is important
  # idleTime is IMPORTANT (key of this algo) and will be used to keep track and add back to heap
  q = deque() 
  while maxHeap or q:
    # plus 1 for each iteration
    # treat time as an index/turn when to be processed
    time += 1

    if not maxHeap:
      time = q[0][1]
    else:
      # to decrease number of freq
      # since maxHeap with - value, we +1 | Otherwise we -1
      count = 1 + heapq.heappop(maxHeap)
      if count: # not equal 0 ~~ we still have to process
        q.append([count, time + n])
    
    if q and q[0][1] == time: # time to process
      heapq.heappush(maxHeap, q.popleft()[0])
  return time
```

#### O(m * n) worst - O(m) time where m is num of tasks | O(m) space

## [Leetcode #295 - Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)

#### Level: Hard 📕

```python
class MedianFinder(object):

  def __init__(self):
    # left is maxHeap, right is minHeap
    # right values are ALWAYS bigger than left values
    self.leftHeap, self.rightHeap = [],[]
      

  def addNum(self, num):
    """
    :type num: int
    :rtype: None
    """
    if self.rightHeap and num > self.rightHeap[0]:
      heapq.heappush(self.rightHeap, num)
    else:
      heapq.heappush(self.leftHeap, -1* num)

    # check if order of number is correct - left < right
    if (
      self.leftHeap and 
      self.rightHeap and 
      -1 * self.leftHeap[0] > self.rightHeap[0]
    ):
      val = -1 * heapq.heappop(self.leftHeap)
      heapq.heappush(self.rightHeap, val)
    
    # check unven size
    if len(self.leftHeap) > len(self.rightHeap) + 1:
      val = -1 * heapq.heappop(self.leftHeap)
      heapq.heappush(self.rightHeap, val)
    if len(self.rightHeap) > len(self.leftHeap) + 1:
      val = heapq.heappop(self.rightHeap)
      heapq.heappush(self.leftHeap, -1 * val)
      

  def findMedian(self):
    """
    :rtype: float
    """
    if len(self.leftHeap) > len(self.rightHeap):
      return -1 * self.leftHeap[0]
    if len(self.rightHeap) > len(self.leftHeap):
      return self.rightHeap[0]
    return (-1 * self.leftHeap[0] + self.rightHeap[0]) / 2.0
```

#### O(log n) time for heapq operations and O(1) for peek

---

# Intervals

## [Leetcode #57 - Insert Interval](https://leetcode.com/problems/insert-interval/)

#### Level: Medium 📘

```python
def insert(self, intervals, newInterval):
  """
  :type intervals: List[List[int]]
  :type newInterval: List[int]
  :rtype: List[List[int]]
  """
  if not intervals or len(intervals) == 0:
    return [newInterval]
  result = []
  for i in range(len(intervals)):
    if newInterval[1] < intervals[i][0]:
      result.append(newInterval)
      return result + intervals[i:]
    if newInterval[0] > intervals[i][1]:
      result.append(intervals[i])
    else:
      start = min(newInterval[0], intervals[i][0])
      end = max(newInterval[1], intervals[i][1])
      newInterval = [start, end]
  result.append(newInterval)
  return result
```

### O(n) time | O(n) space

## [Leetcode #56 - Merge Intervals](https://leetcode.com/problems/merge-intervals/)

#### Level: Medium 📘

```python
def merge(self, intervals):
  """
  :type intervals: List[List[int]]
  :rtype: List[List[int]]
  """
  # sort is important here becasue there's no guarantee that all starts are in ascending order
  intervals.sort(key=lambda interval: interval[0])
  result = [intervals[0]]
  for start, end in intervals[1:]:
    prevEnd = result[-1][1]
    if prevEnd >= start: # overlapping detected
      result[-1][1] = max(prevEnd, end)
    else:
      result.append([start, end])
  return result
```

### O(n * log n) time | O(n) space

## [Leetcode #435 - Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)

#### Level: Medium 📘

```python
def eraseOverlapIntervals(self, intervals):
  """
  :type intervals: List[List[int]]
  :rtype: int
  """
  intervals.sort() # sort based on 1st ele, if 1st ele equalled then 2nd
  removal = 0
  prevEnd = intervals[0][1]
  for start, end in intervals[1:]:
    if start >= prevEnd: # no removal needed
      prevEnd = end
    else:
      removal += 1
      prevEnd = min(prevEnd, end)
  return removal
```

### O(n * log n) time | O(1) space

## [Leetcode #1851 - Minimum Interval to Include Each Query](https://leetcode.com/problems/minimum-interval-to-include-each-query/)

#### Level: Hard 📕

> Brute force - failed b/c time limit exceed, which was expected

```python
def minInterval(self, intervals, queries):
  """
  :type intervals: List[List[int]]
  :type queries: List[int]
  :rtype: List[int]
  """
  result = [-1 for i in range(len(queries))]
  for i in range(len(queries)):
    for start, end in intervals:
      if queries[i] in range(start, end + 1):
        val = result[i]
        newVal = end - start + 1
        result[i] = min(val, newVal) if val != -1 else newVal
  return result
```

#### O(i * q) time | O(q) space where i is length of intervals and q is length of queries

> Optimized and success

```python
def minInterval(self, intervals, queries):
  """
  :type intervals: List[List[int]]
  :type queries: List[int]
  :rtype: List[int]
  """
  intervals.sort() # sort on 1st ele, if equal then 2nd ele
  minHeap = [] # IMPORTANT: minHeap of pair (size, rightIdx)
  i = 0
  result = {}
  sortedQueries = sorted(queries) # we need correct order when return final answer
  for q in sortedQueries:
    # compare query to start of interval - if query is less than start meaning query is out of bound
    while i < len(intervals) and intervals[i][0] <= q:
      l, r = intervals[i]
      heapq.heappush(minHeap, [r - l + 1, r])
      i += 1
      
    while minHeap and minHeap[0][1] < q: # < q means q is outside of right -> out of bound
      heapq.heappop(minHeap)
    result[q] = minHeap[0][0] if minHeap else -1
  return [result[q] for q in queries] # with correct order
```

#### O(n log n + q log q) time | O(n + q) space

---

# Backtracking

## [Leetcode #39 - Combination Sum](https://leetcode.com/problems/combination-sum/)

#### Level: Medium 📘

```python
def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
  result, combination = [], []

  def dfs(i, total):
    if total == target:
      result.append(combination.copy())
      return
    if i >= len(candidates) or total > target:
      return

    combination.append(candidates[i])
    dfs(i, total + candidates[i])
    combination.pop()
    dfs(i + 1, total)

  dfs(0, 0)
  return result
```

### O(2^target) time | O(target) space

## [Leetcode #131 - Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

#### Level: Medium 📘

```python
def partition(self, s: str) -> List[List[str]]:
  res, partition = [], []

  def dfs(i):
    if i >= len(s):
      res.append(partition.copy())
      return
    for j in range(i, len(s)):
      if self.isPalin(s, i, j):
        partition.append(s[i: j + 1])
        dfs(j + 1)
        partition.pop()

  dfs(0)
  return res

def isPalin(self, s, l, r):
  while l < r:
    if s[l] != s[r]:
      return False
    l += 1
    r -= 1
  return True
```

#### O(2^n) time | O(palindromes) space

## [Leetcode #51 - N-Queens](https://leetcode.com/problems/n-queens/)

#### Level: Hard 📕

```python
def solveNQueens(self, n: int) -> List[List[str]]:
  # no needed to keep track of row as we move Q along col
  # can't have Q on same row anyway
  blockedCols = set()
  
  # Diagnoses ALWAYS same value - same straight line (WOAH!!!)
  blockedUpDiags = set() # (r + c)
  blockedDownDiags = set() # (r -c) 

  res = []
  board = [["."] * n for i in range(n)] # ["."] * n is 1 row

  def backtrack(r):
    if r == n:
      # want answer as string for row
      copy = ["".join(row) for row in board]
      res.append(copy)
      return
    for c in range(n):
      if (
        c in blockedCols or
        r + c in blockedUpDiags or
        r - c in blockedDownDiags
      ):
        continue

      blockedCols.add(c)
      blockedUpDiags.add(r + c)
      blockedDownDiags.add(r - c)
      board[r][c] = "Q"

      backtrack(r + 1) 

      # this is backtrack
      blockedCols.remove(c)
      blockedUpDiags.remove(r + c)
      blockedDownDiags.remove(r - c)
      board[r][c] = "."

  backtrack(0)
  return res
```

#### O(n^2) or O(n * n!) time | O(n^2) space
> n! space because we might skip through col that's already blocked
> Be mindful that make a clone/copy might take O(n^2) time as well


---

# Graphs

## [Leetcode #417 - Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)

#### Level: Medium 📘

```python
def pacificAtlantic(self, heights):
  """
  :type heights: List[List[int]]
  :rtype: List[List[int]]
  """
  # idea: go backward
  # start from both pac and alt to go inward, if currVal < prevVal -> elimiated
  ROWS, COLS = len(heights), len(heights[0])
  pac, atl = set(), set()

  # trick see if water can go upward
  def dfs(r, c, visited, prevHeight):
    if (
      r < 0 or
      r == ROWS or
      c < 0 or
      c == COLS or
      heights[r][c] < prevHeight or
      (r, c) in visited
    ):
      return
    visited.add((r, c))
    currHeight = heights[r][c]
    dfs(r - 1, c, visited, currHeight)
    dfs(r + 1, c, visited, currHeight)
    dfs(r, c - 1, visited, currHeight)
    dfs(r, c + 1, visited, currHeight)

  for r in range(ROWS):
    dfs(r, 0, pac, heights[r][0])
    dfs(r, COLS - 1, atl, heights[r][COLS - 1])

  for c in range(COLS):
    dfs(0, c, pac, heights[0][c])
    dfs(ROWS - 1, c, atl, heights[ROWS - 1][c])

  return list(pac.intersection(atl))
```

#### O(n * m) time | O(n * m) space

## [Leetcode #130 - Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)

#### Level: Medium 📘

```python
def solve(self, board):
  """
  :type board: List[List[str]]
  :rtype: None Do not return anything, modify board in-place instead.
  """
  # Reverse Thinking
  # brilliant logic: start from outside
  # anything inside and not connect outside will for sure be surrounded
  ROWS, COLS = len(board), len(board[0])

  # DFS
  def capture(r, c):
    if (
      r < 0 or r == ROWS or
      c < 0 or c == COLS or
      board[r][c] != "O"
    ):
      return
    board[r][c] = "C" # this will avoid duplicated scan
    capture(r - 1, c)
    capture(r + 1, c)
    capture(r, c - 1)
    capture(r, c + 1)

  # 1. DFS - Capture all unsurrounded region
  for r in range(ROWS):
    for c in range(COLS):
      # check if border - check only 2 values here - check in list
      if board[r][c] and (r in [0, ROWS - 1] or c in [0, COLS - 1]):
        capture(r, c)

  # 2. Capture surrounded region
  for r in range(ROWS):
    for c in range(COLS):
      if board[r][c] == "O":
        board[r][c] = "X"

  # 3. Uncapture unsurrounded region
  for r in range(ROWS):
    for c in range(COLS):
      if board[r][c] == "C":
        board[r][c] = "O"
```

#### O(r * c) time

## [Leetcode #994 - Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)

#### Level: Medium 📘

```python
def orangesRotting(self, grid):
  """
  :type grid: List[List[int]]
  :rtype: int
  """
  minute, fresh = 0, 0
  ROWS, COLS = len(grid), len(grid[0])
  q = deque()

  for r in range(ROWS):
    for c in range(COLS):
      if grid[r][c] == 1:
        fresh += 1
      if grid[r][c] == 2:
        q.append((r, c))

  DIRECTIONS = [[0, 1], [0, -1], [1, 0], [-1, 0]]
  
  # still freshness and potential spread rotton
  while fresh > 0 and q:
    length = len(q)
    for i in range(length):
      r, c = q.popleft()
      for dr, dc in DIRECTIONS:
        row, col = r + dr, c + dc

        # if inbound and nonrotten - make rotten
        if (
          row in range(ROWS) and
          col in range(COLS) and
          grid[row][col] == 1
        ):
          grid[row][col] = 2
          q.append((row, col))
          fresh -= 1
      minute += 1

  return minute if fresh == 0 else -1
```

#### O(r * c) time | O(rotten oranges) space

## [Leetcode #210 - Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)

#### Level: Medium 📘

```python
def findOrder(self, numCourses, prerequisites):
  """
  :type numCourses: int
  :type prerequisites: List[List[int]]
  :rtype: List[int]
  """
  prere = {i: [] for i in range(numCourses)}
  for c, pre in prerequisites:
    prere[c].append(pre)

  output = []
  cycle, visited = set(), set() # cycle tell if node is along path

  '''
  courses has 3 stages:
  1. visited - course has been added to output
  2. visiting - course not added to output, but added to cycle
  3. unvisited - course not added to output nor cycle
  '''

  def dfs(course):
    if course in cycle: # mean we're visiting this twice
      return False
    if course in visited: # don't need to visited twice
      return True
    cycle.add(course)
    for pre in prere[course]:
      if not dfs(pre): # cycle detected
        return False
    cycle.remove(course) # done with the path - IMPORTANT
    visited.add(course) # all good to go
    output.append(course)
    return True

  for c in range(numCourses):
    if not dfs(c):
      return []
  
  return output
```

#### O(Prere + Courses) or O(Edge + Vertex (Node)) time | O(numCourse) space

## [Leetcode #684 - Redundant Connection](https://leetcode.com/problems/redundant-connection/)

#### Level: Medium 📘

```python
def findRedundantConnection(self, edges):
  """
  :type edges: List[List[int]]
  :rtype: List[int]
  """
  # Ideal, remove edge that can break the cycle
  # if multiple solution, return latest one in input edges
  
  graphs = defaultdict(set)
  output = []

  def dfs(u, v):
    if u in cycle:
      return False
    if u == v:
      return True
    cycle.add(u)
    for neighbor in graphs[u]:
      if dfs(neighbor, v):
        return True
    return False

  for u, v in edges:
    cycle = set() # this gets reset every time
    if dfs(u, v):
      output = [u, v] # output got updated to latest element in edges
    graphs[u].add(v)
    graphs[v].add(u)

  return output
```

#### O(2n) = O(n) time | O(n) space for recursion stack

## [Leetcode #127 - Word Ladder](https://leetcode.com/problems/word-ladder/)

#### Level: Hard 📕

```python
def ladderLength(self, beginWord, endWord, wordList):
  """
  :type beginWord: str
  :type endWord: str
  :type wordList: List[str]
  :rtype: int
  """
  # 1 replacement at a time
  # all words have same length
  if endWord not in wordList:
    return 0

  neighbors = defaultdict(list)
  wordList.append(beginWord)

  # populate the dict. Ex: neighbors[*ot] = [hot, dot, lot]
  for word in wordList:
    for j in range(len(word)):
      pattern = word[:j] + "*" + word[j + 1:]
      neighbors[pattern].append(word)

  visited = set(beginWord)
  q = deque([beginWord])

  change = 1
  while q:
    for i in range(len(q)):
      word = q.popleft()
      if word == endWord:
        return change # shortest path
      for j in range(len(word)):
        pattern = word[:j] + "*" + word[j + 1:]
        for nei in neighbors[pattern]:
          if nei not in visited:
            visited.add(nei)
            q.append(nei)
      change += 1

  return 0
```

#### O(n * m^2) time | O(n * m^2) space

---

# Dynamic Programming

## [Leetcode #70 - Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

#### Level: Easy 📗

> Brute force

```python
def climbStairs(self, n):
  """
  :type n: int
  :rtype: int
  """
  if n == 1:
    return 1
  if n == 2:
    return 2
  return self.climbStairs(n - 1) + self.climbStairs(n - 2)
```

#### O(2^n) time | O(n) space

> Optimized

```python
def climbStairs(self, n):
  """
  :type n: int
  :rtype: int
  """
  if n <= 3:
    return n
  n1, n2 = 2, 3
  for i in range(4, n + 1):
    temp = n1 + n2
    n1 = n2
    n2 = temp
  return n2
```

#### O(n) time | O(1) space

## [Leetcode #746 - Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

#### Level: Easy 📗

```python
def minCostClimbingStairs(self, cost):
  """
  :type cost: List[int]
  :rtype: int
  """
  # compare 2 prev cost when reaching new cost
  for i in range(2, len(cost)):
    cost[i] += min(cost[i - 1], cost[i - 2])

  return min(cost[len(cost) - 1], cost[len(cost) - 2])
```

#### O(n) time | O(n) space

## [Leetcode #198 - House Robber](https://leetcode.com/problems/house-robber/)

#### Level: Medium 📘

```python
def rob(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  max1, max2 = 0, 0
  for num in nums:
    # can't + max with num because they can't be adjacent
    temp = max(max1 + num, max2) 
    max1 = max2
    max2 = temp
  return max2
```

#### O(n) time | O(1) space

## [Leetcode #213 - House Robber II](https://leetcode.com/problems/house-robber-ii/)

#### Level: Medium 📘

```python
def rob(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  # cases: 1 value, skip first house, skip last house
  return max(nums[0], self.robber1(nums[1:]), self.robber1(nums[:-1]))
  
# this is House Robber I
def robber1(self, nums):
  max1, max2 = 0, 0
  for num in nums:
    temp = max(num + max1, max2)
    max1 = max2
    max2 = temp
  return max2
```

#### O(n) time | O(1) space

## [Leetcode #647 - Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)

#### Level: Medium 📘

```python
def countSubstrings(self, s):
  """
  :type s: str
  :rtype: int
  """
  count = len(s)
  for i in range(1, len(s)):
    odd = self.countPalSub(s, i - 1, i + 1)
    even = self.countPalSub(s, i - 1, i)
    count += odd + even
  return count
  
def countPalSub(self, s, l, r):
  count = 0
  while l >= 0 and r < len(s):
    if s[l] != s[r]:
      break
    l -= 1
    r += 1
    count += 1
  return count
```

#### O(n^2) time | O(1) space

## [Leetcode #152 - Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)

#### Level: Medium 📘

```python
def maxProduct(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  res = nums[0]
  currMin, currMax = 1, 1

  for num in nums:
    temp = num * currMax
    currMax = max(num, temp, num * currMin)
    currMin = min(num, temp, num * currMin)
    res = max(currMax, res)
  
  return res
```

#### O(n) time | O(1) space

## [Leetcode #139 - Word Break](https://leetcode.com/problems/word-break/)

#### Level: Medium 📘

```python
def wordBreak(self, s, wordDict):
  """
  :type s: str
  :type wordDict: List[str]
  :rtype: bool
  """
  dp = [False] * (len(s) + 1) # + 1 for base case
  dp[len(s)] = True

  # backward # bottom-up # top-down would work - return dp[len(s) - 1]
  for i in range(len(s), -1, -1):
    for w in wordDict:
      if (i + len(w)) <= len(s) and s[i:i+len(w)] == w:
        dp[i] = dp[i + len(w)]
      if dp[i]:
        break # found matched word, move onto next
      
  return dp[0]
```

#### O(n * m) time | O(n) space where n is length of string s and m is maximum length of word in wordDict
> Time is augured to be O(n^2 * m) since string slicing takes O(n)

## [Leetcode #91 - Decode Ways](https://leetcode.com/problems/decode-ways/)

#### Level: Medium 📘

```python
def numDecodings(self, s):
  """
  :type s: str
  :rtype: int
  """
  dp = [0] * (len(s) + 1)
  dp[len(s)] = 1

  for i in range(len(s) - 1, -1, -1):
    if s[i] == "0":
      continue
    dp[i] = dp[i + 1]
    if i + 1 < len(s) and (
      s[i] == "1" or s[i] == "2" and s[i + 1] in "0123456"
    ):
      dp[i] += dp[i + 2]
  
  return dp[0]
```

#### O(n) time | O(n) space
