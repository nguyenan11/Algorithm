# Algorithm practice

* Documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 2: 05/17 - 05/23/2021

# Category for this week: 
**[Array](#array)**<br>
**[Strings](#strings)**<br>

---

# Array

## [Longest Peak](Arrays/src/main/java/LongestPeak.java)

#### Level: Medium 📘

> Write a function that takes in an array of integers and returns the length of the longest peak in the array.
>
> A peak is defined as adjacent integers in the array that are **strictly** increasing until they reach a tip (the highest value in the peak), at which point they become **strictly** decreasing. At least three integers are required to form a peak.
>
> For example, the integers `[1, 4, 10, 2]` form a peak, but the integers `[4, 0, 10]` don't and neither do the integers `[1, 2, 2, 0]`. Similarly, the integers `[1, 2, 3]`  don't form a peak because there aren't any strictly decreasing integers after the `3`.

```java
public static int longestPeak(int[] array) {
  int longestPeakLength = 0;
  int i = 1;
  while (i < array.length - 1) {
    boolean tipDetected = array[i - 1] < array[i] && array[i] > array[i + 1];
    if (!tipDetected) {
      i++;
      continue;
    }

    int leftIdx = i - 2;
    while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
      leftIdx--;
    }

    int rightIdx = i + 2;
    while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
      rightIdx++;
    }

    longestPeakLength = updateLongestPeak(longestPeakLength, leftIdx, rightIdx);
    i = rightIdx;

  }
  return longestPeakLength;
}


private static int updateLongestPeak(int longestPeakLength, int leftIdx, int rightIdx) {
  int currPeakLength = rightIdx - leftIdx - 1;
  return Math.max(currPeakLength, longestPeakLength);
}
```

### O(n) time | O(n) space - n is length of input array
* Limitation about assumption: peak as if it points up; pointing down was not
considered.
* We traverse thru each number once, at most 2 - 3 times (when peak found and 
traverse to the left) -> still O(n)

## [Array Of Products](Arrays/src/main/java/ArrayOfProducts.java)

#### Level: Medium 📘

> Write a function that takes in a non-empty array of integers and returns an array of the same length, where each element in the output array is equal to the product of every other number in the input array.
>
> In other words, the value at `output[i]` is equal to the product of every number in the input array other than `input[i]`.
>
> Note that you're expected to solve this problem without using division.

```java
public static int[] arrayOfProducts(int[] array) {
  int[] productArr = new int[array.length];

  int productFromLeft = 1;
  for (int i = 0; i < array.length; i++) {
    productArr[i] = productFromLeft;
    productFromLeft *= array[i];
  }

  int productFromRight = 1;
  for (int i = array.length - 1; i >= 0; i--) {
    productArr[i] *= productFromRight;
    productFromRight *= array[i];
  }
  return productArr;
}
```

### O(n) time | O(n) space - n is length of input array

## [First Duplicate Value](Arrays/src/main/java/FirstDuplicateValue.java)

#### Level: Medium 📘

> Given an array of integers between `1` and `n`, inclusive, where `n` is the length of the array, write a function that returns the first integer that appears more than once (when the array is read from left to right).
>
> In other words, out of all the integers that might occur more than once in the input array, your function should return the one whose first duplicate value has the minimum index.
>
> If no integer appears more than once, your function should return `-1`.
>
> Note that you're allowed to mutate the input array.

```java
public int firstDuplicateValue(int[] array) {
  for (int num : array) {
    int absValue = Math.abs(num);
    if (array[absValue - 1] < 0) return absValue;
    array[absValue - 1] *= -1;
  }
  return -1;
}
```

### O(n) time | O(1) space - most optimal
* O(n) time | O(n) is made with single for-loop and a Set/ List
* O(n^2) | O(1) space is made with double for-loops

## [Merge Overlapping Intervals](Arrays/src/main/java/MergeOverlappingIntervals.java)

#### Level: Medium 📘

> Write a function that takes in a non-empty array of arbitrary intervals merges any overlapping intervals, and returns the new intervals in no particular order.
>
> Each interval `interval` is an array of two integers, with `interval[0]`  as the start of the interval and `interval[1]`  as the end of the interval.
>
> Note that back-to-back intervals aren't considered to be overlapping. For example, `[1, 5]` and `[6, 7]` aren't overlapping; however, `[1, 6]` and `[6, 7]` *are* indeed overlapping.
>
> Also note that the start of any particular interval will always be less than or equal to the end of that interval.

```java
public static int[][] mergeOverlappingIntervals(int[][] intervals) {
  Arrays.sort(intervals, new IntCompare());
  List<int[]> mergedInterval = new ArrayList<int[]>();
  int[] currInterval = intervals[0];
  mergedInterval.add(currInterval);

  for (int[] nextInterval : intervals) {
    int currIntervalEnd = currInterval[1];
    int nextIntervalStart = nextInterval[0];
    int nextIntervalEnd = nextInterval[1];

    if (currIntervalEnd >= nextIntervalStart) {
      currInterval[1] = nextIntervalEnd;
    } else {
      currInterval = nextInterval;
      mergedInterval.add(currInterval);
    }
  }
  return mergedInterval.toArray(new int[mergedInterval.size()][]);
}

static class IntCompare implements Comparator<int[]> {

  @Override
  public int compare(int[] o1, int[] o2) {
    return Integer.compare(o1[0], o2[0]);
  }
}
```

### O(nlog(n)) time | O(n) space

## [Spiral Traverse](Arrays/src/main/java/SpiralTraverse.java)

#### Level: Medium 📘

> Write a function that takes in an n x m two-dimensional array (that can be square-shaped when n == m) and returns a one-dimensional array of all the array's elements in spiral order.
>
> Spiral order starts at the top left corner of the two-dimensional array, goes to the right, and proceeds in a spiral pattern all the way until every element has been visited.

```java
public static List<Integer> spiralTraverse(int[][] array) {
  if (array.length == 0) {
    return new ArrayList<Integer>();
  }

  List<Integer> result = new ArrayList<>();
  int startRow = 0;
  int startCol = 0;
  int endRow = array.length - 1;
  int endCol = array[0].length - 1;

  while (startRow <= endRow && startCol <= endCol) {
    for (int col = startCol; col <= endCol; col++) {
      result.add(array[startRow][col]);
    }

    for (int row = startRow + 1; row <= endRow; row++) {
      result.add(array[row][endCol]);
    }

    /*
    Handle the edge case when there's a single row in the middle of the 
    matrix. In this case, we don't want to double-count the values in this 
    row, which we've already counted in the first for loop above.
      */
    for (int col = endCol - 1; col >= startCol; col--) {
      if (startRow == endRow) {
        break;
      }
      result.add(array[endRow][col]);
    }

    /*
    Handle the edge case when there's a single column in the middle of the 
    matrix. In this case, we don't want to double-count the values in this 
    column, which we've already counted in the second for loop above.
      */
    for (int row = endRow - 1; row >= startRow + 1; row--) {
      if (startCol == endCol) {
        break;
      }
      result.add(array[row][startCol]);
    }

    startRow++;
    startCol++;
    endRow--;
    endCol--;
  }

  return result;
}
```

### O(n) time | O(n) space - n is total number of elements in the array

---

# Strings

## [Palindrome Check](Strings/src/main/java/PalindromeCheck.java)

#### Level: Easy 📗

> Write a function that takes in a non-empty string and that returns a boolean representing whether the string is a palindrome.
>
> A palindrome is defined as a string that's written the same forward and backward. Note that single-character strings are palindromes.

```java
public static boolean isPalindrome(String str) {
  int leftIdx = 0;
  int rightIdx= str.length();
  while (leftIdx <= rightIdx) {
    if (str.charAt(leftIdx) != str.charAt(rightIdx)) return false;
    leftIdx++;
    rightIdx--;
  }
  return true;
}
```

### O(n) time | O(1) space - n is length of input string

## [Run-Length Encoding](Strings/src/main/java/RunLengthEncoding.java)

#### Level: Easy 📗

> Write a function that takes in a non-empty string and returns its run-length encoding.
>
> From Wikipedia, "run-length encoding is a form of lossless data compression in which runs of data are stored as a single data value and count, rather than as the original run." For this problem, a run of data is any sequence of consecutive, identical characters. So the run `"AAA"`  would be run-length-encoded as `"3A"`.
>
> To make things more complicated, however, the input string can contain all sorts of special characters, including numbers. And since encoded data must be decodable, this means that we can't naively run-length-encode long runs. For example, the run `"AAAAAAAAAAAA"` (12`A`s) s), can't naively be encoded as `"12A"`, since this string can be decoded as either `"AAAAAAAAAAAA"` or `"1AA"`. Thus, long runs (runs of 10 or more characters) should be encoded in a split fashion; the aforementioned run should be encoded as `"9A3A"`.

```java
private static final int MAX_COUNT = 9, COUNT_RESET = 1;

public static String runLengthEncoding(String string) {

  // List<String> encoding = new ArrayList<>(); would work the same
  StringBuilder encoding = new StringBuilder();

  int currCount = COUNT_RESET;
  char currChar = string.charAt(0);

  // input string is guaranteed non-empty; start for-loop with 1
  for (int i = 1; i < string.length(); i++) {
    char tempChar = string.charAt(i);
    if (currChar == tempChar && currCount < MAX_COUNT) {
      currCount++;
    } else {
      encoding.append(currCount).append(currChar);
      currChar = tempChar;
      currCount = COUNT_RESET;
    }
  }

  // last run
  encoding.append(currCount).append(currChar);
  return encoding.toString();
}
```

### O(n) time | O(n) space - n is length of input string
* Most space complexity: O(2n) - all different characters -> O(n)
* Accurate time complexity for this solution: O(n) + O(2n)
  * O(n) for first for loop
  * O(n) for the toString() (O(2n) for worst time complexity)
  -> O(n) in conclusion
* Highlight: String concatenation is O(n); using that here will make time
complexity to be O(n^2)

## [Generate Document](Strings/src/main/java/GenerateDocument.java)

#### Level: Easy 📗

> You're given a string of available characters and a string representing a document that you need to generate. Write a function that determines if you can generate the document using the available characters. If you can generate the document, your function should return "true"; otherwise, it should return "false".
>
> You're only able to generate the document if the frequency of unique characters in the characters string is greater than or equal to the frequency of unique characters in the document string. For example, if you're given characters = "abcabc" and document = "aabbccc" you cannot generate the document because you're missing one c.
>
> The document that you need to create may contain any characters, including special characters, capital letters, numbers, and spaces.
>
> Note: you can always generate the empty string ("").

```java
private static final int ONE_APPEARANCE = 1;

public boolean generateDocument(String characters, String document) {
  Map<Character, Integer> mapChar = new HashMap<>();
  for (int i = 0; i < characters.length(); i++) {
    char currChar = characters.charAt(i);
    updateMapChar(mapChar, currChar);
  }

  for (int i = 0; i < document.length(); i++) {
    char currChar = document.charAt(i);
    if (!mapChar.containsKey(currChar) || mapChar.get(currChar) == 0) {
      return false;
    }
    mapChar.replace(currChar, mapChar.get(currChar) - ONE_APPEARANCE);
  }
  return true;
}

private void updateMapChar(Map<Character, Integer> mapChar, char aChar) {
  if (mapChar.containsKey(aChar)) {
    mapChar.replace(aChar, mapChar.get(aChar) + ONE_APPEARANCE);
  } else {
    mapChar.put(aChar, ONE_APPEARANCE);
  }
}
```

### O(n+ m) time | O(c) space - n is number of characters, m is the length of the document, c is number of unique characters in characters string

## [First Non-Repeating Character](Strings/src/main/java/FirstNonRepeatingCharacter.java)

#### Level: Easy 📗

> Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the string's first non-repeating character.
>
> The first non-repeating character is the first character in a string that occurs only once.
> If the input string doesn't have any non-repeating characters, your function should return `-1`.

```java
public int firstNonRepeatingCharacter(String string) {
  Map<Character, Integer> charFrequencies = new HashMap<>();

  for (int i = 0; i < string.length(); i++) {
    char currChar = string.charAt(i);
    charFrequencies.put(currChar, charFrequencies.getOrDefault(currChar, 0) + 1);
  }

  for (int i = 0; i < string.length(); i++) {
    char currChar = string.charAt(i);
    if (charFrequencies.get(currChar) == 1) {
      return i;
    }
  }
  return -1;
}
```

### O(n) time | O(1) space - n is the length of the input string
* Constant space is because input string has only lowercase English-alphabet
letters; thus, our hash table will never have more than 26 character 
frequencies.

## [Caesar Cipher Encryptor](Strings/src/main/java/CaesarCipherEncryptor.java)

#### Level: Easy 📗

> Given a non-empty string of lowercase letters and a non-negative integer representing a key, write a function that returns a new string obtained by shifting every letter in the input string by k positions in the alphabet, where k is the key.
>
> Note that letters should "wrap" around the alphabet; in other words, the letter `z` shifted by one returns the letter `a`.

```java
private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
private static final int TOTAL_LETTERS = 26;

public static String caesarCypherEncryptor(String str, int key) {
  char[] encryptedStr = new char[str.length()];
  int shiftKey = key % TOTAL_LETTERS;
  for (int i = 0; i < encryptedStr.length; i++) {
    encryptedStr[i] = getNewCharacter(str.charAt(i), shiftKey);
  }
  return String.valueOf(encryptedStr);
}

private static char getNewCharacter(char character, int shiftKey) {
  int newCharIndex = ALPHABET.indexOf(character) + shiftKey;
  return ALPHABET.charAt(newCharIndex % TOTAL_LETTERS);
}
```

### O(n) time | O(n) space 

## [Group Anagrams](Strings/src/main/java/GroupAnagrams.java)

#### Level: Medium 📘

> Write a function that takes in an array of strings and groups anagrams together.
>
> Anagrams are strings made up of exactly the same letters, where order doesn't matter. For example, `"cinema"` and `"iceman"` are anagrams; similarly, `"foo"` and `"ofo"` are anagrams.
>
> Your function should return a list of anagram groups in no particular order.

```java
public static List<List<String>> groupAnagrams(List<String> words) {
  Map<String, List<String>> anagramsMap = new HashMap<>();

  for (String word : words) {
    String currKey = sortStr(word);
    if (anagramsMap.containsKey(currKey)) {
      anagramsMap.get(currKey).add(word);
    } else {
      anagramsMap.put(currKey, new ArrayList<>(Arrays.asList(word)));
    }
  }

  return new ArrayList<>(anagramsMap.values());
}

private static String sortStr(String word) {
  char[] arr = word.toCharArray();
  Arrays.sort(arr);
  return String.valueOf(arr); // same as new String(arr); || don't use toString
}
```

### O(w * n * log(n)) time | O(wn) space - where w is the number of words and n is length of the longest word