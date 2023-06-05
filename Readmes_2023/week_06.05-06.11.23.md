# Algorithm practice

# Week 06/05 - 06/11/2023


# Category for this week:
**[Linked List](#linked-list)**<br>

---

# Linked List

## [Leetcode #23 - Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)

#### Level: Hard 📕

```python
def mergeKLists(self, lists):
  """
  :type lists: List[ListNode]
  :rtype: ListNode
  """
  if lists == None or len(lists) == 0:
    return None
  while len(lists) > 1:
    mergedLists = []
    for i in range(0, len(lists), 2):
      list1 = lists[i]
      # oddNum of lists
      list2 = lists[i + 1] if (i + 1) < len(lists) else None 
      mergedLists.append(self.merge2Lists(list1, list2))
    lists = mergedLists
  return lists[0]

def merge2Lists(self, list1, list2):
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

### O(n * log k) time | O(n) space

