# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 7: 06/21 - 06/27/2021

# Category for this week:
More **[Stack](#stack)**<br>

---

# Stack

## [Leetcode #792 - Number of Matching Subsequences](https://leetcode.com/problems/number-of-matching-subsequences/)

#### Level: Medium 📘

```python
from collections import defaultdict

class Solution(object):
    def numMatchingSubseq(self, S, words):
        '''
        Function -- numMatchingSubseq
            Counts the number of words[i] that is the subsequence of S.
            Ex:
            s = "abcde", words = ["a","bb","acd","ace"]
            Output: 3
        Parameter:
            S - the given String.
            words - array of Strings.
        Return:
            Number of subsequences, an int.
        '''
        word_dict = defaultdict(list) # create entry automatically
        count = 0
        
        for word in words:
            word_dict[word[0]].append(word)            
        
        for char in S:
            words_expecting_char = word_dict[char]
            
            # this step is important: reset, then add back if there're more characters
            word_dict[char] = []
            for word in words_expecting_char:
                if len(word) == 1:
                    # Finished subsequence! 
                    count += 1
                else:
                    word_dict[word[1]].append(word[1:])
        
        return count
```

### O(max(n, m)) time | O(m) space - n is length of string `S` and m is number of elements in array `words`.

## [Leetcode #739 - Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

#### Level: Medium 📘

```python
def dailyTemperatures(self, temperatures):
    '''
    Function -- dailyTemperatures
        Conducts a result array where result[i] represents number of ith days
        to get a warmer temperature. If no warmer day 0 is sufficient.

        Ex:
        temperatures = [73,74,75,71,69,72,76,73]
        Output: [1,1,4,2,1,1,0,0]
    Parameter:
        temperatures - array of integers represent daily temperatures.
    Return:
        Array of integers.
    ''' 
    stack = []
    result = [0]*len(temperatures)
    for i in range(len(temperatures)):
        while stack and temperatures[i] > temperatures[stack[-1]]:
            prev_index = stack.pop()
            result[prev_index] = i - prev_index
        stack.append(i)
    return result
```

### O(n) time | O(n) space

## [Leetcode #1673 - Find the Most Competitive Subsequence](https://leetcode.com/problems/find-the-most-competitive-subsequence/)

#### Level: Medium 📘

```python
def mostCompetitive(self, nums, k):
    '''
    Function -- mostCompetitive
        Finds the most competitive subsequence
    Parameter:
        nums - array of integers.
        k - the size, positive int.
    Return:
        Array of integers with size k.
    ''' 
    attempts = len(nums) - k
    stack = []
    for num in nums:
        while stack and num < stack[-1] and attempts > 0:
            stack.pop()
            attempts -= 1
        stack.append(num)
    return stack[:k]
```

### O(n) time | O(k) space - n is number of elements of `nums`.

## [Next Greater Element](../Stacks/src/main/java/NextGreaterElement.java)

#### Level: Medium 📘

> Write a function that takes in an array of integers and returns a new array containing, at each index, the next element in the input array that's greater than the element at that index in the input array.
>
> In other words, your function should return a new array where `outputArray[i]` is the next element in the input array that's greater than `inputArray[i]`. If there's no such next greater element for a particular index, the value at that index in the output array should be `-1`. For example, given `array = [1, 2]` your function should return `[2, -1]`.
>
> Additionally, your function should treat the input array as a `circular` array. A circular array wraps around itself as if it were connected end-to-end. So the next index after the last index in a circular array is the first index. This means that, for our problem, given `array = [0, 0, 5, 0, 0, 3, 0 0]`, the next greater element after `3` is `5`, since the array is circular.

```java
public int[] nextGreaterElement(int[] array) {
    int[] result = new int[array.length];
    Arrays.fill(result, -1);

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < array.length * 2; i++) {
        int circularIdx = i % array.length;

        while (stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
        int top = stack.pop();
        result[top] = array[circularIdx];
        }
        stack.push(circularIdx);
    }
    return result;
}
```

### O(n) time | O(n) space
