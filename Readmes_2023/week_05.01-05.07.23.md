# Algorithm practice

# Week 05/01 - 05/07/2023


# Category for this week:
**[Array](#array)**<br>

---

# Array

## [Leetcode #217 - Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

#### Level: Easy 📗

```python
def containsDuplicate(self, nums):
  """
  :type nums: List[int]
  :rtype: bool
  """
  hashset = set()
  for num in nums:
    if num in hashset:
      return True
    hashset.add(num)
  return False
```

### O(n) time | O(n) space

## [Leetcode #242 - Valid Anagram](https://leetcode.com/problems/valid-anagram/)

#### Level: Easy 📗

```python
def isAnagram(self, s, t):
  """
  :type s: str
  :type t: str
  :rtype: bool
  """
  map_s = {}
  for char in s:
    map_s[char] = map_s.get(char, 0) + 1
  map_t = {}
  for char in t:
    map_t[char] = map_t.get(char, 0) + 1
  return map_s == map_t
```

### O(n + m) time | O(n + m) space - where n and m is length of s and t respectively

Other solution

```python
def isAnagram(self, s, t):
  """
  :type s: str
  :type t: str
  :rtype: bool
  """
  if len(s) != len(t):
    return False
  map_s, map_t = {}, {}
  for i in range(len(s)):
    map_s[s[i]] = map_s.get(s[i], 0) + 1
    map_t[t[i]] = map_t.get(t[i], 0) + 1
  return map_s == map_t
```

### O(n) time | O(2n) space - n is minimum length between s and t

## [Leetcode #1 - Two Sum](https://leetcode.com/problems/two-sum/)

#### Level: Easy 📗

```python
def twoSum(self, nums, target):
  """
  :type nums: List[int]
  :type target: int
  :rtype: List[int]
  """
  target_cache = {}
    for i, num in enumerate(nums):
      search_num = target - num
      if search_num in target_cache:
        return [i, target_cache[search_num]]
      target_cache[num] = i
```

### O(n) time | O(n) space

## [Leetcode #49 - Group Anagrams](https://leetcode.com/problems/group-anagrams/)

#### Level: Medium 📘

```python
def groupAnagrams(self, strs):
  """
  :type strs: List[str]
  :rtype: List[List[str]]
  """
  if len(strs) == 0:
    return
  if len(strs) == 1:
    return [strs]
  anagrams_group = {}
  for word in strs:
    key = "".join(sorted(word))
    if key not in anagrams_group:
      anagrams_group[key] = []
    anagrams_group[key].append(word)
  return anagrams_group.values()
```

### O(w * n * log(n)) time | O(wn) space - where w is the number of words and n is the length of the longest word

## [Leetcode #347 - Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

#### Level: Medium 📘

```python
def topKFrequent(self, nums, k):
  """
  :type nums: List[int]
  :type k: int
  :rtype: List[int]
  """
  count = {}
  freq = [[] for i in range(len(nums) + 1)]
  for num in nums:
    count[num] = count.get(num, 0) + 1
  for key, value in count.items():
    freq[value].append(key)

  result = []
  for i in range(len(freq) - 1, 0, -1):
    for num in freq[i]: # num can be list of null or null
      result.append(num)
      if len(result) == k:
        return result
```

### O(n) time | O(n) space

## [Leetcode #238 - Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

#### Level: Medium 📘

```python
def productExceptSelf(self, nums):
  """
  :type nums: List[int]
  :rtype: List[int]
  """
  products = [1 for i in range(len(nums))]
  leftProducts = [1 for i in range(len(nums))]
  rightProducts = [1 for i in range(len(nums))]

  leftRunningProduct = 1
  for i in range(len(nums)):
    leftProducts[i] = leftRunningProduct
    leftRunningProduct *= nums[i]

  rightRunningProduct = 1
  for i in reversed(range(len(nums))):
    rightProducts[i] = rightRunningProduct
    rightRunningProduct *= nums[i]

  for i in range(len(nums)):
    products[i] = leftProducts[i] * rightProducts[i]

  return products
```

### O(n) time | O(n) space

