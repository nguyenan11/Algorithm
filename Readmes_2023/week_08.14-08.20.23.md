# Algorithm practice

# Week 08/14 - 08/20/2023

# Category for this week:
**[TikTok focused questions](#tiktok)**<br>

---

# TikTok

### Follow this list: https://nodeflair.com/blog/bytedance-software-engineer-interview-questions-and-process

## LRU Cache already

## 347 https://leetcode.com/problems/top-k-frequent-elements/description/

Better solution

```python
def topKFrequent(self, nums: List[int], k: int) -> List[int]:
    count = {}

    for n in nums:
        count[n] = count.get(n, 0) + 1
    sortedCount = sorted(count, key=lambda item: count[item])
    index = len(sortedCount) - k
    return sortedCount[index:]
```

Old solution

```python
def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        count = {}
        freq = [[] for i in range(len(nums) + 1)]

        for n in nums:
            count[n] = 1 + count.get(n, 0)
        for key, value in count.items():
            freq[value].append(key)

        result = []
        for i in range(len(freq) - 1, 0, -1):
            for num in freq[i]:
                result.append(num)
                if len(result) == k:
                    return result
```

## 300 https://leetcode.com/problems/longest-increasing-subsequence/description/

```python
def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        LIS = [1 for i in range(len(nums))]

        for i in range(len(nums) - 1, -1, -1):
            for j in range(i + 1, len(nums)):
                if nums[i] < nums[j]:
                    LIS[i] = max(LIS[i], 1 + LIS[j])
        return max(LIS)
```

## 133 Clone Graph

```python
def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        oldToNew = {}

        def dfs(node):
            if node in oldToNew:
                return oldToNew[node]
            
            copy = Node(node.val)
            oldToNew[node] = copy
            for nei in node.neighbors:
                copy.neighbors.append(dfs(nei))
            return copy
        
        return dfs(node) if node else None
````
