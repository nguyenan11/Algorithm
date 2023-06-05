# Algorithm practice

# Week 05/29 - 06/04/2023


# Category for this week:
**[Linked List](#linked-list)**<br>

---

# Linked List

## [Leetcode #19 - Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

#### Level: Medium 📘

> Brute force

```python
def removeNthFromEnd(self, head, n):
  """
  :type head: ListNode
  :type n: int
  :rtype: ListNode
  """
  currNode = head
  listLength = 0
  while currNode:
    listLength += 1
    currNode = currNode.next

  removedNodeIdx = listLength - n

  i = 0
  dummy = ListNode(0, head)
  currNode = dummy
  while i < listLength:
    if i == removedNodeIdx:
      currNode.next = currNode.next.next            
      break
    currNode = currNode.next
    i += 1

  return dummy.next
```

### O(n) time | O(1) space

> Cleaner version

```python
def removeNthFromEnd(self, head, n):
  """
  :type head: ListNode
  :type n: int
  :rtype: ListNode
  """

  # crucial to shift leftPtr one more to left for deletion. Otherwise, leftPtr will end up on deleted node; we want to be on one node before it
  dummy = ListNode(0, head)
  leftPtr, rightPtr = dummy, head

  while n > 0 and rightPtr:
      rightPtr = rightPtr.next
      n -= 1

  while rightPtr:
      leftPtr = leftPtr.next
      rightPtr = rightPtr.next

  leftPtr.next = leftPtr.next.next
  return dummy.next
```

### O(n) time | O(1) space


## [Leetcode #138 - Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)

#### Level: Medium 📘

```python
def copyRandomList(self, head):
  """
  :type head: Node
  :rtype: Node
  """
  # reference for original node to new copy
  copyReference = {}
  
  # could point to null 
  copyReference[None] = None

  # 2 loops
  currNode = head
  while currNode:
    copy = Node(currNode.val)
    copyReference[currNode] = copy
    currNode = currNode.next

  currNode = head
  while currNode:
    copy = copyReference[currNode]
    copy.next = copyReference[currNode.next]
    copy.random = copyReference[currNode.random]
    currNode = currNode.next

  return copyReference[head]
```

### O(n) time | O(n) space

## [Leetcode #2 - Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

#### Level: Medium 📘

```python
def addTwoNumbers(self, l1, l2):
  """
  :type l1: ListNode
  :type l2: ListNode
  :rtype: ListNode
  """
  dummy = currNode = ListNode(0)
  needAddOne = 0
  while l1 or l2 or needAddOne:
    val1 = val2 = 0
    if l1:
      val1 = l1.val
      l1 = l1.next
    if l2:
      val2 = l2.val
      l2 = l2.next
    needAddOne, val = divmod(val1 + val2 + needAddOne, 10)
    currNode.next = ListNode(val)
    currNode = currNode.next

  return dummy.next
```

### O(max(m, n)) time | O(max(m, n)) space - where m is length of linked list 1 and n is length of linked list 2

## [Leetcode #141 - Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

#### Level: Easy 📗

```python
def hasCycle(self, head):
  """
  :type head: ListNode
  :rtype: bool
  """
  slowPtr, fastPtr = head, head
  while fastPtr and fastPtr.next:
    slowPtr = slowPtr.next
    fastPtr = fastPtr.next.next
    if slowPtr == fastPtr:
      return True
  return False
```

### O(n) time | O(1) space

## [Leetcode #287 - Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)

#### Level: Medium 📘

```python
def findDuplicate(self, nums):
  """
  :type nums: List[int]
  :rtype: int
  """
  slowPtr, fastPtr = 0, 0
  while True:
    slowPtr = nums[slowPtr]
    fastPtr = nums[nums[fastPtr]]
    if slowPtr == fastPtr:
      break

  slowPtr2 = 0
  while True:
    slowPtr = nums[slowPtr]
    slowPtr2 = nums[slowPtr2]
    if slowPtr == slowPtr2:
      return slowPtr
```

### O(n) time | O(1) space

## [Leetcode #146 - LRU Cache](https://leetcode.com/problems/lru-cache/)

#### Level: Medium 📘

```python
class Node:
  def __init__(self, key, value):
    self.key, self.value = key, value
    self.prev = self.next = None

# solve with Double LinkedList (node) and 2 pointers left and right
# with left to be LRU, and right as Most RU
class LRUCache(object):

  def __init__(self, capacity):
    """
    :type capacity: int
    """
    self.cap = capacity
    self.cache = {} # map key to node

    self.left, self.right = Node(0, 0), Node(0, 0)
    self.left.next, self.right.prev = self.right, self.left
      
  # helper - remove from left
  def remove(self, node):
    prev, nxt = node.prev, node.next
    prev.next, nxt.prev = nxt, prev

  # helper - insert at right
  def insert(self, node):
    prev, nxt = self.right.prev, self.right
    prev.next = nxt.prev = node
    node.next, node.prev = nxt, prev

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
    self.cache[key] = Node(key, value)
    self.insert(self.cache[key])

    if len(self.cache) > self.cap:
      # remove from the list and delete the LRU from hashmap
      lru = self.left.next
      self.remove(lru)
      del self.cache[lru.key]
```

### O(1) time | O(1) space - as expected from the question
