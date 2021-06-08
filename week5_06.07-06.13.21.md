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