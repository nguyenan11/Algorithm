# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 7: 06/21 - 06/27/2021

## [Leetcode #792 - Number of Matching Subsequences](https://leetcode.com/problems/number-of-matching-subsequences/)

#### Level: Medium 📘

```python
from collections import defaultdict

class Solution(object):
    def numMatchingSubseq(self, S, words):
        """
        :type S: str
        :type words: List[str]
        :rtype: int
        """
        word_dict = defaultdict(list)
        count = 0
        
        for word in words:
            word_dict[word[0]].append(word)            
        
        for char in S:
            words_expecting_char = word_dict[char]
            word_dict[char] = []
            for word in words_expecting_char:
                if len(word) == 1:
                    # Finished subsequence! 
                    count += 1
                else:
                    word_dict[word[1]].append(word[1:])
        
        return count
```

## [Leetcode #739 - Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

#### Level: Medium 📘

```python
def dailyTemperatures(self, temperatures):
    """
    :type temperatures: List[int]
    :rtype: List[int]
    """
    stack = []
    res = [0]*len(temperatures)
    for i in range(len(temperatures)):
        while stack and temperatures[i] > temperatures[stack[-1]]:
            prev_index = stack.pop()
            res[prev_index] = i - prev_index
        stack.append(i)
    return res
```

## [Leetcode #1673 - Find the Most Competitive Subsequence](https://leetcode.com/problems/find-the-most-competitive-subsequence/)

#### Level: Medium 📘

```python
def mostCompetitive(self, nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: List[int]
    """
    stack = []
    for i, num in enumerate(nums):
        if len(nums) - i + len(stack) == k:
            return stack + nums[i:]
        while stack and stack[-1] > num and len(stack) - 1 + len(nums) - i >= k:
            stack.pop()
        if len(stack) < k:
            stack.append(num)
    return stack
```