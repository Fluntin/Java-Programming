# Substring Finder

This Java program reads a string and an integer `n` from the user and finds the most common substring of length `n` within the given string. If there are multiple substrings with the same highest frequency, the lexicographically smallest one is chosen.

## How It Works

1. **Reading Input:**
   - The program uses `Scanner` to read an integer `n` and a string `S` from the standard input (typically the console).

2. **Finding the Most Common Substring:**
   - The `findCommonSub` method iterates through the input string to find the most frequent substring of length `n`.
   - If multiple substrings have the same frequency, the `lexSmaller` method is used to determine the lexicographically smallest one.

## Methods

### `findCommonSub(int n, String S)`

This method finds the most common substring of length `n` in the given string `S`.

- **Parameters:**
  - `n`: The length of the substring.
  - `S`: The input string.
- **Returns:**
  - The most common substring of length `n`. If multiple substrings have the same frequency, the lexicographically smallest one is returned.

### `lexSmaller(String s1, String s2)`

This method compares two strings lexicographically based on a custom order and returns the smaller one.

- **Parameters:**
  - `s1`: The first string.
  - `s2`: The second string.
- **Returns:**
  - The lexicographically smaller string.

## Example

If the user inputs the integer `3` and the string `abcabcabc`, the program will output `abc` since it is the most common substring of length `3`.