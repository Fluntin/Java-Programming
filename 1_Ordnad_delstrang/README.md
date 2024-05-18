# Longest Sorted Substring

This Java program reads a string input from the user and calculates the length of the longest sorted substring within that input. A sorted substring is defined based on a custom order of characters.

## How It Works

1. **Reading Input:**
   - The program uses `Scanner` to read a line of input from the standard input (typically the console).

2. **Finding the Longest Sorted Substring:**
   - The `findMaxSortedSubstring` method iterates through the input string to find the length of the longest substring where characters are in a defined order.
   - The custom order for characters is defined in the `isCharsInOrder` method.

3. **Custom Character Order:**
   - The custom order for characters is defined as `0123456789ABCDEGHIJKLMNOPQRSTUVWXYZabcdefhijklmnopqrstuvwxyz`.
   - This order is used to compare characters and determine if they are in sorted order.

## Methods

### `findMaxSortedSubstring(String text)`

This method calculates the length of the longest sorted substring in the given string.

- **Parameters:**
  - `text`: The input string.
- **Returns:**
  - An integer representing the length of the longest sorted substring.

### `isCharsInOrder(char previousChar, char currentChar)`

This method checks if the current character follows the previous character according to the custom order.

- **Parameters:**
  - `previousChar`: The character before the current one.
  - `currentChar`: The current character.
- **Returns:**
  - A boolean indicating whether the characters are in order.

## Example

If the user inputs the string `abcXYZ123`, the program will output `6` since `abcXYZ` is the longest sorted substring based on the custom order.