# Paper Navigation

This program simulates navigation on a paper that has been divided into quadrants and sub-quadrants. Each quadrant and sub-quadrant is named using a sequence of numbers. Starting from a given position, you can move a specified number of steps to the right and up.

## Overview

Imagine you have a piece of paper divided into 4 quadrants and named as follows:

```
3 | 4
-----
1 | 2
```

You can repeat this process, dividing each quadrant into sub-quadrants, and name them as shown:

```
3.3 | 3.4 | 4.3 | 4.4
---------------------
3.1 | 3.2 | 4.1 | 4.2
---------------------
1.3 | 1.4 | 2.3 | 2.4
---------------------
1.1 | 1.2 | 2.1 | 2.2
```

And you can continue this process a total of `n` times, dividing the paper into `2^n x 2^n` squares. Each square is assigned a name consisting of a sequence of numbers.

We are interested in determining which square is located `right` steps to the right and `up` steps up from a given square. If you start from a square with a name like "1.3" and move 2 steps to the right and 2 steps up, you will end up in the square "4.3". If you start from "1.3" and move 0 steps to the right and -1 step up (i.e., 1 step down), you will end up in the square "1.1".

If you move outside the paper boundaries, the program should output "outside".

## Input

The input consists of a string representing the name of the starting square (a sequence of numbers separated by dots), and two integers `right` and `up`, indicating the number of steps to move to the right and up.

You can assume that `right` and `up` are integers, both between `-100` and `100`, and that the length of the square name does not exceed `100` characters.

## Output

The program outputs a single string that represents the name of the square you end up in after the movement, or the string "outside" if you move outside the paper boundaries.

## Usage

To run the program, provide the input as described above and execute it. Here's an example of how to run it:

```shell
$ python paper_navigation.py
1.3
2 2
```

The program will then display the final square name.

## Sample Inputs and Outputs

### Sample Input 1
```
1.3
2 2
```

### Sample Output 1
```
4.3
```

### Sample Input 2
```
4.1.4
-3 0
```

### Sample Output 2
```
3.2.3
```
