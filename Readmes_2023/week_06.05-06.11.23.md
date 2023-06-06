# Algorithm practice

# Week 06/05 - 06/11/2023


# Category for this week:
**[Linked List](#linked-list)**<br>
**[Sliding Window](#sliding-window)**<br>

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


## [Leetcode #25 - Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)

#### Level: Hard 📕

```python
def reverseKGroup(self, head, k):
  """
  :type head: ListNode
  :type k: int
  :rtype: ListNode
  """
  dummy = ListNode(0, head)
  groupPrev = dummy # 1 node before the start of group

  while True:
    kth = self.getKth(groupPrev, k)
    if not kth: # k is 0 or None node (not enough to reverse)
      break
    groupNext = kth.next

    # reverse group
    prev, curr = kth.next, groupPrev.next

    while curr != groupNext:
      temp = curr.next
      curr.next = prev
      prev = curr
      curr = temp

    temp = groupPrev.next # 1st node in group, then later will be last
    groupPrev.next = kth
    groupPrev = temp

  return dummy.next

def getKth(self, currNode, k):
  while currNode and k > 0:
    currNode = currNode.next
    k -= 1
  return currNode
```

### O(n) time | O(1) space

---

# Sliding Window

## [Leetcode #121 - Best Time To Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

#### Level: Easy 📗

```python
def maxProfit(self, prices):
  """
  :type prices: List[int]
  :rtype: int
  """
  maxProfit, minPrice = 0, float('inf')
  for price in prices:
    minPrice = min(minPrice, price)
    profit = price - minPrice
    maxProfit = max(maxProfit, profit)
  return maxProfit
```

### O(n) time | O(1) space

## [Leetcode #3 - Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

#### Level: Medium 📘

> Old approach, but still nicely done

```python
def lengthOfLongestSubstring(self, s):
  """
  :type s: str
  :rtype: int
  """
  lastSeen = {}
  startIdx, longest = 0, 0

  for idx, char in enumerate(s):
    if char in lastSeen:
      startIdx = max(startIdx, lastSeen[char] + 1)
    longest = max(longest, idx - startIdx + 1)
    lastSeen[char] = idx
  return longest
```

### O(n) time | O(min(n, a)) - n is the length of input string and a is the length of the character alphabet represented in the input string

> Sliding window with 2 pointers

```python
def lengthOfLongestSubstring(self, s):
  """
  :type s: str
  :rtype: int
  """
  # sliding window using 2 pointers
  charSet = set()
  left, longest = 0, 0
  for right, char in enumerate(s):
    while char in charSet:
      charSet.remove(s[left])
      left += 1
    charSet.add(char)
    longest = max(longest, right - left + 1)
  return longest
```

### O(n) time | O(n) space

## [Leetcode #424 - Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

#### Level: Medium 📘

```python
def characterReplacement(self, s, k):
  """
  :type s: str
  :type k: int
  :rtype: int
  """
  count = {}
  left, result = 0, 0
  for right, char in enumerate(s):
    count[char] = count.get(char, 0) + 1
    while (right - left + 1) - max(count.values()) > k:
      count[s[left]] -= 1
      left += 1
    result = max(result, right - left + 1)
  return result
```

### O(n) time - from O(26n) | O(1) space - from O(26)
