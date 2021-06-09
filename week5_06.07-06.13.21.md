# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 5: 06/07 - 06/13/2021

## [Leetcode #70](https://leetcode.com/problems/climbing-stairs/)

#### Level: Easy 📗

```python
def climbStairs(n) {
    if n == 1:
        return 1
    elif n == 2:
        return 2
    return climbStairs(n - 1) + climbStairs(n - 2)
}
```

## [Leetcode #2 - Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

```python
def addTwoNumbers(self, l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
    needAddOne = 0
    root = n = ListNode(0)
    while l1 or l2 or needAddOne:
        val1 = val2 = 0
        if l1:
            val1 = l1.val
            l1 = l1.next
        if l2:
            val2 = l2.val
            l2 = l2.next
        needAddOne, val = divmod(val1+val2+needAddOne, 10)
        n.next = ListNode(val)
        n = n.next
    return root.next
```