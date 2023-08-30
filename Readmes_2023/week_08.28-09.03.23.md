# Algorithm practice

# Week 08/28 - 09/03/2023


# Category for this week:
**[Heap](#heap)**<br>

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
