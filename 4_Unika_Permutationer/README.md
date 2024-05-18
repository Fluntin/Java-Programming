# Unique Permutations

This Java program reads a string input from the user and generates all unique permutations of the string. The permutations are then sorted alphabetically and printed.

## How It Works

1. **Reading Input:**
   - The program uses `Scanner` to read a string input from the standard input (typically the console).

2. **Generating Permutations:**
   - The `generatePermutations` method is a recursive function that generates all permutations of the input string.
   - A `Set` is used to store the permutations to ensure all permutations are unique.

3. **Sorting and Printing:**
   - The unique permutations are copied from the `Set` to a `List`.
   - The list is then sorted alphabetically using `Collections.sort`.
   - The sorted permutations are printed.

## Methods

### `generatePermutations(String prefix, String remaining, Set<String> permutations)`

This method generates all permutations of the given string.

- **Parameters:**
  - `prefix`: The current permutation being built.
  - `remaining`: The characters left to be permuted.
  - `permutations`: The set of unique permutations.
- **Returns:**
  - This method does not return a value but updates the `permutations` set.

## Example

If the user inputs `abc`, the program will output:
```
abc
acb
bac
bca
cab
cba
```