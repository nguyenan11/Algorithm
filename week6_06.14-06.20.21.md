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

## [Leetcode #1544 - Make The String Great](https://leetcode.com/problems/make-the-string-great/)

#### Level: Easy 📗

```python
def makeGood(self, s):
    """
    :type s: str
    :rtype: str
    """
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

## [Min Max Stack Construction](Stacks/src/main/java/MinMaxStackConstruction.java)

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
* O(1) space because when add add or remove, we work with an existed array; no 
iteration. With each value of n, we might store 2 additional map (3n), but
overall O(n) comes down to O(1) and so does O(3n)

## [Balanced Brackets](Stacks/src/main/java/BalancedBrackets.java)

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

