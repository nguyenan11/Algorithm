# Algorithm practice

# Week 05/22 - 05/28/2023


# Category for this week:
**[Linked List](#linked-list)**<br>

---

# Linked List

## [Leetcode #19 - Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

#### Level: Medium 📘

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
