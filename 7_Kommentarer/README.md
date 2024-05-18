# Kommentar - Comment Remover

This Java program reads input text, removes comments formatted with `%...%` and `/*...*/`, and then outputs the cleaned text.

## How It Works

1. **Reading Input:**
   - The program reads all input lines into a `StringBuilder` using a `Scanner`.
   - The collected input is converted into a single string for processing.

2. **Removing Comments:**
   - The program iterates through each character of the input text.
   - If it encounters a `%` character, it skips all characters until the closing `%`.
   - If it encounters a `/*` sequence, it skips all characters until the closing `*/`.
   - All other characters are printed to the standard output.

3. **Handling Edge Cases:**
   - The program uses a `try-catch` block to handle any exceptions that may occur due to index out-of-bounds or other issues.

## Classes and Methods

### `Kommentar`

#### `public static void main(String[] args)`

- Main method to read input and remove comments.
- Uses a `Scanner` to read from standard input.
- Stores the input in a `StringBuilder` and converts it to a single string.
- Iterates through the string and removes comments based on the specified patterns.
- Prints the cleaned text to the standard output.

### Example

#### Input
```
This is a sample text.
% This is a comment %
This is outside the comment.
/* This is a 
multiline comment */
This is outside the multiline comment.
```

#### Output
```
This is a sample text.
This is outside the comment.
This is outside the multiline comment.
```

## Note
- The program assumes that the input is well-formed with properly closed comments. If comments are not properly closed, it may not behave as expected.