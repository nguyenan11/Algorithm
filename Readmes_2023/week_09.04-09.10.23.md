# Algorithm practice

# Week 09/04 - 09/10/2023


# Category for this week:
**[Advanced Graphs](#advanced-graphs)**<br>
**[Bit Manipulation](#bit-manipulation)**<br>

---

# Advanced Graphs

## Prim's
## [Leetcode #1584 - Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/)

#### Level: Medium 📘

```python
def minCostConnectPoints(self, points):
  """
  :type points: List[List[int]]
  :rtype: int
  """
  numPoints = len(points)

  # adjacent list - i is index
  # list of (cost, node) - node is neighbor point
  adj = {i: [] for i in range(numPoints)} 

  for i in range(numPoints):
    x1, y1 = points[i]
    # compare to all the point in graph
    for j in range(i + 1, numPoints):
      x2, y2 = points[j]
      dist = abs(x1 - x2) + abs(y1 - y2)
      adj[i].append([dist, j])
      adj[j].append([dist, i])
      
  # Prim's algo 
  res = 0
  visited = set()
  minHeap = [[0, 0]] # [cost, point]
  while len(visited) < numPoints: # try to get to equal
    dist, i = heapq.heappop(minHeap)
    if i in visited:
      continue
    res += dist
    visited.add(i)
    for neiDist, nei in adj[i]:
      if nei not in visited:
        heapq.heappush(minHeap, [neiDist, nei])

  return res
```

#### O(n^2 * log n) time | O(n) space

## Djkstra
## [Leetcode #743 - Network Delay Time](https://leetcode.com/problems/network-delay-time/)

#### Level: Medium 📘

```python
def networkDelayTime(self, times, n, k):
  """
  :type times: List[List[int]]
  :type n: int
  :type k: int
  :rtype: int
  """
  edges = defaultdict(list)
  for u, v, w in times:
    edges[u].append((v, w))

  minHeap = [(0, k)] # dist, node
  visited = set()
  time = 0
  while minHeap:
    dist1, node1 = heapq.heappop(minHeap)
    if node1 in visited:
      continue
    visited.add(node1)
    time = max(time, dist1)

    # BFS
    for node2, dist2 in edges[node1]:
      # sum the distance
      heapq.heappush(minHeap, (dist1 + dist2, node2))

  return time if len(visited) == n else -1
```

#### O(E * log V^20) ~~ O(2E * log V) ~~ O(E * log V) time
#### E is edges, V is nodes/vertexes

## Bellman-Ford

---

# Bit Manipulation

## [Leetcode #268 - Missing Number](https://leetcode.com/problems/missing-number/)

#### Level: Easy 📗

> sln 1
```python
def missingNumber(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  expectedSum = 0
  for i in range(len(nums) + 1):
    expectedSum += i
  actualSum = sum(nums)
  return expectedSum - actualSum
```

> sln 2
```python
def missingNumber(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  res = len(nums)
  for i in range(len(nums)):
    # we'll be left with the missing num
    res += (i - nums[i])
  return res
```

#### Both O(n) time | O(1) space

## [Leetcode #136 - Single Number](https://leetcode.com/problems/single-number/)

#### Level: Easy 📗

> Brute force

```python
def singleNumber(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  repeated = set()
  for num in nums:
    # appear TWICE
    if num in repeated:
      repeated.remove(num)
    else:
      repeated.add(num)
  return repeated.pop()
```

#### O(n) time | O(n) space
