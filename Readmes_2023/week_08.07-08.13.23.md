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

# 