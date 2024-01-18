# Path Finder

This program reads a map and finds paths that connect two sides of the map. The map consists of an MxN matrix containing letters A-Z. The program will print all letters (in alphabetical order) that connect the top and bottom rows of the map through one or more paths. Two cells in the map are considered part of the same path if they are either directly above/below or adjacent to each other. Diagonals are not considered part of a path.

If no paths exist, the program should print "0".

Note that paths can branch out, or there can be multiple valid paths with the same letter. However, the output should only contain each letter once, regardless of how many valid paths there are with that letter.

## Input

The input format consists of:
1. Two integers, M and N, representing the number of rows and columns, in that order.
2. The map itself, with M rows, each containing N characters.

You can assume that M and N are integers, both between 1 and 10,000, and that the map consists of uppercase letters.

## Output

The program outputs a string of letters in alphabetical order or the digit "0".

## Usage

To run the program, provide the input as described above and execute it. Here's an example of how to run it:

```shell
$ python path_finder.py
6 6
AACACD
ABBABD
ABAAAD
ABABAD
AAABAD
BBBBBD
```

The program will then display the result.

## Sample Inputs and Outputs

### Sample Input 1
```
6 6
AACACD
ABBABD
ABAAAD
ABABAD
AAABAD
BBBBBD
```

### Sample Output 1
```
D
```

### Sample Input 2
```
10 10
ABCDEFGHIJ
ABCDEFGHIJ
ABCDEFGHIJ
ABCDEFGHIJ
ABCDEFGHIJ
ABCDEFGHIJ
ABCDEFGHIJ
ABCDEFGHIJ
ABCDEFGHIJ
KKKKKKKKKK
```

### Sample Output 2
```
0
```