# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 5: 06/14 - 06/20/2021

# Category for this week:
**[Stack](#stack)**<br>

---

# Recursion

## [Leetcode #71 - Simplify Path](https://leetcode.com/problems/simplify-path/)

#### Level: Medium 📘

```python
def simplifyPath(self, path):
    """
    :type path: str
    :rtype: str
    """
    lst = path.split("/")
    stack = []
    for elem in lst:
        if elem == "..":
            if stack:
                stack.pop()
        elif elem != "." and elem != "":
            stack.append(elem)
    return "/" + "/".join(stack)
```