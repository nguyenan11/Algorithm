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