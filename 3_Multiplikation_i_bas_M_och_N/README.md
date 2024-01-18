# Multiplication in Base N and M

This program reads two numbers, A and B, in base N and calculates their product C, then displays it in base M.

## Overview

The program calculates the value C = A * B and outputs it in base M. For example, if N = 8, M = 10, and A and B are 123 and 1 respectively, then A is 83 in base 10, and C is 83 * 1 = 83, which is displayed in base 10.

The value V of a number T in base N is defined as:
$$
V = \sum_{i=0}^{k-1} t_i * N^i
$$

Where k is the number of digits in T, t_i is the i-th digit in T, counting from the least significant digit starting at 0.

For example, if T = 123 and N = 8, then k = 3, t_0 = 3, t_1 = 2, and t_2 = 3, and V = 83.

Digits in the range 0-9 are represented using regular Arabic numerals, followed by uppercase Latin alphabet letters (A-Z), where A represents 10, B represents 11, and so on up to Z, which represents 35.

## Input

The input format consists of:
1. Two integers N and M on the first line.
2. Two integers A and B on separate lines.

You can assume that N and M are integers, both between 2 and 36 inclusive, and that A and B are positive integers not greater than Integer.MAX_VALUE.

## Output

The program outputs an integer C in base M.

## Usage

To run the program, provide the input as described above and execute it. Here's an example of how to run it:

```shell
$ python base_multiplication.py
8 10
123
1
```

The program will then display the result.

## Sample Inputs and Outputs

### Sample Input 1
```
8 10
123
1
```
### Sample Output 1
```
83
```

### Sample Input 2
```
32 17
HEJ
HOPP
```
### Sample Output 2
```
1865C51E7
```