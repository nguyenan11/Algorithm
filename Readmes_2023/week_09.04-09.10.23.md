# Algorithm practice

# Week 09/04 - 09/10/2023


# Category for this week:
**[Advanced Graphs](#advanced-graphs)**<br>

---

# Advanced Graphs

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
