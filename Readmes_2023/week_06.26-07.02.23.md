# Algorithm practice

# Week 06/26 - 07/02/2023


# Category for this week:
**[Tries](#tries)**<br>

---

# Tries

## [Leetcode #208 - Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)

#### Level: Medium 📘

```python
class TrieNode(object):
  def __init__(self):
    self.children = {}
    self.endOfWord = False

class Trie(object):

  def __init__(self):
    self.root = TrieNode()

  def insert(self, word):
    """
    :type word: str
    :rtype: None
    """
    curr = self.root
    for c in word:
      if c not in curr.children:
        curr.children[c] = TrieNode()
      curr = curr.children[c]
    curr.endOfWord = True
      
  def search(self, word):
    """
    :type word: str
    :rtype: bool
    """
    curr = self.root
    for c in word:
      if c not in curr.children:
        return False
      curr = curr.children[c]
    return curr.endOfWord

  def startsWith(self, prefix):
    """
    :type prefix: str
    :rtype: bool
    """
    curr = self.root
    for c in prefix:
      if c not in curr.children:
        return False
      curr = curr.children[c]
    return True
```

### O(n) time - n is number of characters in word/prefix
