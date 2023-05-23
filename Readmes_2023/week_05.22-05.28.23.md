# Algorithm practice

# Week 05/22 - 05/28/2023


# Category for this week:
**[Stack](#stack)**<br>

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
