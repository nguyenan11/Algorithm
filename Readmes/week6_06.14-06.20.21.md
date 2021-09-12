# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 6: 06/14 - 06/20/2021

# Category for this week:
**[Stack](#stack)**<br>

---

# Stack

## [Leetcode #71 - Simplify Path](https://leetcode.com/problems/simplify-path/)

#### Level: Medium 📘

```python
def simplifyPath(path):
  '''
  Function -- simplifyPath
    Converts an absolute path in simplified canonical path in a Unix-style file 
    system.
  Parameter:
    path - a path, a String.
  Return:
    Simplified path, a String.
  '''
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

### O(n) time | O(n) space

## [Leetcode #1544 - Make The String Great](https://leetcode.com/problems/make-the-string-great/)

#### Level: Easy 📗

```python
def makeGood(s):
  '''
  Function -- makeGood
    Makes the string good by removing two adjacent characters that make the 
    string bad.
    The string is bad when two adjacent characters that are the same letter
    but one is lower-case and one is upper-case.
  Parameter:
    s - the given String.
  Return:
    A String with any bad pair(s) of characters removed.
  '''
  stack = []
  for char in s:
    if not stack:
      stack.append(char)
    elif stack[-1].isupper() and stack[-1].lower() == char:
      stack.pop()
    elif stack[-1].islower() and stack[-1].upper() == char:
      stack.pop()
    else:
      stack.append(char)
  return "".join(stack)
```

### O(n) time | O(n) space

## [Min Max Stack Construction](../Stacks/src/main/java/MinMaxStackConstruction.java)

#### Level: Medium 📘

> Write a `MinMaxStack` class for a Min Max Stack. The class should support:
> - Pushing and popping values on and off the stack.
> - Peeking at the value at the top of the stack.
> - Getting both the minimum and the maximum values in the stack at any given point in time.
>
> All class methods, when considered independently, should run in constant time and with constant space.

```java
static class MinMaxStack {

  List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();
  List<Integer> stack = new ArrayList<Integer>();

  // O(1) time | O(1) space
  public int peek() {
    return stack.get(stack.size() - 1);
  }


  // O(1) time | O(1) space
  public int pop() {
    minMaxStack.remove(minMaxStack.size() - 1);
    return stack.remove(stack.size() - 1);
  }

  // O(1) time | O(1) space
  public void push(Integer number) {
    Map<String, Integer> newMinMax = new HashMap<String, Integer>();
    newMinMax.put("min", number);
    newMinMax.put("max", number);
    if (minMaxStack.size() > 0) {
      Map<String, Integer> lastMinMax = new HashMap<String, Integer>(
          minMaxStack.get(minMaxStack.size() - 1));
      newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
      newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
    }
    minMaxStack.add(newMinMax);
    stack.add(number);
  }

  // O(1) time | O(1) space
  public int getMin() {
    return minMaxStack.get(minMaxStack.size() - 1).get("min");
  }

  // O(1) time | O(1) space
  public int getMax() {
    return minMaxStack.get(minMaxStack.size() - 1).get("max");
  }
}
```

### O(1) time | O(1) space
* O(1) space because at each method, we work with an existed array.

## [Balanced Brackets](../Stacks/src/main/java/BalancedBrackets.java)

#### Level: Medium 📘

> Write a function that takes in a string made up of brackets `(, [, {, ), ], and }` and other optional characters. The function should return a boolean representing whether the string is balanced with regards to brackets.
>
> A string is said to be balanced if it has as many opening brackets of a certain type as it has closing brackets of that type and if no bracket is unmatched. Note that an opening bracket can't match a corresponding closing bracket that comes before it, and similarly, a closing bracket can't match a corresponding opening bracket that comes after it. Also, brackets can't overlap each other as in `([)]`.

```java
public static boolean balancedBrackets(String str) {
  List<Character> OPEN_BRACKETS = Arrays.asList('[', '(', '{');
  List<Character> CLOSE_BRACKETS = Arrays.asList(']', ')', '}');
  List<Character> stack = new ArrayList<>();
  for (int i = 0; i < str.length(); i++) {
    Character currChar = str.charAt(i);
    int targetIdx = CLOSE_BRACKETS.indexOf(currChar); // return -1 if not found
    if (targetIdx != -1) {
      if (stack.size() == 0 || (stack.get(stack.size() - 1) != OPEN_BRACKETS.get(targetIdx))) {
        return false;
      } else {
        stack.remove(stack.size() - 1);
      }
    } else {
      if (OPEN_BRACKETS.contains(currChar)) {
        stack.add(currChar);
      }
    }
  }
  return stack.size() == 0;
}
```

### O(n) time | O(n) space
* space is O(n / 2) at max, which is converted to O(n)

## [Sort Stacks](../Stacks/src/main/java/SortStack.java)

#### Level: Medium 📘

> Write a function that takes in an array of integers representing a stack, recursively sorts the stack in place (i.e., doesn't create a brand new array), and returns it.
>
> The array must be treated as a stack, with the end of the array as the top of the stack. Therefore, you're only allowed to
> * Pop elements from the top of the stack by removing elements from the end of the array using the built-in `.pop()` method in your programming language of choice.
> * Push elements to the top of the stack by appending elements to the end of the array using the built-in `.append()` method in your programming language of choice.
> * Peek at the element on top of the stack by accessing the last element in the array.
>
> You're not allowed to perform any other operations on the input array, including accessing elements (except for the last element), moving elements, etc.. You're also not allowed to use any other data structures, and your solution must be recursive.

```java
public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
  if (stack.size() == 0) return stack;
  
  int top = stack.remove(stack.size() - 1);
  sortStack(stack);
  insertInSortOrder(stack, top);
  return stack;
}

public void insertInSortOrder(ArrayList<Integer> stack, int value) {
  if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
    stack.add(value);
    return;
  }
  int top = stack.remove(stack.size() - 1);
  insertInSortOrder(stack, value);
  stack.add(top);
}
```

### O(n^2) time | O(n) space

## [Leetcode #1249 - Minimum Remove to Make Valid Parentheses](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)

#### Level: Medium 📘

```python
def minRemoveToMakeValid(s):
  '''
  Function -- minRemoveToMakeValid
    Removes the minimum number of parentheses ( '(' or ')', in any positions ).
  Parameter:
    s - the given String.
  Return:
    A valid resulting parentheses String.
  '''
  s = list(s)
  stack = []
  for idx, char in enumerate(s):
    if char == '(':
      stack.append(idx)
    elif char == ')':
      if stack:
        stack.pop()
      else:
        s[idx] = ''
  while stack:
    s[stack.pop()] = ''
  return ''.join(s)
```

### O(n) time | O(n) space