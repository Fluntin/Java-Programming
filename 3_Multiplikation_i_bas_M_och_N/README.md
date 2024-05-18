# Base Calculator

This Java program reads two numbers in a given source base, multiplies them, and converts the result to a specified target base.

## How It Works

1. **Reading Input:**
   - The program uses `Scanner` to read the source base, target base, and two numbers from the standard input (typically the console).

2. **Multiplying and Converting:**
   - The `performMultiplication` method multiplies the two numbers after converting them to decimal (base 10).
   - The result is then converted from decimal to the target base.

## Methods

### `performMultiplication(int sourceBase, int targetBase, String num1, String num2)`

This method multiplies two numbers in a given source base and converts the result to the target base.

- **Parameters:**
  - `sourceBase`: The base of the input numbers.
  - `targetBase`: The base for the output result.
  - `num1`: The first number in the source base.
  - `num2`: The second number in the source base.
- **Returns:**
  - The product of the two numbers in the target base.

### `convertToDecimal(String numberStr, int base)`

This method converts a number from any base to decimal (base 10).

- **Parameters:**
  - `numberStr`: The number in the source base as a string.
  - `base`: The base of the input number.
- **Returns:**
  - The decimal (base 10) equivalent of the input number.

### `convertToBase(long number, int base)`

This method converts a decimal number to the specified target base.

- **Parameters:**
  - `number`: The number in decimal (base 10).
  - `base`: The target base.
- **Returns:**
  - The number in the target base as a string.

## Example

If the user inputs `2` for the source base, `8` for the target base, `110` for the first number, and `101` for the second number, the program will output `144` since `110` (binary) * `101` (binary) = `10010` (binary), which is `22` in decimal and `144` in octal.