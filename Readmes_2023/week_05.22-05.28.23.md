# Algorithm practice

# Week 05/22 - 05/28/2023


# Category for this week:
**[Stack](#stack)**<br>
**[Linked List](#linked-list)**<br>

---

# Stack

## [Leetcode #739 - Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

#### Level: Medium 📘

```python
def dailyTemperatures(self, temperatures):
  """
  :type temperatures: List[int]
  :rtype: List[int]
  """
  answer =[0 for i in range(len(temperatures))]
  stack = []
  for i in range(len(temperatures)):
    while stack and temperatures[i] > temperatures[stack[-1]]:
      prev_index = stack.pop()
      answer[prev_index] = i - prev_index
    stack.append(i)
  return answer
```

### O(n) time | O(n) space


## [Leetcode #853 - Car Fleet](https://leetcode.com/problems/car-fleet/)

#### Level: Medium 📘

Linear equation -> intersection

![LC853](../2023_images/LC853.png)

> Success run on Python3

```python
def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
  pair = [(p, s) for p, s in zip(position, speed)]
  pair.sort(reverse=True)
  stack = []
  for p, s in pair:  # Reverse Sorted Order
    stack.append((target - p) / s)
    if len(stack) >= 2 and stack[-1] <= stack[-2]:
      stack.pop()
  return len(stack)
```

### O(n log(n)) time | O(n) space

## [Leetcode #84 - Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

#### Level: Hard 📕

```python
def largestRectangleArea(self, heights):
  """
  :type heights: List[int]
  :rtype: int
  """
  HEIGHT = 1
  maxArea = 0
  stack = []  # pair: (index, height)

  for i, h in enumerate(heights):
    start = i
    while stack and stack[-1][HEIGHT] > h:
      index, height = stack.pop()
      maxArea = max(maxArea, height * (i - index))
      start = index
    stack.append((start, h))

  for i, h in stack:
    maxArea = max(maxArea, h * (len(heights) - i))
  return maxArea
```

### O(n) time | O(n) space

---

# Linked List

## [Leetcode #206 - Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

#### Level: Easy 📗

```python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
  def reverseList(self, head):
    """
    :type head: ListNode
    :rtype: ListNode
    """
    prevNode = None
    currNode = head
    while currNode != None:
      nextNode = currNode.next
      currNode.next = prevNode
      prevNode = currNode
      currNode = nextNode
    return prevNode
```

### O(n) time | O(1) space

## [Leetcode #21 - Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

#### Level: Easy 📗

```python
def mergeTwoLists(self, list1, list2):
  """
  :type list1: Optional[ListNode]
  :type list2: Optional[ListNode]
  :rtype: Optional[ListNode]
  """
  head = currNode = ListNode(0)
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

### O(n1 + n2) time | O(n1 + n2) space

## [Leetcode #143 - Reorder List](https://leetcode.com/problems/reorder-list/)

#### Level: Medium 📘

```python
def reorderList(self, head):
  """
  :type head: ListNode
  :rtype: None Do not return anything, modify head in-place instead.
  """
  # find mid point
  slowPtr, fastPtr = head, head.next
  while fastPtr and fastPtr.next:
    slowPtr = slowPtr.next
    fastPtr = fastPtr.next.next

  # reverse second half
  second = slowPtr.next
  prevNode = slowPtr.next = None
  while second:
    nextNode = second.next
    second.next = prevNode
    prevNode = second
    second = nextNode
  
  # merge
  first, second = head, prevNode
  while second:
    temp1, temp2 = first.next, second.next
    first.next = second
    second.next = temp1
    first, second = temp1, temp2
```

### O(n) time | O(1) space
